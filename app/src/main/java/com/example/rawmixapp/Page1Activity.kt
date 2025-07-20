package com.example.rawmixapp

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.rawmixapp.db.SavedDataDbHelper
import org.json.JSONArray
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.max

class Page1Activity : BaseActivity() {

    //Declaration for Page2 variables
    private var F31 = 0.0
    private var G31 = 0.0
    private var H31 = 0.0
    private var F32 = 0.0
    private var G32 = 0.0
    private var H32 = 0.0
    private var F33 = 0.0
    private var G33 = 0.0
    private var H33 = 0.0
    private var F34 = 0.0
    private var G34 = 0.0
    private var H34 = 0.0

    //For TRC values, from Sio2 to Cl in Page2
    private var I13 = 0.0
    private var I14 = 0.0
    private var I15 = 0.0
    private var I16 = 0.0
    private var I17 = 0.0
    private var I18 = 0.0
    private var I19 = 0.0
    private var I20 = 0.0
    private var I21 = 0.0
    private var I22 = 0.0

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
    private lateinit var et_T52_trc_LOI: EditText
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
    private lateinit var et_M60: EditText
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

    // Add raw_mix_type field
    private lateinit var raw_mix_type: EditText

    private val df1 = DecimalFormat("#,##0.0")
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

        // Retrieve the values from Page2DataCache
        F31 = Page2DataCache.sio2Limestone
        G31 = Page2DataCache.sio2Shale
        H31 = Page2DataCache.sio2IronOre

        F32 = Page2DataCache.al2o3Limestone
        G32 = Page2DataCache.al2o3Shale
        H32 = Page2DataCache.al2o3IronOre

        F33 = Page2DataCache.fe2o3Limestone
        G33 = Page2DataCache.fe2o3Shale
        H33 = Page2DataCache.fe2o3IronOre

        F34 = Page2DataCache.caoLimestone
        G34 = Page2DataCache.caoShale
        H34 = Page2DataCache.caoIronOre

        //Retrieve the values from Page2DataCache
        I13 =Page2DataCache.sio2Rawmeal
        I14 =Page2DataCache.al2o3Rawmeal
        I15 =Page2DataCache.fe2o3Rawmeal
        I16 =Page2DataCache.caoRawmeal
        I17 =Page2DataCache.mgoRawmeal
        I18 =Page2DataCache.na2oRawmeal
        I19 =Page2DataCache.k2oRawmeal
        I20 =Page2DataCache.so3Rawmeal
        I21 =Page2DataCache.clRawmeal
        I22 =Page2DataCache.loiRawmeal
        Log.d("Page1Debug", "LOI from Page2 = $I22")
        Toast.makeText(this, "LOI from Page2 = $I22", Toast.LENGTH_SHORT).show()

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
            et_K52, et_L52, et_M52, et_N52, et_O52, et_P52, et_Q52, et_R52, et_S52, et_T52_trc_LOI,
            et_K54, et_L54, et_M54, et_N54, et_O54, et_P54, et_Q54, et_R54, et_S54, et_T54,
            et_K60, et_L60, et_M60, et_O60, et_X60, et_Y60,
            raw_mix_type
        )
        alwaysEditableFields.forEach { editText ->
            editText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            editText.isFocusable = true
            editText.isFocusableInTouchMode = true
            editText.isCursorVisible = true
            editText.addTextChangedListener(mainTextWatcher)
        }

        // Configure text field that's not numeric
        raw_mix_type.inputType = InputType.TYPE_CLASS_TEXT
        raw_mix_type.isFocusable = true
        raw_mix_type.isFocusableInTouchMode = true
        raw_mix_type.isCursorVisible = true
        raw_mix_type.addTextChangedListener(mainTextWatcher)

        // Set et_M60 to use text input
        et_M60.inputType = InputType.TYPE_CLASS_TEXT
        et_M60.isFocusable = true
        et_M60.isFocusableInTouchMode = true
        et_M60.isCursorVisible = true

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
        cachePage1Fields()
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
        et_T52_trc_LOI = findViewById(R.id.et_T52); tv_U52_trc_TOTAL = findViewById(R.id.tv_U52); tv_V52_trc_LSF = findViewById(R.id.tv_V52)
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

        et_K60 = findViewById(R.id.et_K60); et_L60 = findViewById(R.id.et_L60); et_M60 = findViewById(R.id.et_M60)
        tv_N60 = findViewById(R.id.tv_N60); et_O60 = findViewById(R.id.et_O60); tv_P60 = findViewById(R.id.tv_P60)
        tv_Q60 = findViewById(R.id.tv_Q60); tv_R60 = findViewById(R.id.tv_R60); tv_S60 = findViewById(R.id.tv_S60)
        tv_T60 = findViewById(R.id.tv_T60); tv_U60 = findViewById(R.id.tv_U60); tv_V60 = findViewById(R.id.tv_V60)
        tv_W60 = findViewById(R.id.tv_W60); et_X60 = findViewById(R.id.et_X60); et_Y60 = findViewById(R.id.et_Y60)

        // Initialize raw_mix_type
        raw_mix_type = findViewById(R.id.raw_mix_type)

        allInputEditTexts = listOf(
            et_H45, et_I45, et_J45, et_K45, et_L45, et_M45, et_N45, et_O45, et_P45, et_Q45, et_R45, et_S45,
            et_H46, et_I46, et_J46, et_K46, et_L46, et_M46, et_N46, et_O46, et_P46, et_Q46, et_R46, et_S46,
            et_H47, et_I47, et_J47, et_K47, et_L47, et_M47, et_N47, et_O47, et_P47, et_Q47, et_R47, et_S47,
            et_H48, et_I48, et_J48, et_K48, et_L48, et_M48, et_N48, et_O48, et_P48, et_Q48, et_R48, et_S48,
            et_H49, et_I49, et_J49,
            et_H54,
            et_K52, et_L52, et_M52, et_N52, et_O52, et_P52, et_Q52, et_R52, et_S52, et_T52_trc_LOI,
            et_K54, et_L54, et_M54, et_N54, et_O54, et_P54, et_Q54, et_R54, et_S54, et_T54,
            et_K60, et_L60, et_M60, et_O60, et_X60, et_Y60,
            raw_mix_type
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
            et_K52, et_L52, et_M52, et_N52, et_O52, et_P52, et_Q52, et_R52, et_S52, et_T52_trc_LOI,
            et_K54, et_L54, et_M54, et_N54, et_O54, et_P54, et_Q54, et_R54, et_S54, et_T54,
            et_K60, et_L60, et_M60, et_O60, et_X60, et_Y60,
            raw_mix_type
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
                    switch_row2 -> listOf(et_H46, et_I46, et_J46)
                    switch_row3 -> listOf(et_H47, et_I47, et_J47)
                    switch_row4 -> listOf(et_H48, et_I48, et_J48)
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
                if (et.id == R.id.et_M60) {
                    // Special case for et_M60 - preserve text input
                    et.inputType = InputType.TYPE_CLASS_TEXT
                    et.hint = "Cond."
                } else {
                    // Normal numeric input for other fields
                    et.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
                    et.hint = "0.00"
                }
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
                                if (et.id == R.id.et_M60) {
                                    et.hint = "Cond."
                                } else {
                                    et.hint = "0.00"
                                }
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
                if (currentValue.isNotEmpty() && currentValue != "0.00" && currentValue != "Cond.") {
                    et.hint = currentValue
                    et.setText("")
                } else {
                    if (et.id == R.id.et_M60) {
                        et.hint = "Cond."
                    } else {
                        et.hint = "0.00"
                    }
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
        // Special case for text fields like et_M60 and raw_mix_type
        if (view.id == R.id.et_M60 || view.id == R.id.raw_mix_type) {
            // These are text fields, don't try to convert to double
            // Just store the text value in values map for future reference
            values[key] = 0.0
            return 0.0
        }

        val textValue = view.text.toString()
        val value = if (textValue.isEmpty() && !view.isFocusable) { // Handle AUTO fields that might be empty before calc
            0.0 // Default to 0 if an AUTO field is somehow empty before its calculation
        } else {
            textValue.toDoubleOrNull() ?: 0.0
        }
        values[key] = value
        return value
    }

    // For TextView
    private fun setDouble(view: TextView, value: Double) {
        // val idName = resources.getResourceEntryName(view.id)
        // val useOneDecimal = idName.matches(Regex("tv_G4[5-9]"))
        // val formatted = if (useOneDecimal) df1.format(value) else df.format(value)

        val formatted = df.format(value)  // Always use 2 decimal places for now
        view.text = formatted
    }

    // For EditText
    private fun setDouble(view: EditText, value: Double) {
        // val idName = resources.getResourceEntryName(view.id)
        // val useOneDecimal = idName.matches(Regex("et_[HIJ]4[5-9]"))
        // val formatted = if (useOneDecimal) df1.format(value) else df.format(value)

        val formatted = df.format(value)  // Always use 2 decimal places for now

        if (view.text.toString() != formatted) {
            val watcher = customWatchers[view]
            watcher?.let { view.removeTextChangedListener(it) }

            view.setText(formatted)
            view.setSelection(view.text.length)

            watcher?.let { view.addTextChangedListener(it) }
        }
    }


    private fun recalculateAndUpdate() {
        // 1. Gather all user inputs into values map
        allInputEditTexts.forEach { editText ->
            val idName = resources.getResourceEntryName(editText.id)
            getDoubleInput(editText, idName)
        }

// Pull from Page2DataCache first
        val I13 = Page2DataCache.sio2Rawmeal
        val I14 = Page2DataCache.al2o3Rawmeal
        val I15 = Page2DataCache.fe2o3Rawmeal
        val I16 = Page2DataCache.caoRawmeal
        val I17 = Page2DataCache.mgoRawmeal
        val I18 = Page2DataCache.na2oRawmeal
        val I19 = Page2DataCache.k2oRawmeal
        val I20 = Page2DataCache.so3Rawmeal
        val I21 = Page2DataCache.clRawmeal
        val I22 = Page2DataCache.loiRawmeal

// Now check if Page2DataCache has meaningful data
        val isPage2DataValid = listOf(I13, I14, I15, I16, I17, I18, I19, I20, I21, I22).any { it != 0.0 }

        val allTrcFieldsEmptyOrZero = listOf(
            et_K52, et_L52, et_M52, et_N52, et_O52,
            et_P52, et_Q52, et_R52, et_S52, et_T52_trc_LOI
        ).all { it.text.isNullOrBlank() || it.text.toString().toDoubleOrNull() == 0.0 }

        if (isPage2DataValid && allTrcFieldsEmptyOrZero) {
            et_K52.setText(df.format(I13))
            et_L52.setText(df.format(I14))
            et_M52.setText(df.format(I15))
            et_N52.setText(df.format(I16))
            et_O52.setText(df.format(I17))
            et_P52.setText(df.format(I18))
            et_Q52.setText(df.format(I19))
            et_R52.setText(df.format(I20))
            et_S52.setText(df.format(I21))
            et_T52_trc_LOI.setText(df.format(I22))
        }

        // --- MATERIAL SETTING: LIMESTONE, SHALE, IRON ORE ---
        // Row 1: Always Manual
        // H45, I45, J45 are user inputs

        // Row 2-5: AUTO/MANUAL depending on switch
        // For manual mode (switch.isChecked = true), use user input values
        // For auto mode (switch.isChecked = false), calculate values

// Material Setting

// === ROW 2 ===
// Column Green 1
// Error Row
        val K29 = (values["et_K52"] ?: 0.0) - (values["et_K45"] ?: 0.0)
        val M29 = (values["et_M52"] ?: 0.0) - (values["et_M45"] ?: 0.0)
        val N29 = (values["et_N52"] ?: 0.0) - (values["et_N45"] ?: 0.0)
// Est. Adj Oxide Row
        val K30 = if (G31 != 0.0) (K29 / G31) * 100 else 0.0
        val M30 = if (H33 != 0.0) (M29 / H33) * 100 else 0.0
        val N30 = if (F34 != 0.0) (N29 / F34) * 100 else 0.0
// Unnormalized Row
        val K31 = K30 + (values["et_I45"] ?: 0.0)
        val M31 = M30 + (values["et_J45"] ?: 0.0)
        val N31 = N30 + (values["et_H45"] ?: 0.0)
// Condition if Row
        val K32 = if (K31 < 0) 0.0 else K31
        val M32 = if (M31 < 0) 0.0 else M31
        val N32 = if (N31 < 0) 0.0 else N31
// Normalized Row
        val total = K32 + M32 + N32
        val I46 = if (total != 0.0) (K32 / total) * 100 else 0.0
        val J46 = if (total != 0.0) (M32 / total) * 100 else 0.0
        val H46 = 100 - I46 - J46
        values["I46"] = I46
        values["J46"] = J46
        values["H46"] = H46

// === ROW 3 ===
// Use actual source values from Row 2 depending on manual/auto
        val I46_actual = if (switch_row2.isChecked) values["et_I46"] ?: 0.0 else I46
        val J46_actual = if (switch_row2.isChecked) values["et_J46"] ?: 0.0 else J46
        val H46_actual = if (switch_row2.isChecked) values["et_H46"] ?: 0.0 else H46
// Column Light Blue 2
// Error Row
        val O29 = (values["et_K52"] ?: 0.0) - (values["et_K46"] ?: 0.0)
        val Q29 = (values["et_M52"] ?: 0.0) - (values["et_M46"] ?: 0.0)
        val R29 = (values["et_N52"] ?: 0.0) - (values["et_N46"] ?: 0.0)
// Est. Adj Oxide Row
        val O30 = if (G31 != 0.0) (O29 / G31) * 100 else 0.0
        val Q30 = if (H33 != 0.0) (Q29 / H33) * 100 else 0.0
        val R30 = if (F34 != 0.0) (R29 / F34) * 100 else 0.0
// Unnormalized Row
        val O31 = O30 + I46_actual
        val Q31 = Q30 + J46_actual
        val R31 = R30 + H46_actual
// Condition if Row
        val O32 = if (O31 < 0) 0.0 else O31
        val Q32 = if (Q31 < 0) 0.0 else Q31
        val R32 = if (R31 < 0) 0.0 else R31
// Normalized Row
        val total2 = O32 + Q32 + R32
        val I47 = if (total2 != 0.0) (O32 / total2) * 100 else 0.0
        val J47 = if (total2 != 0.0) (Q32 / total2) * 100 else 0.0
        val H47 = 100 - I47 - J47
        values["I47"] = I47
        values["J47"] = J47
        values["H47"] = H47

// === ROW 4 ===
// Use actual source values from Row 3 depending on manual/auto
        val I47_actual = if (switch_row3.isChecked) values["et_I47"] ?: 0.0 else I47
        val J47_actual = if (switch_row3.isChecked) values["et_J47"] ?: 0.0 else J47
        val H47_actual = if (switch_row3.isChecked) values["et_H47"] ?: 0.0 else H47
// Column Gray 3
// Error Row
        val S29 = (values["et_K52"] ?: 0.0) - (values["et_K47"] ?: 0.0)
        val U29 = (values["et_M52"] ?: 0.0) - (values["et_M47"] ?: 0.0)
        val V29 = (values["et_N52"] ?: 0.0) - (values["et_N47"] ?: 0.0)
// Est. Adj Oxide Row
        val S30 = if (G31 != 0.0) (S29 / G31) * 100 else 0.0
        val U30 = if (H33 != 0.0) (U29 / H33) * 100 else 0.0
        val V30 = if (F34 != 0.0) (V29 / F34) * 100 else 0.0
// Unnormalized Row
        val S31 = S30 + I47_actual
        val U31 = U30 + J47_actual
        val V31 = V30 + H47_actual
// Condition if Row
        val S32 = if (S31 < 0) 0.0 else S31
        val U32 = if (U31 < 0) 0.0 else U31
        val V32 = if (V31 < 0) 0.0 else V31
// Normalized Row
        val total3 = S32 + U32 + V32
        val I48 = if (total3 != 0.0) (S32 / total3) * 100 else 0.0
        val J48 = if (total3 != 0.0) (U32 / total3) * 100 else 0.0
        val H48 = 100 - I48 - J48
        values["I48"] = I48
        values["J48"] = J48
        values["H48"] = H48

// === ROW 5 ===
// Use actual source values from Row 4 depending on manual/auto
        val I48_actual = if (switch_row4.isChecked) values["et_I48"] ?: 0.0 else I48
        val J48_actual = if (switch_row4.isChecked) values["et_J48"] ?: 0.0 else J48
        val H48_actual = if (switch_row4.isChecked) values["et_H48"] ?: 0.0 else H48
// Column Light Orange 4
// Error Row
        val W29 = (values["et_K52"] ?: 0.0) - (values["et_K48"] ?: 0.0)
        val Y29 = (values["et_M52"] ?: 0.0) - (values["et_M48"] ?: 0.0)
        val Z29 = (values["et_N52"] ?: 0.0) - (values["et_N48"] ?: 0.0)
// Est. Adj Oxide Row
        val W30 = if (G31 != 0.0) (W29 / G31) * 100 else 0.0
        val Y30 = if (H33 != 0.0) (Y29 / H33) * 100 else 0.0
        val Z30 = if (F34 != 0.0) (Z29 / F34) * 100 else 0.0
// Unnormalized Row
        val W31 = W30 + I48_actual
        val Y31 = Y30 + J48_actual
        val Z31 = Z30 + H48_actual
// Condition if Row
        val W32 = if (W31 < 0) 0.0 else W31
        val Y32 = if (Y31 < 0) 0.0 else Y31
        val Z32 = if (Z31 < 0) 0.0 else Z31
// Normalized Row
        val total4 = W32 + Y32 + Z32
        val I49 = if (total4 != 0.0) (W32 / total4) * 100 else 0.0
        val J49 = if (total4 != 0.0) (Y32 / total4) * 100 else 0.0
        val H49 = 100 - I49 - J49
        values["I49"] = I49
        values["J49"] = J49
        values["H49"] = H49


        // Row 2
        if (!switch_row2.isChecked) {
            // Auto mode calculations
            values["et_H46"] = values["H46"]?:0.0
            values["et_J46"] = values["J46"]?:0.0
            values["et_I46"] = values["I46"]?:0.0
        }
        // Row 3
        if (!switch_row3.isChecked) {
            // Auto mode calculations
            values["et_H47"] = values["H47"]?:0.0
            values["et_J47"] = values["J47"]?:0.0
            values["et_I47"] = values["I47"]?:0.0
        }
        // Row 4
        if (!switch_row4.isChecked) {
            // Auto mode calculations
            values["et_H48"] = values["H48"]?:0.0
            values["et_J48"] = values["J48"]?:0.0
            values["et_I48"] = values["I48"]?:0.0
        }
        // Row 5
        if (!switch_row5.isChecked) {
            // Auto mode calculations
            values["et_H49"] = values["H49"]?:0.0
            values["et_J49"] = values["J49"]?:0.0
            values["et_I49"] = values["I49"]?:0.0
        }



        // --- TOTAL1 (G45–G49) ---
        for (i in 45..49) {
            val h = values["et_H$i"] ?: 0.0
            val ii = values["et_I$i"] ?: 0.0
            val j = values["et_J$i"] ?: 0.0
            values["G$i"] = h + ii + j
        }


        // --- LOI (T45–T48) ---
        for (i in 45..48) {
            val n = values["et_N$i"] ?: 0.0
            val o = values["et_O$i"] ?: 0.0
            values["T$i"] = if (n == 0.0 && o == 0.0) 0.0 else 0.786 * n + 1.1 * o + 0.2
        }


        // --- TOTAL2 (U45–U48) ---
        for (i in 45..48) {
            val keys = listOf(
                "et_K$i", "et_L$i", "et_M$i", "et_N$i",
                "et_O$i", "et_P$i", "et_Q$i", "et_R$i", "et_S$i",
                "T$i"
            )
            values["U$i"] = keys.sumOf { values[it] ?: 0.0 }
        }

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
        values["T52"] = values["et_T52"]?:0.0
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
        values["Q57"] = factor1 * (values["et_Q52"] ?: 0.0) * factor_1_minus_h54 + (values["et_Q54"] ?: 0.0) * h54
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
            /* Also update XRF row 2
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
            */
        }
        setDouble(tv_T46, values["T46"] ?: 0.0); setDouble(tv_U46, values["U46"] ?: 0.0); setDouble(tv_V46, values["V46"] ?: 0.0)
        setDouble(tv_W46, values["W46"] ?: 0.0); setDouble(tv_X46, values["X46"] ?: 0.0); setDouble(tv_Y46, values["Y46"] ?: 0.0)

        setDouble(tv_G47, values["G47"] ?: 0.0)
        if (!switch_row3.isChecked) {
            setDouble(et_H47, values["et_H47"] ?: 0.0)
            setDouble(et_I47, values["et_I47"] ?: 0.0)
            setDouble(et_J47, values["et_J47"] ?: 0.0)
            /* Also update XRF row 3
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
            */
        }
        setDouble(tv_T47, values["T47"] ?: 0.0); setDouble(tv_U47, values["U47"] ?: 0.0); setDouble(tv_V47, values["V47"] ?: 0.0)
        setDouble(tv_W47, values["W47"] ?: 0.0); setDouble(tv_X47, values["X47"] ?: 0.0); setDouble(tv_Y47, values["Y47"] ?: 0.0)

        setDouble(tv_G48, values["G48"] ?: 0.0)
        if (!switch_row4.isChecked) {
            setDouble(et_H48, values["et_H48"] ?: 0.0)
            setDouble(et_I48, values["et_I48"] ?: 0.0)
            setDouble(et_J48, values["et_J48"] ?: 0.0)
            /* Also update XRF row 4
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
            */
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

        //setDouble(et_T52_trc_LOI, values["T52"] ?: 0.0)
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

            // Backward compatibility for older saves that used tv_M60 instead of et_M60
            if (!data.has("et_M60") && data.has("tv_M60")) {
                et_M60.setText(data.optString("tv_M60", ""))
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
                et_K52, et_L52, et_M52, et_N52, et_O52, et_P52, et_Q52, et_R52, et_S52, et_T52_trc_LOI,
                et_K54, et_L54, et_M54, et_N54, et_O54, et_P54, et_Q54, et_R54, et_S54, et_T54,
                et_K60, et_L60, et_M60, et_O60, et_X60, et_Y60,
                raw_mix_type
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

                    // No need for explicit text fields save anymore since we're saving all EditTexts

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

                // Backward compatibility for older saves that used tv_M60 instead of et_M60
                if (!data.has("et_M60") && data.has("tv_M60")) {
                    et_M60.setText(data.optString("tv_M60", ""))
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

    private fun updateSavedData() {
        try {
            val data = JSONObject()

            // Save all EditText values
            allInputEditTexts.forEach { editText ->
                val idName = resources.getResourceEntryName(editText.id)
                data.put(idName, editText.text.toString())
            }

            // No need for explicit text fields save anymore since we're saving all EditTexts

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

    private fun cachePage1Fields() {
        val fields = listOf(

            // --- Materials Setting (H45–J49) ---
            Triple(et_H45, { Page1DataCache.H45 }, { v: Double -> Page1DataCache.H45 = v }),
            Triple(et_I45, { Page1DataCache.I45 }, { v: Double -> Page1DataCache.I45 = v }),
            Triple(et_J45, { Page1DataCache.J45 }, { v: Double -> Page1DataCache.J45 = v }),
            Triple(et_H46, { Page1DataCache.H46 }, { v: Double -> Page1DataCache.H46 = v }),
            Triple(et_I46, { Page1DataCache.I46 }, { v: Double -> Page1DataCache.I46 = v }),
            Triple(et_J46, { Page1DataCache.J46 }, { v: Double -> Page1DataCache.J46 = v }),
            Triple(et_H47, { Page1DataCache.H47 }, { v: Double -> Page1DataCache.H47 = v }),
            Triple(et_I47, { Page1DataCache.I47 }, { v: Double -> Page1DataCache.I47 = v }),
            Triple(et_J47, { Page1DataCache.J47 }, { v: Double -> Page1DataCache.J47 = v }),
            Triple(et_H48, { Page1DataCache.H48 }, { v: Double -> Page1DataCache.H48 = v }),
            Triple(et_I48, { Page1DataCache.I48 }, { v: Double -> Page1DataCache.I48 = v }),
            Triple(et_J48, { Page1DataCache.J48 }, { v: Double -> Page1DataCache.J48 = v }),
            Triple(et_H49, { Page1DataCache.H49 }, { v: Double -> Page1DataCache.H49 = v }),
            Triple(et_I49, { Page1DataCache.I49 }, { v: Double -> Page1DataCache.I49 = v }),
            Triple(et_J49, { Page1DataCache.J49 }, { v: Double -> Page1DataCache.J49 = v }),

            // --- Additional Input ---
            Triple(et_H54, { Page1DataCache.H54 }, { v: Double -> Page1DataCache.H54 = v }),

            // --- XRF Row 1 (K45–S45) ---
            Triple(et_K45, { Page1DataCache.K45 }, { v: Double -> Page1DataCache.K45 = v }),
            Triple(et_L45, { Page1DataCache.L45 }, { v: Double -> Page1DataCache.L45 = v }),
            Triple(et_M45, { Page1DataCache.M45 }, { v: Double -> Page1DataCache.M45 = v }),
            Triple(et_N45, { Page1DataCache.N45 }, { v: Double -> Page1DataCache.N45 = v }),
            Triple(et_O45, { Page1DataCache.O45 }, { v: Double -> Page1DataCache.O45 = v }),
            Triple(et_P45, { Page1DataCache.P45 }, { v: Double -> Page1DataCache.P45 = v }),
            Triple(et_Q45, { Page1DataCache.Q45 }, { v: Double -> Page1DataCache.Q45 = v }),
            Triple(et_R45, { Page1DataCache.R45 }, { v: Double -> Page1DataCache.R45 = v }),
            Triple(et_S45, { Page1DataCache.S45 }, { v: Double -> Page1DataCache.S45 = v }),

            // --- XRF Row 2 (K46–S46) ---
            Triple(et_K46, { Page1DataCache.K46 }, { v: Double -> Page1DataCache.K46 = v }),
            Triple(et_L46, { Page1DataCache.L46 }, { v: Double -> Page1DataCache.L46 = v }),
            Triple(et_M46, { Page1DataCache.M46 }, { v: Double -> Page1DataCache.M46 = v }),
            Triple(et_N46, { Page1DataCache.N46 }, { v: Double -> Page1DataCache.N46 = v }),
            Triple(et_O46, { Page1DataCache.O46 }, { v: Double -> Page1DataCache.O46 = v }),
            Triple(et_P46, { Page1DataCache.P46 }, { v: Double -> Page1DataCache.P46 = v }),
            Triple(et_Q46, { Page1DataCache.Q46 }, { v: Double -> Page1DataCache.Q46 = v }),
            Triple(et_R46, { Page1DataCache.R46 }, { v: Double -> Page1DataCache.R46 = v }),
            Triple(et_S46, { Page1DataCache.S46 }, { v: Double -> Page1DataCache.S46 = v }),

            // --- XRF Row 3 (K47–S47) ---
            Triple(et_K47, { Page1DataCache.K47 }, { v: Double -> Page1DataCache.K47 = v }),
            Triple(et_L47, { Page1DataCache.L47 }, { v: Double -> Page1DataCache.L47 = v }),
            Triple(et_M47, { Page1DataCache.M47 }, { v: Double -> Page1DataCache.M47 = v }),
            Triple(et_N47, { Page1DataCache.N47 }, { v: Double -> Page1DataCache.N47 = v }),
            Triple(et_O47, { Page1DataCache.O47 }, { v: Double -> Page1DataCache.O47 = v }),
            Triple(et_P47, { Page1DataCache.P47 }, { v: Double -> Page1DataCache.P47 = v }),
            Triple(et_Q47, { Page1DataCache.Q47 }, { v: Double -> Page1DataCache.Q47 = v }),
            Triple(et_R47, { Page1DataCache.R47 }, { v: Double -> Page1DataCache.R47 = v }),
            Triple(et_S47, { Page1DataCache.S47 }, { v: Double -> Page1DataCache.S47 = v }),

            // --- XRF Row 4 (K48–S48) ---
            Triple(et_K48, { Page1DataCache.K48 }, { v: Double -> Page1DataCache.K48 = v }),
            Triple(et_L48, { Page1DataCache.L48 }, { v: Double -> Page1DataCache.L48 = v }),
            Triple(et_M48, { Page1DataCache.M48 }, { v: Double -> Page1DataCache.M48 = v }),
            Triple(et_N48, { Page1DataCache.N48 }, { v: Double -> Page1DataCache.N48 = v }),
            Triple(et_O48, { Page1DataCache.O48 }, { v: Double -> Page1DataCache.O48 = v }),
            Triple(et_P48, { Page1DataCache.P48 }, { v: Double -> Page1DataCache.P48 = v }),
            Triple(et_Q48, { Page1DataCache.Q48 }, { v: Double -> Page1DataCache.Q48 = v }),
            Triple(et_R48, { Page1DataCache.R48 }, { v: Double -> Page1DataCache.R48 = v }),
            Triple(et_S48, { Page1DataCache.S48 }, { v: Double -> Page1DataCache.S48 = v }),

            // --- Coal Ash Composition (K54–T54) ---
            Triple(et_K54, { Page1DataCache.K54 }, { v: Double -> Page1DataCache.K54 = v }),
            Triple(et_L54, { Page1DataCache.L54 }, { v: Double -> Page1DataCache.L54 = v }),
            Triple(et_M54, { Page1DataCache.M54 }, { v: Double -> Page1DataCache.M54 = v }),
            Triple(et_N54, { Page1DataCache.N54 }, { v: Double -> Page1DataCache.N54 = v }),
            Triple(et_O54, { Page1DataCache.O54 }, { v: Double -> Page1DataCache.O54 = v }),
            Triple(et_P54, { Page1DataCache.P54 }, { v: Double -> Page1DataCache.P54 = v }),
            Triple(et_Q54, { Page1DataCache.Q54 }, { v: Double -> Page1DataCache.Q54 = v }),
            Triple(et_R54, { Page1DataCache.R54 }, { v: Double -> Page1DataCache.R54 = v }),
            Triple(et_S54, { Page1DataCache.S54 }, { v: Double -> Page1DataCache.S54 = v }),
            Triple(et_T54, { Page1DataCache.T54 }, { v: Double -> Page1DataCache.T54 = v }),

            // --- Fuel Section (K60, L60, O60, X60, Y60) ---
            Triple(et_K60, { Page1DataCache.K60 }, { v: Double -> Page1DataCache.K60 = v }),
            Triple(et_L60, { Page1DataCache.L60 }, { v: Double -> Page1DataCache.L60 = v }),
            Triple(et_O60, { Page1DataCache.O60 }, { v: Double -> Page1DataCache.O60 = v }),
            Triple(et_X60, { Page1DataCache.X60 }, { v: Double -> Page1DataCache.X60 = v }),
            Triple(et_Y60, { Page1DataCache.Y60 }, { v: Double -> Page1DataCache.Y60 = v })
        )

        fields.forEach { (editText, getter, setter) ->
            // Restore from cache
            if (editText.text.isNullOrBlank()) {
                val cachedValue = getter()
                if (cachedValue != 0.0) editText.setText(cachedValue.toString())
            }

            // Update cache when user types
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    setter(s.toString().toDoubleOrNull() ?: 0.0)
                }
            })
        }
    }
}
