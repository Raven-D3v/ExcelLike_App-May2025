package com.example.rawmixapp

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.Gravity
import android.view.KeyEvent
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Page1Activity : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_page1)

        tableLayout = findViewById(R.id.tableLayout)

        val etLimestone = findViewById<EditText>(R.id.etLimestone)
        val etShale = findViewById<EditText>(R.id.etShale)
        val etIron = findViewById<EditText>(R.id.etIron)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        // Iron is calculated, disable editing
        etIron.apply {
            isFocusable = false
            isFocusableInTouchMode = false
            isClickable = false
            isLongClickable = false
            isCursorVisible = false
            inputType = InputType.TYPE_NULL
        }

        // Optional: force correct input types
        etLimestone.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        etShale.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL

        // Handle keyboard “done” or “enter” to prevent accidental exit
        etShale.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event?.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
            ) {
                // consume the event
                return@setOnEditorActionListener true
            }
            false
        }

        fun updateIronAndTotal() {
            val limestone = etLimestone.text.toString().toDoubleOrNull() ?: 0.0
            val shale = etShale.text.toString().toDoubleOrNull() ?: 0.0
            val iron = 100 - limestone - shale
            val total = limestone + shale + iron

            // Update views
            etIron.setText(String.format("%.2f", iron))
            tvTotal.text = String.format("%.2f", total)
        }

        val watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                updateIronAndTotal()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        etLimestone.addTextChangedListener(watcher)
        etShale.addTextChangedListener(watcher)

        // Optional: Add row sample for demo
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
