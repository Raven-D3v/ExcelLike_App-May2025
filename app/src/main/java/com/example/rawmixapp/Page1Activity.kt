package com.example.rawmixapp

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.rawmixapp.db.SavedDataDbHelper
import org.json.JSONArray
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.max

class Page1Activity : BaseActivity() {

    private lateinit var tableLayout: TableLayout

    // Declare UI elements
    private lateinit var tv_G45: TextView
    private lateinit var et_H45: EditText
    private lateinit var et_I45: EditText
    private lateinit var et_J45: EditText
    private lateinit var et_K45: EditText
    private lateinit var et_L45: EditText
    private lateinit var et_M45: EditText
    private lateinit var et_N45: EditText
    private lateinit var et_O45: EditText
    private lateinit var et_P45: EditText
    private lateinit var et_Q45: EditText
    private lateinit var et_R45: EditText
    private lateinit var et_S45: EditText
    private lateinit var tv_T45: TextView
    private lateinit var tv_U45: TextView
    private lateinit var tv_V45: TextView
    private lateinit var tv_W45: TextView
    private lateinit var tv_X45: TextView
    private lateinit var tv_Y45: TextView

    private lateinit var switch_row2: Switch
    private lateinit var tv_G46: TextView
    private lateinit var et_H46: EditText
    private lateinit var et_I46: EditText
    private lateinit var et_J46: EditText
    private lateinit var et_K46: EditText
    private lateinit var et_L46: EditText
    private lateinit var et_M46: EditText
    private lateinit var et_N46: EditText
    private lateinit var et_O46: EditText
    private lateinit var et_P46: EditText
    private lateinit var et_Q46: EditText
    private lateinit var et_R46: EditText
    private lateinit var et_S46: EditText
    private lateinit var tv_T46: TextView
    private lateinit var tv_U46: TextView
    private lateinit var tv_V46: TextView
    private lateinit var tv_W46: TextView
    private lateinit var tv_X46: TextView
    private lateinit var tv_Y46: TextView

    private lateinit var switch_row3: Switch
    private lateinit var tv_G47: TextView
    private lateinit var et_H47: EditText
    private lateinit var et_I47: EditText
    private lateinit var et_J47: EditText
    private lateinit var et_K47: EditText
    private lateinit var et_L47: EditText
    private lateinit var et_M47: EditText
    private lateinit var et_N47: EditText
    private lateinit var et_O47: EditText
    private lateinit var et_P47: EditText
    private lateinit var et_Q47: EditText
    private lateinit var et_R47: EditText
    private lateinit var et_S47: EditText
    private lateinit var tv_T47: TextView
    private lateinit var tv_U47: TextView
    private lateinit var tv_V47: TextView
    private lateinit var tv_W47: TextView
    private lateinit var tv_X47: TextView
    private lateinit var tv_Y47: TextView

    private lateinit var switch_row4: Switch
    private lateinit var tv_G48: TextView
    private lateinit var et_H48: EditText
    private lateinit var et_I48: EditText
    private lateinit var et_J48: EditText
    private lateinit var et_K48: EditText
    private lateinit var et_L48: EditText
    private lateinit var et_M48: EditText
    private lateinit var et_N48: EditText
    private lateinit var et_O48: EditText
    private lateinit var et_P48: EditText
    private lateinit var et_Q48: EditText
    private lateinit var et_R48: EditText
    private lateinit var et_S48: EditText
    private lateinit var tv_T48: TextView
    private lateinit var tv_U48: TextView
    private lateinit var tv_V48: TextView
    private lateinit var tv_W48: TextView
    private lateinit var tv_X48: TextView
    private lateinit var tv_Y48: TextView

    private lateinit var switch_row5: Switch
    private lateinit var tv_G49: TextView
    private lateinit var et_H49: EditText
    private lateinit var et_I49: EditText
    private lateinit var et_J49: EditText

    private lateinit var tv_H52_target_LSF: TextView
    private lateinit var tv_H53_target_AM: TextView
    private lateinit var et_H54: EditText

    private lateinit var et_K52: EditText
    private lateinit var et_L52: EditText
    private lateinit var et_M52: EditText
    private lateinit var et_N52: EditText
    private lateinit var et_O52: EditText
    private lateinit var et_P52: EditText
    private lateinit var et_Q52: EditText
    private lateinit var et_R52: EditText
    private lateinit var et_S52: EditText
    private lateinit var tv_T52_trc_LOI: TextView
    private lateinit var tv_U52_trc_TOTAL: TextView
    private lateinit var tv_V52_trc_LSF: TextView
    private lateinit var tv_W52_trc_SM: TextView
    private lateinit var tv_X52_trc_SR: TextView
    private lateinit var tv_Y52_trc_AM: TextView

    private lateinit var et_K54: EditText
    private lateinit var et_L54: EditText
    private lateinit var et_M54: EditText
    private lateinit var et_N54: EditText
    private lateinit var et_O54: EditText
    private lateinit var et_P54: EditText
    private lateinit var et_Q54: EditText
    private lateinit var et_R54: EditText
    private lateinit var et_S54: EditText
    private lateinit var et_T54: EditText
    private lateinit var tv_U54: TextView
    private lateinit var tv_V54: TextView
    private lateinit var tv_W54: TextView
    private lateinit var tv_X54: TextView
    private lateinit var tv_Y54: TextView

    private lateinit var tv_K57: TextView
    private lateinit var tv_L57: TextView
    private lateinit var tv_M57: TextView
    private lateinit var tv_N57: TextView
    private lateinit var tv_O57: TextView
    private lateinit var tv_P57: TextView
    private lateinit var tv_Q57: TextView
    private lateinit var tv_R57: TextView
    private lateinit var tv_S57: TextView
    private lateinit var tv_T57: TextView
    private lateinit var tv_V57: TextView
    private lateinit var tv_W57: TextView
    private lateinit var tv_X57: TextView
    private lateinit var tv_Y57: TextView

    private lateinit var et_K60: EditText
    private lateinit var et_L60: EditText
    private lateinit var tv_M60: TextView
    private lateinit var tv_N60: TextView
    private lateinit var et_O60: EditText
    private lateinit var tv_P60: TextView
    private lateinit var tv_Q60: TextView
    private lateinit var tv_R60: TextView
    private lateinit var tv_S60: TextView
    private lateinit var tv_T60: TextView
    private lateinit var tv_U60: TextView
    private lateinit var tv_V60: TextView
    private lateinit var tv_W60: TextView
    private lateinit var et_X60: EditText
    private lateinit var et_Y60: EditText

    private val df = DecimalFormat("#,##0.00")
    private val values = mutableMapOf<String, Double>()
    private lateinit var allInputEditTexts: List<EditText>
    private lateinit var mainTextWatcher: TextWatcher

    private lateinit var dbHelper: SavedDataDbHelper
    private lateinit var btnSave: Button
    private lateinit var btnClear: Button

    private lateinit var allSwitches: List<Switch>

    // Add XRF row declarations at class level
    private lateinit var xrfRow2: List<EditText>
    private lateinit var xrfRow3: List<EditText>
    private lateinit var xrfRow4: List<EditText>

    private var isDataModified = false
    private var currentSavedDataId: Long = -1
    private var originalDataJson: String? = null

    // Add this property at class level to store custom watchers
    private val customWatchers = mutableMapOf<EditText, TextWatcher>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "3 Materials LSF & AM"
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page1)

        dbHelper = SavedDataDbHelper(this)
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        mainTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                recalculateAndUpdate()
            }
        }

        tableLayout = findViewById(R.id.tableLayout)
        initializeViews()
        
        // Initialize XRF rows
        xrfRow2 = listOf(et_K46, et_L46, et_M46, et_N46, et_O46, et_P46, et_Q46, et_R46, et_S46)
        xrfRow3 = listOf(et_K47, et_L47, et_M47, et_N47, et_O47, et_P47, et_Q47, et_R47, et_S47)
        xrfRow4 = listOf(et_K48, et_L48, et_M48, et_N48, et_O48, et_P48, et_Q48, et_R48, et_S48)
        
        // Set all switches to manual mode by default and configure their fields
        allSwitches.forEach { switch ->
            switch.isChecked = true
            // Configure the corresponding fields for manual mode
            when (switch) {
                switch_row2 -> toggleEditTextsManual(listOf(et_H46, et_I46, et_J46) + xrfRow2, true, mainTextWatcher)
                switch_row3 -> toggleEditTextsManual(listOf(et_H47, et_I47, et_J47) + xrfRow3, true, mainTextWatcher)
                switch_row4 -> toggleEditTextsManual(listOf(et_H48, et_I48, et_J48) + xrfRow4, true, mainTextWatcher)
                switch_row5 -> toggleEditTextsManual(listOf(et_H49, et_I49, et_J49), true, mainTextWatcher)
            }
        }
        
        // Configure always editable fields (Row 1 and other input fields)
        val alwaysEditableFields = listOf(
            et_H45, et_I45, et_J45, et_K45, et_L45, et_M45, et_N45, et_O45, et_P45, et_Q45, et_R45, et_S45,
            et_H54,
            et_K52, et_L52, et_M52, et_N52, et_O52, et_P52, et_Q52, et_R52, et_S52,
            et_K54, et_L54, et_M54, et_N54, et_O54, et_P54, et_Q54, et_R54, et_S54, et_T54,
            et_K60, et_L60, et_O60, et_X60, et_Y60
        )
        alwaysEditableFields.forEach { editText ->
            editText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            editText.isFocusable = true
            editText.isFocusableInTouchMode = true
            editText.isCursorVisible = true
            editText.addTextChangedListener(mainTextWatcher)
        }
        
        setupListeners()
        setupButtons()
        
        // Initial calculation after setting up manual mode
        recalculateAndUpdate()

        // Check if we're loading saved data
        val savedDataId = intent.getLongExtra("saved_data_id", -1)
        if (savedDataId != -1L) {
            currentSavedDataId = savedDataId
            loadSavedData(savedDataId)
        } else {
            val loadedDataJson = intent.getStringExtra("LOADED_DATA")
            if (loadedDataJson != null) {
                loadDataFromJson(loadedDataJson)
            } else {
                allInputEditTexts.forEach { it.setText("") }
                values.clear()
                recalculateAndUpdate()
            }
        }
    }

    private fun initializeViews() {
        tv_G45 = findViewById(R.id.tv_G45)
        et_H45 = findViewById(R.id.et_H45); et_I45 = findViewById(R.id.et_I45); et_J45 = findViewById(R.id.et_J45)
        et_K45 = findViewById(R.id.et_K45); et_L45 = findViewById(R.id.et_L45); et_M45 = findViewById(R.id.et_M45)
        et_N45 = findViewById(R.id.et_N45); et_O45 = findViewById(R.id.et_O45); et_P45 = findViewById(R.id.et_P45)
        et_Q45 = findViewById(R.id.et_Q45); et_R45 = findViewById(R.id.et_R45); et_S45 = findViewById(R.id.et_S45)
        tv_T45 = findViewById(R.id.tv_T45); tv_U45 = findViewById(R.id.tv_U45); tv_V45 = findViewById(R.id.tv_V45)
        tv_W45 = findViewById(R.id.tv_W45); tv_X45 = findViewById(R.id.tv_X45); tv_Y45 = findViewById(R.id.tv_Y45)

        switch_row2 = findViewById(R.id.switch_row2); tv_G46 = findViewById(R.id.tv_G46)
        et_H46 = findViewById(R.id.et_H46); et_I46 = findViewById(R.id.et_I46); et_J46 = findViewById(R.id.et_J46)
        et_K46 = findViewById(R.id.et_K46); et_L46 = findViewById(R.id.et_L46); et_M46 = findViewById(R.id.et_M46)
        et_N46 = findViewById(R.id.et_N46); et_O46 = findViewById(R.id.et_O46); et_P46 = findViewById(R.id.et_P46)
        et_Q46 = findViewById(R.id.et_Q46); et_R46 = findViewById(R.id.et_R46); et_S46 = findViewById(R.id.et_S46)
        tv_T46 = findViewById(R.id.tv_T46); tv_U46 = findViewById(R.id.tv_U46); tv_V46 = findViewById(R.id.tv_V46)
        tv_W46 = findViewById(R.id.tv_W46); tv_X46 = findViewById(R.id.tv_X46); tv_Y46 = findViewById(R.id.tv_Y46)

        switch_row3 = findViewById(R.id.switch_row3); tv_G47 = findViewById(R.id.tv_G47)
        et_H47 = findViewById(R.id.et_H47); et_I47 = findViewById(R.id.et_I47); et_J47 = findViewById(R.id.et_J47)
        et_K47 = findViewById(R.id.et_K47); et_L47 = findViewById(R.id.et_L47); et_M47 = findViewById(R.id.et_M47)
        et_N47 = findViewById(R.id.et_N47); et_O47 = findViewById(R.id.et_O47); et_P47 = findViewById(R.id.et_P47)
        et_Q47 = findViewById(R.id.et_Q47); et_R47 = findViewById(R.id.et_R47); et_S47 = findViewById(R.id.et_S47)
        tv_T47 = findViewById(R.id.tv_T47); tv_U47 = findViewById(R.id.tv_U47); tv_V47 = findViewById(R.id.tv_V47)
        tv_W47 = findViewById(R.id.tv_W47); tv_X47 = findViewById(R.id.tv_X47); tv_Y47 = findViewById(R.id.tv_Y47)

        switch_row4 = findViewById(R.id.switch_row4); tv_G48 = findViewById(R.id.tv_G48)
        et_H48 = findViewById(R.id.et_H48); et_I48 = findViewById(R.id.et_I48); et_J48 = findViewById(R.id.et_J48)
        et_K48 = findViewById(R.id.et_K48); et_L48 = findViewById(R.id.et_L48); et_M48 = findViewById(R.id.et_M48)
        et_N48 = findViewById(R.id.et_N48); et_O48 = findViewById(R.id.et_O48); et_P48 = findViewById(R.id.et_P48)
        et_Q48 = findViewById(R.id.et_Q48); et_R48 = findViewById(R.id.et_R48); et_S48 = findViewById(R.id.et_S48)
        tv_T48 = findViewById(R.id.tv_T48); tv_U48 = findViewById(R.id.tv_U48); tv_V48 = findViewById(R.id.tv_V48)
        tv_W48 = findViewById(R.id.tv_W48); tv_X48 = findViewById(R.id.tv_X48); tv_Y48 = findViewById(R.id.tv_Y48)

        switch_row5 = findViewById(R.id.switch_row5); tv_G49 = findViewById(R.id.tv_G49)
        et_H49 = findViewById(R.id.et_H49); et_I49 = findViewById(R.id.et_I49); et_J49 = findViewById(R.id.et_J49)

        tv_H52_target_LSF = findViewById(R.id.tv_H52); tv_H53_target_AM = findViewById(R.id.tv_H53); et_H54 = findViewById(R.id.et_H54)

        et_K52 = findViewById(R.id.et_K52); et_L52 = findViewById(R.id.et_L52); et_M52 = findViewById(R.id.et_M52)
        et_N52 = findViewById(R.id.et_N52); et_O52 = findViewById(R.id.et_O52); et_P52 = findViewById(R.id.et_P52)
        et_Q52 = findViewById(R.id.et_Q52); et_R52 = findViewById(R.id.et_R52); et_S52 = findViewById(R.id.et_S52)
        tv_T52_trc_LOI = findViewById(R.id.tv_T52); tv_U52_trc_TOTAL = findViewById(R.id.tv_U52); tv_V52_trc_LSF = findViewById(R.id.tv_V52)
        tv_W52_trc_SM = findViewById(R.id.tv_W52); tv_X52_trc_SR = findViewById(R.id.tv_X52); tv_Y52_trc_AM = findViewById(R.id.tv_Y52)

        et_K54 = findViewById(R.id.et_K54); et_L54 = findViewById(R.id.et_L54); et_M54 = findViewById(R.id.et_M54)
        et_N54 = findViewById(R.id.et_N54); et_O54 = findViewById(R.id.et_O54); et_P54 = findViewById(R.id.et_P54)
        et_Q54 = findViewById(R.id.et_Q54); et_R54 = findViewById(R.id.et_R54); et_S54 = findViewById(R.id.et_S54)
        et_T54 = findViewById(R.id.et_T54)
        tv_U54 = findViewById(R.id.tv_U54); tv_V54 = findViewById(R.id.tv_V54); tv_W54 = findViewById(R.id.tv_W54)
        tv_X54 = findViewById(R.id.tv_X54); tv_Y54 = findViewById(R.id.tv_Y54)

        tv_K57 = findViewById(R.id.tv_K57); tv_L57 = findViewById(R.id.tv_L57); tv_M57 = findViewById(R.id.tv_M57)
        tv_N57 = findViewById(R.id.tv_N57); tv_O57 = findViewById(R.id.tv_O57); tv_P57 = findViewById(R.id.tv_P57)
        tv_Q57 = findViewById(R.id.tv_Q57); tv_R57 = findViewById(R.id.tv_R57); tv_S57 = findViewById(R.id.tv_S57)
        tv_T57 = findViewById(R.id.tv_T57); tv_V57 = findViewById(R.id.tv_V57); tv_W57 = findViewById(R.id.tv_W57)
        tv_X57 = findViewById(R.id.tv_X57); tv_Y57 = findViewById(R.id.tv_Y57)

        et_K60 = findViewById(R.id.et_K60); et_L60 = findViewById(R.id.et_L60); tv_M60 = findViewById(R.id.tv_M60)
        tv_N60 = findViewById(R.id.tv_N60); et_O60 = findViewById(R.id.et_O60); tv_P60 = findViewById(R.id.tv_P60)
        tv_Q60 = findViewById(R.id.tv_Q60); tv_R60 = findViewById(R.id.tv_R60); tv_S60 = findViewById(R.id.tv_S60)
        tv_T60 = findViewById(R.id.tv_T60); tv_U60 = findViewById(R.id.tv_U60); tv_V60 = findViewById(R.id.tv_V60)
        tv_W60 = findViewById(R.id.tv_W60); et_X60 = findViewById(R.id.et_X60); et_Y60 = findViewById(R.id.et_Y60)

        allInputEditTexts = listOf(
            et_H45, et_I45, et_J45, et_K45, et_L45, et_M45, et_N45, et_O45, et_P45, et_Q45, et_R45, et_S45,
            et_H46, et_I46, et_J46, et_K46, et_L46, et_M46, et_N46, et_O46, et_P46, et_Q46, et_R46, et_S46,
            et_H47, et_I47, et_J47, et_K47, et_L47, et_M47, et_N47, et_O47, et_P47, et_Q47, et_R47, et_S47,
            et_H48, et_I48, et_J48, et_K48, et_L48, et_M48, et_N48, et_O48, et_P48, et_Q48, et_R48, et_S48,
            et_H49, et_I49, et_J49,
            et_H54,
            et_K52, et_L52, et_M52, et_N52, et_O52, et_P52, et_Q52, et_R52, et_S52,
            et_K54, et_L54, et_M54, et_N54, et_O54, et_P54, et_Q54, et_R54, et_S54, et_T54,
            et_K60, et_L60, et_O60, et_X60, et_Y60
        )

        // Initialize allSwitches list
        allSwitches = listOf(switch_row2, switch_row3, switch_row4, switch_row5)
    }

    private fun setupListeners() {
        // Remove any existing listeners first
        allInputEditTexts.forEach { it.removeTextChangedListener(mainTextWatcher) }
        
        // Add text watcher to always editable fields
        val alwaysEditableFields = listOf(
            et_H45, et_I45, et_J45, et_K45, et_L45, et_M45, et_N45, et_O45, et_P45, et_Q45, et_R45, et_S45,
            et_H54,
            et_K52, et_L52, et_M52, et_N52, et_O52, et_P52, et_Q52, et_R52, et_S52,
            et_K54, et_L54, et_M54, et_N54, et_O54, et_P54, et_Q54, et_R54, et_S54, et_T54,
            et_K60, et_L60, et_O60, et_X60, et_Y60
        )
        
        alwaysEditableFields.forEach { editText ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (currentSavedDataId != -1L) {
                        isDataModified = true
                    }
                    recalculateAndUpdate()
                }
            })
        }
        
        // Setup switch listeners after text watchers
        setupSwitchListeners()
    }

    private fun setupSwitchListeners() {
        allSwitches.forEach { switch ->
            switch.setOnCheckedChangeListener { _, isChecked ->
                // Temporarily remove text watcher to prevent recursive updates
                val editTexts = when (switch) {
                    switch_row2 -> listOf(et_H46, et_I46, et_J46) + xrfRow2
                    switch_row3 -> listOf(et_H47, et_I47, et_J47) + xrfRow3
                    switch_row4 -> listOf(et_H48, et_I48, et_J48) + xrfRow4
                    switch_row5 -> listOf(et_H49, et_I49, et_J49)
                    else -> emptyList()
                }
                
                // Remove text watchers before changing state
                editTexts.forEach { it.removeTextChangedListener(mainTextWatcher) }
                
                // Update switch state
                if (currentSavedDataId != -1L) {
                    isDataModified = true
                }
                
                // Toggle edit texts
                toggleEditTextsManual(editTexts, isChecked, mainTextWatcher)
                
                // Recalculate after state change
                recalculateAndUpdate()
            }
        }
    }

    private fun toggleEditTextsManual(editTexts: List<EditText>, isManual: Boolean, watcher: TextWatcher) {
        editTexts.forEach { et ->
            // Remove any existing custom watcher
            customWatchers[et]?.let { existingWatcher ->
                et.removeTextChangedListener(existingWatcher)
                customWatchers.remove(et)
            }
            
            // Remove main watcher if it exists
            try {
                et.removeTextChangedListener(watcher)
            } catch (e: Exception) {
                // Ignore if watcher wasn't attached
            }

            if (isManual) {
                // Manual mode
                et.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
                et.isFocusable = true
                et.isFocusableInTouchMode = true
                et.isCursorVisible = true
                
                // Create a new custom watcher
                val customWatcher = object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                    override fun afterTextChanged(s: Editable?) {
                        try {
                            // If user starts typing, remove hint and show actual text
                            if (s?.isNotEmpty() == true) {
                                et.hint = ""
                            } else {
                                // If field becomes empty, restore hint
                                et.hint = "0.00"
                            }
                            // Call the main watcher for calculations
                            watcher.afterTextChanged(s)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
                
                // Store and add the custom watcher
                customWatchers[et] = customWatcher
                et.addTextChangedListener(customWatcher)
                
                // Set hint to current value if it's not empty
                val currentValue = et.text.toString()
                if (currentValue.isNotEmpty() && currentValue != "0.00") {
                    et.hint = currentValue
                    et.setText("")
                } else {
                    et.hint = "0.00"
                    et.setText("")
                }
            } else {
                // Auto mode
                et.inputType = InputType.TYPE_NULL
                et.isFocusable = false
                et.isFocusableInTouchMode = false
                et.isCursorVisible = false
                et.hint = ""
                
                // In auto mode, we don't need any watchers
                // The values will be updated through recalculateAndUpdate
            }
        }
    }

    private fun getDouble(view: View, key: String): Double { // Used for TextViews or pre-calculated values
        val text = when (view) {
            is EditText -> view.text.toString()
            is TextView -> view.text.toString()
            else -> "0.0"
        }
        return values[key] ?: text.toDoubleOrNull() ?: 0.0
    }

    private fun getDoubleInput(view: EditText, key: String): Double { // Used for primary EditText inputs
        val textValue = view.text.toString()
        val value = if (textValue.isEmpty() && !view.isFocusable) { // Handle AUTO fields that might be empty before calc
            0.0 // Default to 0 if an AUTO field is somehow empty before its calculation
        } else {
            textValue.toDoubleOrNull() ?: 0.0
        }
        values[key] = value
        return value
    }

    private fun setDouble(view: TextView, value: Double) {
        view.text = df.format(value)
    }
    private fun setDouble(view: EditText, value: Double) {
        view.setText(df.format(value))
    }

    private fun recalculateAndUpdate() {
        // 1. Gather all user inputs into values map
        allInputEditTexts.forEach { editText ->
            val idName = resources.getResourceEntryName(editText.id)
            getDoubleInput(editText, idName)
        }

        // --- MATERIAL SETTING: LIMESTONE, SHALE, IRON ORE ---
        // Row 1: Always Manual
        // H45, I45, J45 are user inputs
        
        // Row 2-5: AUTO/MANUAL depending on switch
        // For manual mode (switch.isChecked = true), use user input values
        // For auto mode (switch.isChecked = false), calculate values
        
        // Row 2
        if (!switch_row2.isChecked) {
            // Auto mode calculations
            values["et_H46"] = (values["et_H45"] ?: 0.0) + (values["et_N52"] ?: 0.0) - (values["et_N45"] ?: 0.0)
            values["et_J46"] = (values["et_J45"] ?: 0.0) + (values["et_M52"] ?: 0.0) - (values["et_M45"] ?: 0.0)
            values["et_I46"] = 100.0 - (values["et_H46"] ?: 0.0) - (values["et_J46"] ?: 0.0)
        }
        // Row 3
        if (!switch_row3.isChecked) {
            // Auto mode calculations
            values["et_H47"] = (values["et_H46"] ?: 0.0) + (values["et_N52"] ?: 0.0) - (values["et_N46"] ?: 0.0)
            values["et_J47"] = (values["et_J46"] ?: 0.0) + (values["et_M52"] ?: 0.0) - (values["et_M46"] ?: 0.0)
            values["et_I47"] = 100.0 - (values["et_H47"] ?: 0.0) - (values["et_J47"] ?: 0.0)
        }
        // Row 4
        if (!switch_row4.isChecked) {
            // Auto mode calculations
            values["et_H48"] = (values["et_H47"] ?: 0.0) + (values["et_N52"] ?: 0.0) - (values["et_N47"] ?: 0.0)
            values["et_J48"] = (values["et_J47"] ?: 0.0) + (values["et_M52"] ?: 0.0) - (values["et_M47"] ?: 0.0)
            values["et_I48"] = 100.0 - (values["et_H48"] ?: 0.0) - (values["et_J48"] ?: 0.0)
        }
        // Row 5
        if (!switch_row5.isChecked) {
            // Auto mode calculations
            values["et_H49"] = (values["et_H48"] ?: 0.0) + (values["et_N52"] ?: 0.0) - (values["et_N48"] ?: 0.0)
            values["et_J49"] = (values["et_J48"] ?: 0.0) + (values["et_M52"] ?: 0.0) - (values["et_M48"] ?: 0.0)
            values["et_I49"] = 100.0 - (values["et_H49"] ?: 0.0) - (values["et_J49"] ?: 0.0)
        }

        // --- TOTAL1 (G45-G49) ---
        values["G45"] = (values["et_H45"] ?: 0.0) + (values["et_I45"] ?: 0.0) + (values["et_J45"] ?: 0.0)
        values["G46"] = (values["et_H46"] ?: 0.0) + (values["et_I46"] ?: 0.0) + (values["et_J46"] ?: 0.0)
        values["G47"] = (values["et_H47"] ?: 0.0) + (values["et_I47"] ?: 0.0) + (values["et_J47"] ?: 0.0)
        values["G48"] = (values["et_H48"] ?: 0.0) + (values["et_I48"] ?: 0.0) + (values["et_J48"] ?: 0.0)
        values["G49"] = (values["et_H49"] ?: 0.0) + (values["et_I49"] ?: 0.0) + (values["et_J49"] ?: 0.0)

        // --- LOI (T45-T48) ---
        values["T45"] = 0.786 * (values["et_N45"] ?: 0.0) + 1.1 * (values["et_O45"] ?: 0.0) + 0.2
        values["T46"] = 0.786 * (values["et_N46"] ?: 0.0) + 1.1 * (values["et_O46"] ?: 0.0) + 0.2
        values["T47"] = 0.786 * (values["et_N47"] ?: 0.0) + 1.1 * (values["et_O47"] ?: 0.0) + 0.2
        values["T48"] = 0.786 * (values["et_N48"] ?: 0.0) + 1.1 * (values["et_O48"] ?: 0.0) + 0.2

        // --- TOTAL2 (U45-U48) ---
        values["U45"] = listOf("et_K45","et_L45","et_M45","et_N45","et_O45","et_P45","et_Q45","et_R45","et_S45","T45").sumOf { values[it] ?: 0.0 }
        values["U46"] = listOf("et_K46","et_L46","et_M46","et_N46","et_O46","et_P46","et_Q46","et_R46","et_S46","T46").sumOf { values[it] ?: 0.0 }
        values["U47"] = listOf("et_K47","et_L47","et_M47","et_N47","et_O47","et_P47","et_Q47","et_R47","et_S47","T47").sumOf { values[it] ?: 0.0 }
        values["U48"] = listOf("et_K48","et_L48","et_M48","et_N48","et_O48","et_P48","et_Q48","et_R48","et_S48","T48").sumOf { values[it] ?: 0.0 }

        // --- RATIOS (V45-Y48) ---
        fun lsf(n: Double, k: Double, l: Double, m: Double): Double {
            val den = 2.8 * k + 1.2 * l + 0.65 * m
            return if (den == 0.0) 0.0 else n * 100 / den
        }
        fun hm(n: Double, k: Double, l: Double, m: Double): Double {
            val den = k + l + m
            return if (den == 0.0) 0.0 else n / den
        }
        fun sm(k: Double, l: Double, m: Double): Double {
            val den = l + m
            return if (den == 0.0) 0.0 else k / den
        }
        fun am(l: Double, m: Double): Double {
            return if (m == 0.0) 0.0 else l / m
        }
        values["V45"] = lsf(values["et_N45"] ?: 0.0, values["et_K45"] ?: 0.0, values["et_L45"] ?: 0.0, values["et_M45"] ?: 0.0)
        values["V46"] = lsf(values["et_N46"] ?: 0.0, values["et_K46"] ?: 0.0, values["et_L46"] ?: 0.0, values["et_M46"] ?: 0.0)
        values["V47"] = lsf(values["et_N47"] ?: 0.0, values["et_K47"] ?: 0.0, values["et_L47"] ?: 0.0, values["et_M47"] ?: 0.0)
        values["V48"] = lsf(values["et_N48"] ?: 0.0, values["et_K48"] ?: 0.0, values["et_L48"] ?: 0.0, values["et_M48"] ?: 0.0)
        values["W45"] = hm(values["et_N45"] ?: 0.0, values["et_K45"] ?: 0.0, values["et_L45"] ?: 0.0, values["et_M45"] ?: 0.0)
        values["W46"] = hm(values["et_N46"] ?: 0.0, values["et_K46"] ?: 0.0, values["et_L46"] ?: 0.0, values["et_M46"] ?: 0.0)
        values["W47"] = hm(values["et_N47"] ?: 0.0, values["et_K47"] ?: 0.0, values["et_L47"] ?: 0.0, values["et_M47"] ?: 0.0)
        values["W48"] = hm(values["et_N48"] ?: 0.0, values["et_K48"] ?: 0.0, values["et_L48"] ?: 0.0, values["et_M48"] ?: 0.0)
        values["X45"] = sm(values["et_K45"] ?: 0.0, values["et_L45"] ?: 0.0, values["et_M45"] ?: 0.0)
        values["X46"] = sm(values["et_K46"] ?: 0.0, values["et_L46"] ?: 0.0, values["et_M46"] ?: 0.0)
        values["X47"] = sm(values["et_K47"] ?: 0.0, values["et_L47"] ?: 0.0, values["et_M47"] ?: 0.0)
        values["X48"] = sm(values["et_K48"] ?: 0.0, values["et_L48"] ?: 0.0, values["et_M48"] ?: 0.0)
        values["Y45"] = am(values["et_L45"] ?: 0.0, values["et_M45"] ?: 0.0)
        values["Y46"] = am(values["et_L46"] ?: 0.0, values["et_M46"] ?: 0.0)
        values["Y47"] = am(values["et_L47"] ?: 0.0, values["et_M47"] ?: 0.0)
        values["Y48"] = am(values["et_L48"] ?: 0.0, values["et_M48"] ?: 0.0)

        // --- TARGET TABLE ---
        values["H52"] = values["V52"] ?: 0.0
        values["H53"] = values["Y52"] ?: 0.0
        // H54 is user input

        // --- TARGET RAWMEAL COMPOSITION ---
        values["T52"] = 0.786 * (values["et_N52"] ?: 0.0) + 1.1 * (values["et_O52"] ?: 0.0) + 0.2
        values["U52"] = listOf("et_K52","et_L52","et_M52","et_N52","et_O52","et_P52","et_Q52","et_R52","et_S52","T52").sumOf { values[it] ?: 0.0 }
        values["V52"] = lsf(values["et_N52"] ?: 0.0, values["et_K52"] ?: 0.0, values["et_L52"] ?: 0.0, values["et_M52"] ?: 0.0)
        values["W52"] = hm(values["et_N52"] ?: 0.0, values["et_K52"] ?: 0.0, values["et_L52"] ?: 0.0, values["et_M52"] ?: 0.0)
        values["X52"] = sm(values["et_K52"] ?: 0.0, values["et_L52"] ?: 0.0, values["et_M52"] ?: 0.0)
        values["Y52"] = am(values["et_L52"] ?: 0.0, values["et_M52"] ?: 0.0)

        // --- COAL ASH COMPOSITION ---
        values["U54"] = listOf("et_K54","et_L54","et_M54","et_N54","et_O54","et_P54","et_Q54","et_R54","et_S54","et_T54").sumOf { values[it] ?: 0.0 }
        values["V54"] = lsf(values["et_N54"] ?: 0.0, values["et_K54"] ?: 0.0, values["et_L54"] ?: 0.0, values["et_M54"] ?: 0.0)
        values["W54"] = hm(values["et_N54"] ?: 0.0, values["et_K54"] ?: 0.0, values["et_L54"] ?: 0.0, values["et_M54"] ?: 0.0)
        values["X54"] = sm(values["et_K54"] ?: 0.0, values["et_L54"] ?: 0.0, values["et_M54"] ?: 0.0)
        values["Y54"] = am(values["et_L54"] ?: 0.0, values["et_M54"] ?: 0.0)

        // --- POTENTIAL CLINKER COMPOSITION ---
        val t52 = values["T52"] ?: 0.0
        val h54 = (values["et_H54"] ?: 0.0) / 100.0
        val factor1 = if (1.0 - t52 / 100.0 == 0.0) 0.0 else 1.0 / (1.0 - t52 / 100.0)
        val factor_1_minus_h54 = 1.0 - h54
        values["K57"] = factor1 * (values["et_K52"] ?: 0.0) * factor_1_minus_h54 + (values["et_K54"] ?: 0.0) * h54
        values["L57"] = factor1 * (values["et_L52"] ?: 0.0) * factor_1_minus_h54 + (values["et_L54"] ?: 0.0) * h54
        values["M57"] = factor1 * (values["et_M52"] ?: 0.0) * factor_1_minus_h54 + (values["et_M54"] ?: 0.0) * h54
        values["N57"] = factor1 * (values["et_N52"] ?: 0.0) * factor_1_minus_h54 + (values["et_N54"] ?: 0.0) * h54
        values["O57"] = factor1 * (values["et_O52"] ?: 0.0) * factor_1_minus_h54 + (values["et_O54"] ?: 0.0) * h54
        values["P57"] = factor1 * (values["et_P52"] ?: 0.0) * factor_1_minus_h54 + (values["et_P54"] ?: 0.0) * h54
        // Q57 special formula - using Z52 (which equals T52) for the calculation
        val z52 = t52 // Z52 = T52
        val q52 = values["et_Q52"] ?: 0.0
        val n60 = (values["N60"] ?: 0.0) / 100.0
        val q54 = values["et_Q54"] ?: 0.0
        val factorZ = if (1.0 - z52 / 100.0 == 0.0) 0.0 else 1.0 / (1.0 - z52 / 100.0)
        values["Q57"] = factorZ * q52 * (1.0 - n60) + q54 * n60
        values["R57"] = factor1 * (values["et_R52"] ?: 0.0) * factor_1_minus_h54 + (values["et_R54"] ?: 0.0) * h54
        values["S57"] = factor1 * (values["et_S52"] ?: 0.0) * factor_1_minus_h54 + (values["et_S54"] ?: 0.0) * h54
        // T57 is the sum of K57 through S57
        values["T57"] = listOf("K57","L57","M57","N57","O57","P57","Q57","R57","S57").sumOf { values[it] ?: 0.0 }
        values["V57"] = lsf(values["N57"] ?: 0.0, values["K57"] ?: 0.0, values["L57"] ?: 0.0, values["M57"] ?: 0.0)
        values["W57"] = hm(values["N57"] ?: 0.0, values["K57"] ?: 0.0, values["L57"] ?: 0.0, values["M57"] ?: 0.0)
        values["X57"] = sm(values["K57"] ?: 0.0, values["L57"] ?: 0.0, values["M57"] ?: 0.0)
        values["Y57"] = am(values["L57"] ?: 0.0, values["M57"] ?: 0.0)

        // --- MINERALS & HOTMEAL ---
        // K60, L60, O60, X60, Y60 are user inputs
        // M60 is always 'reducing'
        // N60 = ((O60/100)-(Y60/100))/((O60/100)-(O60/100)*(Y60/100))*100
        val o60 = (values["et_O60"] ?: 0.0) / 100.0
        val y60 = (values["et_Y60"] ?: 0.0) / 100.0
        val doc_num = o60 - y60
        val doc_den = o60 - (o60 * y60)
        values["N60"] = if (doc_den == 0.0) 0.0 else (doc_num / doc_den) * 100.0
        // P60 = 4.071*(N57-L60)-7.6024*K57-6.718*L57-1.4297*M57
        val n57 = values["N57"] ?: 0.0
        val l60 = values["et_L60"] ?: 0.0
        val k57 = values["K57"] ?: 0.0
        val l57 = values["L57"] ?: 0.0
        val m57 = values["M57"] ?: 0.0
        values["P60"] = 4.071 * (n57 - l60) - 7.6024 * k57 - 6.718 * l57 - 1.4297 * m57
        // Q60 = 8.6024*K57+5.0683*L57+1.0785*M57-3.071*(N57-L60)
        values["Q60"] = 8.6024 * k57 + 5.0683 * l57 + 1.0785 * m57 - 3.071 * (n57 - l60)
        // R60 = 2.65*L57-1.692*M57
        values["R60"] = 2.65 * l57 - 1.692 * m57
        // S60 = 3.0432*M57
        values["S60"] = 3.0432 * m57
        // T60 = R57/(Q57+0.5*P57) - Fixed calculation
        val r57 = values["R57"] ?: 0.0
        val q57 = values["Q57"] ?: 0.0
        val p57 = values["P57"] ?: 0.0
        val t60_den = q57 + 0.5 * p57
        values["T60"] = if (t60_den == 0.0) 0.0 else r57 / t60_den
        // U60 = P57+(0.658*Q57) - Fixed calculation
        values["U60"] = p57 + (0.658 * q57)
        // V60 = 3*L57+2.25*M57+O57+P57+Q57+R57 - Fixed calculation
        val o57 = values["O57"] ?: 0.0
        values["V60"] = 3 * l57 + 2.25 * m57 + o57 + p57 + q57 + r57
        // W60 = R60+S60+(Q60*0.2)+(2*M57)
        val r60 = values["R60"] ?: 0.0
        val s60 = values["S60"] ?: 0.0
        val q60 = values["Q60"] ?: 0.0
        values["W60"] = r60 + s60 + (q60 * 0.2) + (2 * m57)

        // --- UI UPDATE ---
        setDouble(tv_G45, values["G45"] ?: 0.0)
        setDouble(tv_T45, values["T45"] ?: 0.0)
        setDouble(tv_U45, values["U45"] ?: 0.0)
        setDouble(tv_V45, values["V45"] ?: 0.0)
        setDouble(tv_W45, values["W45"] ?: 0.0)
        setDouble(tv_X45, values["X45"] ?: 0.0)
        setDouble(tv_Y45, values["Y45"] ?: 0.0)

        setDouble(tv_G46, values["G46"] ?: 0.0)
        if (!switch_row2.isChecked) {
            setDouble(et_H46, values["et_H46"] ?: 0.0)
            setDouble(et_I46, values["et_I46"] ?: 0.0)
            setDouble(et_J46, values["et_J46"] ?: 0.0)
            // Also update XRF row 2
            xrfRow2.forEachIndexed { index, et ->
                val key = when(index) {
                    0 -> "et_K46"
                    1 -> "et_L46"
                    2 -> "et_M46"
                    3 -> "et_N46"
                    4 -> "et_O46"
                    5 -> "et_P46"
                    6 -> "et_Q46"
                    7 -> "et_R46"
                    8 -> "et_S46"
                    else -> return@forEachIndexed
                }
                setDouble(et, values[key] ?: 0.0)
            }
        }
        setDouble(tv_T46, values["T46"] ?: 0.0); setDouble(tv_U46, values["U46"] ?: 0.0); setDouble(tv_V46, values["V46"] ?: 0.0)
        setDouble(tv_W46, values["W46"] ?: 0.0); setDouble(tv_X46, values["X46"] ?: 0.0); setDouble(tv_Y46, values["Y46"] ?: 0.0)

        setDouble(tv_G47, values["G47"] ?: 0.0)
        if (!switch_row3.isChecked) {
            setDouble(et_H47, values["et_H47"] ?: 0.0)
            setDouble(et_I47, values["et_I47"] ?: 0.0)
            setDouble(et_J47, values["et_J47"] ?: 0.0)
            // Also update XRF row 3
            xrfRow3.forEachIndexed { index, et ->
                val key = when(index) {
                    0 -> "et_K47"
                    1 -> "et_L47"
                    2 -> "et_M47"
                    3 -> "et_N47"
                    4 -> "et_O47"
                    5 -> "et_P47"
                    6 -> "et_Q47"
                    7 -> "et_R47"
                    8 -> "et_S47"
                    else -> return@forEachIndexed
                }
                setDouble(et, values[key] ?: 0.0)
            }
        }
        setDouble(tv_T47, values["T47"] ?: 0.0); setDouble(tv_U47, values["U47"] ?: 0.0); setDouble(tv_V47, values["V47"] ?: 0.0)
        setDouble(tv_W47, values["W47"] ?: 0.0); setDouble(tv_X47, values["X47"] ?: 0.0); setDouble(tv_Y47, values["Y47"] ?: 0.0)

        setDouble(tv_G48, values["G48"] ?: 0.0)
        if (!switch_row4.isChecked) {
            setDouble(et_H48, values["et_H48"] ?: 0.0)
            setDouble(et_I48, values["et_I48"] ?: 0.0)
            setDouble(et_J48, values["et_J48"] ?: 0.0)
            // Also update XRF row 4
            xrfRow4.forEachIndexed { index, et ->
                val key = when(index) {
                    0 -> "et_K48"
                    1 -> "et_L48"
                    2 -> "et_M48"
                    3 -> "et_N48"
                    4 -> "et_O48"
                    5 -> "et_P48"
                    6 -> "et_Q48"
                    7 -> "et_R48"
                    8 -> "et_S48"
                    else -> return@forEachIndexed
                }
                setDouble(et, values[key] ?: 0.0)
            }
        }
        setDouble(tv_T48, values["T48"] ?: 0.0); setDouble(tv_U48, values["U48"] ?: 0.0); setDouble(tv_V48, values["V48"] ?: 0.0)
        setDouble(tv_W48, values["W48"] ?: 0.0); setDouble(tv_X48, values["X48"] ?: 0.0); setDouble(tv_Y48, values["Y48"] ?: 0.0)

        setDouble(tv_G49, values["G49"] ?: 0.0)
        if (!switch_row5.isChecked) {
            setDouble(et_H49, values["et_H49"] ?: 0.0)
            setDouble(et_I49, values["et_I49"] ?: 0.0)
            setDouble(et_J49, values["et_J49"] ?: 0.0)
        }

        setDouble(tv_H52_target_LSF, values["H52"] ?: 0.0)
        setDouble(tv_H53_target_AM, values["H53"] ?: 0.0)

        setDouble(tv_T52_trc_LOI, values["T52"] ?: 0.0)
        setDouble(tv_U52_trc_TOTAL, values["U52"] ?: 0.0)
        setDouble(tv_V52_trc_LSF, values["V52"] ?: 0.0)
        setDouble(tv_W52_trc_SM, values["W52"] ?: 0.0)
        setDouble(tv_X52_trc_SR, values["X52"] ?: 0.0)
        setDouble(tv_Y52_trc_AM, values["Y52"] ?: 0.0)

        setDouble(tv_U54, values["U54"] ?: 0.0); setDouble(tv_V54, values["V54"] ?: 0.0); setDouble(tv_W54, values["W54"] ?: 0.0)
        setDouble(tv_X54, values["X54"] ?: 0.0); setDouble(tv_Y54, values["Y54"] ?: 0.0)

        setDouble(tv_K57, values["K57"] ?: 0.0); setDouble(tv_L57, values["L57"] ?: 0.0); setDouble(tv_M57, values["M57"] ?: 0.0)
        setDouble(tv_N57, values["N57"] ?: 0.0); setDouble(tv_O57, values["O57"] ?: 0.0); setDouble(tv_P57, values["P57"] ?: 0.0)
        setDouble(tv_Q57, values["Q57"] ?: 0.0); setDouble(tv_R57, values["R57"] ?: 0.0); setDouble(tv_S57, values["S57"] ?: 0.0)
        setDouble(tv_T57, values["T57"] ?: 0.0); setDouble(tv_V57, values["V57"] ?: 0.0); setDouble(tv_W57, values["W57"] ?: 0.0)
        setDouble(tv_X57, values["X57"] ?: 0.0); setDouble(tv_Y57, values["Y57"] ?: 0.0)

        setDouble(tv_N60, values["N60"] ?: 0.0); setDouble(tv_P60, values["P60"] ?: 0.0); setDouble(tv_Q60, values["Q60"] ?: 0.0)
        setDouble(tv_R60, values["R60"] ?: 0.0); setDouble(tv_S60, values["S60"] ?: 0.0); setDouble(tv_T60, values["T60"] ?: 0.0)
        setDouble(tv_U60, values["U60"] ?: 0.0); setDouble(tv_V60, values["V60"] ?: 0.0); setDouble(tv_W60, values["W60"] ?: 0.0)
    }

    private fun loadDataFromJson(jsonString: String) {
        try {
            val data = JSONObject(jsonString)

            values.clear()

            // Temporarily remove listeners
            allInputEditTexts.forEach { it.removeTextChangedListener(mainTextWatcher) }

            switch_row2.isChecked = data.optBoolean("switch_row2", false)
            switch_row3.isChecked = data.optBoolean("switch_row3", false)
            switch_row4.isChecked = data.optBoolean("switch_row4", false)
            switch_row5.isChecked = data.optBoolean("switch_row5", false)

            // Set text for all EditTexts that have saved data
            allInputEditTexts.forEach { editText ->
                val idName = resources.getResourceEntryName(editText.id)
                if (data.has(idName)) {
                    editText.setText(data.optString(idName, ""))
                } else {
                    editText.setText("")
                }
            }

            // Now, set up focusability and listeners based on loaded switch states
            val xrfRow2 = listOf(et_K46, et_L46, et_M46, et_N46, et_O46, et_P46, et_Q46, et_R46, et_S46)
            val xrfRow3 = listOf(et_K47, et_L47, et_M47, et_N47, et_O47, et_P47, et_Q47, et_R47, et_S47)
            val xrfRow4 = listOf(et_K48, et_L48, et_M48, et_N48, et_O48, et_P48, et_Q48, et_R48, et_S48)

            toggleEditTextsManual(listOf(et_H46, et_I46, et_J46) + xrfRow2, switch_row2.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H47, et_I47, et_J47) + xrfRow3, switch_row3.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H48, et_I48, et_J48) + xrfRow4, switch_row4.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H49, et_I49, et_J49), switch_row5.isChecked, mainTextWatcher)

            // Re-attach listener to always-editable fields
            val alwaysEditableFields = listOf(
                et_H45, et_I45, et_J45, et_K45, et_L45, et_M45, et_N45, et_O45, et_P45, et_Q45, et_R45, et_S45,
                et_H54,
                et_K52, et_L52, et_M52, et_N52, et_O52, et_P52, et_Q52, et_R52, et_S52,
                et_K54, et_L54, et_M54, et_N54, et_O54, et_P54, et_Q54, et_R54, et_S54, et_T54,
                et_K60, et_L60, et_O60, et_X60, et_Y60
            )
            alwaysEditableFields.forEach {
                it.removeTextChangedListener(mainTextWatcher)
                it.addTextChangedListener(mainTextWatcher)
            }

            recalculateAndUpdate()

            Toast.makeText(this, "Data loaded successfully!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error loading data: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun setupButtons() {
        btnSave.setOnClickListener {
            saveCurrentData()
        }

        btnClear.setOnClickListener {
            showClearConfirmation()
        }
    }

    private fun saveCurrentData() {
        try {
            // Create a dialog for naming the save
            val dialogView = layoutInflater.inflate(R.layout.dialog_save_name, null)
            val etSaveName = dialogView.findViewById<EditText>(R.id.et_save_name)
            
            AlertDialog.Builder(this)
                .setTitle("Save Data")
                .setView(dialogView)
                .setPositiveButton("Save") { _, _ ->
                    val saveName = etSaveName.text.toString().trim()
                    val data = JSONObject()
                    
                    // Save all EditText values
                    allInputEditTexts.forEach { editText ->
                        val idName = resources.getResourceEntryName(editText.id)
                        data.put(idName, editText.text.toString())
                    }

                    // Save all Switch states
                    allSwitches.forEach { switch ->
                        val idName = resources.getResourceEntryName(switch.id)
                        data.put(idName, switch.isChecked)
                    }

                    // Save to database with title
                    dbHelper.saveData(1, data.toString(), if (saveName.isEmpty()) null else saveName)
                    Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel", null)
                .show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error saving data: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun formatTimestamp(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    private fun showClearConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Clear Table")
            .setMessage("Are you sure you want to clear all data?")
            .setPositiveButton("Clear") { _, _ ->
                clearAllData()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun clearAllData() {
        // Clear all EditTexts
        allInputEditTexts.forEach { it.setText("") }
        
        // Reset switches
        switch_row2.isChecked = false
        switch_row3.isChecked = false
        switch_row4.isChecked = false
        switch_row5.isChecked = false

        // Clear values map
        values.clear()

        // Recalculate and update UI
        recalculateAndUpdate()
        Toast.makeText(this, "All data cleared", Toast.LENGTH_SHORT).show()
    }

    private fun loadSavedData(savedDataId: Long) {
        try {
            val entry = dbHelper.getSavedData(savedDataId)
            if (entry != null) {
                originalDataJson = entry.data // Store original data for comparison
                val data = JSONObject(entry.data)
                
                // Temporarily remove listeners
                allInputEditTexts.forEach { it.removeTextChangedListener(mainTextWatcher) }
                allSwitches.forEach { it.setOnCheckedChangeListener(null) }

                // Load all EditText values
                allInputEditTexts.forEach { editText ->
                    val idName = resources.getResourceEntryName(editText.id)
                    if (data.has(idName)) {
                        editText.setText(data.optString(idName, ""))
                    } else {
                        editText.setText("")
                    }
                }

                // Load all Switch states
                allSwitches.forEach { switch ->
                    val idName = resources.getResourceEntryName(switch.id)
                    if (data.has(idName)) {
                        switch.isChecked = data.optBoolean(idName, false)
                    }
                }

                // Reattach listeners
                allInputEditTexts.forEach { it.addTextChangedListener(mainTextWatcher) }
                setupSwitchListeners()

                // Recalculate
                recalculateAndUpdate()
                Toast.makeText(this, "Data loaded successfully!", Toast.LENGTH_SHORT).show()

                // Reset modification flag after loading
                isDataModified = false
            } else {
                Toast.makeText(this, "Saved data not found", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error loading saved data: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onBackPressed() {
        if (currentSavedDataId != -1L && isDataModified) {
            showBackConfirmationDialog()
        } else {
            super.onBackPressed()
        }
    }

    private fun showBackConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Save Changes")
            .setMessage("Do you want to save the changes to this data?")
            .setPositiveButton("Save") { _, _ ->
                updateSavedData()
            }
            .setNegativeButton("Don't Save") { _, _ ->
                finish()
            }
            .setNeutralButton("Cancel", null)
            .show()
    }

    private fun updateSavedData() {
        try {
            val data = JSONObject()
            
            // Save all EditText values
            allInputEditTexts.forEach { editText ->
                val idName = resources.getResourceEntryName(editText.id)
                data.put(idName, editText.text.toString())
            }

            // Save all Switch states
            allSwitches.forEach { switch ->
                val idName = resources.getResourceEntryName(switch.id)
                data.put(idName, switch.isChecked)
            }

            // Update the existing saved data
            dbHelper.updateSavedData(currentSavedDataId, data.toString())
            Toast.makeText(this, "Data updated successfully!", Toast.LENGTH_SHORT).show()
            finish()
        } catch (e: Exception) {
            Toast.makeText(this, "Error updating data: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clean up all custom watchers
        customWatchers.forEach { (editText, watcher) ->
            try {
                editText.removeTextChangedListener(watcher)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        customWatchers.clear()
    }
}