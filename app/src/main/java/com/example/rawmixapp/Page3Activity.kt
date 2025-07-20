package com.example.rawmixapp

import android.content.pm.ActivityInfo
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.rawmixapp.db.SavedDataDbHelper
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
// import androidx.appcompat.app.AppCompatActivity // Replaced by BaseActivity
class Page3Activity : BaseActivity() {

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



    private lateinit var tableLayout: TableLayout

    //Declare Ui ELements
    private lateinit var tv_G10_PG3: TextView
    private lateinit var et_H10_PG3: EditText
    private lateinit var et_I10_PG3: EditText
    private lateinit var et_J10_PG3: EditText
    private lateinit var et_K10_PG3: EditText
    private lateinit var et_L10_PG3: EditText
    private lateinit var et_M10_PG3: EditText
    private lateinit var et_N10_PG3: EditText
    private lateinit var et_O10_PG3: EditText
    private lateinit var et_P10_PG3: EditText
    private lateinit var et_Q10_PG3: EditText
    private lateinit var et_R10_PG3: EditText
    private lateinit var et_S10_PG3: EditText
    private lateinit var tv_T10_PG3: TextView
    private lateinit var tv_U10_PG3: TextView
    private lateinit var tv_V10_PG3: TextView
    private lateinit var tv_W10_PG3: TextView
    private lateinit var tv_X10_PG3: TextView
    private lateinit var tv_Y10_PG3: TextView

    private lateinit var switch_row2: Switch
    private lateinit var tv_G11_PG3: TextView
    private lateinit var et_H11_PG3: EditText
    private lateinit var et_I11_PG3: EditText
    private lateinit var et_J11_PG3: EditText
    private lateinit var et_K11_PG3: EditText
    private lateinit var et_L11_PG3: EditText
    private lateinit var et_M11_PG3: EditText
    private lateinit var et_N11_PG3: EditText
    private lateinit var et_O11_PG3: EditText
    private lateinit var et_P11_PG3: EditText
    private lateinit var et_Q11_PG3: EditText
    private lateinit var et_R11_PG3: EditText
    private lateinit var et_S11_PG3: EditText
    private lateinit var tv_T11_PG3: TextView
    private lateinit var tv_U11_PG3: TextView
    private lateinit var tv_V11_PG3: TextView
    private lateinit var tv_W11_PG3: TextView
    private lateinit var tv_X11_PG3: TextView
    private lateinit var tv_Y11_PG3: TextView

    private lateinit var switch_row3: Switch
    private lateinit var tv_G12_PG3: TextView
    private lateinit var et_H12_PG3: EditText
    private lateinit var et_I12_PG3: EditText
    private lateinit var et_J12_PG3: EditText
    private lateinit var et_K12_PG3: EditText
    private lateinit var et_L12_PG3: EditText
    private lateinit var et_M12_PG3: EditText
    private lateinit var et_N12_PG3: EditText
    private lateinit var et_O12_PG3: EditText
    private lateinit var et_P12_PG3: EditText
    private lateinit var et_Q12_PG3: EditText
    private lateinit var et_R12_PG3: EditText
    private lateinit var et_S12_PG3: EditText
    private lateinit var tv_T12_PG3: TextView
    private lateinit var tv_U12_PG3: TextView
    private lateinit var tv_V12_PG3: TextView
    private lateinit var tv_W12_PG3: TextView
    private lateinit var tv_X12_PG3: TextView
    private lateinit var tv_Y12_PG3: TextView

    private lateinit var switch_row4: Switch
    private lateinit var tv_G13_PG3: TextView
    private lateinit var et_H13_PG3: EditText
    private lateinit var et_I13_PG3: EditText
    private lateinit var et_J13_PG3: EditText
    private lateinit var et_K13_PG3: EditText
    private lateinit var et_L13_PG3: EditText
    private lateinit var et_M13_PG3: EditText
    private lateinit var et_N13_PG3: EditText
    private lateinit var et_O13_PG3: EditText
    private lateinit var et_P13_PG3: EditText
    private lateinit var et_Q13_PG3: EditText
    private lateinit var et_R13_PG3: EditText
    private lateinit var et_S13_PG3: EditText
    private lateinit var tv_T13_PG3: TextView
    private lateinit var tv_U13_PG3: TextView
    private lateinit var tv_V13_PG3: TextView
    private lateinit var tv_W13_PG3: TextView
    private lateinit var tv_X13_PG3: TextView
    private lateinit var tv_Y13_PG3: TextView

    private lateinit var switch_row5: Switch
    private lateinit var tv_G14_PG3: TextView
    private lateinit var et_H14_PG3: EditText
    private lateinit var et_I14_PG3: EditText
    private lateinit var et_J14_PG3: EditText

    private lateinit var tv_H17_target_LSF_PG3: TextView
    private lateinit var tv_H18_target_AM_PG3: TextView
    private lateinit var et_H19_PG3: EditText

    private lateinit var et_K17_PG3: EditText
    private lateinit var et_L17_PG3: EditText
    private lateinit var et_M17_PG3: EditText
    private lateinit var et_N17_PG3: EditText
    private lateinit var et_O17_PG3: EditText
    private lateinit var et_P17_PG3: EditText
    private lateinit var et_Q17_PG3: EditText
    private lateinit var et_R17_PG3: EditText
    private lateinit var et_S17_PG3: EditText
    private lateinit var et_T17_trc_LOI_PG3: EditText
    private lateinit var tv_U17_trc_TOTAL_PG3: TextView
    private lateinit var tv_V17_trc_LSF_PG3: TextView
    private lateinit var tv_W17_trc_SM_PG3: TextView
    private lateinit var tv_X17_trc_SR_PG3: TextView
    private lateinit var tv_Y17_trc_AM_PG3: TextView

    private lateinit var et_K19_PG3: EditText
    private lateinit var et_L19_PG3: EditText
    private lateinit var et_M19_PG3: EditText
    private lateinit var et_N19_PG3: EditText
    private lateinit var et_O19_PG3: EditText
    private lateinit var et_P19_PG3: EditText
    private lateinit var et_Q19_PG3: EditText
    private lateinit var et_R19_PG3: EditText
    private lateinit var et_S19_PG3: EditText
    private lateinit var et_T19_PG3: EditText
    private lateinit var tv_U19_PG3: TextView
    private lateinit var tv_V19_PG3: TextView
    private lateinit var tv_W19_PG3: TextView
    private lateinit var tv_X19_PG3: TextView
    private lateinit var tv_Y19_PG3: TextView

    private lateinit var tv_K22_PG3: TextView
    private lateinit var tv_L22_PG3: TextView
    private lateinit var tv_M22_PG3: TextView
    private lateinit var tv_N22_PG3: TextView
    private lateinit var tv_O22_PG3: TextView
    private lateinit var tv_P22_PG3: TextView
    private lateinit var tv_Q22_PG3: TextView
    private lateinit var tv_R22_PG3: TextView
    private lateinit var tv_S22_PG3: TextView
    private lateinit var tv_T22_PG3: TextView
    private lateinit var tv_V22_PG3: TextView
    private lateinit var tv_W22_PG3: TextView
    private lateinit var tv_X22_PG3: TextView
    private lateinit var tv_Y22_PG3: TextView

    private lateinit var et_K25_PG3: EditText
    private lateinit var et_L25_PG3: EditText
    private lateinit var tv_M25_PG3: TextView
    private lateinit var tv_N25_PG3: TextView
    private lateinit var et_O25_PG3: EditText
    private lateinit var tv_P25_PG3: TextView
    private lateinit var tv_Q25_PG3: TextView
    private lateinit var tv_R25_PG3: TextView
    private lateinit var tv_S25_PG3: TextView
    private lateinit var tv_T25_PG3: TextView
    private lateinit var tv_U25_PG3: TextView
    private lateinit var tv_V25_PG3: TextView
    private lateinit var tv_W25_PG3: TextView
    private lateinit var et_X25_PG3: EditText
    private lateinit var et_Y25_PG3: EditText

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
        supportActionBar?.title = "3 Materials LSF & SM"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page3) // Use BaseActivity's content frame
        // Add any specific Page3Activity initialization here

        // Retrieve the values from Page4DataCache
        F31 = Page4DataCache.SiO2Limestone
        G31 = Page4DataCache.SiO2Shale
        H31 = Page4DataCache.SiO2Ironore

        F32 = Page4DataCache.Al2O3Limestone
        G32 = Page4DataCache.Al2O3Shale
        H32 = Page4DataCache.Al2O3Ironore

        F33 = Page4DataCache.Fe2O3Limestone
        G33 = Page4DataCache.Fe2O3Shale
        H33 = Page4DataCache.Fe2O3Ironore

        F34 = Page4DataCache.CaOLimestone
        G34 = Page4DataCache.CaOShale
        H34 = Page4DataCache.CaOIronore



        dbHelper = SavedDataDbHelper(this)
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        mainTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (currentSavedDataId != -1L) {
                    isDataModified = true
                }
                recalculateAndUpdate()
            }
        }

        tableLayout = findViewById(R.id.tableLayout)
        initializeViews()

        xrfRow2 = listOf(et_K11_PG3, et_L11_PG3, et_M11_PG3, et_N11_PG3, et_O11_PG3, et_P11_PG3, et_Q11_PG3, et_R11_PG3, et_S11_PG3)
        xrfRow3 = listOf(et_K12_PG3, et_L12_PG3, et_M12_PG3, et_N12_PG3, et_O12_PG3, et_P12_PG3, et_Q12_PG3, et_R12_PG3, et_S12_PG3)
        xrfRow4 = listOf(et_K13_PG3, et_L13_PG3, et_M13_PG3, et_N13_PG3, et_O13_PG3, et_P13_PG3, et_Q13_PG3, et_R13_PG3, et_S13_PG3)

        allSwitches.forEach { switch ->
            switch.isChecked = true
            when (switch) {
                switch_row2 -> toggleEditTextsManual(listOf(et_H11_PG3, et_I11_PG3, et_J11_PG3) + xrfRow2, true, mainTextWatcher)
                switch_row3 -> toggleEditTextsManual(listOf(et_H12_PG3, et_I12_PG3, et_J12_PG3) + xrfRow3, true, mainTextWatcher)
                switch_row4 -> toggleEditTextsManual(listOf(et_H13_PG3, et_I13_PG3, et_J13_PG3) + xrfRow4, true, mainTextWatcher)
                switch_row5 -> toggleEditTextsManual(listOf(et_H14_PG3, et_I14_PG3, et_J14_PG3), true, mainTextWatcher)
            }
        }

        setupListeners() // handles watcher attachment only once
        setupButtons()

        recalculateAndUpdate()

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
        cachePage3Fields()
    }


    private fun initializeViews() {
        tv_G10_PG3 = findViewById(R.id.tv_G10)
        et_H10_PG3 = findViewById(R.id.et_H10); et_I10_PG3 = findViewById(R.id.et_I10); et_J10_PG3 = findViewById(R.id.et_J10)
        et_K10_PG3 = findViewById(R.id.et_K10); et_L10_PG3 = findViewById(R.id.et_L10); et_M10_PG3 = findViewById(R.id.et_M10)
        et_N10_PG3 = findViewById(R.id.et_N10); et_O10_PG3 = findViewById(R.id.et_O10); et_P10_PG3 = findViewById(R.id.et_P10)
        et_Q10_PG3 = findViewById(R.id.et_Q10); et_R10_PG3 = findViewById(R.id.et_R10); et_S10_PG3 = findViewById(R.id.et_S10)
        tv_T10_PG3 = findViewById(R.id.tv_T10); tv_U10_PG3 = findViewById(R.id.tv_U10); tv_V10_PG3 = findViewById(R.id.tv_V10)
        tv_W10_PG3 = findViewById(R.id.tv_W10); tv_X10_PG3 = findViewById(R.id.tv_X10); tv_Y10_PG3 = findViewById(R.id.tv_Y10)

        switch_row2 = findViewById(R.id.switch_row2); tv_G11_PG3 = findViewById(R.id.tv_G11)
        et_H11_PG3 = findViewById(R.id.et_H11); et_I11_PG3 = findViewById(R.id.et_I11); et_J11_PG3 = findViewById(R.id.et_J11)
        et_K11_PG3 = findViewById(R.id.et_K11); et_L11_PG3 = findViewById(R.id.et_L11); et_M11_PG3 = findViewById(R.id.et_M11)
        et_N11_PG3 = findViewById(R.id.et_N11); et_O11_PG3 = findViewById(R.id.et_O11); et_P11_PG3 = findViewById(R.id.et_P11)
        et_Q11_PG3 = findViewById(R.id.et_Q11); et_R11_PG3 = findViewById(R.id.et_R11); et_S11_PG3 = findViewById(R.id.et_S11)
        tv_T11_PG3 = findViewById(R.id.tv_T11); tv_U11_PG3 = findViewById(R.id.tv_U11); tv_V11_PG3 = findViewById(R.id.tv_V11)
        tv_W11_PG3 = findViewById(R.id.tv_W11); tv_X11_PG3 = findViewById(R.id.tv_X11); tv_Y11_PG3 = findViewById(R.id.tv_Y11)

        switch_row3 = findViewById(R.id.switch_row3); tv_G12_PG3 = findViewById(R.id.tv_G12)
        et_H12_PG3 = findViewById(R.id.et_H12); et_I12_PG3 = findViewById(R.id.et_I12); et_J12_PG3 = findViewById(R.id.et_J12)
        et_K12_PG3 = findViewById(R.id.et_K12); et_L12_PG3 = findViewById(R.id.et_L12); et_M12_PG3 = findViewById(R.id.et_M12)
        et_N12_PG3 = findViewById(R.id.et_N12); et_O12_PG3 = findViewById(R.id.et_O12); et_P12_PG3 = findViewById(R.id.et_P12)
        et_Q12_PG3 = findViewById(R.id.et_Q12); et_R12_PG3 = findViewById(R.id.et_R12); et_S12_PG3 = findViewById(R.id.et_S12)
        tv_T12_PG3 = findViewById(R.id.tv_T12); tv_U12_PG3 = findViewById(R.id.tv_U12); tv_V12_PG3 = findViewById(R.id.tv_V12)
        tv_W12_PG3 = findViewById(R.id.tv_W12); tv_X12_PG3 = findViewById(R.id.tv_X12); tv_Y12_PG3 = findViewById(R.id.tv_Y12)

        switch_row4 = findViewById(R.id.switch_row4); tv_G13_PG3 = findViewById(R.id.tv_G13)
        et_H13_PG3 = findViewById(R.id.et_H13); et_I13_PG3 = findViewById(R.id.et_I13); et_J13_PG3 = findViewById(R.id.et_J13)
        et_K13_PG3 = findViewById(R.id.et_K13); et_L13_PG3 = findViewById(R.id.et_L13); et_M13_PG3 = findViewById(R.id.et_M13)
        et_N13_PG3 = findViewById(R.id.et_N13); et_O13_PG3 = findViewById(R.id.et_O13); et_P13_PG3 = findViewById(R.id.et_P13)
        et_Q13_PG3 = findViewById(R.id.et_Q13); et_R13_PG3 = findViewById(R.id.et_R13); et_S13_PG3 = findViewById(R.id.et_S13)
        tv_T13_PG3 = findViewById(R.id.tv_T13); tv_U13_PG3 = findViewById(R.id.tv_U13); tv_V13_PG3 = findViewById(R.id.tv_V13)
        tv_W13_PG3 = findViewById(R.id.tv_W13); tv_X13_PG3 = findViewById(R.id.tv_X13); tv_Y13_PG3 = findViewById(R.id.tv_Y13)

        switch_row5 = findViewById(R.id.switch_row5); tv_G14_PG3 = findViewById(R.id.tv_G14)
        et_H14_PG3 = findViewById(R.id.et_H14); et_I14_PG3 = findViewById(R.id.et_I14); et_J14_PG3 = findViewById(R.id.et_J14)

        tv_H17_target_LSF_PG3 = findViewById(R.id.tv_H17); tv_H18_target_AM_PG3 = findViewById(R.id.tv_H18); et_H19_PG3 = findViewById(R.id.et_H19)

        et_K17_PG3 = findViewById(R.id.et_K17); et_L17_PG3 = findViewById(R.id.et_L17); et_M17_PG3 = findViewById(R.id.et_M17)
        et_N17_PG3 = findViewById(R.id.et_N17); et_O17_PG3 = findViewById(R.id.et_O17); et_P17_PG3 = findViewById(R.id.et_P17)
        et_Q17_PG3 = findViewById(R.id.et_Q17); et_R17_PG3 = findViewById(R.id.et_R17); et_S17_PG3 = findViewById(R.id.et_S17)
        et_T17_trc_LOI_PG3 = findViewById(R.id.et_T17); tv_U17_trc_TOTAL_PG3 = findViewById(R.id.tv_U17); tv_V17_trc_LSF_PG3 = findViewById(R.id.tv_V17)
        tv_W17_trc_SM_PG3 = findViewById(R.id.tv_W17); tv_X17_trc_SR_PG3 = findViewById(R.id.tv_X17); tv_Y17_trc_AM_PG3 = findViewById(R.id.tv_Y17)

        et_K19_PG3 = findViewById(R.id.et_K19); et_L19_PG3 = findViewById(R.id.et_L19); et_M19_PG3 = findViewById(R.id.et_M19)
        et_N19_PG3 = findViewById(R.id.et_N19); et_O19_PG3 = findViewById(R.id.et_O19); et_P19_PG3 = findViewById(R.id.et_P19)
        et_Q19_PG3 = findViewById(R.id.et_Q19); et_R19_PG3 = findViewById(R.id.et_R19); et_S19_PG3 = findViewById(R.id.et_S19)
        et_T19_PG3 = findViewById(R.id.et_T19)
        tv_U19_PG3 = findViewById(R.id.tv_U19); tv_V19_PG3 = findViewById(R.id.tv_V19); tv_W19_PG3 = findViewById(R.id.tv_W19)
        tv_X19_PG3 = findViewById(R.id.tv_X19); tv_Y19_PG3 = findViewById(R.id.tv_Y19)

        tv_K22_PG3 = findViewById(R.id.tv_K22); tv_L22_PG3 = findViewById(R.id.tv_L22); tv_M22_PG3 = findViewById(R.id.tv_M22)
        tv_N22_PG3 = findViewById(R.id.tv_N22); tv_O22_PG3 = findViewById(R.id.tv_O22); tv_P22_PG3 = findViewById(R.id.tv_P22)
        tv_Q22_PG3 = findViewById(R.id.tv_Q22); tv_R22_PG3 = findViewById(R.id.tv_R22); tv_S22_PG3 = findViewById(R.id.tv_S22)
        tv_T22_PG3 = findViewById(R.id.tv_T22); tv_V22_PG3 = findViewById(R.id.tv_V22); tv_W22_PG3 = findViewById(R.id.tv_W22)
        tv_X22_PG3 = findViewById(R.id.tv_X22); tv_Y22_PG3 = findViewById(R.id.tv_Y22)

        et_K25_PG3 = findViewById(R.id.et_K25); et_L25_PG3 = findViewById(R.id.et_L25); tv_M25_PG3 = findViewById(R.id.tv_M25)
        tv_N25_PG3 = findViewById(R.id.tv_N25); et_O25_PG3 = findViewById(R.id.et_O25); tv_P25_PG3 = findViewById(R.id.tv_P25)
        tv_Q25_PG3 = findViewById(R.id.tv_Q25); tv_R25_PG3 = findViewById(R.id.tv_R25); tv_S25_PG3 = findViewById(R.id.tv_S25)
        tv_T25_PG3 = findViewById(R.id.tv_T25); tv_U25_PG3 = findViewById(R.id.tv_U25); tv_V25_PG3 = findViewById(R.id.tv_V25)
        tv_W25_PG3 = findViewById(R.id.tv_W25); et_X25_PG3 = findViewById(R.id.et_X25); et_Y25_PG3 = findViewById(R.id.et_Y25)

        allInputEditTexts = listOf(
            et_H10_PG3, et_I10_PG3, et_J10_PG3, et_K10_PG3, et_L10_PG3, et_M10_PG3, et_N10_PG3, et_O10_PG3, et_P10_PG3, et_Q10_PG3, et_R10_PG3, et_S10_PG3,
            et_H11_PG3, et_I11_PG3, et_J11_PG3, et_K11_PG3, et_L11_PG3, et_M11_PG3, et_N11_PG3, et_O11_PG3, et_P11_PG3, et_Q11_PG3, et_R11_PG3, et_S11_PG3,
            et_H12_PG3, et_I12_PG3, et_J12_PG3, et_K12_PG3, et_L12_PG3, et_M12_PG3, et_N12_PG3, et_O12_PG3, et_P12_PG3, et_Q12_PG3, et_R12_PG3, et_S12_PG3,
            et_H13_PG3, et_I13_PG3, et_J13_PG3, et_K13_PG3, et_L13_PG3, et_M13_PG3, et_N13_PG3, et_O13_PG3, et_P13_PG3, et_Q13_PG3, et_R13_PG3, et_S13_PG3,
            et_H14_PG3, et_I14_PG3, et_J14_PG3,
            et_H19_PG3,
            et_K17_PG3, et_L17_PG3, et_M17_PG3, et_N17_PG3, et_O17_PG3, et_P17_PG3, et_Q17_PG3, et_R17_PG3, et_S17_PG3, et_T17_trc_LOI_PG3,
            et_K19_PG3, et_L19_PG3, et_M19_PG3, et_N19_PG3, et_O19_PG3, et_P19_PG3, et_Q19_PG3, et_R19_PG3, et_S19_PG3, et_T19_PG3,
            et_K25_PG3, et_L25_PG3, et_O25_PG3, et_X25_PG3, et_Y25_PG3
        )

        // Initialize allSwitches list
        allSwitches = listOf(switch_row2, switch_row3, switch_row4, switch_row5)

    }

    private fun setupListeners() {
        // Remove any existing listeners first
        allInputEditTexts.forEach { it.removeTextChangedListener(mainTextWatcher) }

        // Add text watcher to always editable fields
        val alwaysEditableFields = listOf(
            et_H10_PG3, et_I10_PG3, et_J10_PG3, et_K10_PG3, et_L10_PG3, et_M10_PG3, et_N10_PG3, et_O10_PG3, et_P10_PG3, et_Q10_PG3, et_R10_PG3, et_S10_PG3,
            et_H19_PG3,
            et_K17_PG3, et_L17_PG3, et_M17_PG3, et_N17_PG3, et_O17_PG3, et_P17_PG3, et_Q17_PG3, et_R17_PG3, et_S17_PG3, et_T17_trc_LOI_PG3,
            et_K19_PG3, et_L19_PG3, et_M19_PG3, et_N19_PG3, et_O19_PG3, et_P19_PG3, et_Q19_PG3, et_R19_PG3, et_S19_PG3, et_T19_PG3,
            et_K25_PG3, et_L25_PG3, et_O25_PG3, et_X25_PG3, et_Y25_PG3
        )
        alwaysEditableFields.forEach { editText ->
            editText.addTextChangedListener(mainTextWatcher)
        }

        // Setup switch listeners after text watchers
        setupSwitchListeners()
    }

    private fun setupSwitchListeners() {
        allSwitches.forEach { switch ->
            switch.setOnCheckedChangeListener { _, isChecked ->
                // Temporarily remove text watcher to prevent recursive updates
                val editTexts = when (switch) {
                    switch_row2 -> listOf(et_H11_PG3, et_I11_PG3, et_J11_PG3)
                    switch_row3 -> listOf(et_H12_PG3, et_I12_PG3, et_J12_PG3)
                    switch_row4 -> listOf(et_H13_PG3, et_I13_PG3, et_J13_PG3)
                    switch_row5 -> listOf(et_H14_PG3, et_I14_PG3, et_J14_PG3)
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

    private fun getDoubleInput(editText: EditText, originalKey: String? = null): Double {
        val idName = originalKey ?: "${resources.getResourceEntryName(editText.id)}_PG3"
        val textValue = editText.text.toString().trim()
        val value = textValue.toDoubleOrNull() ?: 0.0
        values[idName] = value


        return value
    }

    // This Function is Modified for G 10-14 row to specifically display 1 decimal point.
    // Currently disabled; all are using 2 decimal points.
    private fun setDouble(view: TextView, value: Double) {
        // val idName = resources.getResourceEntryName(view.id)
        // val useOneDecimal = idName.matches(Regex("tv_G1[0-4](_PG3)?"))
        // val formatted = if (useOneDecimal) df1.format(value) else df.format(value)

        val formatted = df.format(value)  // Always use 2 decimal places for now
        view.text = formatted
    }


    // This Function Is Modified For H, I, J 10-14 Row to specifically display 1 decimal point only,
    // Currently disabled; all EditTexts show 2 decimal points.
    private fun setDouble(view: EditText, value: Double) {
        // val idName = resources.getResourceEntryName(view.id)
        // val useOneDecimal = idName.matches(Regex("et_[HIJ]1[0-4](_PG3)?"))
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
            getDoubleInput(editText) // Let it auto-append _PG3
        }

        // Retrieve the Values from Page4DataCache
        val I13_PG3 = Page4DataCache.SiO2Rawmeal
        val I14_PG3 = Page4DataCache.Al2O3Rawmeal
        val I15_PG3 = Page4DataCache.Fe2O3Rawmeal
        val I16_PG3 = Page4DataCache.CaORawmeal
        val I17_PG3 = Page4DataCache.MgORawmeal
        val I18_PG3 = Page4DataCache.Na2ORawmeal
        val I19_PG3 = Page4DataCache.K2ORawmeal
        val I20_PG3 = Page4DataCache.SO3Rawmeal
        val I21_PG3 = Page4DataCache.ClRawmeal
        val I22_PG3 = Page4DataCache.LoiRawmeal


        // Validate if Page4DataCache has meaningful data
        val isPage4DataValid = listOf(
            I13_PG3, I14_PG3, I15_PG3, I16_PG3, I17_PG3,
            I18_PG3, I19_PG3, I20_PG3, I21_PG3, I22_PG3
        ).any { it != 0.0 }

        val allTrcFieldsEmptyOrZero = listOf(
            et_K17_PG3, et_L17_PG3, et_M17_PG3, et_N17_PG3, et_O17_PG3,
            et_P17_PG3, et_Q17_PG3, et_R17_PG3, et_S17_PG3, et_T17_trc_LOI_PG3
        ).all { it.text.isNullOrBlank() || it.text.toString().toDoubleOrNull() == 0.0 }

        if (isPage4DataValid && allTrcFieldsEmptyOrZero) {
            et_K17_PG3.setText(df.format(I13_PG3))
            et_L17_PG3.setText(df.format(I14_PG3))
            et_M17_PG3.setText(df.format(I15_PG3))
            et_N17_PG3.setText(df.format(I16_PG3))
            et_O17_PG3.setText(df.format(I17_PG3))
            et_P17_PG3.setText(df.format(I18_PG3))
            et_Q17_PG3.setText(df.format(I19_PG3))
            et_R17_PG3.setText(df.format(I20_PG3))
            et_S17_PG3.setText(df.format(I21_PG3))
            et_T17_trc_LOI_PG3.setText(df.format(I22_PG3))
        }

        // --- MATERIAL SETTING: LIMESTONE, SHALE, IRON ORE ---
        // Row 1: Always Manual
        // H10, I10, J10 are user inputs

        // Row 2-5: AUTO/MANUAL depending on switch
        // For manual mode (switch.isChecked = true), use user input values
        // For auto mode (switch.isChecked = false), calculate values

        //Material Setting
        // === ROW 2 ===
        //Column Green 1
        //Error Row
        val K29 = (values["et_K17_PG3"] ?: 0.0) - (values["et_K10_PG3"] ?: 0.0)
        val M29 = (values["et_M17_PG3"] ?: 0.0) - (values["et_M10_PG3"] ?: 0.0)
        val N29 = (values["et_N17_PG3"] ?: 0.0) - (values["et_N10_PG3"] ?: 0.0)
        // Est. Adj Oxide Row
        val K30 = if (G31 != 0.0) (K29 / G31) * 100 else 0.0
        val M30 = if (H33 != 0.0) (M29 / H33) * 100 else 0.0
        val N30 = if (F34 != 0.0) (N29 / F34) * 100 else 0.0
        //Unnormalized RoW
        val K31 = K30 + (values["et_I10_PG3"]?:0.0)
        val M31 = M30 + (values["et_J10_PG3"]?:0.0)
        val N31 = N30 + (values["et_H10_PG3"]?:0.0)
        //Condition if Row
        val K32 = if (K31 < 0) 0.0 else K31
        val M32 = if (M31 < 0) 0.0 else M31
        val N32 = if (N31 < 0) 0.0 else N31
        //Normalized Row
        val total = K32 + M32 + N32
        val I11 = if (total != 0.0) (K32 / total) * 100 else 0.0
        val J11 = if (total != 0.0) (M32 / total) * 100 else 0.0
        val H11 = 100 - I11 - J11
        values["I11"] = I11
        values["J11"] = J11
        values["H11"] = H11


        // === ROW 3 ===
        // Use actual source values from Row 2 depending on manual/auto
        val I11_actual = if (switch_row2.isChecked) values["et_I11_PG3"] ?: 0.0 else I11
        val J11_actual = if (switch_row2.isChecked) values["et_J11_PG3"] ?: 0.0 else J11
        val H11_actual = if (switch_row2.isChecked) values["et_H11_PG3"] ?: 0.0 else H11
        //Column Light Blue 2
        //Error Row
        val O29 = (values["et_K17_PG3"] ?: 0.0) - (values["et_K11_PG3"] ?: 0.0)
        val Q29 = (values["et_M17_PG3"] ?: 0.0) - (values["et_M11_PG3"] ?: 0.0)
        val R29 = (values["et_N17_PG3"] ?: 0.0) - (values["et_N11_PG3"] ?: 0.0)
        // Est. Adj Oxide Row
        val O30 = if (G31 != 0.0) (O29 / G31) * 100 else 0.0
        val Q30 = if (H33 != 0.0) (Q29 / H33) * 100 else 0.0
        val R30 = if (F34 != 0.0) (R29 / F34) * 100 else 0.0
        //Unnormalized RoW
        val O31 = O30 + I11_actual
        val Q31 = Q30 + J11_actual
        val R31 = R30 + H11_actual
        //Condition if Row
        val O32 = if (O31 < 0) 0.0 else O31
        val Q32 = if (Q31 < 0) 0.0 else Q31
        val R32 = if (R31 < 0) 0.0 else R31
        //Normalized Row
        val total2 = O32 + Q32 + R32
        val I12 = if (total2 != 0.0) (O32 / total2) * 100 else 0.0
        val J12 = if (total2 != 0.0) (Q32 / total2) * 100 else 0.0
        val H12 = 100 - I12 - J12
        values["I12"] = I12
        values["J12"] = J12
        values["H12"] = H12

        // === ROW 4 ===
        // Use actual source values from Row 3 depending on manual/auto
        val I12_actual = if (switch_row3.isChecked) values["et_I12_PG3"] ?: 0.0 else I12
        val J12_actual = if (switch_row3.isChecked) values["et_J12_PG3"] ?: 0.0 else J12
        val H12_actual = if (switch_row3.isChecked) values["et_H12_PG3"] ?: 0.0 else H12
        //Column Gray 3
        //Error Row
        val S29 = (values["et_K17_PG3"] ?: 0.0) - (values["et_K12_PG3"] ?: 0.0)
        val U29 = (values["et_M17_PG3"] ?: 0.0) - (values["et_M12_PG3"] ?: 0.0)
        val V29 = (values["et_N17_PG3"] ?: 0.0) - (values["et_N12_PG3"] ?: 0.0)
        // Est. Adj Oxide Row
        val S30 = if (G31 != 0.0) (S29 / G31) * 100 else 0.0
        val U30 = if (H33 != 0.0) (U29 / H33) * 100 else 0.0
        val V30 = if (F34 != 0.0) (V29 / F34) * 100 else 0.0
        //Unnormalized RoW
        val S31 = S30 + I12_actual
        val U31 = U30 + J12_actual
        val V31 = V30 + H12_actual
        //Condition if Row
        val S32 = if (S31 < 0) 0.0 else S31
        val U32 = if (U31 < 0) 0.0 else U31
        val V32 = if (V31 < 0) 0.0 else V31
        //Normalized Row
        val total3 = S32 + U32 + V32
        val I13 = if (total3 != 0.0) (S32 / total3) * 100 else 0.0
        val J13 = if (total3 != 0.0) (U32 / total3) * 100 else 0.0
        val H13 = 100 - I13 - J13
        values["I13"] = I13
        values["J13"] = J13
        values["H13"] = H13

        // === ROW 5 ===
        // Use actual source values from Row 4 depending on manual/auto
        val I13_actual = if (switch_row4.isChecked) values["et_I13_PG3"] ?: 0.0 else I13
        val J13_actual = if (switch_row4.isChecked) values["et_J13_PG3"] ?: 0.0 else J13
        val H13_actual = if (switch_row4.isChecked) values["et_H13_PG3"] ?: 0.0 else H13
        //Column Light Orange 4
        val W29 = (values["et_K17_PG3"] ?: 0.0) - (values["et_K13_PG3"] ?: 0.0)
        val Y29 = (values["et_M17_PG3"] ?: 0.0) - (values["et_M13_PG3"] ?: 0.0)
        val Z29 = (values["et_N17_PG3"] ?: 0.0) - (values["et_N13_PG3"] ?: 0.0)
        // Est. Adj Oxide Row
        val W30 = if (G31 != 0.0) (W29 / G31) * 100 else 0.0
        val Y30 = if (H33 != 0.0) (Y29 / H33) * 100 else 0.0
        val Z30 = if (F34 != 0.0) (Z29 / F34) * 100 else 0.0
        //Unnormalized RoW
        val W31 = W30 + I13_actual
        val Y31 = Y30 + J13_actual
        val Z31 = Z30 + H13_actual
        //Condition if Row
        val W32 = if (W31 < 0) 0.0 else W31
        val Y32 = if (Y31 < 0) 0.0 else Y31
        val Z32 = if (Z31 < 0) 0.0 else Z31
        //Normalized Row
        val total4 = W32 + Y32 + Z32
        val I14 = if (total4 != 0.0) (W32 / total4) * 100 else 0.0
        val J14 = if (total4 != 0.0) (Y32 / total4) * 100 else 0.0
        val H14 = 100 - I14 - J14
        values["I14"] = I14
        values["J14"] = J14
        values["H14"] = H14



        if (!switch_row2.isChecked) {
            // Auto mode calculations for Row 2 (Row 11)
            values["et_H11_PG3"] = values["H11"]?:0.0
            values["et_I11_PG3"] = values["I11"]?:0.0
            values["et_J11_PG3"] = values["J11"]?:0.0
        }

        if (!switch_row3.isChecked) {
            // Auto mode calculations for Row 3 (Row 12)
            values["et_H12_PG3"] = values["H12"]?:0.0
            values["et_J12_PG3"] = values["J12"]?:0.0
            values["et_I12_PG3"] = values["I12"]?:0.0
        }

        if (!switch_row4.isChecked) {
            // Auto mode calculations for Row 4 (Row 13)
            values["et_H13_PG3"] = values["H13"]?:0.0
            values["et_J13_PG3"] = values["J13"]?:0.0
            values["et_I13_PG3"] = values["I13"]?:0.0
        }

        if (!switch_row5.isChecked) {
            // Auto mode calculations for Row 5 (Row 14)
            values["et_H14_PG3"] = values["H14"]?:0.0
            values["et_J14_PG3"] = values["J14"]?:0.0
            values["et_I14_PG3"] = values["I14"]?:0.0
        }

    // --- TOTAL1 (G10-G14) ---
        for (i in 10..14) {
            val h = values["et_H${i}_PG3"] ?: 0.0
            val ii = values["et_I${i}_PG3"] ?: 0.0
            val j = values["et_J${i}_PG3"] ?: 0.0
            values["G$i"] = h + ii + j
        }


    // --- LOI (T10-T13) ---
        for (i in 10..13) {
            val n = values["et_N${i}_PG3"] ?: 0.0
            val o = values["et_O${i}_PG3"] ?: 0.0
            values["T$i"] = if (n == 0.0 && o == 0.0) 0.0 else 0.786 * n + 1.1 * o + 0.2
        }


    // --- TOTAL2 (U10-U13) ---
        for (i in 10..13) {
            val keys = listOf(
                "et_K${i}_PG3", "et_L${i}_PG3", "et_M${i}_PG3", "et_N${i}_PG3",
                "et_O${i}_PG3", "et_P${i}_PG3", "et_Q${i}_PG3", "et_R${i}_PG3", "et_S${i}_PG3",
                "T$i"
            )
            values["U$i"] = keys.sumOf { values[it] ?: 0.0 }
        }


        // --- RATIOS (V10-Y13) ---
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

        values["V10"] = lsf(values["et_N10_PG3"] ?: 0.0, values["et_K10_PG3"] ?: 0.0, values["et_L10_PG3"] ?: 0.0, values["et_M10_PG3"] ?: 0.0)
        values["V11"] = lsf(values["et_N11_PG3"] ?: 0.0, values["et_K11_PG3"] ?: 0.0, values["et_L11_PG3"] ?: 0.0, values["et_M11_PG3"] ?: 0.0)
        values["V12"] = lsf(values["et_N12_PG3"] ?: 0.0, values["et_K12_PG3"] ?: 0.0, values["et_L12_PG3"] ?: 0.0, values["et_M12_PG3"] ?: 0.0)
        values["V13"] = lsf(values["et_N13_PG3"] ?: 0.0, values["et_K13_PG3"] ?: 0.0, values["et_L13_PG3"] ?: 0.0, values["et_M13_PG3"] ?: 0.0)

        values["W10"] = hm(values["et_N10_PG3"] ?: 0.0, values["et_K10_PG3"] ?: 0.0, values["et_L10_PG3"] ?: 0.0, values["et_M10_PG3"] ?: 0.0)
        values["W11"] = hm(values["et_N11_PG3"] ?: 0.0, values["et_K11_PG3"] ?: 0.0, values["et_L11_PG3"] ?: 0.0, values["et_M11_PG3"] ?: 0.0)
        values["W12"] = hm(values["et_N12_PG3"] ?: 0.0, values["et_K12_PG3"] ?: 0.0, values["et_L12_PG3"] ?: 0.0, values["et_M12_PG3"] ?: 0.0)
        values["W13"] = hm(values["et_N13_PG3"] ?: 0.0, values["et_K13_PG3"] ?: 0.0, values["et_L13_PG3"] ?: 0.0, values["et_M13_PG3"] ?: 0.0)

        values["X10"] = sm(values["et_K10_PG3"] ?: 0.0, values["et_L10_PG3"] ?: 0.0, values["et_M10_PG3"] ?: 0.0)
        values["X11"] = sm(values["et_K11_PG3"] ?: 0.0, values["et_L11_PG3"] ?: 0.0, values["et_M11_PG3"] ?: 0.0)
        values["X12"] = sm(values["et_K12_PG3"] ?: 0.0, values["et_L12_PG3"] ?: 0.0, values["et_M12_PG3"] ?: 0.0)
        values["X13"] = sm(values["et_K13_PG3"] ?: 0.0, values["et_L13_PG3"] ?: 0.0, values["et_M13_PG3"] ?: 0.0)

        values["Y10"] = am(values["et_L10_PG3"] ?: 0.0, values["et_M10_PG3"] ?: 0.0)
        values["Y11"] = am(values["et_L11_PG3"] ?: 0.0, values["et_M11_PG3"] ?: 0.0)
        values["Y12"] = am(values["et_L12_PG3"] ?: 0.0, values["et_M12_PG3"] ?: 0.0)
        values["Y13"] = am(values["et_L13_PG3"] ?: 0.0, values["et_M13_PG3"] ?: 0.0)

        // --- TARGET TABLE ---
        values["H17"] = values["V17"] ?: 0.0
        values["H18"] = values["X17"] ?: 0.0
        // H19 is user input


        // --- TARGET RAWMEAL COMPOSITION ---
        values["T17"] = (values["et_T17_PG3"]?:0.0)
        values["U17"] = listOf("et_K17_PG3","et_L17_PG3","et_M17_PG3","et_N17_PG3","et_O17_PG3","et_P17_PG3","et_Q17_PG3","et_R17_PG3","et_S17_PG3","T17").sumOf { values[it] ?: 0.0 }
        values["V17"] = lsf(values["et_N17_PG3"] ?: 0.0, values["et_K17_PG3"] ?: 0.0, values["et_L17_PG3"] ?: 0.0, values["et_M17_PG3"] ?: 0.0)
        values["W17"] = hm(values["et_N17_PG3"] ?: 0.0, values["et_K17_PG3"] ?: 0.0, values["et_L17_PG3"] ?: 0.0, values["et_M17_PG3"] ?: 0.0)
        values["X17"] = sm(values["et_K17_PG3"] ?: 0.0, values["et_L17_PG3"] ?: 0.0, values["et_M17_PG3"] ?: 0.0)
        values["Y17"] = am(values["et_L17_PG3"] ?: 0.0, values["et_M17_PG3"] ?: 0.0)

        // --- COAL ASH COMPOSITION ---
        values["U19"] = listOf("et_K19_PG3","et_L19_PG3","et_M19_PG3","et_N19_PG3","et_O19_PG3","et_P19_PG3","et_Q19_PG3","et_R19_PG3","et_S19_PG3","et_T19_PG3").sumOf { values[it] ?: 0.0 }
        values["V19"] = lsf(values["et_N19_PG3"] ?: 0.0, values["et_K19_PG3"] ?: 0.0, values["et_L19_PG3"] ?: 0.0, values["et_M19_PG3"] ?: 0.0)
        values["W19"] = hm(values["et_N19_PG3"] ?: 0.0, values["et_K19_PG3"] ?: 0.0, values["et_L19_PG3"] ?: 0.0, values["et_M19_PG3"] ?: 0.0)
        values["X19"] = sm(values["et_K19_PG3"] ?: 0.0, values["et_L19_PG3"] ?: 0.0, values["et_M19_PG3"] ?: 0.0)
        values["Y19"] = am(values["et_L19_PG3"] ?: 0.0, values["et_M19_PG3"] ?: 0.0)


        // --- POTENTIAL CLINKER COMPOSITION ---
        val t17 = values["T17"] ?: 0.0
        val h19 = (values["et_H19_PG3"] ?: 0.0) / 100.0
        val factor1 = if (1.0 - t17 / 100.0 == 0.0) 0.0 else 1.0 / (1.0 - t17 / 100.0)
        val factor_1_minus_h19 = 1.0 - h19
        values["K22"] = factor1 * (values["et_K17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_K19_PG3"] ?: 0.0) * h19
        values["L22"] = factor1 * (values["et_L17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_L19_PG3"] ?: 0.0) * h19
        values["M22"] = factor1 * (values["et_M17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_M19_PG3"] ?: 0.0) * h19
        values["N22"] = factor1 * (values["et_N17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_N19_PG3"] ?: 0.0) * h19
        values["O22"] = factor1 * (values["et_O17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_O19_PG3"] ?: 0.0) * h19
        values["P22"] = factor1 * (values["et_P17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_P19_PG3"] ?: 0.0) * h19

        // Q57 special formula - using Z52 (which equals T52) for the calculation
        val z17 = t17 // Z17 = T17
        val q17 = values["et_Q17_PG3"] ?: 0.0
        val n25 = (values["N25"] ?: 0.0) / 100.0
        val q19 = values["et_Q19_PG3"] ?: 0.0
        val factorZ = if (1.0 - z17 / 100.0 == 0.0) 0.0 else 1.0 / (1.0 - z17 / 100.0)
        values["Q22"] = factor1 * (values["et_Q17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_Q19_PG3"] ?: 0.0) * h19
        values["R22"] = factor1 * (values["et_R17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_R19_PG3"] ?: 0.0) * h19
        values["S22"] = factor1 * (values["et_S17_PG3"] ?: 0.0) * factor_1_minus_h19 + (values["et_S19_PG3"] ?: 0.0) * h19

        // T22 is the sum of K22 through S22
        values["T22"] = listOf("K22","L22","M22","N22","O22","P22","Q22","R22","S22").sumOf { values[it] ?: 0.0 }
        values["V22"] = lsf(values["N22"] ?: 0.0, values["K22"] ?: 0.0, values["L22"] ?: 0.0, values["M22"] ?: 0.0)
        values["W22"] = hm(values["N22"] ?: 0.0, values["K22"] ?: 0.0, values["L22"] ?: 0.0, values["M22"] ?: 0.0)
        values["X22"] = sm(values["K22"] ?: 0.0, values["L22"] ?: 0.0, values["M22"] ?: 0.0)
        values["Y22"] = am(values["L22"] ?: 0.0, values["M22"] ?: 0.0)

        // --- MINERALS & HOTMEAL ---
        // K25, L25, O25, X25, Y25 are user inputs
        // M25 is always 'reducing'
        // N25 = ((O25/100)-(Y25/100))/((O25/100)-(O25/100)*(Y25/100))*100
        val o25 = (values["et_O25_PG3"] ?: 0.0) / 100.0
        val y25 = (values["et_Y25_PG3"] ?: 0.0) / 100.0
        val doc_num = o25 - y25
        val doc_den = o25 - (o25 * y25)
        values["N25"] = if (doc_den == 0.0) 0.0 else (doc_num / doc_den) * 100.0
        // P25 = 4.071*(N22-L25)-7.6024*K22-6.718*L22-1.4297*M22
        val n22 = values["N22"] ?: 0.0
        val l25 = values["et_L25_PG3"] ?: 0.0
        val k22 = values["K22"] ?: 0.0
        val l22 = values["L22"] ?: 0.0
        val m22 = values["M22"] ?: 0.0
        values["P25"] = 4.071 * (n22 - l25) - 7.6024 * k22 - 6.718 * l22 - 1.4297 * m22
        // Q25 = 8.6024*K22+5.0683*L22+1.0785*M22-3.071*(N22-L25)
        values["Q25"] = 8.6024 * k22 + 5.0683 * l22 + 1.0785 * m22 - 3.071 * (n22 - l25)
        // R25 = 2.65*L57-1.692*M57
        values["R25"] = 2.65 * l22 - 1.692 * m22
        // S25 = 3.0432*M57
        values["S25"] = 3.0432 * m22
        // T25 = R22/(Q22+0.5*P22) - Fixed calculation
        val r22 = values["R22"] ?: 0.0
        val q22 = values["Q22"] ?: 0.0
        val p22 = values["P22"] ?: 0.0
        val t25_den = q22 + 0.5 * p22
        values["T25"] = if (t25_den == 0.0) 0.0 else r22 / t25_den
        // U60 = P57+(0.658*Q57) - Fixed calculation
        values["U25"] = p22 + (0.658 * q22)
        // V60 = 3*L57+2.25*M57+O57+P57+Q57+R57 - Fixed calculation
        val o57 = values["O22"] ?: 0.0
        values["V25"] = 3 * l22 + 2.25 * m22 + o57 + p22 + q22 + r22
        // W60 = R60+S60+(Q60*0.2)+(2*M57)
        val r25 = values["R25"] ?: 0.0
        val s25 = values["S25"] ?: 0.0
        val q25 = values["Q25"] ?: 0.0
        values["W25"] = r25 + s25 + (q25 * 0.2) + (2 * m22)

        // --- UI UPDATE ---
        setDouble(tv_G10_PG3, values["G10"] ?: 0.0)
        setDouble(tv_T10_PG3, values["T10"] ?: 0.0)
        setDouble(tv_U10_PG3, values["U10"] ?: 0.0)
        setDouble(tv_V10_PG3, values["V10"] ?: 0.0)
        setDouble(tv_W10_PG3, values["W10"] ?: 0.0)
        setDouble(tv_X10_PG3, values["X10"] ?: 0.0)
        setDouble(tv_Y10_PG3, values["Y10"] ?: 0.0)

        setDouble(tv_G11_PG3, values["G11"] ?: 0.0)
        if (!switch_row2.isChecked) {
            setDouble(et_H11_PG3, values["et_H11_PG3"] ?: 0.0)
            setDouble(et_I11_PG3, values["et_I11_PG3"] ?: 0.0)
            setDouble(et_J11_PG3, values["et_J11_PG3"] ?: 0.0)
            /* Also update XRF row 2
            xrfRow2.forEachIndexed { index, et ->
                val key = when(index) {
                    0 -> "et_K11_PG3"
                    1 -> "et_L11_PG3"
                    2 -> "et_M11_PG3"
                    3 -> "et_N11_PG3"
                    4 -> "et_O11_PG3"
                    5 -> "et_P11_PG3"
                    6 -> "et_Q11_PG3"
                    7 -> "et_R11_PG3"
                    8 -> "et_S11_PG3"
                    else -> return@forEachIndexed
                }
                setDouble(et, values[key] ?: 0.0)
            }
             */
        }
        setDouble(tv_T11_PG3, values["T11"] ?: 0.0); setDouble(tv_U11_PG3, values["U11"] ?: 0.0); setDouble(tv_V11_PG3, values["V11"] ?: 0.0)
        setDouble(tv_W11_PG3, values["W11"] ?: 0.0); setDouble(tv_X11_PG3, values["X11"] ?: 0.0); setDouble(tv_Y11_PG3, values["Y11"] ?: 0.0)

        setDouble(tv_G12_PG3, values["G12"] ?: 0.0)
        if (!switch_row3.isChecked) {
            setDouble(et_H12_PG3, values["et_H12_PG3"] ?: 0.0)
            setDouble(et_I12_PG3, values["et_I12_PG3"] ?: 0.0)
            setDouble(et_J12_PG3, values["et_J12_PG3"] ?: 0.0)
            /* Also update XRF row 3
            xrfRow3.forEachIndexed { index, et ->
                val key = when(index) {
                    0 -> "et_K12_PG3"
                    1 -> "et_L12_PG3"
                    2 -> "et_M12_PG3"
                    3 -> "et_N12_PG3"
                    4 -> "et_O12_PG3"
                    5 -> "et_P12_PG3"
                    6 -> "et_Q12_PG3"
                    7 -> "et_R12_PG3"
                    8 -> "et_S12_PG3"
                    else -> return@forEachIndexed
                }
                setDouble(et, values[key] ?: 0.0)
            }
             */
        }
        setDouble(tv_T12_PG3, values["T12"] ?: 0.0); setDouble(tv_U12_PG3, values["U12"] ?: 0.0); setDouble(tv_V12_PG3, values["V12"] ?: 0.0)
        setDouble(tv_W12_PG3, values["W12"] ?: 0.0); setDouble(tv_X12_PG3, values["X12"] ?: 0.0); setDouble(tv_Y12_PG3, values["Y12"] ?: 0.0)

        setDouble(tv_G13_PG3, values["G13"] ?: 0.0)
        if (!switch_row4.isChecked) {
            setDouble(et_H13_PG3, values["et_H13_PG3"] ?: 0.0)
            setDouble(et_I13_PG3, values["et_I13_PG3"] ?: 0.0)
            setDouble(et_J13_PG3, values["et_J13_PG3"] ?: 0.0)
            /* Also update XRF row 4
            xrfRow4.forEachIndexed { index, et ->
                val key = when(index) {
                    0 -> "et_K13_PG3"
                    1 -> "et_L13_PG3"
                    2 -> "et_M13_PG3"
                    3 -> "et_N13_PG3"
                    4 -> "et_O13_PG3"
                    5 -> "et_P13_PG3"
                    6 -> "et_Q13_PG3"
                    7 -> "et_R13_PG3"
                    8 -> "et_S13_PG3"
                    else -> return@forEachIndexed
                }
                setDouble(et, values[key] ?: 0.0)
            }
             */
        }
        setDouble(tv_T13_PG3, values["T13"] ?: 0.0); setDouble(tv_U13_PG3, values["U13"] ?: 0.0); setDouble(tv_V13_PG3, values["V13"] ?: 0.0)
        setDouble(tv_W13_PG3, values["W13"] ?: 0.0); setDouble(tv_X13_PG3, values["X13"] ?: 0.0); setDouble(tv_Y13_PG3, values["Y13"] ?: 0.0)

        setDouble(tv_G14_PG3, values["G14"] ?: 0.0)
        if (!switch_row5.isChecked) {
            setDouble(et_H14_PG3, values["et_H14_PG3"] ?: 0.0)
            setDouble(et_I14_PG3, values["et_I14_PG3"] ?: 0.0)
            setDouble(et_J14_PG3, values["et_J14_PG3"] ?: 0.0)
        }

        setDouble(tv_H17_target_LSF_PG3, values["H17"] ?: 0.0)
        setDouble(tv_H18_target_AM_PG3, values["H18"] ?: 0.0)

        //setDouble(tv_T17_trc_LOI_PG3, values["T52"] ?: 0.0)
        setDouble(tv_U17_trc_TOTAL_PG3, values["U17"] ?: 0.0)
        setDouble(tv_V17_trc_LSF_PG3, values["V17"] ?: 0.0)
        setDouble(tv_W17_trc_SM_PG3, values["W17"] ?: 0.0)
        setDouble(tv_X17_trc_SR_PG3, values["X17"] ?: 0.0)
        setDouble(tv_Y17_trc_AM_PG3, values["Y17"] ?: 0.0)

        setDouble(tv_U19_PG3, values["U19"] ?: 0.0); setDouble(tv_V19_PG3, values["V19"] ?: 0.0); setDouble(tv_W19_PG3, values["W19"] ?: 0.0)
        setDouble(tv_X19_PG3, values["X19"] ?: 0.0); setDouble(tv_Y19_PG3, values["Y19"] ?: 0.0)

        setDouble(tv_K22_PG3, values["K22"] ?: 0.0); setDouble(tv_L22_PG3, values["L22"] ?: 0.0); setDouble(tv_M22_PG3, values["M22"] ?: 0.0)
        setDouble(tv_N22_PG3, values["N22"] ?: 0.0); setDouble(tv_O22_PG3, values["O22"] ?: 0.0); setDouble(tv_P22_PG3, values["P22"] ?: 0.0)
        setDouble(tv_Q22_PG3, values["Q22"] ?: 0.0); setDouble(tv_R22_PG3, values["R22"] ?: 0.0); setDouble(tv_S22_PG3, values["S22"] ?: 0.0)
        setDouble(tv_T22_PG3, values["T22"] ?: 0.0); setDouble(tv_V22_PG3, values["V22"] ?: 0.0); setDouble(tv_W22_PG3, values["W22"] ?: 0.0)
        setDouble(tv_X22_PG3, values["X22"] ?: 0.0); setDouble(tv_Y22_PG3, values["Y22"] ?: 0.0)

        setDouble(tv_N25_PG3, values["N25"] ?: 0.0); setDouble(tv_P25_PG3, values["P25"] ?: 0.0); setDouble(tv_Q25_PG3, values["Q25"] ?: 0.0)
        setDouble(tv_R25_PG3, values["R25"] ?: 0.0); setDouble(tv_S25_PG3, values["S25"] ?: 0.0); setDouble(tv_T25_PG3, values["T25"] ?: 0.0)
        setDouble(tv_U25_PG3, values["U25"] ?: 0.0); setDouble(tv_V25_PG3, values["V25"] ?: 0.0); setDouble(tv_W25_PG3, values["W25"] ?: 0.0)

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
            val xrfRow2 = listOf(et_K11_PG3, et_L11_PG3, et_M11_PG3, et_N11_PG3, et_O11_PG3, et_P11_PG3, et_Q11_PG3, et_R11_PG3, et_S11_PG3)
            val xrfRow3 = listOf(et_K12_PG3, et_L12_PG3, et_M12_PG3, et_N12_PG3, et_O12_PG3, et_P12_PG3, et_Q12_PG3, et_R12_PG3, et_S12_PG3)
            val xrfRow4 = listOf(et_K13_PG3, et_L13_PG3, et_M13_PG3, et_N13_PG3, et_O13_PG3, et_P13_PG3, et_Q13_PG3, et_R13_PG3, et_S13_PG3)

            toggleEditTextsManual(listOf(et_H11_PG3, et_I11_PG3, et_J11_PG3) + xrfRow2, switch_row2.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H12_PG3, et_I12_PG3, et_J12_PG3) + xrfRow3, switch_row3.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H13_PG3, et_I13_PG3, et_J13_PG3) + xrfRow4, switch_row4.isChecked, mainTextWatcher)
            toggleEditTextsManual(listOf(et_H14_PG3, et_I14_PG3, et_J14_PG3), switch_row5.isChecked, mainTextWatcher)

            val alwaysEditableFields = listOf(
                et_H10_PG3, et_I10_PG3, et_J10_PG3, et_K10_PG3, et_L10_PG3, et_M10_PG3, et_N10_PG3, et_O10_PG3, et_P10_PG3, et_Q10_PG3, et_R10_PG3, et_S10_PG3,
                et_H19_PG3,
                et_K17_PG3, et_L17_PG3, et_M17_PG3, et_N17_PG3, et_O17_PG3, et_P17_PG3, et_Q17_PG3, et_R17_PG3, et_S17_PG3, et_T17_trc_LOI_PG3,
                et_K19_PG3, et_L19_PG3, et_M19_PG3, et_N19_PG3, et_O19_PG3, et_P19_PG3, et_Q19_PG3, et_R19_PG3, et_S19_PG3, et_T19_PG3,
                et_K25_PG3, et_L25_PG3, et_O25_PG3, et_X25_PG3, et_Y25_PG3
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
                    dbHelper.saveData(3, data.toString(), if (saveName.isEmpty()) null else saveName)
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

    private fun cachePage3Fields() {
        val fields = listOf(

            // --- Materials Setting (H10–J14) ---
            Triple(et_H10_PG3, { Page3DataCache.H10 }, { v: Double -> Page3DataCache.H10 = v }),
            Triple(et_I10_PG3, { Page3DataCache.I10 }, { v: Double -> Page3DataCache.I10 = v }),
            Triple(et_J10_PG3, { Page3DataCache.J10 }, { v: Double -> Page3DataCache.J10 = v }),
            Triple(et_H11_PG3, { Page3DataCache.H11 }, { v: Double -> Page3DataCache.H11 = v }),
            Triple(et_I11_PG3, { Page3DataCache.I11 }, { v: Double -> Page3DataCache.I11 = v }),
            Triple(et_J11_PG3, { Page3DataCache.J11 }, { v: Double -> Page3DataCache.J11 = v }),
            Triple(et_H12_PG3, { Page3DataCache.H12 }, { v: Double -> Page3DataCache.H12 = v }),
            Triple(et_I12_PG3, { Page3DataCache.I12 }, { v: Double -> Page3DataCache.I12 = v }),
            Triple(et_J12_PG3, { Page3DataCache.J12 }, { v: Double -> Page3DataCache.J12 = v }),
            Triple(et_H13_PG3, { Page3DataCache.H13 }, { v: Double -> Page3DataCache.H13 = v }),
            Triple(et_I13_PG3, { Page3DataCache.I13 }, { v: Double -> Page3DataCache.I13 = v }),
            Triple(et_J13_PG3, { Page3DataCache.J13 }, { v: Double -> Page3DataCache.J13 = v }),
            Triple(et_H14_PG3, { Page3DataCache.H14 }, { v: Double -> Page3DataCache.H14 = v }),
            Triple(et_I14_PG3, { Page3DataCache.I14 }, { v: Double -> Page3DataCache.I14 = v }),
            Triple(et_J14_PG3, { Page3DataCache.J14 }, { v: Double -> Page3DataCache.J14 = v }),

            // --- Additional Field ---
            Triple(et_H19_PG3, { Page3DataCache.H19 }, { v: Double -> Page3DataCache.H19 = v }),

            // --- XRF Row 1 (K10–S10) ---
            Triple(et_K10_PG3, { Page3DataCache.K10 }, { v: Double -> Page3DataCache.K10 = v }),
            Triple(et_L10_PG3, { Page3DataCache.L10 }, { v: Double -> Page3DataCache.L10 = v }),
            Triple(et_M10_PG3, { Page3DataCache.M10 }, { v: Double -> Page3DataCache.M10 = v }),
            Triple(et_N10_PG3, { Page3DataCache.N10 }, { v: Double -> Page3DataCache.N10 = v }),
            Triple(et_O10_PG3, { Page3DataCache.O10 }, { v: Double -> Page3DataCache.O10 = v }),
            Triple(et_P10_PG3, { Page3DataCache.P10 }, { v: Double -> Page3DataCache.P10 = v }),
            Triple(et_Q10_PG3, { Page3DataCache.Q10 }, { v: Double -> Page3DataCache.Q10 = v }),
            Triple(et_R10_PG3, { Page3DataCache.R10 }, { v: Double -> Page3DataCache.R10 = v }),
            Triple(et_S10_PG3, { Page3DataCache.S10 }, { v: Double -> Page3DataCache.S10 = v }),

            // --- XRF Row 2 (K11–S11) ---
            Triple(et_K11_PG3, { Page3DataCache.K11 }, { v: Double -> Page3DataCache.K11 = v }),
            Triple(et_L11_PG3, { Page3DataCache.L11 }, { v: Double -> Page3DataCache.L11 = v }),
            Triple(et_M11_PG3, { Page3DataCache.M11 }, { v: Double -> Page3DataCache.M11 = v }),
            Triple(et_N11_PG3, { Page3DataCache.N11 }, { v: Double -> Page3DataCache.N11 = v }),
            Triple(et_O11_PG3, { Page3DataCache.O11 }, { v: Double -> Page3DataCache.O11 = v }),
            Triple(et_P11_PG3, { Page3DataCache.P11 }, { v: Double -> Page3DataCache.P11 = v }),
            Triple(et_Q11_PG3, { Page3DataCache.Q11 }, { v: Double -> Page3DataCache.Q11 = v }),
            Triple(et_R11_PG3, { Page3DataCache.R11 }, { v: Double -> Page3DataCache.R11 = v }),
            Triple(et_S11_PG3, { Page3DataCache.S11 }, { v: Double -> Page3DataCache.S11 = v }),

            // --- XRF Row 3 (K12–S12) ---
            Triple(et_K12_PG3, { Page3DataCache.K12 }, { v: Double -> Page3DataCache.K12 = v }),
            Triple(et_L12_PG3, { Page3DataCache.L12 }, { v: Double -> Page3DataCache.L12 = v }),
            Triple(et_M12_PG3, { Page3DataCache.M12 }, { v: Double -> Page3DataCache.M12 = v }),
            Triple(et_N12_PG3, { Page3DataCache.N12 }, { v: Double -> Page3DataCache.N12 = v }),
            Triple(et_O12_PG3, { Page3DataCache.O12 }, { v: Double -> Page3DataCache.O12 = v }),
            Triple(et_P12_PG3, { Page3DataCache.P12 }, { v: Double -> Page3DataCache.P12 = v }),
            Triple(et_Q12_PG3, { Page3DataCache.Q12 }, { v: Double -> Page3DataCache.Q12 = v }),
            Triple(et_R12_PG3, { Page3DataCache.R12 }, { v: Double -> Page3DataCache.R12 = v }),
            Triple(et_S12_PG3, { Page3DataCache.S12 }, { v: Double -> Page3DataCache.S12 = v }),

            // --- XRF Row 4 (K13–S13) ---
            Triple(et_K13_PG3, { Page3DataCache.K13 }, { v: Double -> Page3DataCache.K13 = v }),
            Triple(et_L13_PG3, { Page3DataCache.L13 }, { v: Double -> Page3DataCache.L13 = v }),
            Triple(et_M13_PG3, { Page3DataCache.M13 }, { v: Double -> Page3DataCache.M13 = v }),
            Triple(et_N13_PG3, { Page3DataCache.N13 }, { v: Double -> Page3DataCache.N13 = v }),
            Triple(et_O13_PG3, { Page3DataCache.O13 }, { v: Double -> Page3DataCache.O13 = v }),
            Triple(et_P13_PG3, { Page3DataCache.P13 }, { v: Double -> Page3DataCache.P13 = v }),
            Triple(et_Q13_PG3, { Page3DataCache.Q13 }, { v: Double -> Page3DataCache.Q13 = v }),
            Triple(et_R13_PG3, { Page3DataCache.R13 }, { v: Double -> Page3DataCache.R13 = v }),
            Triple(et_S13_PG3, { Page3DataCache.S13 }, { v: Double -> Page3DataCache.S13 = v }),

            // --- Coal Ash Composition (K19–T19) ---
            Triple(et_K19_PG3, { Page3DataCache.K19 }, { v: Double -> Page3DataCache.K19 = v }),
            Triple(et_L19_PG3, { Page3DataCache.L19 }, { v: Double -> Page3DataCache.L19 = v }),
            Triple(et_M19_PG3, { Page3DataCache.M19 }, { v: Double -> Page3DataCache.M19 = v }),
            Triple(et_N19_PG3, { Page3DataCache.N19 }, { v: Double -> Page3DataCache.N19 = v }),
            Triple(et_O19_PG3, { Page3DataCache.O19 }, { v: Double -> Page3DataCache.O19 = v }),
            Triple(et_P19_PG3, { Page3DataCache.P19 }, { v: Double -> Page3DataCache.P19 = v }),
            Triple(et_Q19_PG3, { Page3DataCache.Q19 }, { v: Double -> Page3DataCache.Q19 = v }),
            Triple(et_R19_PG3, { Page3DataCache.R19 }, { v: Double -> Page3DataCache.R19 = v }),
            Triple(et_S19_PG3, { Page3DataCache.S19 }, { v: Double -> Page3DataCache.S19 = v }),
            Triple(et_T19_PG3, { Page3DataCache.T19 }, { v: Double -> Page3DataCache.T19 = v }),


            // --- Fuel Section (K25, L25, O25, X25, Y25) ---
            Triple(et_K25_PG3, { Page3DataCache.K25 }, { v: Double -> Page3DataCache.K25 = v }),
            Triple(et_L25_PG3, { Page3DataCache.L25 }, { v: Double -> Page3DataCache.L25 = v }),
            Triple(et_O25_PG3, { Page3DataCache.O25 }, { v: Double -> Page3DataCache.O25 = v }),
            Triple(et_X25_PG3, { Page3DataCache.X25 }, { v: Double -> Page3DataCache.X25 = v }),
            Triple(et_Y25_PG3, { Page3DataCache.Y25 }, { v: Double -> Page3DataCache.Y25 = v })
        )

        fields.forEach { (editText, getter, setter) ->
            if (editText.text.isNullOrBlank()) {
                val cachedValue = getter()
                if (cachedValue != 0.0) editText.setText(cachedValue.toString())
            }

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
