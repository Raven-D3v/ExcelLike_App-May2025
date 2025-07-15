package com.example.rawmixapp

import android.content.Context
import android.graphics.Matrix
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.max
import kotlin.math.min

class ZoomableImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    private var matrix = Matrix()
    private var mode = NONE

    // For panning
    private var last = PointF()
    private var start = PointF()

    // For zooming
    private var minScale = 1f
    private var maxScale = 5f
    private var m: FloatArray = FloatArray(9)
    private var saveScale = 1f

    private var viewWidth = 0
    private var viewHeight = 0

    private var origWidth = 0f
    private var origHeight = 0f

    private var scaleDetector: ScaleGestureDetector

    companion object {
        private const val NONE = 0
        private const val DRAG = 1
        private const val ZOOM = 2
    }

    init {
        super.setClickable(true)
        scaleDetector = ScaleGestureDetector(context, ScaleListener())
        imageMatrix = matrix
        scaleType = ScaleType.MATRIX
        setOnTouchListener { _, event -> onTouchEvent(event) }
    }

    override fun setImageResource(resId: Int) {
        super.setImageResource(resId)
        // Reset matrix when new image is set
        post {
            fitImageToView()
        }
    }

    private fun fitImageToView() {
        val drawable = drawable ?: return
        val dWidth = drawable.intrinsicWidth
        val dHeight = drawable.intrinsicHeight

        val scale: Float = min(width.toFloat() / dWidth, height.toFloat() / dHeight)
        matrix.setScale(scale, scale)
        val redundantYSpace = (height - scale * dHeight) / 2
        val redundantXSpace = (width - scale * dWidth) / 2
        matrix.postTranslate(redundantXSpace, redundantYSpace)
        imageMatrix = matrix
        saveScale = 1f
        origWidth = width - 2 * redundantXSpace
        origHeight = height - 2 * redundantYSpace
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleDetector.onTouchEvent(event)
        val curr = PointF(event.x, event.y)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                last.set(curr)
                start.set(last)
                mode = DRAG
            }
            MotionEvent.ACTION_MOVE -> {
                if (mode == DRAG) {
                    val dx = curr.x - last.x
                    val dy = curr.y - last.y
                    matrix.postTranslate(dx, dy)
                    fixTranslation()
                    last.set(curr.x, curr.y)
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                mode = NONE
            }
        }
        imageMatrix = matrix
        return true
    }

    private fun fixTranslation() {
        matrix.getValues(m)
        val transX = m[Matrix.MTRANS_X]
        val transY = m[Matrix.MTRANS_Y]
        val fixTransX = getFixTrans(transX, viewWidth.toFloat(), origWidth * saveScale)
        val fixTransY = getFixTrans(transY, viewHeight.toFloat(), origHeight * saveScale)
        if (fixTransX != 0f || fixTransY != 0f) {
            matrix.postTranslate(fixTransX, fixTransY)
        }
    }

    private fun getFixTrans(trans: Float, viewSize: Float, contentSize: Float): Float {
        val minTrans: Float
        val maxTrans: Float

        if (contentSize <= viewSize) {
            minTrans = 0f
            maxTrans = viewSize - contentSize
        } else {
            minTrans = viewSize - contentSize
            maxTrans = 0f
        }
        if (trans < minTrans) return -trans + minTrans
        if (trans > maxTrans) return -trans + maxTrans
        return 0f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)
        if (saveScale == 1f) {
            fitImageToView()
        }
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            var scale = detector.scaleFactor
            val origScale = saveScale
            saveScale *= scale
            if (saveScale > maxScale) {
                saveScale = maxScale
                scale = maxScale / origScale
            } else if (saveScale < minScale) {
                saveScale = minScale
                scale = minScale / origScale
            }
            if (origWidth * saveScale <= viewWidth || origHeight * saveScale <= viewHeight)
                matrix.postScale(scale, scale, (viewWidth / 2).toFloat(), (viewHeight / 2).toFloat())
            else
                matrix.postScale(scale, scale, detector.focusX, detector.focusY)
            fixTranslation()
            return true
        }
    }
} 