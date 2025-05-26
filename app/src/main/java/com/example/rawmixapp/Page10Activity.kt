package com.example.rawmixapp

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class Page10Activity : AppCompatActivity() {
    private lateinit var container: LinearLayout
    private lateinit var noDataView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_page10)

        container = findViewById<LinearLayout>(R.id.saveListContainer)
        refreshDataList()
    }

    private fun refreshDataList() {
        container.removeAllViews()

        val saves = Page1Activity.getSavedData(this)
        if (saves.length() == 0) {
            showNoDataMessage()
        } else {
            displaySavedData(saves)
        }
    }

    private fun showNoDataMessage() {
        val cardView = CardView(this)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(32, 64, 32, 32)
        cardView.layoutParams = layoutParams
        cardView.cardElevation = 8f
        cardView.radius = 16f
        cardView.setCardBackgroundColor(Color.parseColor("#F5F5F5"))

        val innerLayout = LinearLayout(this)
        innerLayout.orientation = LinearLayout.VERTICAL
        innerLayout.gravity = android.view.Gravity.CENTER
        innerLayout.setPadding(48, 64, 48, 64)

        // Icon (using a simple text icon)
        val iconView = TextView(this)
        iconView.text = "📋"
        iconView.textSize = 48f
        iconView.gravity = android.view.Gravity.CENTER

        val titleView = TextView(this)
        titleView.text = "No Saved Data"
        titleView.textSize = 24f
        titleView.setTextColor(Color.parseColor("#666666"))
        titleView.gravity = android.view.Gravity.CENTER
        titleView.setTypeface(null, android.graphics.Typeface.BOLD)

        val messageView = TextView(this)
        messageView.text = "Start using the app to see your saved calculations here"
        messageView.textSize = 16f
        messageView.setTextColor(Color.parseColor("#999999"))
        messageView.gravity = android.view.Gravity.CENTER

        val iconParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        iconParams.setMargins(0, 0, 0, 16)
        iconView.layoutParams = iconParams

        val titleParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        titleParams.setMargins(0, 0, 0, 8)
        titleView.layoutParams = titleParams

        innerLayout.addView(iconView)
        innerLayout.addView(titleView)
        innerLayout.addView(messageView)
        cardView.addView(innerLayout)
        container.addView(cardView)

        noDataView = cardView
    }

    private fun displaySavedData(saves: JSONArray) {
        // Display items in reverse order (newest first)
        for (i in saves.length() - 1 downTo 0) {
            try {
                val saveData = saves.getJSONObject(i)
                createEnhancedSaveDataView(saveData, i)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun createEnhancedSaveDataView(saveData: JSONObject, index: Int) {
        // Main card container
        val cardView = CardView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(16, 8, 16, 8)
            }
            cardElevation = 6f
            radius = 12f
            setCardBackgroundColor(Color.WHITE)
            isClickable = true
            isFocusable = true
        }

        // Main horizontal layout
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(20, 16, 16, 16)
            gravity = android.view.Gravity.CENTER_VERTICAL
        }

        // Left side - Content
        val contentLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }

        // Entry number with colored indicator
        val headerLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = android.view.Gravity.CENTER_VERTICAL
        }

        val indicator = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(12, 12).apply {
                setMargins(0, 0, 12, 0)
            }
            background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(getColorForIndex(index))
            }
        }

        val titleView = TextView(this)
        titleView.text = saveData.optString("saveName", "Calculation Entry #${index + 1}")
        titleView.textSize = 18f
        titleView.setTextColor(Color.parseColor("#2196F3"))
        titleView.setTypeface(null, android.graphics.Typeface.BOLD)

        headerLayout.addView(indicator)
        headerLayout.addView(titleView)

        // Date only (no timestamp or clock icon)
        val dateView = TextView(this)
        val timestamp = saveData.optString("timestamp", "Unknown time")
        dateView.text = formatDateOnly(timestamp)
        dateView.textSize = 14f
        dateView.setTextColor(Color.parseColor("#757575"))

        // Data preview
        val previewView = TextView(this)
        previewView.text = generateDataPreview(saveData)
        previewView.textSize = 13f
        previewView.setTextColor(Color.parseColor("#424242"))
        val previewParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        previewParams.setMargins(0, 8, 0, 0)
        previewView.layoutParams = previewParams

        contentLayout.addView(headerLayout)
        contentLayout.addView(dateView)
        contentLayout.addView(previewView)

        // Right side - Action buttons
        val buttonLayout = LinearLayout(this)
        buttonLayout.orientation = LinearLayout.VERTICAL
        buttonLayout.gravity = android.view.Gravity.CENTER

        // Delete button - Fixed layout
        val deleteButton = createDeleteButton()
        deleteButton.setOnClickListener {
            showDeleteConfirmation(index)
        }

        buttonLayout.addView(deleteButton)

        mainLayout.addView(contentLayout)
        mainLayout.addView(buttonLayout)
        cardView.addView(mainLayout)

        // Optimize touch handling
        cardView.setOnTouchListener { view, event ->
            when (event.action) {
                android.view.MotionEvent.ACTION_DOWN -> {
                    view.animate()
                        .scaleX(0.98f)
                        .scaleY(0.98f)
                        .setDuration(100)
                        .start()
                    cardView.cardElevation = 10f
                }
                android.view.MotionEvent.ACTION_UP, android.view.MotionEvent.ACTION_CANCEL -> {
                    view.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                        .start()
                    cardView.cardElevation = 6f
                }
            }
            false
        }

        // Set click listener for the entire card to load data
        cardView.setOnClickListener {
            loadSavedData(saveData)
        }

        container.addView(cardView)
    }

    private fun createDeleteButton(): Button {
        val button = Button(this)
        button.text = "Delete"
        button.textSize = 14f
        button.setTextColor(Color.WHITE)
        button.isAllCaps = false

        // Create rounded background
        val buttonDrawable = GradientDrawable()
        buttonDrawable.shape = GradientDrawable.RECTANGLE
        buttonDrawable.setColor(Color.parseColor("#F44336"))
        buttonDrawable.cornerRadius = 8f

        button.background = buttonDrawable

        // Set proper button dimensions
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(8, 0, 8, 0)
        button.layoutParams = params
        button.setPadding(24, 12, 24, 12)
        button.minWidth = 0
        button.minimumWidth = 0

        return button
    }

    // Remove the old createActionButton function as it's no longer needed
    private fun getColorForIndex(index: Int): Int {
        val colors = arrayOf(
            "#2196F3", "#4CAF50", "#FF9800", "#9C27B0",
            "#F44336", "#00BCD4", "#795548", "#607D8B"
        )
        return Color.parseColor(colors[index % colors.size])
    }

    private fun formatDateOnly(timestamp: String): String {
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val outputFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            val date = inputFormat.parse(timestamp)
            date?.let { outputFormat.format(it) } ?: timestamp
        } catch (e: Exception) {
            timestamp
        }
    }

    private fun generateDataPreview(saveData: JSONObject): String {
        val preview = StringBuilder()

        // Extract some key data points for preview
        try {
            if (saveData.has("limestone_percent")) {
                preview.append("Limestone: ${saveData.optString("limestone_percent", "N/A")}%")
            }
            if (saveData.has("shale_percent")) {
                if (preview.isNotEmpty()) preview.append(" • ")
                preview.append("Shale: ${saveData.optString("shale_percent", "N/A")}%")
            }
            if (saveData.has("iron_percent")) {
                if (preview.isNotEmpty()) preview.append(" • ")
                preview.append("Iron: ${saveData.optString("iron_percent", "N/A")}%")
            }
            if (saveData.has("lsf_result")) {
                if (preview.isNotEmpty()) preview.append(" • ")
                preview.append("LSF: ${saveData.optString("lsf_result", "N/A")}")
            }
        } catch (e: Exception) {
            preview.append("Calculation data available")
        }

        return if (preview.isEmpty()) {
            "Raw mix calculation data"
        } else {
            preview.toString()
        }
    }

    private fun showDeleteConfirmation(index: Int) {
        AlertDialog.Builder(this)
            .setTitle("Delete Entry")
            .setMessage("Are you sure you want to delete this saved calculation? This action cannot be undone.")
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton("Delete") { _, _ ->
                deleteSavedData(index)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun deleteSavedData(index: Int) {
        try {
            val saves = Page1Activity.getSavedData(this)
            val newSaves = JSONArray()

            // Copy all items except the one to delete
            for (i in 0 until saves.length()) {
                if (i != index) {
                    newSaves.put(saves.getJSONObject(i))
                }
            }

            // Save the updated array
            val sharedPref = getSharedPreferences("RawMixApp", android.content.Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("savedData", newSaves.toString())
                apply()
            }

            // Show success message
            Toast.makeText(this, "Entry deleted successfully", Toast.LENGTH_SHORT).show()

            // Refresh the list
            refreshDataList()

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error deleting entry: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadSavedData(saveData: JSONObject) {
        val intent = Intent(this, Page1Activity::class.java)
        intent.putExtra("LOADED_DATA", saveData.toString())
        intent.putExtra("EDIT_INDEX", getDataIndex(saveData))
        startActivity(intent)
        finish()
    }

    private fun getDataIndex(saveData: JSONObject): Int {
        val saves = Page1Activity.getSavedData(this)
        for (i in 0 until saves.length()) {
            try {
                val currentData = saves.getJSONObject(i)
                if (currentData.toString() == saveData.toString()) {
                    return i
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return -1
    }
}