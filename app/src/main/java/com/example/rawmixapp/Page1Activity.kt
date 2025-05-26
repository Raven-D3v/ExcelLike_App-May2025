package com.example.rawmixapp

import android.annotation.SuppressLint
import android.content.Intent
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
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Switch
import android.widget.LinearLayout
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import android.app.AlertDialog

class Page1Activity : AppCompatActivity() {

    companion object {
        fun getSavedData(context: android.content.Context): JSONArray {
            val sharedPrefs = context.getSharedPreferences("RawMixApp", android.content.Context.MODE_PRIVATE)
            val savedData = sharedPrefs.getString("savedData", "[]")
            return JSONArray(savedData)
        }

        private fun saveData(context: android.content.Context, dataArray: JSONArray) {
            val sharedPrefs = context.getSharedPreferences("RawMixApp", android.content.Context.MODE_PRIVATE)
            sharedPrefs.edit().putString("savedData", dataArray.toString()).apply()
        }
    }

    private lateinit var tableLayout: TableLayout
    private var isEditing = false
    private var editingIndex = -1

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
        val btnSave = findViewById<Button>(R.id.btnSave)

        val switchRow2 = findViewById<Switch>(R.id.switch_row2)
        val switchRow3 = findViewById<Switch>(R.id.switch_row3)
        val switchRow4 = findViewById<Switch>(R.id.switch_row4)
        val switchRow5 = findViewById<Switch>(R.id.switch_row5)

        // Check if we have data to load from intent
        val loadedDataJson = intent.getStringExtra("LOADED_DATA")
        if (loadedDataJson != null) {
            loadDataFromJson(loadedDataJson)
        }

        // Helper to get TableRow by index (0-based, skip header rows)
        fun getTableRow(index: Int): TableRow? {
            // 0: Top Section, 1: Header, 2: Row 1, 3: Row 2, 4: Row 3, 5: Row 4, 6: Row 5
            return tableLayout.getChildAt(index) as? TableRow
        }

        // --- Calculation logic for manual mode (like row 1) ---
        fun setupManualRow(rowIdx: Int, limestoneIdx: Int, shaleIdx: Int, ironIdx: Int, totalIdx: Int) {
            val row = getTableRow(rowIdx) ?: return
            val etLimestone = row.getChildAt(limestoneIdx) as? EditText ?: return
            val etShale = row.getChildAt(shaleIdx) as? EditText ?: return
            val etIron = row.getChildAt(ironIdx) as? EditText ?: return
            val tvTotal = row.getChildAt(totalIdx) as? TextView ?: return

            etIron.apply {
                isFocusable = false
                isFocusableInTouchMode = false
                isClickable = false
                isLongClickable = false
                isCursorVisible = false
                inputType = InputType.TYPE_NULL
            }
            etLimestone.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            etShale.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL

            fun updateIronAndTotal() {
                val limestone = etLimestone.text.toString().toDoubleOrNull() ?: 0.0
                val shale = etShale.text.toString().toDoubleOrNull() ?: 0.0
                val iron = 100 - limestone - shale
                val total = limestone + shale + iron
                etIron.setText(String.format("%.2f", iron))
                tvTotal.text = String.format("%.2f", total)
            }
            val watcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) { updateIronAndTotal() }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            }
            etLimestone.addTextChangedListener(watcher)
            etShale.addTextChangedListener(watcher)
        }

        // --- Dynamic replacement logic ---
        fun setRowManual(rowIdx: Int, limestoneIdx: Int, shaleIdx: Int, ironIdx: Int, totalIdx: Int) {
            val row = getTableRow(rowIdx) ?: return
            // Replace TextViews with EditTexts for Limestone, Shale, Iron Ore
            fun replaceWithEditText(idx: Int, bgColor: Int, textColor: Int): EditText {
                val old = row.getChildAt(idx)
                val et = EditText(this)
                et.layoutParams = old.layoutParams
                et.setBackgroundColor(bgColor)
                et.setTextColor(textColor)
                et.gravity = Gravity.CENTER
                et.setPadding(8, 8, 8, 8)
                et.setText((old as? TextView)?.text ?: "")
                row.removeViewAt(idx)
                row.addView(et, idx)
                return et
            }
            val etLimestone = replaceWithEditText(limestoneIdx, Color.parseColor("#E26B0A"), Color.WHITE)
            val etShale = replaceWithEditText(shaleIdx, Color.parseColor("#D2B48C"), Color.WHITE)
            val etIron = replaceWithEditText(ironIdx, Color.parseColor("#808080"), Color.WHITE)
            setupManualRow(rowIdx, limestoneIdx, shaleIdx, ironIdx, totalIdx)
        }
        fun setRowAuto(rowIdx: Int, limestoneIdx: Int, shaleIdx: Int, ironIdx: Int, totalIdx: Int, values: Triple<String, String, String>) {
            val row = getTableRow(rowIdx) ?: return
            // Replace EditTexts with TextViews for Limestone, Shale, Iron Ore
            fun replaceWithTextView(idx: Int, bgColor: Int, textColor: Int, value: String) {
                val old = row.getChildAt(idx)
                val tv = TextView(this)
                tv.layoutParams = old.layoutParams
                tv.setBackgroundColor(bgColor)
                tv.setTextColor(textColor)
                tv.gravity = Gravity.CENTER
                tv.setPadding(8, 8, 8, 8)
                tv.text = value
                row.removeViewAt(idx)
                row.addView(tv, idx)
            }
            replaceWithTextView(limestoneIdx, Color.parseColor("#E26B0A"), Color.WHITE, values.first)
            replaceWithTextView(shaleIdx, Color.parseColor("#D2B48C"), Color.WHITE, values.second)
            replaceWithTextView(ironIdx, Color.parseColor("#808080"), Color.WHITE, values.third)
            // Optionally reset total
            val tvTotal = row.getChildAt(totalIdx) as? TextView
            tvTotal?.text = "100.0"
        }

        // Row indices: 3 = Row 2, 4 = Row 3, 5 = Row 4, 6 = Row 5 (counting TableRows in TableLayout)
        switchRow2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setRowManual(3, 2, 3, 4, 1)
            } else {
                setRowAuto(3, 2, 3, 4, 1, Triple("81.8", "15.0", "5.0"))
            }
        }
        switchRow3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setRowManual(4, 2, 3, 4, 1)
            } else {
                setRowAuto(4, 2, 3, 4, 1, Triple("81.8", "13.2", "5.0"))
            }
        }
        switchRow4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setRowManual(5, 2, 3, 4, 1)
            } else {
                setRowAuto(5, 2, 3, 4, 1, Triple("81.8", "13.2", "5.0"))
            }
        }
        switchRow5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setRowManual(6, 2, 3, 4, 1)
            } else {
                setRowAuto(6, 2, 3, 4, 1, Triple("81.8", "13.2", "5.0"))
            }
        }

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

        // Handle keyboard "done" or "enter" to prevent accidental exit
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

        // Save button functionality
        btnSave.setOnClickListener {
            saveCurrentData()
        }

    }

    private fun saveCurrentData() {
        try {
            val currentData = collectCurrentData()
            val existingSaves = getSavedData(this)
            
            if (isEditing && editingIndex >= 0 && editingIndex < existingSaves.length()) {
                // When editing, keep the existing save name and update the data
                val existingData = existingSaves.getJSONObject(editingIndex)
                currentData.put("saveName", existingData.optString("saveName", "Unnamed Save"))
                existingSaves.put(editingIndex, currentData)
                saveData(this, existingSaves)
                Toast.makeText(this, "Data updated successfully!", Toast.LENGTH_SHORT).show()
            } else {
                // For new saves, show dialog to get save name
                val input = EditText(this)
                input.hint = "Enter a name for this save"
                input.inputType = InputType.TYPE_CLASS_TEXT
                
                AlertDialog.Builder(this)
                    .setTitle("Save Data")
                    .setView(input)
                    .setPositiveButton("Save") { _, _ ->
                        val saveName = input.text.toString().takeIf { it.isNotBlank() } ?: "Unnamed Save"
                        currentData.put("saveName", saveName)
                        existingSaves.put(currentData)
                        saveData(this, existingSaves)
                        Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Cancel", null)
                    .show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error saving data: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun collectCurrentData(): JSONObject {
        val data = JSONObject()

        // Add timestamp
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        data.put("timestamp", sdf.format(Date()))

        // Collect all form data
        data.put("limestone", findViewById<EditText>(R.id.etLimestone).text.toString())
        data.put("shale", findViewById<EditText>(R.id.etShale).text.toString())
        data.put("iron", findViewById<EditText>(R.id.etIron).text.toString())
        data.put("total", findViewById<TextView>(R.id.tvTotal).text.toString())

        // Switch states
        data.put("switch_row2", findViewById<Switch>(R.id.switch_row2).isChecked)
        data.put("switch_row3", findViewById<Switch>(R.id.switch_row3).isChecked)
        data.put("switch_row4", findViewById<Switch>(R.id.switch_row4).isChecked)
        data.put("switch_row5", findViewById<Switch>(R.id.switch_row5).isChecked)

        // Collect all values from the table
        val tableData = JSONArray()
        for (i in 0 until tableLayout.childCount) {
            val row = tableLayout.getChildAt(i) as? TableRow
            if (row != null) {
                val rowData = JSONObject()
                for (j in 0 until row.childCount) {
                    val child = row.getChildAt(j)
                    when (child) {
                        is EditText -> {
                            rowData.put("cell_$j", JSONObject().apply {
                                put("type", "EditText")
                                put("value", child.text.toString())
                                put("hint", child.hint.toString())
                                put("inputType", child.inputType)
                                put("background", child.background.toString())
                            })
                        }
                        is TextView -> {
                            rowData.put("cell_$j", JSONObject().apply {
                                put("type", "TextView")
                                put("value", child.text.toString())
                                put("background", child.background.toString())
                            })
                        }
                        is Switch -> {
                            rowData.put("cell_$j", JSONObject().apply {
                                put("type", "Switch")
                                put("checked", child.isChecked)
                            })
                        }
                        is LinearLayout -> {
                            // Find switch in the LinearLayout
                            val switch = child.findViewWithTag<Switch>("switch")
                            if (switch != null) {
                                rowData.put("cell_$j", JSONObject().apply {
                                    put("type", "Switch")
                                    put("checked", switch.isChecked)
                                })
                            }
                        }
                    }
                }
                tableData.put(rowData)
            }
        }
        data.put("tableData", tableData)

        return data
    }

    private fun loadDataFromJson(jsonString: String) {
        try {
            val data = JSONObject(jsonString)
            
            // Set editing mode
            isEditing = true
            editingIndex = intent.getIntExtra("EDIT_INDEX", -1)

            // Load basic values
            findViewById<EditText>(R.id.etLimestone).setText(data.optString("limestone", ""))
            findViewById<EditText>(R.id.etShale).setText(data.optString("shale", ""))
            findViewById<EditText>(R.id.etIron).setText(data.optString("iron", ""))
            findViewById<TextView>(R.id.tvTotal).text = data.optString("total", "100.0")

            // Load switch states
            findViewById<Switch>(R.id.switch_row2).isChecked = data.optBoolean("switch_row2", false)
            findViewById<Switch>(R.id.switch_row3).isChecked = data.optBoolean("switch_row3", false)
            findViewById<Switch>(R.id.switch_row4).isChecked = data.optBoolean("switch_row4", false)
            findViewById<Switch>(R.id.switch_row5).isChecked = data.optBoolean("switch_row5", false)

            // Load table data
            val tableData = data.optJSONArray("tableData")
            if (tableData != null) {
                for (i in 0 until tableData.length()) {
                    val rowData = tableData.getJSONObject(i)
                    val row = tableLayout.getChildAt(i) as? TableRow
                    if (row != null) {
                        for (j in 0 until row.childCount) {
                            val cellData = rowData.optJSONObject("cell_$j")
                            if (cellData != null) {
                                val child = row.getChildAt(j)
                                when (cellData.optString("type")) {
                                    "EditText" -> {
                                        if (child is EditText) {
                                            child.setText(cellData.optString("value", ""))
                                        }
                                    }
                                    "TextView" -> {
                                        if (child is TextView) {
                                            child.text = cellData.optString("value", "")
                                        }
                                    }
                                    "Switch" -> {
                                        if (child is Switch) {
                                            child.isChecked = cellData.optBoolean("checked", false)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Toast.makeText(this, "Data loaded successfully!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error loading data: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }


}