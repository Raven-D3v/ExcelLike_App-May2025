package com.example.rawmixapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.rawmixapp.db.SavedDataDbHelper
import org.json.JSONObject
import java.util.*

class Page2Activity : BaseActivity() {

    // Target Inputs
    private lateinit var etLsfTarget: EditText
    private lateinit var etAmTarget: EditText

    // Mix % Table - Inputs (EditText)
    private lateinit var etMixLimestone: EditText // U12
    private lateinit var etMixShale: EditText     // V12
    private lateinit var etMixIronOre: EditText   // W12

    private lateinit var etSio2Limestone: EditText // U13
    private lateinit var etSio2Shale: EditText     // V13
    private lateinit var etSio2IronOre: EditText   // W13

    private lateinit var etAl2o3Limestone: EditText // U14
    private lateinit var etAl2o3Shale: EditText     // V14
    private lateinit var etAl2o3IronOre: EditText   // W14

    private lateinit var etFe2o3Limestone: EditText // U15
    private lateinit var etFe2o3Shale: EditText     // V15
    private lateinit var etFe2o3IronOre: EditText   // W15

    private lateinit var etCaoLimestone: EditText // U16
    private lateinit var etCaoShale: EditText     // V16
    private lateinit var etCaoIronOre: EditText   // W16

    private lateinit var etMgoLimestone: EditText // U17
    private lateinit var etMgoShale: EditText     // V17
    private lateinit var etMgoIronOre: EditText   // W17

    private lateinit var etNa2oLimestone: EditText // U18
    private lateinit var etNa2oShale: EditText     // V18
    private lateinit var etNa2oIronOre: EditText   // W18

    private lateinit var etK2oLimestone: EditText // U19
    private lateinit var etK2oShale: EditText     // V19
    private lateinit var etK2oIronOre: EditText   // W19

    private lateinit var etSo3Limestone: EditText // U20
    private lateinit var etSo3Shale: EditText     // V20
    private lateinit var etSo3IronOre: EditText   // W20

    private lateinit var etClLimestone: EditText // U21
    private lateinit var etClShale: EditText     // V21
    private lateinit var etClIronOre: EditText   // W21

    private lateinit var etLoiLimestone: EditText // U22
    private lateinit var etLoiShale: EditText     // V22
    private lateinit var etLoiIronOre: EditText   // W22

    // Mix % Table - Outputs (TextView)
    private lateinit var tvMixRawmeal: TextView // X12
    private lateinit var tvSio2Rawmeal: TextView // X13
    private lateinit var tvAl2o3Rawmeal: TextView // X14
    private lateinit var tvFe2o3Rawmeal: TextView // X15
    private lateinit var tvCaoRawmeal: TextView // X16
    private lateinit var tvMgoRawmeal: TextView // X17
    private lateinit var tvNa2oRawmeal: TextView // X18
    private lateinit var tvK2oRawmeal: TextView // X19
    private lateinit var tvSo3Rawmeal: TextView // X20
    private lateinit var tvClRawmeal: TextView // X21
    private lateinit var tvLoiRawmeal: TextView // X22

    private lateinit var tvTotalLimestone: TextView // U23
    private lateinit var tvTotalShale: TextView     // V23
    private lateinit var tvTotalIronOre: TextView   // W23
    private lateinit var tvTotalRawmeal: TextView   // X23

    private lateinit var tvLsfLimestone: TextView // U24
    private lateinit var tvLsfShale: TextView     // V24
    private lateinit var tvLsfIronOre: TextView   // W24
    private lateinit var tvLsfRawmeal: TextView   // X24

    private lateinit var tvSmLimestone: TextView // U25
    private lateinit var tvSmShale: TextView     // V25
    private lateinit var tvSmIronOre: TextView   // W25
    private lateinit var tvSmRawmeal: TextView   // X25

    private lateinit var tvAmLimestone: TextView // U26
    private lateinit var tvAmShale: TextView     // V26
    private lateinit var tvAmIronOre: TextView   // W26
    private lateinit var tvAmRawmeal: TextView   // X26

    // Raw Material Percentage (Dry Basis) - Outputs (TextView)
    private lateinit var tvDryLimestone: TextView // W28
    private lateinit var tvDryShale: TextView     // W29
    private lateinit var tvDryIronOre: TextView   // W30
    private lateinit var tvDryTotal: TextView     // W31

    // Material Percentage (Weigh Feeder) - Inputs (EditText)
    private lateinit var etWfDryLimestone: EditText // W34
    private lateinit var etWfDryShale: EditText     // W35
    private lateinit var etWfDryIronOre: EditText   // W36

    private lateinit var etWfH2oLimestone: EditText // Y34
    private lateinit var etWfH2oShale: EditText     // Y35
    private lateinit var etWfH2oIronOre: EditText   // Y36

    // Material Percentage (Weigh Feeder) - Outputs (TextView)
    private lateinit var tvWfWetLimestone: TextView // U34
    private lateinit var tvWfWetShale: TextView     // U35
    private lateinit var tvWfWetIronOre: TextView   // U36
    private lateinit var tvWfWetTotal: TextView     // U37

    private lateinit var tvWfDryTotal: TextView // W37
    private lateinit var tvWfH2oTotal: TextView // Y37

    // Coefficients for Mix Calculation Table - Outputs (TextView)
    private lateinit var tvCoeffA: TextView // AB12
    private lateinit var tvCoeffB: TextView // AB13
    private lateinit var tvCoeffC: TextView // AB14
    private lateinit var tvCoeffD: TextView // AB15
    private lateinit var tvCoeffE: TextView // AB16
    private lateinit var tvCoeffF: TextView // AB17
    private lateinit var tvCoeffG: TextView // AB18
    private lateinit var tvCoeffH: TextView // AB19
    private lateinit var tvCoeffI: TextView // AB20
    private lateinit var tvCoeffJ: TextView // AB21
    private lateinit var tvCoeffK: TextView // AB22
    private lateinit var tvCoeffL: TextView // AB23
    private lateinit var tvCoeffDelta: TextView // AB24

    // Wet Basis Column - Outputs (TextView)
    private lateinit var tvDelta1: TextView // AA26
    private lateinit var tvDelta2: TextView // AA27
    private lateinit var tvDelta3: TextView // AA28
    private lateinit var tvDelta4: TextView // AA29
    private lateinit var tvDelta5: TextView // AA30

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            calculateAll()
        }
    }

    private lateinit var dbHelper: SavedDataDbHelper
    private lateinit var btnSave: Button
    private lateinit var btnClear: Button
    private lateinit var allInputEditTexts: List<EditText>

    // Add tracking variables
    private var isDataModified = false
    private var currentSavedDataId: Long = -1
    private var originalDataJson: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Recipe LSF & AM"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page2) // Use BaseActivity's content frame

        dbHelper = SavedDataDbHelper(this)
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        initializeViews()
        Page2Cache()
        setupTextWatchers()
        setupButtons()
        calculateAll() // Initial calculation

        // Collapsible section logic for coefficients table
        // val btnToggleCoefficients = findViewById<Button>(R.id.btn_toggle_coefficients)
        // val layoutCoefficientsTable = findViewById<LinearLayout>(R.id.layout_coefficients_table)
        // btnToggleCoefficients.setOnClickListener {
        // if (layoutCoefficientsTable.visibility == LinearLayout.VISIBLE) {
        // layoutCoefficientsTable.visibility = LinearLayout.GONE
        // btnToggleCoefficients.text = "Show Coefficients Table"
        // } else {
        //    layoutCoefficientsTable.visibility = LinearLayout.VISIBLE
        //   btnToggleCoefficients.text = "Hide Coefficients Table"
        // }
        // }

        // Check if we're loading saved data
        val savedDataId = intent.getLongExtra("saved_data_id", -1)
        if (savedDataId != -1L) {
            loadSavedData(savedDataId)
        }
    }

    private fun initializeViews() {
        // Target Inputs
        etLsfTarget = findViewById(R.id.et_lsf_target)
        etAmTarget = findViewById(R.id.et_am_target)

        // Mix % Table - Inputs
        etMixLimestone = findViewById(R.id.et_mix_limestone)
        etMixShale = findViewById(R.id.et_mix_shale)
        etMixIronOre = findViewById(R.id.et_mix_ironore)

        etSio2Limestone = findViewById(R.id.et_sio2_limestone)
        etSio2Shale = findViewById(R.id.et_sio2_shale)
        etSio2IronOre = findViewById(R.id.et_sio2_ironore)

        etAl2o3Limestone = findViewById(R.id.et_al2o3_limestone)
        etAl2o3Shale = findViewById(R.id.et_al2o3_shale)
        etAl2o3IronOre = findViewById(R.id.et_al2o3_ironore)

        etFe2o3Limestone = findViewById(R.id.et_fe2o3_limestone)
        etFe2o3Shale = findViewById(R.id.et_fe2o3_shale)
        etFe2o3IronOre = findViewById(R.id.et_fe2o3_ironore)

        etCaoLimestone = findViewById(R.id.et_cao_limestone)
        etCaoShale = findViewById(R.id.et_cao_shale)
        etCaoIronOre = findViewById(R.id.et_cao_ironore)

        etMgoLimestone = findViewById(R.id.et_mgo_limestone)
        etMgoShale = findViewById(R.id.et_mgo_shale)
        etMgoIronOre = findViewById(R.id.et_mgo_ironore)

        etNa2oLimestone = findViewById(R.id.et_na2o_limestone)
        etNa2oShale = findViewById(R.id.et_na2o_shale)
        etNa2oIronOre = findViewById(R.id.et_na2o_ironore)

        etK2oLimestone = findViewById(R.id.et_k2o_limestone)
        etK2oShale = findViewById(R.id.et_k2o_shale)
        etK2oIronOre = findViewById(R.id.et_k2o_ironore)

        etSo3Limestone = findViewById(R.id.et_so3_limestone)
        etSo3Shale = findViewById(R.id.et_so3_shale)
        etSo3IronOre = findViewById(R.id.et_so3_ironore)

        etClLimestone = findViewById(R.id.et_cl_limestone)
        etClShale = findViewById(R.id.et_cl_shale)
        etClIronOre = findViewById(R.id.et_cl_ironore)

        etLoiLimestone = findViewById(R.id.et_loi_limestone)
        etLoiShale = findViewById(R.id.et_loi_shale)
        etLoiIronOre = findViewById(R.id.et_loi_ironore)

        // Mix % Table - Outputs
        tvMixRawmeal = findViewById(R.id.tv_mix_rawmeal)
        tvSio2Rawmeal = findViewById(R.id.tv_sio2_rawmeal)
        tvAl2o3Rawmeal = findViewById(R.id.tv_al2o3_rawmeal)
        tvFe2o3Rawmeal = findViewById(R.id.tv_fe2o3_rawmeal)
        tvCaoRawmeal = findViewById(R.id.tv_cao_rawmeal)
        tvMgoRawmeal = findViewById(R.id.tv_mgo_rawmeal)
        tvNa2oRawmeal = findViewById(R.id.tv_na2o_rawmeal)
        tvK2oRawmeal = findViewById(R.id.tv_k2o_rawmeal)
        tvSo3Rawmeal = findViewById(R.id.tv_so3_rawmeal)
        tvClRawmeal = findViewById(R.id.tv_cl_rawmeal)
        tvLoiRawmeal = findViewById(R.id.tv_loi_rawmeal)

        tvTotalLimestone = findViewById(R.id.tv_total_limestone)
        tvTotalShale = findViewById(R.id.tv_total_shale)
        tvTotalIronOre = findViewById(R.id.tv_total_ironore)
        tvTotalRawmeal = findViewById(R.id.tv_total_rawmeal)

        tvLsfLimestone = findViewById(R.id.tv_lsf_limestone)
        tvLsfShale = findViewById(R.id.tv_lsf_shale)
        tvLsfIronOre = findViewById(R.id.tv_lsf_ironore)
        tvLsfRawmeal = findViewById(R.id.tv_lsf_rawmeal)

        tvSmLimestone = findViewById(R.id.tv_sm_limestone)
        tvSmShale = findViewById(R.id.tv_sm_shale)
        tvSmIronOre = findViewById(R.id.tv_sm_ironore)
        tvSmRawmeal = findViewById(R.id.tv_sm_rawmeal)

        tvAmLimestone = findViewById(R.id.tv_am_limestone)
        tvAmShale = findViewById(R.id.tv_am_shale)
        tvAmIronOre = findViewById(R.id.tv_am_ironore)
        tvAmRawmeal = findViewById(R.id.tv_am_rawmeal)

        // Raw Material Percentage (Dry Basis) - Outputs
        tvDryLimestone = findViewById(R.id.tv_dry_limestone)
        tvDryShale = findViewById(R.id.tv_dry_shale)
        tvDryIronOre = findViewById(R.id.tv_dry_ironore)
        tvDryTotal = findViewById(R.id.tv_dry_total)

        // Material Percentage (Weigh Feeder) - Inputs
        etWfDryLimestone = findViewById(R.id.et_wf_dry_limestone)
        etWfDryShale = findViewById(R.id.et_wf_dry_shale)
        etWfDryIronOre = findViewById(R.id.et_wf_dry_ironore)

        etWfH2oLimestone = findViewById(R.id.et_wf_h2o_limestone)
        etWfH2oShale = findViewById(R.id.et_wf_h2o_shale)
        etWfH2oIronOre = findViewById(R.id.et_wf_h2o_ironore)

        // Material Percentage (Weigh Feeder) - Outputs
        tvWfWetLimestone = findViewById(R.id.tv_wf_wet_limestone)
        tvWfWetShale = findViewById(R.id.tv_wf_wet_shale)
        tvWfWetIronOre = findViewById(R.id.tv_wf_wet_ironore)
        tvWfWetTotal = findViewById(R.id.tv_wf_wet_total)
        tvWfDryTotal = findViewById(R.id.tv_wf_dry_total)
        tvWfH2oTotal = findViewById(R.id.tv_wf_h2o_total)

        // Coefficients for Mix Calculation Table - Outputs
        tvCoeffA = findViewById(R.id.tv_coeff_a)
        tvCoeffB = findViewById(R.id.tv_coeff_b)
        tvCoeffC = findViewById(R.id.tv_coeff_c)
        tvCoeffD = findViewById(R.id.tv_coeff_d)
        tvCoeffE = findViewById(R.id.tv_coeff_e)
        tvCoeffF = findViewById(R.id.tv_coeff_f)
        tvCoeffG = findViewById(R.id.tv_coeff_g)
        tvCoeffH = findViewById(R.id.tv_coeff_h)
        tvCoeffI = findViewById(R.id.tv_coeff_i)
        tvCoeffJ = findViewById(R.id.tv_coeff_j)
        tvCoeffK = findViewById(R.id.tv_coeff_k)
        tvCoeffL = findViewById(R.id.tv_coeff_l)
        tvCoeffDelta = findViewById(R.id.tv_coeff_delta)

        // Wet Basis Column - Outputs
        tvDelta1 = findViewById(R.id.et_delta_1)
        tvDelta2 = findViewById(R.id.et_delta_2)
        tvDelta3 = findViewById(R.id.et_delta_3)
        tvDelta4 = findViewById(R.id.et_delta_4)
        tvDelta5 = findViewById(R.id.et_delta_5)

        // Create list of all input EditTexts
        allInputEditTexts = listOf(
            etLsfTarget, etAmTarget,
            etMixLimestone, etMixShale, etMixIronOre,
            etSio2Limestone, etSio2Shale, etSio2IronOre,
            etAl2o3Limestone, etAl2o3Shale, etAl2o3IronOre,
            etFe2o3Limestone, etFe2o3Shale, etFe2o3IronOre,
            etCaoLimestone, etCaoShale, etCaoIronOre,
            etMgoLimestone, etMgoShale, etMgoIronOre,
            etNa2oLimestone, etNa2oShale, etNa2oIronOre,
            etK2oLimestone, etK2oShale, etK2oIronOre,
            etSo3Limestone, etSo3Shale, etSo3IronOre,
            etClLimestone, etClShale, etClIronOre,
            etLoiLimestone, etLoiShale, etLoiIronOre,
            etWfDryLimestone, etWfDryShale, etWfDryIronOre,
            etWfH2oLimestone, etWfH2oShale, etWfH2oIronOre
        )
    }

    private fun setupTextWatchers() {
        val allEditTexts = listOf(
            etLsfTarget, etAmTarget,
            etMixLimestone, etMixShale, etMixIronOre,
            etSio2Limestone, etSio2Shale, etSio2IronOre,
            etAl2o3Limestone, etAl2o3Shale, etAl2o3IronOre,
            etFe2o3Limestone, etFe2o3Shale, etFe2o3IronOre,
            etCaoLimestone, etCaoShale, etCaoIronOre,
            etMgoLimestone, etMgoShale, etMgoIronOre,
            etNa2oLimestone, etNa2oShale, etNa2oIronOre,
            etK2oLimestone, etK2oShale, etK2oIronOre,
            etSo3Limestone, etSo3Shale, etSo3IronOre,
            etClLimestone, etClShale, etClIronOre,
            etLoiLimestone, etLoiShale, etLoiIronOre,
            etWfDryLimestone, etWfDryShale, etWfDryIronOre,
            etWfH2oLimestone, etWfH2oShale, etWfH2oIronOre
        )
        allEditTexts.forEach {
            it.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (currentSavedDataId != -1L) {
                        isDataModified = true
                    }
                    calculateAll()
                }
            })
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

                    // Save to database with title
                    dbHelper.saveData(2, data.toString(), if (saveName.isEmpty()) null else saveName)
                    Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel", null)
                .show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error saving data: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
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

        // Recalculate and update UI
        calculateAll()
        Toast.makeText(this, "All data cleared", Toast.LENGTH_SHORT).show()

    }

    private fun loadSavedData(savedDataId: Long) {
        try {
            val entry = dbHelper.getSavedData(savedDataId)
            if (entry != null) {
                currentSavedDataId = savedDataId
                originalDataJson = entry.data // Store original data for comparison
                val data = JSONObject(entry.data)

                // Temporarily remove listeners
                allInputEditTexts.forEach { it.removeTextChangedListener(textWatcher) }

                // Load all EditText values
                allInputEditTexts.forEach { editText ->
                    val idName = resources.getResourceEntryName(editText.id)
                    if (data.has(idName)) {
                        editText.setText(data.optString(idName, ""))
                    } else {
                        editText.setText("")
                    }
                }

                // Reattach listeners
                allInputEditTexts.forEach { it.addTextChangedListener(textWatcher) }

                // Recalculate
                calculateAll()
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

    private fun getDoubleValue(editText: EditText): Double {
        return editText.text.toString().toDoubleOrNull() ?: 0.0
    }

    private fun setTextViewValue(
        textView: TextView,
        value: Double,
        defaultOnError: String = "0.00",
        decimalPlaces: Int = 2
    ) {
        if (value.isInfinite() || value.isNaN()) {
            textView.text = defaultOnError
        } else {
            val format = "%.${decimalPlaces}f"
            textView.text = String.format(Locale.US, format, value)
        }
    }


    private fun calculateAll() {
        // --- Read Inputs ---
        val targetLsf = getDoubleValue(etLsfTarget) // X9 or AB15
        val targetAm = getDoubleValue(etAmTarget)   // X10

        // Limestone Column Inputs
        val u12 = getDoubleValue(etMixLimestone)
        val u13 = getDoubleValue(etSio2Limestone)
        val u14 = getDoubleValue(etAl2o3Limestone)
        val u15 = getDoubleValue(etFe2o3Limestone)
        val u16 = getDoubleValue(etCaoLimestone)
        val u17 = getDoubleValue(etMgoLimestone)
        val u18 = getDoubleValue(etNa2oLimestone)
        val u19 = getDoubleValue(etK2oLimestone)
        val u20 = getDoubleValue(etSo3Limestone)
        val u21 = getDoubleValue(etClLimestone)
        val u22 = getDoubleValue(etLoiLimestone)

        // Shale Column Inputs
        val v12 = getDoubleValue(etMixShale)
        val v13 = getDoubleValue(etSio2Shale)
        val v14 = getDoubleValue(etAl2o3Shale)
        val v15 = getDoubleValue(etFe2o3Shale)
        val v16 = getDoubleValue(etCaoShale)
        val v17 = getDoubleValue(etMgoShale)
        val v18 = getDoubleValue(etNa2oShale)
        val v19 = getDoubleValue(etK2oShale)
        val v20 = getDoubleValue(etSo3Shale)
        val v21 = getDoubleValue(etClShale)
        val v22 = getDoubleValue(etLoiShale)

        // Iron Ore Column Inputs
        val w12_io = getDoubleValue(etMixIronOre) // Renamed to avoid conflict with W28 etc.
        val w13 = getDoubleValue(etSio2IronOre)
        val w14 = getDoubleValue(etAl2o3IronOre)
        val w15 = getDoubleValue(etFe2o3IronOre)
        val w16 = getDoubleValue(etCaoIronOre)
        val w17 = getDoubleValue(etMgoIronOre)
        val w18 = getDoubleValue(etNa2oIronOre)
        val w19 = getDoubleValue(etK2oIronOre)
        val w20 = getDoubleValue(etSo3IronOre)
        val w21 = getDoubleValue(etClIronOre)
        val w22 = getDoubleValue(etLoiIronOre)

        // Weigh Feeder Inputs
        val w34_dry_ls = getDoubleValue(etWfDryLimestone)
        val w35_dry_sh = getDoubleValue(etWfDryShale)
        val w36_dry_io = getDoubleValue(etWfDryIronOre)

        val y34_h2o_ls = getDoubleValue(etWfH2oLimestone)
        val y35_h2o_sh = getDoubleValue(etWfH2oShale)
        val y36_h2o_io = getDoubleValue(etWfH2oIronOre)

        // --- Calculations ---

        // LIMESTONE COLUMN
        val u23 = u13 + u14 + u15 + u16 + u17 + u18 + u19 + u20 + u21 + u22 // SUM(U13:U22)
        val u24_denominator = 2.8 * u13 + 1.18 * u14 + 0.65 * u15
        val u24 = if (u24_denominator == 0.0) 0.0 else 100 * u16 / u24_denominator
        val u25_denominator = u14 + u15
        val u25 = if (u25_denominator == 0.0) 0.0 else u13 / u25_denominator
        val u26 = if (u15 == 0.0) 0.0 else u14 / u15

        // SHALE COLUMN
        val v23 = v13 + v14 + v15 + v16 + v17 + v18 + v19 + v20 + v21 + v22 // SUM(V13:V22)
        val v24_denominator = 2.8 * v13 + 1.18 * v14 + 0.65 * v15
        val v24 = if (v24_denominator == 0.0) 0.0 else 100 * v16 / v24_denominator
        val v25_denominator = v14 + v15
        val v25 = if (v25_denominator == 0.0) 0.0 else v13 / v25_denominator
        val v26 = if (v15 == 0.0) 0.0 else v14 / v15

        // IRON ORE COLUMN
        val w23 = w13 + w14 + w15 + w16 + w17 + w18 + w19 + w20 + w21 + w22 // SUM(W13:W22)
        val w24_denominator = 2.8 * w13 + 1.18 * w14 + 0.65 * w15
        val w24 = if (w24_denominator == 0.0) 0.0 else 100 * w16 / w24_denominator
        val w25_denominator = w14 + w15
        val w25 = if (w25_denominator == 0.0) 0.0 else w13 / w25_denominator
        val w26 = if (w15 == 0.0) 0.0 else w14 / w15

        // RAWMEAL COLUMN
        val x12 = u12 + v12 + w12_io // SUM(U12:W12)
        val x13 = if (x12 == 0.0) 0.0 else (u12 * u13 + v12 * v13 + w12_io * w13) / x12
        val x14 = if (x12 == 0.0) 0.0 else (u12 * u14 + v12 * v14 + w12_io * w14) / x12
        val x15 = if (x12 == 0.0) 0.0 else (u12 * u15 + v12 * v15 + w12_io * w15) / x12
        val x16 = if (x12 == 0.0) 0.0 else (u12 * u16 + v12 * v16 + w12_io * w16) / x12
        val x17 = if (x12 == 0.0) 0.0 else (u12 * u17 + v12 * v17 + w12_io * w17) / x12
        val x18 = if (x12 == 0.0) 0.0 else (u12 * u18 + v12 * v18 + w12_io * w18) / x12
        val x19 = if (x12 == 0.0) 0.0 else (u12 * u19 + v12 * v19 + w12_io * w19) / x12
        val x20 = if (x12 == 0.0) 0.0 else (u12 * u20 + v12 * v20 + w12_io * w20) / x12
        val x21 = if (x12 == 0.0) 0.0 else (u12 * u21 + v12 * v21 + w12_io * w21) / x12
        val x22 = if (x12 == 0.0) 0.0 else (u12 * u22 + v12 * v22 + w12_io * w22) / x12
        val x23 = x13 + x14 + x15 + x16 + x17 + x18 + x19 + x20 + x21 + x22 // SUM(X13:X22)
        val x24_denominator = 2.8 * x13 + 1.18 * x14 + 0.65 * x15
        val x24 = if (x24_denominator == 0.0) 0.0 else 100 * x16 / x24_denominator
        val x25_denominator = x14 + x15
        val x25 = if (x25_denominator == 0.0) 0.0 else x13 / x25_denominator
        val x26 = if (x15 == 0.0) 0.0 else x14 / x15

        // COEFFICIENTS FOR MIX CALCULATION TABLE (Invisible, used for W28, W29)
        // AB12, AB13, AB14 are assumed 1.0 as they are not page inputs. User should verify.
        val ab12_cfm_a = 1.0
        val ab13_cfm_b = 1.0
        val ab14_cfm_c = 1.0
        // val ab15_cfm_d = targetLsf // This is X9 (targetLsf input from page)
        // For W28, W29 calculations, AB15 refers to coefficient D, which is 100 from Excel's "COEFFICIENTS" table (cell AB15 in that table).
        val cfm_d_coeff_for_rmp = 100.0 // This is the 'D' coefficient (value 100) for RMP formulas.

        val ab16_cfm_e = (targetAm * u15) - u14 // E = (X10*U15)-U14
        val ab17_cfm_f = (targetAm * v15) - v14 // F = (X10*V15)-V14
        val ab18_cfm_g = (targetAm * w15) - w14 // G = (X10*W15)-W14
        // AB19_cfm_h not used in visible calculations
        // Coefficients I, J, K (AB20, AB21, AB22) use targetLsf (X9 from page input)
        val ab20_cfm_i = targetLsf * (2.8 * u13 + 1.18 * u14 + 0.65 * u15) - 100 * u16
        val ab21_cfm_j = targetLsf * (2.8 * v13 + 1.18 * v14 + 0.65 * v15) - 100 * v16
        val ab22_cfm_k = targetLsf * (2.8 * w13 + 1.18 * w14 + 0.65 * w15) - 100 * w16
        // AB23_cfm_l not used in visible calculations
        val ab24_cfm_delta = (ab12_cfm_a * ab17_cfm_f * ab22_cfm_k) +
                (ab13_cfm_b * ab18_cfm_g * ab20_cfm_i) +
                (ab14_cfm_c * ab16_cfm_e * ab21_cfm_j) -
                (ab14_cfm_c * ab17_cfm_f * ab20_cfm_i) -
                (ab12_cfm_a * ab18_cfm_g * ab21_cfm_j) -
                (ab13_cfm_b * ab16_cfm_e * ab22_cfm_k)

        // RAW MATERIAL PERCENTAGE TABLE
        // Use cfm_d_coeff_for_rmp (100.0) for AB15 in these formulas, not targetLsf.
        val w28_rmp_limestone = if (ab24_cfm_delta == 0.0) 0.0 else (cfm_d_coeff_for_rmp * ab17_cfm_f * ab22_cfm_k - cfm_d_coeff_for_rmp * ab18_cfm_g * ab21_cfm_j) / ab24_cfm_delta
        val w29_rmp_shale = if (ab24_cfm_delta == 0.0) 0.0 else (cfm_d_coeff_for_rmp * ab18_cfm_g * ab20_cfm_i - cfm_d_coeff_for_rmp * ab16_cfm_e * ab22_cfm_k) / ab24_cfm_delta
        val w30_rmp_iron_ore = 100.0 - w29_rmp_shale - w28_rmp_limestone
        val w31_rmp_total = w28_rmp_limestone + w29_rmp_shale + w30_rmp_iron_ore // Should be 100 or close due to W30 formula

        // H2O COLUMN (Totals)
        val y37_h2o_total = y34_h2o_ls + y35_h2o_sh + y36_h2o_io

        // CFM-WET-BASIS-COLUMN (Invisible, used for U34, U35, U36)
        val aa26_denominator = 1 - (y34_h2o_ls / 100.0)
        val aa26 = if (aa26_denominator == 0.0) 0.0 else w28_rmp_limestone / aa26_denominator

        val aa27_denominator = 1 - (y35_h2o_sh / 100.0)
        val aa27 = if (aa27_denominator == 0.0) 0.0 else w29_rmp_shale / aa27_denominator

        val aa28_denominator = 1 - (y36_h2o_io / 100.0)
        val aa28 = if (aa28_denominator == 0.0) 0.0 else w30_rmp_iron_ore / aa28_denominator

        val aa29 = aa26 + aa27 + aa28
        val aa30 = if (aa29 == 0.0) 0.0 else w31_rmp_total / aa29


        // WET BASIS COLUMN
        val u34_wet_ls = aa26 * aa30
        val u35_wet_sh = aa27 * aa30
        val u36_wet_io = aa28 * aa30
        val u37_wet_total = u34_wet_ls + u35_wet_sh + u36_wet_io

        // DRY BASIS COLUMN (Totals)
        val w37_dry_total = w34_dry_ls + w35_dry_sh + w36_dry_io


        // Cache Rawmeal Oxide Values for Page1 or later use
        Page2DataCache.sio2Rawmeal = x13
        Page2DataCache.al2o3Rawmeal = x14
        Page2DataCache.fe2o3Rawmeal = x15
        Page2DataCache.caoRawmeal = x16
        Page2DataCache.mgoRawmeal = x17
        Page2DataCache.na2oRawmeal = x18
        Page2DataCache.k2oRawmeal = x19
        Page2DataCache.so3Rawmeal = x20
        Page2DataCache.clRawmeal = x21
        Page2DataCache.loiRawmeal = x22

        // --- Update UI ---
        // Limestone Column
        setTextViewValue(tvTotalLimestone, u23)
        setTextViewValue(tvLsfLimestone, u24)
        setTextViewValue(tvSmLimestone, u25)
        setTextViewValue(tvAmLimestone, u26)

        // Shale Column
        setTextViewValue(tvTotalShale, v23)
        setTextViewValue(tvLsfShale, v24)
        setTextViewValue(tvSmShale, v25)
        setTextViewValue(tvAmShale, v26)

        // Iron Ore Column
        setTextViewValue(tvTotalIronOre, w23)
        setTextViewValue(tvLsfIronOre, w24)
        setTextViewValue(tvSmIronOre, w25)
        setTextViewValue(tvAmIronOre, w26)

        // Rawmeal Column
        setTextViewValue(tvMixRawmeal, x12)
        setTextViewValue(tvSio2Rawmeal, x13)
        setTextViewValue(tvAl2o3Rawmeal, x14)
        setTextViewValue(tvFe2o3Rawmeal, x15)
        setTextViewValue(tvCaoRawmeal, x16)
        setTextViewValue(tvMgoRawmeal, x17)
        setTextViewValue(tvNa2oRawmeal, x18)
        setTextViewValue(tvK2oRawmeal, x19)
        setTextViewValue(tvSo3Rawmeal, x20)
        setTextViewValue(tvClRawmeal, x21)
        setTextViewValue(tvLoiRawmeal, x22)
        setTextViewValue(tvTotalRawmeal, x23)
        setTextViewValue(tvLsfRawmeal, x24)
        setTextViewValue(tvSmRawmeal, x25)
        setTextViewValue(tvAmRawmeal, x26)

        // Raw Material Percentage Table
        setTextViewValue(tvDryLimestone, w28_rmp_limestone)
        setTextViewValue(tvDryShale, w29_rmp_shale)
        setTextViewValue(tvDryIronOre, w30_rmp_iron_ore)
        setTextViewValue(tvDryTotal, w31_rmp_total)

        // Wet Basis Column
        setTextViewValue(tvWfWetLimestone, u34_wet_ls)
        setTextViewValue(tvWfWetShale, u35_wet_sh)
        setTextViewValue(tvWfWetIronOre, u36_wet_io)
        setTextViewValue(tvWfWetTotal, u37_wet_total)

        // Dry Basis Column (Totals)
        setTextViewValue(tvWfDryTotal, w37_dry_total)

        // H2O Column (Totals)
        setTextViewValue(tvWfH2oTotal, y37_h2o_total)

        // Coefficients for Mix Calculation Table
        setTextViewValue(tvCoeffA, ab12_cfm_a)
        setTextViewValue(tvCoeffB, ab13_cfm_b)
        setTextViewValue(tvCoeffC, ab14_cfm_c)
        setTextViewValue(tvCoeffD, cfm_d_coeff_for_rmp)
        setTextViewValue(tvCoeffE, ab16_cfm_e)
        setTextViewValue(tvCoeffF, ab17_cfm_f)
        setTextViewValue(tvCoeffG, ab18_cfm_g)
        setTextViewValue(tvCoeffH, 0.0) // Not used in calculations
        setTextViewValue(tvCoeffI, ab20_cfm_i)
        setTextViewValue(tvCoeffJ, ab21_cfm_j)
        setTextViewValue(tvCoeffK, ab22_cfm_k)
        setTextViewValue(tvCoeffL, 0.0) // Not used in calculations
        setTextViewValue(tvCoeffDelta, ab24_cfm_delta)

        // Wet Basis Column
        setTextViewValue(tvDelta1, aa26)
        setTextViewValue(tvDelta2, aa27)
        setTextViewValue(tvDelta3, aa28)
        setTextViewValue(tvDelta4, aa29)
        setTextViewValue(tvDelta5, aa30)
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

            // Update the existing saved data
            dbHelper.updateSavedData(currentSavedDataId, data.toString())
            Toast.makeText(this, "Data updated successfully!", Toast.LENGTH_SHORT).show()
            finish()
        } catch (e: Exception) {
            Toast.makeText(this, "Error updating data: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun Page2Cache() {
        val fields = listOf(
            // Target Inputs
            Triple(etLsfTarget, { Page2DataCache.lsfTarget }, { v: Double -> Page2DataCache.lsfTarget = v }),
            Triple(etAmTarget, { Page2DataCache.amTarget }, { v: Double -> Page2DataCache.amTarget = v }),

            // Mix Inputs
            Triple(etMixLimestone, { Page2DataCache.mixLimestone }, { v: Double -> Page2DataCache.mixLimestone = v }),
            Triple(etMixShale, { Page2DataCache.mixShale }, { v: Double -> Page2DataCache.mixShale = v }),
            Triple(etMixIronOre, { Page2DataCache.mixIronOre }, { v: Double -> Page2DataCache.mixIronOre = v }),

            // Oxide Inputs (Limestone, Shale, Iron Ore)
            Triple(etSio2Limestone, { Page2DataCache.sio2Limestone }, { v: Double -> Page2DataCache.sio2Limestone = v }),
            Triple(etSio2Shale, { Page2DataCache.sio2Shale }, { v: Double -> Page2DataCache.sio2Shale = v }),
            Triple(etSio2IronOre, { Page2DataCache.sio2IronOre }, { v: Double -> Page2DataCache.sio2IronOre = v }),

            Triple(etAl2o3Limestone, { Page2DataCache.al2o3Limestone }, { v: Double -> Page2DataCache.al2o3Limestone = v }),
            Triple(etAl2o3Shale, { Page2DataCache.al2o3Shale }, { v: Double -> Page2DataCache.al2o3Shale = v }),
            Triple(etAl2o3IronOre, { Page2DataCache.al2o3IronOre }, { v: Double -> Page2DataCache.al2o3IronOre = v }),

            Triple(etFe2o3Limestone, { Page2DataCache.fe2o3Limestone }, { v: Double -> Page2DataCache.fe2o3Limestone = v }),
            Triple(etFe2o3Shale, { Page2DataCache.fe2o3Shale }, { v: Double -> Page2DataCache.fe2o3Shale = v }),
            Triple(etFe2o3IronOre, { Page2DataCache.fe2o3IronOre }, { v: Double -> Page2DataCache.fe2o3IronOre = v }),

            Triple(etCaoLimestone, { Page2DataCache.caoLimestone }, { v: Double -> Page2DataCache.caoLimestone = v }),
            Triple(etCaoShale, { Page2DataCache.caoShale }, { v: Double -> Page2DataCache.caoShale = v }),
            Triple(etCaoIronOre, { Page2DataCache.caoIronOre }, { v: Double -> Page2DataCache.caoIronOre = v }),

            Triple(etMgoLimestone, { Page2DataCache.mgoLimestone }, { v: Double -> Page2DataCache.mgoLimestone = v }),
            Triple(etMgoShale, { Page2DataCache.mgoShale }, { v: Double -> Page2DataCache.mgoShale = v }),
            Triple(etMgoIronOre, { Page2DataCache.mgoIronOre }, { v: Double -> Page2DataCache.mgoIronOre = v }),

            Triple(etNa2oLimestone, { Page2DataCache.na2oLimestone }, { v: Double -> Page2DataCache.na2oLimestone = v }),
            Triple(etNa2oShale, { Page2DataCache.na2oShale }, { v: Double -> Page2DataCache.na2oShale = v }),
            Triple(etNa2oIronOre, { Page2DataCache.na2oIronOre }, { v: Double -> Page2DataCache.na2oIronOre = v }),

            Triple(etK2oLimestone, { Page2DataCache.k2oLimestone }, { v: Double -> Page2DataCache.k2oLimestone = v }),
            Triple(etK2oShale, { Page2DataCache.k2oShale }, { v: Double -> Page2DataCache.k2oShale = v }),
            Triple(etK2oIronOre, { Page2DataCache.k2oIronOre }, { v: Double -> Page2DataCache.k2oIronOre = v }),

            Triple(etSo3Limestone, { Page2DataCache.so3Limestone }, { v: Double -> Page2DataCache.so3Limestone = v }),
            Triple(etSo3Shale, { Page2DataCache.so3Shale }, { v: Double -> Page2DataCache.so3Shale = v }),
            Triple(etSo3IronOre, { Page2DataCache.so3IronOre }, { v: Double -> Page2DataCache.so3IronOre = v }),

            Triple(etClLimestone, { Page2DataCache.clLimestone }, { v: Double -> Page2DataCache.clLimestone = v }),
            Triple(etClShale, { Page2DataCache.clShale }, { v: Double -> Page2DataCache.clShale = v }),
            Triple(etClIronOre, { Page2DataCache.clIronOre }, { v: Double -> Page2DataCache.clIronOre = v }),

            Triple(etLoiLimestone, { Page2DataCache.loiLimestone }, { v: Double -> Page2DataCache.loiLimestone = v }),
            Triple(etLoiShale, { Page2DataCache.loiShale }, { v: Double -> Page2DataCache.loiShale = v }),
            Triple(etLoiIronOre, { Page2DataCache.loiIronOre }, { v: Double -> Page2DataCache.loiIronOre = v }),

            // Weigh Feeder
            Triple(etWfDryLimestone, { Page2DataCache.wfDryLimestone }, { v: Double -> Page2DataCache.wfDryLimestone = v }),
            Triple(etWfDryShale, { Page2DataCache.wfDryShale }, { v: Double -> Page2DataCache.wfDryShale = v }),
            Triple(etWfDryIronOre, { Page2DataCache.wfDryIronOre }, { v: Double -> Page2DataCache.wfDryIronOre = v }),

            Triple(etWfH2oLimestone, { Page2DataCache.wfH2oLimestone }, { v: Double -> Page2DataCache.wfH2oLimestone = v }),
            Triple(etWfH2oShale, { Page2DataCache.wfH2oShale }, { v: Double -> Page2DataCache.wfH2oShale = v }),
            Triple(etWfH2oIronOre, { Page2DataCache.wfH2oIronOre }, { v: Double -> Page2DataCache.wfH2oIronOre = v })
        )

        fields.forEach { (editText, getter, setter) ->
            editText.setText(getter().takeIf { it != 0.0 }?.toString() ?: "")
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

