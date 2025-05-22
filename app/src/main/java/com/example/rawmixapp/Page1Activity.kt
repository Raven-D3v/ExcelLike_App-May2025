package com.example.rawmixapp

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import androidx.appcompat.app.AppCompatActivity

class Page1Activity : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_page1)


        tableLayout = findViewById(R.id.tableLayout)

        // Example: Add another row dynamically
        addNewTableRow()
    }

    private fun addNewTableRow() {
        val row = TableRow(this)
        for (i in 0 until 20) {
            val editText = EditText(this)
            editText.layoutParams = TableRow.LayoutParams(150, ViewGroup.LayoutParams.WRAP_CONTENT)
            editText.hint = "0.0"
            editText.setPadding(6, 6, 6, 6)
            editText.gravity = Gravity.CENTER
            editText.setTextColor(Color.BLACK)
            editText.setBackgroundColor(Color.WHITE)
            row.addView(editText)
        }
        tableLayout.addView(row)
    }
}
