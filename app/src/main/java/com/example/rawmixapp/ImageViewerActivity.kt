package com.example.rawmixapp

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.rawmixapp.ZoomableImageView

class ImageViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageView = ZoomableImageView(this)
        imageView.layoutParams = android.view.ViewGroup.LayoutParams(
            android.view.ViewGroup.LayoutParams.MATCH_PARENT,
            android.view.ViewGroup.LayoutParams.MATCH_PARENT
        )
        setContentView(imageView)
        val imageResId = intent.getIntExtra("imageResId", 0)
        if (imageResId != 0) {
            imageView.setImageResource(imageResId)
        }
    }
} 