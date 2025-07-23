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
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

// import androidx.appcompat.app.AppCompatActivity // Replaced by BaseActivity

class Page5Activity : BaseActivity() {

    //Declaration for Page6 variables
    private var I8_PG6 = 0.0
    private var I9_PG6 = 0.0
    private var I10_PG6 = 0.0
    private var F31 = 0.0
    private var G31 = 0.0
    private var H31 = 0.0
    private var I31 = 0.0
    private var F32 = 0.0
    private var G32 = 0.0
    private var H32 = 0.0
    private var I32 = 0.0
    private var F33 = 0.0
    private var G33 = 0.0
    private var H33 = 0.0
    private var I33 = 0.0
    private var F34 = 0.0
    private var G34 = 0.0
    private var H34 = 0.0
    private var I34 = 0.0

    //For TRC values, from Sio2 to Cl in Page6
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
    private lateinit var tv_G10: TextView
    private lateinit var et_H10: EditText
    private lateinit var et_I10: EditText
    private lateinit var et_J10: EditText
    private lateinit var et_K10: EditText
    private lateinit var et_L10: EditText
    private lateinit var et_M10: EditText
    private lateinit var et_N10: EditText
    private lateinit var et_O10: EditText
    private lateinit var et_P10: EditText
    private lateinit var et_Q10: EditText
    private lateinit var et_R10: EditText
    private lateinit var et_S10: EditText
    private lateinit var et_T10: EditText
    private lateinit var tv_U10: TextView
    private lateinit var tv_V10: TextView
    private lateinit var tv_W10: TextView
    private lateinit var tv_X10: TextView
    private lateinit var tv_Y10: TextView
    private lateinit var tv_Z10: TextView

    private lateinit var switch_row2: Switch
    private lateinit var tv_G11: TextView
    private lateinit var et_H11: EditText
    private lateinit var et_I11: EditText
    private lateinit var et_J11: EditText
    private lateinit var et_K11: EditText
    private lateinit var et_L11: EditText
    private lateinit var et_M11: EditText
    private lateinit var et_N11: EditText
    private lateinit var et_O11: EditText
    private lateinit var et_P11: EditText
    private lateinit var et_Q11: EditText
    private lateinit var et_R11: EditText
    private lateinit var et_S11: EditText
    private lateinit var et_T11: EditText
    private lateinit var tv_U11: TextView
    private lateinit var tv_V11: TextView
    private lateinit var tv_W11: TextView
    private lateinit var tv_X11: TextView
    private lateinit var tv_Y11: TextView
    private lateinit var tv_Z11: TextView

    private lateinit var switch_row3: Switch
    private lateinit var tv_G12: TextView
    private lateinit var et_H12: EditText
    private lateinit var et_I12: EditText
    private lateinit var et_J12: EditText
    private lateinit var et_K12: EditText
    private lateinit var et_L12: EditText
    private lateinit var et_M12: EditText
    private lateinit var et_N12: EditText
    private lateinit var et_O12: EditText
    private lateinit var et_P12: EditText
    private lateinit var et_Q12: EditText
    private lateinit var et_R12: EditText
    private lateinit var et_S12: EditText
    private lateinit var et_T12: EditText
    private lateinit var tv_U12: TextView
    private lateinit var tv_V12: TextView
    private lateinit var tv_W12: TextView
    private lateinit var tv_X12: TextView
    private lateinit var tv_Y12: TextView
    private lateinit var tv_Z12: TextView


    private lateinit var switch_row4: Switch
    private lateinit var tv_G13: TextView
    private lateinit var et_H13: EditText
    private lateinit var et_I13: EditText
    private lateinit var et_J13: EditText
    private lateinit var et_K13: EditText
    private lateinit var et_L13: EditText
    private lateinit var et_M13: EditText
    private lateinit var et_N13: EditText
    private lateinit var et_O13: EditText
    private lateinit var et_P13: EditText
    private lateinit var et_Q13: EditText
    private lateinit var et_R13: EditText
    private lateinit var et_S13: EditText
    private lateinit var et_T13: EditText
    private lateinit var tv_U13: TextView
    private lateinit var tv_V13: TextView
    private lateinit var tv_W13: TextView
    private lateinit var tv_X13: TextView
    private lateinit var tv_Y13: TextView
    private lateinit var tv_Z13: TextView


    private lateinit var switch_row5: Switch
    private lateinit var tv_G14: TextView
    private lateinit var et_H14: EditText
    private lateinit var et_I14: EditText
    private lateinit var et_J14: EditText
    private lateinit var et_K14: EditText

    private lateinit var tv_I17_target_LSF: TextView
    private lateinit var tv_I18_target_SM: TextView
    private lateinit var tv_I19_target_AM: TextView
    private lateinit var et_I20: EditText

    private lateinit var et_L17: EditText
    private lateinit var et_M17: EditText
    private lateinit var et_N17: EditText
    private lateinit var et_O17: EditText
    private lateinit var et_P17: EditText
    private lateinit var et_Q17: EditText
    private lateinit var et_R17: EditText
    private lateinit var et_S17: EditText
    private lateinit var et_T17:EditText
    private lateinit var et_U17_trc_LOI: EditText
    private lateinit var tv_V17_trc_TOTAL: TextView
    private lateinit var tv_W17_trc_LSF: TextView
    private lateinit var tv_X17_trc_HM: TextView
    private lateinit var tv_Y17_trc_SM: TextView
    private lateinit var tv_Z17_trc_AM: TextView

    private lateinit var et_L19: EditText
    private lateinit var et_M19: EditText
    private lateinit var et_N19: EditText
    private lateinit var et_O19: EditText
    private lateinit var et_P19: EditText
    private lateinit var et_Q19: EditText
    private lateinit var et_R19: EditText
    private lateinit var et_S19: EditText
    private lateinit var et_T19: EditText
    private lateinit var et_U19: EditText
    private lateinit var tv_V19: TextView
    private lateinit var tv_W19: TextView
    private lateinit var tv_X19: TextView
    private lateinit var tv_Y19: TextView
    private lateinit var tv_Z19:TextView

    private lateinit var tv_L22: TextView
    private lateinit var tv_M22: TextView
    private lateinit var tv_N22: TextView
    private lateinit var tv_O22: TextView
    private lateinit var tv_P22: TextView
    private lateinit var tv_Q22: TextView
    private lateinit var tv_R22: TextView
    private lateinit var tv_S22: TextView
    private lateinit var tv_T22: TextView
    private lateinit var tv_U22: TextView
    private lateinit var tv_W22: TextView
    private lateinit var tv_X22: TextView
    private lateinit var tv_Y22: TextView
    private lateinit var tv_Z22: TextView

    private lateinit var et_L25: EditText
    private lateinit var et_M25: EditText
    private lateinit var et_N25: EditText
    private lateinit var tv_O25: TextView
    private lateinit var et_P25: EditText
    private lateinit var tv_Q25: TextView
    private lateinit var tv_R25: TextView
    private lateinit var tv_S25: TextView
    private lateinit var tv_T25: TextView
    private lateinit var tv_U25: TextView
    private lateinit var tv_V25: TextView
    private lateinit var tv_W25: TextView
    private lateinit var tv_X25: TextView
    private lateinit var et_Y25: EditText
    private lateinit var et_Z25: EditText

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
        supportActionBar?.title = "Control 4X (LSF,SM & AM)"
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page5)

        // Retrieve the values from Page6DataCache

        I8_PG6 = Page6DataCache.LsfTarget
        I9_PG6 = Page6DataCache.SmTarget
        I10_PG6 = Page6DataCache.AmTarget

        F31 = Page6DataCache.Sio2Limestone
        G31 = Page6DataCache.Sio2Shale
        H31 = Page6DataCache.Sio2Sand
        I31 = Page6DataCache.Sio2IronOre

        F32 = Page6DataCache.Al2o3Limestone
        G32 = Page6DataCache.Al2o3Shale
        H32 = Page6DataCache.Al2o3Sand
        I32 = Page6DataCache.Al2o3Shale

        F33 = Page6DataCache.Fe2o3Limestone
        G33 = Page6DataCache.Fe2o3Shale
        H33 = Page6DataCache.Fe2o3IronOre
        I33 = Page6DataCache.Fe2o3IronOre

        F34 = Page6DataCache.CaoLimestone
        G34 = Page6DataCache.CaoShale
        H34 = Page6DataCache.CaoSand
        I34 = Page6DataCache.CaoIronOre

        //Retrieve the values from Page6DataCache
        I13 =Page6DataCache.Sio2RawMeal
        I14 =Page6DataCache.Al2o3RawMeal
        I15 =Page6DataCache.Fe2o3RawMeal
        I16 =Page6DataCache.CaoRawMeal
        I17 =Page6DataCache.MgoRawMeal
        I18 =Page6DataCache.Na2oRawMeal
        I19 =Page6DataCache.K2oRawMeal
        I20 =Page6DataCache.So3RawMeal
        I21 =Page6DataCache.ClRawMeal
        I22 =Page6DataCache.LoiRawMeal

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
        xrfRow2 = listOf(et_L11, et_M11, et_N11, et_O11, et_P11, et_Q11, et_R11, et_S11, et_T11)
        xrfRow3 = listOf(et_L12, et_M12, et_N12, et_O12, et_P12, et_Q12, et_R12, et_S12, et_T12)
        xrfRow4 = listOf(et_L13, et_M13, et_N13, et_O13, et_P13, et_Q13, et_R13, et_S13, et_T13)

        // Set all switches to manual mode by default and configure their fields
        allSwitches.forEach { switch ->
            switch.isChecked = true
            // Configure the corresponding fields for manual mode
            when (switch) {
                switch_row2 -> toggleEditTextsManual(listOf(et_H11, et_I11, et_J11, et_K11) + xrfRow2, true, mainTextWatcher)
                switch_row3 -> toggleEditTextsManual(listOf(et_H12, et_I12, et_J12, et_K12) + xrfRow3, true, mainTextWatcher)
                switch_row4 -> toggleEditTextsManual(listOf(et_H13, et_I13, et_J13, et_K13) + xrfRow4, true, mainTextWatcher)
                switch_row5 -> toggleEditTextsManual(listOf(et_H14, et_I14, et_J14, et_K14), true, mainTextWatcher)
            }
        }

        // Configure always editable fields (Row 1 and other input fields)
        val alwaysEditableFields = listOf(
            et_H10, et_I10, et_J10, et_K10, et_L10, et_M10, et_N10, et_O10, et_P10, et_Q10, et_R10, et_S10, et_T10,
            et_I20,
            et_L17, et_M17, et_N17, et_O17, et_P17, et_Q17, et_R17, et_S17, et_T17, et_U17_trc_LOI,
            et_L19, et_M19, et_N19, et_O19, et_P19, et_Q19, et_R19, et_S19, et_T19, et_U19,
            et_L25, et_M25, et_N25, et_P25, et_Y25, et_Z25,
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

        // Set et_N25 to use text input
        et_N25.inputType = InputType.TYPE_CLASS_TEXT
        et_N25.isFocusable = true
        et_N25.isFocusableInTouchMode = true
        et_N25.isCursorVisible = true

        cachePage5Fields()
        setupListeners()
        setupButtons()
        recalculateAndUpdate()
        // Initial calculation after setting up manual mode


        // Check if we're loading saved data
        val savedDataId = intent.getLongExtra("saved_data_id", -1)
        if (savedDataId != -1L) {
            loadSavedData(savedDataId)
        }

    }

    private fun initializeViews() {
        tv_G10 = findViewById(R.id.tv_G10_PG5)
        tv_U10 = findViewById(R.id.tv_U10_PG5)
        tv_V10 = findViewById(R.id.tv_V10_PG5)
        tv_W10 = findViewById(R.id.tv_W10_PG5)
        tv_X10 = findViewById(R.id.tv_X10_PG5)
        tv_Y10 = findViewById(R.id.tv_Y10_PG5)
        tv_Z10 = findViewById(R.id.tv_Z10_PG5)

        et_H10 = findViewById(R.id.et_H10_PG5); et_I10 = findViewById(R.id.et_I10_PG5); et_J10 = findViewById(R.id.et_J10_PG5)
        et_K10 = findViewById(R.id.et_K10_PG5); et_L10 = findViewById(R.id.et_L10_PG5); et_M10 = findViewById(R.id.et_M10_PG5)
        et_N10 = findViewById(R.id.et_N10_PG5); et_O10 = findViewById(R.id.et_O10_PG5); et_P10 = findViewById(R.id.et_P10_PG5)
        et_Q10 = findViewById(R.id.et_Q10_PG5); et_R10 = findViewById(R.id.et_R10_PG5); et_S10 = findViewById(R.id.et_S10_PG5)
        et_T10 = findViewById(R.id.et_T10_PG5)

        switch_row2 = findViewById(R.id.switch_row2_PG5);
        tv_G11 = findViewById(R.id.tv_G11_PG5)
        tv_U11 = findViewById(R.id.tv_U11_PG5)
        tv_V11 = findViewById(R.id.tv_V11_PG5)
        tv_W11 = findViewById(R.id.tv_W11_PG5)
        tv_X11 = findViewById(R.id.tv_X11_PG5)
        tv_Y11 = findViewById(R.id.tv_Y11_PG5)
        tv_Z11 = findViewById(R.id.tv_Z11_PG5)

        et_H11 = findViewById(R.id.et_H11_PG5); et_I11 = findViewById(R.id.et_I11_PG5); et_J11 = findViewById(R.id.et_J11_PG5)
        et_K11 = findViewById(R.id.et_K11_PG5); et_L11 = findViewById(R.id.et_L11_PG5); et_M11 = findViewById(R.id.et_M11_PG5)
        et_N11 = findViewById(R.id.et_N11_PG5); et_O11 = findViewById(R.id.et_O11_PG5); et_P11 = findViewById(R.id.et_P11_PG5)
        et_Q11 = findViewById(R.id.et_Q11_PG5); et_R11 = findViewById(R.id.et_R11_PG5); et_S11 = findViewById(R.id.et_S11_PG5)
        et_T11 = findViewById(R.id.et_T11_PG5)

        switch_row3 = findViewById(R.id.switch_row3_PG5)
        tv_G12 = findViewById(R.id.tv_G12_PG5)
        tv_U12 = findViewById(R.id.tv_U12_PG5)
        tv_V12 = findViewById(R.id.tv_V12_PG5)
        tv_W12 = findViewById(R.id.tv_W12_PG5)
        tv_X12 = findViewById(R.id.tv_X12_PG5)
        tv_Y12 = findViewById(R.id.tv_Y12_PG5)
        tv_Z12 = findViewById(R.id.tv_Z12_PG5)

        et_H12 = findViewById(R.id.et_H12_PG5); et_I12 = findViewById(R.id.et_I12_PG5); et_J12 = findViewById(R.id.et_J12_PG5)
        et_K12 = findViewById(R.id.et_K12_PG5); et_L12 = findViewById(R.id.et_L12_PG5); et_M12 = findViewById(R.id.et_M12_PG5)
        et_N12 = findViewById(R.id.et_N12_PG5); et_O12 = findViewById(R.id.et_O12_PG5); et_P12 = findViewById(R.id.et_P12_PG5)
        et_Q12 = findViewById(R.id.et_Q12_PG5); et_R12 = findViewById(R.id.et_R12_PG5); et_S12 = findViewById(R.id.et_S12_PG5)
        et_T12 = findViewById(R.id.et_T12_PG5)

        switch_row4 = findViewById(R.id.switch_row4_PG5)
        tv_G13 = findViewById(R.id.tv_G13_PG5)
        tv_U13 = findViewById(R.id.tv_U13_PG5)
        tv_V13 = findViewById(R.id.tv_V13_PG5)
        tv_W13 = findViewById(R.id.tv_W13_PG5)
        tv_X13 = findViewById(R.id.tv_X13_PG5)
        tv_Y13 = findViewById(R.id.tv_Y13_PG5)
        tv_Z13 = findViewById(R.id.tv_Z13_PG5)

        et_H13 = findViewById(R.id.et_H13_PG5); et_I13 = findViewById(R.id.et_I13_PG5); et_J13 = findViewById(R.id.et_J13_PG5)
        et_K13 = findViewById(R.id.et_K13_PG5); et_L13 = findViewById(R.id.et_L13_PG5); et_M13 = findViewById(R.id.et_M13_PG5)
        et_N13 = findViewById(R.id.et_N13_PG5); et_O13 = findViewById(R.id.et_O13_PG5); et_P13 = findViewById(R.id.et_P13_PG5)
        et_Q13 = findViewById(R.id.et_Q13_PG5); et_R13 = findViewById(R.id.et_R13_PG5); et_S13 = findViewById(R.id.et_S13_PG5)
        et_T13 = findViewById(R.id.et_T13_PG5)

        switch_row5 = findViewById(R.id.switch_row5_PG5)
        tv_G14 = findViewById(R.id.tv_G14_PG5)

        et_H14 = findViewById(R.id.et_H14_PG5); et_I14 = findViewById(R.id.et_I14_PG5); et_J14 = findViewById(R.id.et_J14_PG5)
        et_K14 = findViewById(R.id.et_K14_PG5)

        tv_I17_target_LSF = findViewById(R.id.tv_I17_PG5)
        tv_I18_target_SM = findViewById(R.id.tv_I18_PG5)
        tv_I19_target_AM = findViewById(R.id.tv_I19_PG5)
        et_I20 = findViewById(R.id.et_I20_PG5)

        tv_V17_trc_TOTAL = findViewById(R.id.tv_V17_PG5)
        tv_W17_trc_LSF = findViewById(R.id.tv_W17_PG5)
        tv_X17_trc_HM = findViewById(R.id.tv_X17_PG5)
        tv_Y17_trc_SM = findViewById(R.id.tv_Y17_PG5)
        tv_Z17_trc_AM = findViewById(R.id.tv_Z17_PG5)

        et_L17 = findViewById(R.id.et_L17_PG5); et_M17 = findViewById(R.id.et_M17_PG5); et_N17 = findViewById(R.id.et_N17_PG5)
        et_O17 = findViewById(R.id.et_O17_PG5); et_P17 = findViewById(R.id.et_P17_PG5); et_Q17 = findViewById(R.id.et_Q17_PG5)
        et_R17 = findViewById(R.id.et_R17_PG5); et_S17 = findViewById(R.id.et_S17_PG5); et_T17 = findViewById(R.id.et_T17_PG5)
        et_U17_trc_LOI = findViewById(R.id.et_U17_PG5)

        tv_V19 = findViewById(R.id.tv_V19_PG5)
        tv_W19 = findViewById(R.id.tv_W19_PG5)
        tv_X19 = findViewById(R.id.tv_X19_PG5)
        tv_Y19 = findViewById(R.id.tv_Y19_PG5)
        tv_Z19 = findViewById(R.id.tv_Z19_PG5)

        et_L19 = findViewById(R.id.et_L19_PG5); et_M19 = findViewById(R.id.et_M19_PG5); et_N19 = findViewById(R.id.et_N19_PG5)
        et_O19 = findViewById(R.id.et_O19_PG5); et_P19 = findViewById(R.id.et_P19_PG5); et_Q19 = findViewById(R.id.et_Q19_PG5)
        et_R19 = findViewById(R.id.et_R19_PG5); et_S19 = findViewById(R.id.et_S19_PG5); et_T19 = findViewById(R.id.et_T19_PG5)
        et_U19 = findViewById(R.id.et_U19_PG5)

        tv_L22 = findViewById(R.id.tv_L22_PG5); tv_M22 = findViewById(R.id.tv_M22_PG5); tv_N22 = findViewById(R.id.tv_N22_PG5)
        tv_O22 = findViewById(R.id.tv_O22_PG5); tv_P22 = findViewById(R.id.tv_P22_PG5); tv_Q22 = findViewById(R.id.tv_Q22_PG5)
        tv_R22 = findViewById(R.id.tv_R22_PG5); tv_S22 = findViewById(R.id.tv_S22_PG5); tv_T22 = findViewById(R.id.tv_T22_PG5)
        tv_U22 = findViewById(R.id.tv_U22_PG5); tv_W22 = findViewById(R.id.tv_W22_PG5); tv_X22 = findViewById(R.id.tv_X22_PG5)
        tv_Y22 = findViewById(R.id.tv_Y22_PG5); tv_Z22 = findViewById(R.id.tv_Z22_PG5)

        et_L25 = findViewById(R.id.et_L25_PG5); et_M25 = findViewById(R.id.et_M25_PG5); et_N25 = findViewById(R.id.et_N25_PG5)
        tv_O25 = findViewById(R.id.tv_O25_PG5); et_P25 = findViewById(R.id.et_P25_PG5); tv_Q25 = findViewById(R.id.tv_Q25_PG5)
        tv_R25 = findViewById(R.id.tv_R25_PG5); tv_S25 = findViewById(R.id.tv_S25_PG5); tv_T25 = findViewById(R.id.tv_T25_PG5)
        tv_U25 = findViewById(R.id.tv_U25_PG5); tv_V25 = findViewById(R.id.tv_V25_PG5); tv_W25 = findViewById(R.id.tv_W25_PG5)
        tv_X25 = findViewById(R.id.tv_X25_PG5); et_Y25 = findViewById(R.id.et_Y25_PG5); et_Z25 = findViewById(R.id.et_Z25_PG5)

        // Initialize raw_mix_type
        raw_mix_type = findViewById(R.id.raw_mix_type_PG5)

        allInputEditTexts = listOf(
            et_H10, et_I10, et_J10, et_K10, et_L10, et_M10, et_N10, et_O10, et_P10, et_Q10, et_R10, et_S10, et_T10,
            et_H11, et_I11, et_J11, et_K11, et_L11, et_M11, et_N11, et_O11, et_P11, et_Q11, et_R11, et_S11, et_T11,
            et_H12, et_I12, et_J12, et_K12, et_L12, et_M12, et_N12, et_O12, et_P12, et_Q12, et_R12, et_S12, et_T12,
            et_H13, et_I13, et_J13, et_K13, et_L13, et_M13, et_N13, et_O13, et_P13, et_Q13, et_R13, et_S13, et_T13,
            et_H14, et_I14, et_J14, et_K14,
            et_I20,
            et_L17, et_M17, et_N17, et_O17, et_P17, et_Q17, et_R17, et_S17, et_T17 , et_U17_trc_LOI,
            et_L19, et_M19, et_N19, et_O19, et_P19, et_Q19, et_R19, et_S19, et_T19, et_U19,
            et_L25, et_M25, et_N25, et_P25 , et_Y25, et_Z25,
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
            et_H10, et_I10, et_J10, et_K10, et_L10, et_M10, et_N10, et_O10, et_P10, et_Q10, et_R10, et_S10, et_T10,
            et_I20,
            et_L17, et_M17, et_N17, et_O17, et_P17, et_Q17, et_R17, et_S17, et_T17, et_U17_trc_LOI,
            et_L19, et_M19, et_N19, et_O19, et_P19, et_Q19, et_R19, et_S19, et_T19, et_U19,
            et_L25, et_M25, et_N25, et_P25 , et_Y25, et_Z25,
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
                    switch_row2 -> listOf(et_H11, et_I11, et_J11, et_K11)
                    switch_row3 -> listOf(et_H12, et_I12, et_J12, et_K12)
                    switch_row4 -> listOf(et_H13, et_I13, et_J13, et_K13)
                    switch_row5 -> listOf(et_H14, et_I14, et_J14, et_K14)
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
                if (et.id == R.id.et_N25_PG5) {
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
                                if (et.id == R.id.et_N25_PG5) {
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
                    if (et.id == R.id.et_N25_PG5) {
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

    private fun getDoubleInput(editText: EditText, originalKey: String? = null): Double {
        val fullId = originalKey ?: resources.getResourceEntryName(editText.id)
        val idName = fullId.replace("_PG5", "")
        val textValue = editText.text.toString().trim()
        val value = textValue.toDoubleOrNull() ?: 0.0
        values[idName] = value
        return value
    }


    // This Function is Modified for G10–G14 row to display 1 decimal point.
// Currently disabled; all are using 2 decimal points.
    private fun setDouble(view: TextView, value: Double) {
        // val idName = resources.getResourceEntryName(view.id).replace("_PG5", "")
        // val useOneDecimal = idName.matches(Regex("tv_G1[0-4]"))
        // val formatted = if (useOneDecimal) df1.format(value) else df.format(value)

        val formatted = df.format(value)  // Always use 2 decimal places for now
        view.text = formatted
    }


    // This Function is Modified for H, I, J, K 10–14 to display 1 decimal point only
// Currently disabled; all EditTexts show 2 decimal points.
    private fun setDouble(view: EditText, value: Double) {
        // val idName = resources.getResourceEntryName(view.id).replace("_PG5", "")
        // val useOneDecimal = idName.matches(Regex("et_[HIJK]1[0-4]"))
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

    private fun updateTextViews(ids: List<TextView>, keys: List<String>, values: Map<String, Double?>) {
        ids.zip(keys).forEach { (view, key) ->
            setDouble(view, values[key] ?: 0.0)
        }
    }

    private fun updateEditTexts(ids: List<EditText>, keys: List<String>, values: Map<String, Double?>, condition: Boolean) {
        if (!condition) {
            ids.zip(keys).forEach { (view, key) ->
                setDouble(view, values[key] ?: 0.0)
            }
        }
    }

    private fun round2(value: Double): Double {
        return BigDecimal(value).setScale(2, RoundingMode.HALF_UP).toDouble()
    }

    private fun recalculateAndUpdate() {
        // 1. Gather all user inputs into values map
        allInputEditTexts.forEach { editText ->
            getDoubleInput(editText) // Let it auto-append _PG3
        }

        // Pull from Page6DataCache and round2 them
        val I13_PG6 = round2(Page6DataCache.Sio2RawMeal)
        val I14_PG6 = round2(Page6DataCache.Al2o3RawMeal)
        val I15_PG6 = round2(Page6DataCache.Fe2o3RawMeal)
        val I16_PG6 = round2(Page6DataCache.CaoRawMeal)
        val I17_PG6 = round2(Page6DataCache.MgoRawMeal)
        val I18_PG6 = round2(Page6DataCache.Na2oRawMeal)
        val I19_PG6 = round2(Page6DataCache.K2oRawMeal)
        val I20_PG6 = round2(Page6DataCache.So3RawMeal)
        val I21_PG6 = round2(Page6DataCache.ClRawMeal)
        val I22_PG6 = round2(Page6DataCache.LoiRawMeal)

        val isPage6DataValid = listOf(
            I13_PG6, I14_PG6, I15_PG6, I16_PG6, I17_PG6,
            I18_PG6, I19_PG6, I20_PG6, I21_PG6, I22_PG6
        ).any { it != 0.0 }

        val allTrcFieldsEmptyOrZero = listOf(
            et_L17, et_M17, et_N17, et_O17,
            et_P17, et_Q17, et_R17, et_S17, et_T17, et_U17_trc_LOI
        ).all { it.text.isNullOrBlank() || it.text.toString().toDoubleOrNull() == 0.0 }

        if (isPage6DataValid && allTrcFieldsEmptyOrZero) {
            et_L17.setText(df.format(I13_PG6))
            et_M17.setText(df.format(I14_PG6))
            et_N17.setText(df.format(I15_PG6))
            et_O17.setText(df.format(I16_PG6))
            et_P17.setText(df.format(I17_PG6))
            et_Q17.setText(df.format(I18_PG6))
            et_R17.setText(df.format(I19_PG6))
            et_S17.setText(df.format(I20_PG6))
            et_T17.setText(df.format(I21_PG6))
            et_U17_trc_LOI.setText(df.format(I22_PG6))

            values["et_L17"] = I13_PG6
            values["et_M17"] = I14_PG6
            values["et_N17"] = I15_PG6
            values["et_O17"] = I16_PG6
            values["et_P17"] = I17_PG6
            values["et_Q17"] = I18_PG6
            values["et_R17"] = I19_PG6
            values["et_S17"] = I20_PG6
            values["et_T17"] = I21_PG6
            values["et_U17"] = I22_PG6
        }


        // --- MATERIAL SETTING: LIMESTONE, SHALE, IRON ORE ---
        // Row 1: Always Manual
        // H10, I10, J10, K10 are user inputs

        // Row 2-5: AUTO/MANUAL depending on switch
        // For manual mode (switch.isChecked = true), use user input values
        // For auto mode (switch.isChecked = false), calculate values

        // Material Setting

// === ROW 2 ===
// Column Green 1
// Error Row
        val L30 = (values["et_L17"] ?: 0.0) - (values["et_L10"] ?: 0.0)
        val M30 = (values["et_M17"] ?: 0.0) - (values["et_M10"] ?: 0.0)
        val N30 = (values["et_N17"] ?: 0.0) - (values["et_N10"] ?: 0.0)
        val O30 = (values["et_O17"] ?: 0.0) - (values["et_O10"] ?: 0.0)
// Est. Adj Oxide Row
        val L31 = if (H31 != 0.0) (L30 / H31) * 100 else 0.0
        val M31 = if (G32 != 0.0) (M30 / G32) * 100 else 0.0
        val N31 = if (I33 != 0.0) (N30 / I33) * 100 else 0.0
        val O31 = if (F34 != 0.0) (O30 / F34) * 100 else 0.0
// Unnormalized Row
        val L32 = L31 + (values["et_J10"] ?: 0.0)
        val M32 = M31 + (values["et_I10"] ?: 0.0)
        val N32 = N31 + (values["et_K10"] ?: 0.0)
        val O32 = O31 + (values["et_H10"] ?: 0.0)
// Condition if Row
        val L33 = if (L32 < 0) 0.0 else L32
        val M33 = if (M32 < 0) 0.0 else M32
        val N33 = if (N32 < 0) 0.0 else N32
        val O33 = if (O32 < 0) 0.0 else O32
// Normalized Row
        val totalOxides = L33 + M33 + N33 + O33
        val H11 = round2(if (totalOxides != 0.0) (O33 / totalOxides) * 100 else 0.0)
        val J11 = round2(if (totalOxides != 0.0) (L33 / totalOxides) * 100 else 0.0)
        val K11 = round2(if (totalOxides != 0.0) (N33 / totalOxides) * 100 else 0.0)
        val I11 = round2(100 - H11 - J11 - K11)

        values["H11"] = H11
        values["J11"] = J11
        values["K11"] = K11
        values["I11"] = I11

// Use actual source values from Row 2 depending on manual/auto
        val H11_actual = if (switch_row2.isChecked) values["et_H11"] ?: 0.0 else H11
        val J11_actual = if (switch_row2.isChecked) values["et_J11"] ?: 0.0 else J11
        val K11_actual = if (switch_row2.isChecked) values["et_K11"] ?: 0.0 else K11
        val I11_actual = if (switch_row2.isChecked) values["et_I11"] ?: 0.0 else I11

// === ROW 3 ===
// Column Light Blue 2
// Error Row
        val P30 = (values["et_L17"] ?: 0.0) - (values["et_L11"] ?: 0.0)
        val Q30 = (values["et_M17"] ?: 0.0) - (values["et_M11"] ?: 0.0)
        val R30 = (values["et_N17"] ?: 0.0) - (values["et_N11"] ?: 0.0)
        val S30 = (values["et_O17"] ?: 0.0) - (values["et_O11"] ?: 0.0)
// Est. Adj Oxide Row
        val P31 = if (H31 != 0.0) (P30 / H31) * 100 else 0.0
        val Q31 = if (G32 != 0.0) (Q30 / G32) * 100 else 0.0
        val R31 = if (I33 != 0.0) (R30 / I33) * 100 else 0.0
        val S31 = if (F34 != 0.0) (S30 / F34) * 100 else 0.0
// Unnormalized Row
        val P32 = P31 + J11_actual
        val Q32 = Q31 + I11_actual
        val R32 = R31 + K11_actual
        val S32 = S31 + H11_actual
// Condition if Row
        val P33 = if (P32 < 0) 0.0 else P32
        val Q33 = if (Q32 < 0) 0.0 else Q32
        val R33 = if (R32 < 0) 0.0 else R32
        val S33 = if (S32 < 0) 0.0 else S32
// Normalized Row
        val totalOxides2 = P33 + Q33 + R33 + S33
        val H12 = round2(if (totalOxides2 != 0.0) (S33 / totalOxides2) * 100 else 0.0)
        val J12 = round2(if (totalOxides2 != 0.0) (P33 / totalOxides2) * 100 else 0.0)
        val K12 = round2(if (totalOxides2 != 0.0) (R33 / totalOxides2) * 100 else 0.0)
        val I12 = round2(100 - H12 - J12 - K12)

        values["H12"] = H12
        values["J12"] = J12
        values["K12"] = K12
        values["I12"] = I12

// === ROW 4 ===
        val H12_actual = if (switch_row3.isChecked) values["et_H12"] ?: 0.0 else H12
        val J12_actual = if (switch_row3.isChecked) values["et_J12"] ?: 0.0 else J12
        val K12_actual = if (switch_row3.isChecked) values["et_K12"] ?: 0.0 else K12
        val I12_actual = if (switch_row3.isChecked) values["et_I12"] ?: 0.0 else I12

// Column Gray 3
        val T30 = (values["et_L17"] ?: 0.0) - (values["et_L12"] ?: 0.0)
        val U30 = (values["et_M17"] ?: 0.0) - (values["et_M12"] ?: 0.0)
        val V30 = (values["et_N17"] ?: 0.0) - (values["et_N12"] ?: 0.0)
        val W30 = (values["et_O17"] ?: 0.0) - (values["et_O12"] ?: 0.0)
        val T31 = if (H31 != 0.0) (T30 / H31) * 100 else 0.0
        val U31 = if (G32 != 0.0) (U30 / G32) * 100 else 0.0
        val V31 = if (I33 != 0.0) (V30 / I33) * 100 else 0.0
        val W31 = if (F34 != 0.0) (W30 / F34) * 100 else 0.0
        val T32 = T31 + J12_actual
        val U32 = U31 + I12_actual
        val V32 = V31 + K12_actual
        val W32 = W31 + H12_actual
        val T33 = if (T32 < 0) 0.0 else T32
        val U33 = if (U32 < 0) 0.0 else U32
        val V33 = if (V32 < 0) 0.0 else V32
        val W33 = if (W32 < 0) 0.0 else W32
        val totalOxides3 = T33 + U33 + V33 + W33
        val H13 = round2(if (totalOxides3 != 0.0) (W33 / totalOxides3) * 100 else 0.0)
        val J13 = round2(if (totalOxides3 != 0.0) (T33 / totalOxides3) * 100 else 0.0)
        val K13 = round2(if (totalOxides3 != 0.0) (V33 / totalOxides3) * 100 else 0.0)
        val I13 = round2(100 - H13 - J13 - K13)

        values["H13"] = H13
        values["J13"] = J13
        values["K13"] = K13
        values["I13"] = I13

// === ROW 5 ===
        val H13_actual = if (switch_row4.isChecked) values["et_H13"] ?: 0.0 else H13
        val J13_actual = if (switch_row4.isChecked) values["et_J13"] ?: 0.0 else J13
        val K13_actual = if (switch_row4.isChecked) values["et_K13"] ?: 0.0 else K13
        val I13_actual = if (switch_row4.isChecked) values["et_I13"] ?: 0.0 else I13
        val X30 = (values["et_L17"] ?: 0.0) - (values["et_L13"] ?: 0.0)
        val Y30 = (values["et_M17"] ?: 0.0) - (values["et_M13"] ?: 0.0)
        val Z30 = (values["et_N17"] ?: 0.0) - (values["et_N13"] ?: 0.0)
        val AA30 = (values["et_O17"] ?: 0.0) - (values["et_O13"] ?: 0.0)
        val X31 = if (H31 != 0.0) (X30 / H31) * 100 else 0.0
        val Y31 = if (G32 != 0.0) (Y30 / G32) * 100 else 0.0
        val Z31 = if (I33 != 0.0) (Z30 / I33) * 100 else 0.0
        val AA31 = if (F34 != 0.0) (AA30 / F34) * 100 else 0.0
        val X32 = X31 + J13_actual
        val Y32 = Y31 + I13_actual
        val Z32 = Z31 + K13_actual
        val AA32 = AA31 + H13_actual
        val X33 = if (X32 < 0) 0.0 else X32
        val Y33 = if (Y32 < 0) 0.0 else Y32
        val Z33 = if (Z32 < 0) 0.0 else Z32
        val AA33 = if (AA32 < 0) 0.0 else AA32
        val totalOxides4 = X33 + Y33 + Z33 + AA33
        val H14 = round2(if (totalOxides4 != 0.0) (AA33 / totalOxides4) * 100 else 0.0)
        val J14 = round2(if (totalOxides4 != 0.0) (X33 / totalOxides4) * 100 else 0.0)
        val K14 = round2(if (totalOxides4 != 0.0) (Z33 / totalOxides4) * 100 else 0.0)
        val I14 = round2(100 - H14 - J14 - K14)

        values["H14"] = H14
        values["J14"] = J14
        values["K14"] = K14
        values["I14"] = I14

// Store back for manual mode
        if (!switch_row2.isChecked) {
            values["et_H11"] = H11
            values["et_J11"] = J11
            values["et_K11"] = K11
            values["et_I11"] = I11
        }
        if (!switch_row3.isChecked) {
            values["et_H12"] = H12
            values["et_J12"] = J12
            values["et_K12"] = K12
            values["et_I12"] = I12
        }
        if (!switch_row4.isChecked) {
            values["et_H13"] = H13
            values["et_J13"] = J13
            values["et_K13"] = K13
            values["et_I13"] = I13
        }
        if (!switch_row5.isChecked) {
            values["et_H14"] = H14
            values["et_J14"] = J14
            values["et_K14"] = K14
            values["et_I14"] = I14
        }


        // --- TOTAL1 (G10–G14) ---
        for (i in 10..14) {
            val h = values["et_H$i"] ?: 0.0
            val iVal = values["et_I$i"] ?: 0.0
            val j = values["et_J$i"] ?: 0.0
            val k = values["et_K$i"] ?: 0.0
            values["G$i"] = h + iVal + j + k
        }


        // --- LOI (U10–U13) ---
        for (i in 10..13) {
            val o = values["et_O$i"] ?: 0.0
            val p = values["et_P$i"] ?: 0.0
            values["U$i"] = if (o == 0.0 && p == 0.0) 0.0 else 0.786 * o + 1.1 * p + 0.2
        }


        // --- TOTAL2 (V10–V13) ---
        val vKeys = listOf("et_L", "et_M", "et_N", "et_O", "et_P", "et_Q", "et_R", "et_S", "et_T")

        for (i in 10..13) {
            val total = vKeys.sumOf { values["${it}$i"] ?: 0.0 } + (values["U$i"] ?: 0.0)
            values["V$i"] = total
        }

        // --- RATIOS (W10-Z3) ---
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

        // --- RATIOS: LSF (W10–W13) ---
        for (i in 10..13) {
            val O = values["et_O$i"] ?: 0.0
            val L = values["et_L$i"] ?: 0.0
            val M = values["et_M$i"] ?: 0.0
            val N = values["et_N$i"] ?: 0.0

            values["W$i"] = lsf(O, L, M, N)
        }

        // --- RATIOS: HM (X10–X13) ---
        for (i in 10..13) {
            val O = values["et_O$i"] ?: 0.0
            val L = values["et_L$i"] ?: 0.0
            val M = values["et_M$i"] ?: 0.0
            val N = values["et_N$i"] ?: 0.0

            values["X$i"] = hm(O, L, M, N)
        }

        // --- RATIOS: SM (Y10–Y13) ---
        for (i in 10..13) {
            val L = values["et_L$i"] ?: 0.0
            val M = values["et_M$i"] ?: 0.0
            val N = values["et_N$i"] ?: 0.0

            values["Y$i"] = sm(L, M, N)
        }

        // --- RATIOS: AM (Z10–Z13) ---
        for (i in 10..13) {
            val M = values["et_M$i"] ?: 0.0
            val N = values["et_N$i"] ?: 0.0

            values["Z$i"] = am(M,N)
        }

        // --- TARGET TABLE ---
        values["I17"] = I8_PG6
        values["I18"] = I9_PG6
        values["I19"] = I10_PG6
        // I20 is user input

    // --- TARGET RAWMEAL COMPOSITION ---
        val row17 = 17

    // Total TRC
        val trcKeys = listOf("et_L", "et_M", "et_N", "et_O", "et_P", "et_Q", "et_R", "et_S", "et_T", "et_U")
        values["V$row17"] = trcKeys.sumOf { values["${it}$row17"] ?: 0.0 }

    // Ratios
        val L17 = values["et_L$row17"] ?: 0.0
        val M17 = values["et_M$row17"] ?: 0.0
        val N17 = values["et_N$row17"] ?: 0.0
        val O17 = values["et_O$row17"] ?: 0.0

        values["W$row17"] = lsf(O17, L17, M17, N17)
        values["X$row17"] = hm(O17, L17, M17, N17)
        values["Y$row17"] = sm(L17, M17, N17)
        values["Z$row17"] = am(M17, N17)


    // --- COAL ASH COMPOSITION ---
        val row19 = 19

    // Total TRC
        values["V$row19"] = trcKeys.sumOf { values["${it}$row19"] ?: 0.0 }

    // Ratios
        val L19 = values["et_L$row19"] ?: 0.0
        val M19 = values["et_M$row19"] ?: 0.0
        val N19 = values["et_N$row19"] ?: 0.0
        val O19 = values["et_O$row19"] ?: 0.0

        values["W$row19"] = lsf(O19, L19, M19, N19)
        values["X$row19"] = hm(O19, L19, M19, N19)
        values["Y$row19"] = sm(L19, M19, N19)
        values["Z$row19"] = am(M19, N19)



// --- POTENTIAL CLINKER COMPOSITION ---

        val u17 = values["et_U17"] ?: 0.0
        val i20 = (values["et_I20"] ?: 0.0) / 100.0
        val factorL = if (1.0 - u17 / 100.0 == 0.0) 0.0 else 1.0 / (1.0 - u17 / 100.0)
        val factor1MinusI20 = 1.0 - i20

// Populate L22 to T22
        ('L'..'T').forEach { letter ->
            val v17 = values["et_${letter}17"] ?: 0.0
            val v19 = values["et_${letter}19"] ?: 0.0
            values["${letter}22"] = factorL * v17 * factor1MinusI20 + v19 * i20
        }

// Sum L22 to T22 into U22
        values["U22"] = ('L'..'T').sumOf { values["${it}22"] ?: 0.0 }

// W22 to Z22 Calculations
        val (L22, M22, N22, O22) = listOf("L22", "M22", "N22", "O22").map { values[it] ?: 0.0 }

        values["W22"] = (if (2.8 * L22 + 1.2 * M22 + 0.65 * N22 == 0.0) 0.0 else (O22 * 100) / (2.8 * L22 + 1.2 * M22 + 0.65 * N22))
        values["X22"] = (if (L22 + M22 + N22 == 0.0) 0.0 else O22 / (L22 + M22 + N22))
        values["Y22"] = (if (M22 + N22 == 0.0) 0.0 else L22 / (M22 + N22))
        values["Z22"] = (if (N22 == 0.0) 0.0 else M22 / N22)


// --- MINERAL & HOT MEAL ---

        val (S22, R22, Q22, P22) = listOf("S22", "R22", "Q22", "P22").map { values[it] ?: 0.0 }
        val m25 = values["et_M25"] ?: 0.0
        val p25 = (values["et_P25"] ?: 0.0) / 100.0
        val z25 = (values["et_Z25"] ?: 0.0) / 100.0

        val numerator1 = p25 - z25
        val denominator1 = p25 - (p25 * z25)
        values["O25"] = if (denominator1 == 0.0) 0.0 else (numerator1 / denominator1) * 100.0

// Re-use L22, M22, N22, O22 from above
        values["Q25"] = 4.071 * (O22 - m25) - 7.6024 * L22 - 6.718 * M22 - 1.4297 * N22
        values["R25"] = 8.6024 * L22 + 5.0683 * M22 + 1.0785 * N22 - 3.071 * (O22 - m25)
        values["S25"] = 2.65 * M22 - 1.692 * N22
        values["T25"] = 3.0432 * N22

        val denominatorU25 = R22 + 0.5 * Q22
        values["U25"] = if (denominatorU25 == 0.0) 0.0 else S22 / denominatorU25

        values["V25"] = Q22 + (0.658 * R22)
        values["W25"] = 3 * M22 + 2.25 * N22 + P22 + Q22 + R22 + S22

        val S25 = values["S25"] ?: 0.0
        val T25 = values["T25"] ?: 0.0
        val R25 = values["R25"] ?: 0.0
        values["X25"] = S25 + T25 + (R25 * 0.2) + (2 * N22)




    // Row 1 Cell 10 Groups
        updateTextViews(
            listOf(tv_G10, tv_U10, tv_V10, tv_W10, tv_X10, tv_Y10, tv_Z10),
            listOf("G10", "U10", "V10", "W10", "X10", "Y10", "Z10"),
            values
        )

    // Row 2 Cell 11 Group
        updateTextViews(
            listOf(tv_G11, tv_U11, tv_V11, tv_W11, tv_X11, tv_Y11, tv_Z11),
            listOf("G11", "U11", "V11", "W11", "X11", "Y11", "Z11"),
            values
        )
        updateEditTexts(
            listOf(et_H11, et_I11, et_J11, et_K11),
            listOf("et_H11", "et_I11", "et_J11", "et_K11"),
            values,
            switch_row2.isChecked
        )

    // Row 3 Cell 12 Group
        updateTextViews(
            listOf(tv_G12, tv_U12, tv_V12, tv_W12, tv_X12, tv_Y12, tv_Z12),
            listOf("G12", "U12", "V12", "W12", "X12", "Y12", "Z12"),
            values
        )
        updateEditTexts(
            listOf(et_H12, et_I12, et_J12, et_K12),
            listOf("et_H12", "et_I12", "et_J12", "et_K12"),
            values,
            switch_row3.isChecked
        )

    // Row 4 Cell 13 Group
        updateTextViews(
            listOf(tv_G13, tv_U13, tv_V13, tv_W13, tv_X13, tv_Y13, tv_Z13),
            listOf("G13", "U13", "V13", "W13", "X13", "Y13", "Z13"),
            values
        )
        updateEditTexts(
            listOf(et_H13, et_I13, et_J13, et_K13),
            listOf("et_H13", "et_I13", "et_J13", "et_K13"),
            values,
            switch_row4.isChecked
        )

    // Row 4 Cell 14 Group
        updateTextViews(
            listOf(tv_G14),
            listOf("G14"),
            values
        )
        updateEditTexts(
            listOf(et_H14, et_I14, et_J14, et_K14),
            listOf("et_H14", "et_I14", "et_J14", "et_K14"),
            values,
            switch_row5.isChecked
        )

    // Target Values
        updateTextViews(
            listOf(tv_I17_target_LSF, tv_I18_target_SM, tv_I19_target_AM),
            listOf("I17", "I18", "I19"),
            values
        )

    // TRC
        updateTextViews(
            listOf(tv_V17_trc_TOTAL, tv_W17_trc_LSF, tv_X17_trc_HM, tv_Y17_trc_SM, tv_Z17_trc_AM),
            listOf("V17", "W17", "X17", "Y17", "Z17"),
            values
        )

    // Coal Ash Composition
        updateTextViews(
            listOf(tv_V19, tv_W19, tv_X19, tv_Y19, tv_Z19),
            listOf("V19", "W19", "X19", "Y19", "Z19"),
            values
        )

    // PCC
        updateTextViews(
            listOf(tv_L22, tv_M22, tv_N22, tv_O22, tv_P22, tv_Q22, tv_R22, tv_S22, tv_T22, tv_U22, tv_W22, tv_X22, tv_Y22, tv_Z22),
            listOf("L22", "M22", "N22", "O22", "P22", "Q22", "R22", "S22", "T22", "U22", "W22", "X22", "Y22", "Z22"),
            values
        )

    // Mineral & Hotmeal
        updateTextViews(
            listOf(tv_O25, tv_Q25, tv_R25, tv_S25, tv_T25, tv_U25, tv_V25, tv_W25, tv_X25),
            listOf("O25", "Q25", "R25", "S25", "T25", "U25", "V25", "W25", "X25"),
            values
        )

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
            val xrfRow2 = listOf(et_L11, et_M11, et_N11, et_O11, et_P11, et_Q11, et_R11, et_S11, et_T11)
            val xrfRow3 = listOf(et_L12, et_M12, et_N12, et_O12, et_P12, et_Q12, et_R12, et_S12, et_T12)
            val xrfRow4 = listOf(et_L13, et_M13, et_N13, et_O13, et_P13, et_Q13, et_R13, et_S13, et_T13)

            toggleEditTextsManual(listOf(et_H11, et_I11, et_J11, et_K11) + xrfRow2, switch_row2.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H12, et_I12, et_J12, et_K12) + xrfRow3, switch_row3.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H13, et_I13, et_J13, et_K13) + xrfRow4, switch_row4.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H14, et_I14, et_J14, et_K14), switch_row5.isChecked, mainTextWatcher)

            val alwaysEditableFields = listOf(
                et_H10, et_I10, et_J10, et_K10, et_L10, et_M10, et_N10, et_O10, et_P10, et_Q10, et_R10, et_S10, et_T10,
                et_I20,
                et_L17, et_M17, et_N17, et_O17, et_P17, et_Q17, et_R17, et_S17, et_T17, et_U17_trc_LOI,
                et_L19, et_M19, et_N19, et_O19, et_P19, et_Q19, et_R19, et_S19, et_T19, et_U19,
                et_L25, et_M25, et_N25, et_P25 , et_Y25, et_Z25
            )
            alwaysEditableFields.forEach {
                it.removeTextChangedListener(mainTextWatcher)
                it.addTextChangedListener(mainTextWatcher)
            }

            recalculateAndUpdate()

            Toast.makeText(this, "Data loaded successfully!", Toast.LENGTH_SHORT).show()
        }catch (e: Exception) {
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
                    dbHelper.saveData(5, data.toString(), if (saveName.isEmpty()) null else saveName)
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

    private fun cachePage5Fields() {
        val fields = listOf(
            // --- Material Row 1 (H10–K14) ---
            Triple(et_H10, { Page5DataCache.H10.toString() }, { v: String -> Page5DataCache.H10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_I10, { Page5DataCache.I10.toString() }, { v: String -> Page5DataCache.I10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_J10, { Page5DataCache.J10.toString() }, { v: String -> Page5DataCache.J10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_K10, { Page5DataCache.K10.toString() }, { v: String -> Page5DataCache.K10 = v.toDoubleOrNull() ?: 0.0 }),

            Triple(et_H11, { Page5DataCache.H11.toString() }, { v: String -> Page5DataCache.H11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_I11, { Page5DataCache.I11.toString() }, { v: String -> Page5DataCache.I11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_J11, { Page5DataCache.J11.toString() }, { v: String -> Page5DataCache.J11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_K11, { Page5DataCache.K11.toString() }, { v: String -> Page5DataCache.K11 = v.toDoubleOrNull() ?: 0.0 }),

            Triple(et_H12, { Page5DataCache.H12.toString() }, { v: String -> Page5DataCache.H12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_I12, { Page5DataCache.I12.toString() }, { v: String -> Page5DataCache.I12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_J12, { Page5DataCache.J12.toString() }, { v: String -> Page5DataCache.J12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_K12, { Page5DataCache.K12.toString() }, { v: String -> Page5DataCache.K12 = v.toDoubleOrNull() ?: 0.0 }),

            Triple(et_H13, { Page5DataCache.H13.toString() }, { v: String -> Page5DataCache.H13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_I13, { Page5DataCache.I13.toString() }, { v: String -> Page5DataCache.I13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_J13, { Page5DataCache.J13.toString() }, { v: String -> Page5DataCache.J13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_K13, { Page5DataCache.K13.toString() }, { v: String -> Page5DataCache.K13 = v.toDoubleOrNull() ?: 0.0 }),

            Triple(et_H14, { Page5DataCache.H14.toString() }, { v: String -> Page5DataCache.H14 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_I14, { Page5DataCache.I14.toString() }, { v: String -> Page5DataCache.I14 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_J14, { Page5DataCache.J14.toString() }, { v: String -> Page5DataCache.J14 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_K14, { Page5DataCache.K14.toString() }, { v: String -> Page5DataCache.K14 = v.toDoubleOrNull() ?: 0.0 }),

            // --- XRF Row 1 (L10–T10) ---
            Triple(et_L10, { Page5DataCache.L10.toString() }, { v: String -> Page5DataCache.L10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_M10, { Page5DataCache.M10.toString() }, { v: String -> Page5DataCache.M10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_N10, { Page5DataCache.N10.toString() }, { v: String -> Page5DataCache.N10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_O10, { Page5DataCache.O10.toString() }, { v: String -> Page5DataCache.O10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_P10, { Page5DataCache.P10.toString() }, { v: String -> Page5DataCache.P10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_Q10, { Page5DataCache.Q10.toString() }, { v: String -> Page5DataCache.Q10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_R10, { Page5DataCache.R10.toString() }, { v: String -> Page5DataCache.R10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_S10, { Page5DataCache.S10.toString() }, { v: String -> Page5DataCache.S10 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_T10, { Page5DataCache.T10.toString() }, { v: String -> Page5DataCache.T10 = v.toDoubleOrNull() ?: 0.0 }),

            // --- XRF Row 2 (L11–T11) ---
            Triple(et_L11, { Page5DataCache.L11.toString() }, { v: String -> Page5DataCache.L11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_M11, { Page5DataCache.M11.toString() }, { v: String -> Page5DataCache.M11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_N11, { Page5DataCache.N11.toString() }, { v: String -> Page5DataCache.N11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_O11, { Page5DataCache.O11.toString() }, { v: String -> Page5DataCache.O11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_P11, { Page5DataCache.P11.toString() }, { v: String -> Page5DataCache.P11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_Q11, { Page5DataCache.Q11.toString() }, { v: String -> Page5DataCache.Q11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_R11, { Page5DataCache.R11.toString() }, { v: String -> Page5DataCache.R11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_S11, { Page5DataCache.S11.toString() }, { v: String -> Page5DataCache.S11 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_T11, { Page5DataCache.T11.toString() }, { v: String -> Page5DataCache.T11 = v.toDoubleOrNull() ?: 0.0 }),

            // --- XRF Row 3 (L12–T12) ---
            Triple(et_L12, { Page5DataCache.L12.toString() }, { v: String -> Page5DataCache.L12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_M12, { Page5DataCache.M12.toString() }, { v: String -> Page5DataCache.M12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_N12, { Page5DataCache.N12.toString() }, { v: String -> Page5DataCache.N12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_O12, { Page5DataCache.O12.toString() }, { v: String -> Page5DataCache.O12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_P12, { Page5DataCache.P12.toString() }, { v: String -> Page5DataCache.P12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_Q12, { Page5DataCache.Q12.toString() }, { v: String -> Page5DataCache.Q12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_R12, { Page5DataCache.R12.toString() }, { v: String -> Page5DataCache.R12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_S12, { Page5DataCache.S12.toString() }, { v: String -> Page5DataCache.S12 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_T12, { Page5DataCache.T12.toString() }, { v: String -> Page5DataCache.T12 = v.toDoubleOrNull() ?: 0.0 }),

            // --- XRF Row 4 (L13–T13) ---
            Triple(et_L13, { Page5DataCache.L13.toString() }, { v: String -> Page5DataCache.L13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_M13, { Page5DataCache.M13.toString() }, { v: String -> Page5DataCache.M13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_N13, { Page5DataCache.N13.toString() }, { v: String -> Page5DataCache.N13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_O13, { Page5DataCache.O13.toString() }, { v: String -> Page5DataCache.O13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_P13, { Page5DataCache.P13.toString() }, { v: String -> Page5DataCache.P13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_Q13, { Page5DataCache.Q13.toString() }, { v: String -> Page5DataCache.Q13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_R13, { Page5DataCache.R13.toString() }, { v: String -> Page5DataCache.R13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_S13, { Page5DataCache.S13.toString() }, { v: String -> Page5DataCache.S13 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_T13, { Page5DataCache.T13.toString() }, { v: String -> Page5DataCache.T13 = v.toDoubleOrNull() ?: 0.0 }),

            // --- Target Ratios ---
            Triple(et_I20, { Page5DataCache.I20.toString() }, { v: String -> Page5DataCache.I20 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(raw_mix_type, { Page5DataCache.raw_mix_type }, { v: String -> Page5DataCache.raw_mix_type = v }), // String type

            // --- Coal Ash Composition (L19–U19) ---
            Triple(et_L19, { Page5DataCache.L19.toString() }, { v: String -> Page5DataCache.L19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_M19, { Page5DataCache.M19.toString() }, { v: String -> Page5DataCache.M19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_N19, { Page5DataCache.N19.toString() }, { v: String -> Page5DataCache.N19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_O19, { Page5DataCache.O19.toString() }, { v: String -> Page5DataCache.O19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_P19, { Page5DataCache.P19.toString() }, { v: String -> Page5DataCache.P19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_Q19, { Page5DataCache.Q19.toString() }, { v: String -> Page5DataCache.Q19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_R19, { Page5DataCache.R19.toString() }, { v: String -> Page5DataCache.R19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_S19, { Page5DataCache.S19.toString() }, { v: String -> Page5DataCache.S19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_T19, { Page5DataCache.T19.toString() }, { v: String -> Page5DataCache.T19 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_U19, { Page5DataCache.U19.toString() }, { v: String -> Page5DataCache.U19 = v.toDoubleOrNull() ?: 0.0 }),

            // --- Fuel Section (L25, M25, N25, P25, Y25, Z25) ---
            Triple(et_L25, { Page5DataCache.L25.toString() }, { v: String -> Page5DataCache.L25 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_M25, { Page5DataCache.M25.toString() }, { v: String -> Page5DataCache.M25 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_N25, { Page5DataCache.N25 }, { v: String -> Page5DataCache.N25 = v }), // String type
            Triple(et_P25, { Page5DataCache.P25.toString() }, { v: String -> Page5DataCache.P25 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_Y25, { Page5DataCache.Y25.toString() }, { v: String -> Page5DataCache.Y25 = v.toDoubleOrNull() ?: 0.0 }),
            Triple(et_Z25, { Page5DataCache.Z25.toString() }, { v: String -> Page5DataCache.Z25 = v.toDoubleOrNull() ?: 0.0 })
        )

        fields.forEach { (editText, getter, setter) ->
            if (editText.text.isNullOrBlank()) {
                val cachedValue = getter()
                if (cachedValue != "0.0" && cachedValue.isNotBlank()) {
                    editText.setText(cachedValue)
                }
            }

            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    setter(s.toString())
                }
            })
        }
    }


}