package com.example.rawmixapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.rawmixapp.db.SavedDataDbHelper
import org.json.JSONObject
import java.util.*

class Page6Activity : BaseActivity() {
    // Target Inputs
    private lateinit var etLsfTarget: EditText
    private lateinit var etSmTarget: EditText
    private lateinit var etAmTarget: EditText

    // Mix % Table - Inputs (EditText)
    private lateinit var etMixLimestone: EditText
    private lateinit var etMixShale: EditText
    private lateinit var etMixSand: EditText
    private lateinit var etMixIronOre: EditText

    private lateinit var etSio2Limestone: EditText
    private lateinit var etSio2Shale: EditText
    private lateinit var etSio2Sand: EditText
    private lateinit var etSio2IronOre: EditText

    private lateinit var etAl2o3Limestone: EditText
    private lateinit var etAl2o3Shale: EditText
    private lateinit var etAl2o3Sand: EditText
    private lateinit var etAl2o3IronOre: EditText

    private lateinit var etFe2o3Limestone: EditText
    private lateinit var etFe2o3Shale: EditText
    private lateinit var etFe2o3Sand: EditText
    private lateinit var etFe2o3IronOre: EditText

    private lateinit var etCaoLimestone: EditText
    private lateinit var etCaoShale: EditText
    private lateinit var etCaoSand: EditText
    private lateinit var etCaoIronOre: EditText

    private lateinit var etMgoLimestone: EditText
    private lateinit var etMgoShale: EditText
    private lateinit var etMgoSand: EditText
    private lateinit var etMgoIronOre: EditText

    private lateinit var etNa2oLimestone: EditText
    private lateinit var etNa2oShale: EditText
    private lateinit var etNa2oSand: EditText
    private lateinit var etNa2oIronOre: EditText

    private lateinit var etK2oLimestone: EditText
    private lateinit var etK2oShale: EditText
    private lateinit var etK2oSand: EditText
    private lateinit var etK2oIronOre: EditText

    private lateinit var etSo3Limestone: EditText
    private lateinit var etSo3Shale: EditText
    private lateinit var etSo3Sand: EditText
    private lateinit var etSo3IronOre: EditText

    private lateinit var etClLimestone: EditText
    private lateinit var etClShale: EditText
    private lateinit var etClSand: EditText
    private lateinit var etClIronOre: EditText

    private lateinit var etLoiLimestone: EditText
    private lateinit var etLoiShale: EditText
    private lateinit var etLoiSand: EditText
    private lateinit var etLoiIronOre: EditText

    // Mix % Table - Outputs (TextView)
    private lateinit var tvMixRawmeal: TextView
    private lateinit var tvSio2Rawmeal: TextView
    private lateinit var tvAl2o3Rawmeal: TextView
    private lateinit var tvFe2o3Rawmeal: TextView
    private lateinit var tvCaoRawmeal: TextView
    private lateinit var tvMgoRawmeal: TextView
    private lateinit var tvNa2oRawmeal: TextView
    private lateinit var tvK2oRawmeal: TextView
    private lateinit var tvSo3Rawmeal: TextView
    private lateinit var tvClRawmeal: TextView
    private lateinit var tvLoiRawmeal: TextView

    private lateinit var tvTotalLimestone: TextView
    private lateinit var tvTotalShale: TextView
    private lateinit var tvTotalSand: TextView
    private lateinit var tvTotalIronOre: TextView
    private lateinit var tvTotalRawmeal: TextView

    private lateinit var tvLsfLimestone: TextView
    private lateinit var tvLsfShale: TextView
    private lateinit var tvLsfSand: TextView
    private lateinit var tvLsfIronOre: TextView
    private lateinit var tvLsfRawmeal: TextView

    private lateinit var tvSmLimestone: TextView
    private lateinit var tvSmShale: TextView
    private lateinit var tvSmSand: TextView
    private lateinit var tvSmIronOre: TextView
    private lateinit var tvSmRawmeal: TextView

    private lateinit var tvAmLimestone: TextView
    private lateinit var tvAmShale: TextView
    private lateinit var tvAmSand: TextView
    private lateinit var tvAmIronOre: TextView
    private lateinit var tvAmRawmeal: TextView

    // Raw Material Percentage (Dry Basis) - Outputs (TextView)
    private lateinit var tvDryLimestone: TextView
    private lateinit var tvDryShale: TextView
    private lateinit var tvDrySand: TextView
    private lateinit var tvDryIronOre: TextView
    private lateinit var tvDryTotal: TextView

    // Material Percentage (Weigh Feeder) - Inputs (EditText)
    private lateinit var etWfDryLimestone: EditText
    private lateinit var etWfDryShale: EditText
    private lateinit var etWfDrySand: EditText
    private lateinit var etWfDryIronOre: EditText

    private lateinit var etWfH2oLimestone: EditText
    private lateinit var etWfH2oShale: EditText
    private lateinit var etWfH2oSand: EditText
    private lateinit var etWfH2oIronOre: EditText

    // Material Percentage (Weigh Feeder) - Outputs (TextView)
    private lateinit var tvWfWetLimestone: TextView
    private lateinit var tvWfWetShale: TextView
    private lateinit var tvWfWetSand: TextView
    private lateinit var tvWfWetIronOre: TextView
    private lateinit var tvWfWetTotal: TextView

    private lateinit var tvWfDryTotal: TextView
    private lateinit var tvWfH2oTotal: TextView

    // Coefficients for Mix Calculation Table - Outputs (TextView)
    private lateinit var tvCoeffA: TextView
    private lateinit var tvCoeffB: TextView
    private lateinit var tvCoeffC: TextView
    private lateinit var tvCoeffD: TextView
    private lateinit var tvCoeffE: TextView
    private lateinit var tvCoeffF: TextView
    private lateinit var tvCoeffG: TextView
    private lateinit var tvCoeffH: TextView
    private lateinit var tvCoeffI: TextView
    private lateinit var tvCoeffJ: TextView
    private lateinit var tvCoeffK: TextView
    private lateinit var tvCoeffL: TextView
    private lateinit var tvCoeffDelta: TextView

    // Wet Basis Column - Outputs (TextView)
    private lateinit var tvDelta1: TextView
    private lateinit var tvDelta2: TextView
    private lateinit var tvDelta3: TextView
    private lateinit var tvDelta4: TextView
    private lateinit var tvDelta5: TextView

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
        supportActionBar?.title = "Recipe LSF, SM & AM"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page6)

        dbHelper = SavedDataDbHelper(this)
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        initializeViews()
        page6Cache()
        setupTextWatchers()
        setupButtons()
        calculateAll() // Initial calculation

        // Check if we're loading saved data
        val savedDataId = intent.getLongExtra("saved_data_id", -1)
        if (savedDataId != -1L) {
            loadSavedData(savedDataId)
        }
    }

    private fun initializeViews() {
        // Target Inputs
        etLsfTarget = findViewById(R.id.et_lsf_target)
        etSmTarget = findViewById(R.id.et_sm_target)
        etAmTarget = findViewById(R.id.et_am_target)

        // Mix % Table - Inputs
        etMixLimestone = findViewById(R.id.et_mix_limestone)
        etMixShale = findViewById(R.id.et_mix_shale)
        etMixSand = findViewById(R.id.et_mix_sand)
        etMixIronOre = findViewById(R.id.et_mix_ironore)

        etSio2Limestone = findViewById(R.id.et_sio2_limestone)
        etSio2Shale = findViewById(R.id.et_sio2_shale)
        etSio2Sand = findViewById(R.id.et_sio2_sand)
        etSio2IronOre = findViewById(R.id.et_sio2_ironore)

        etAl2o3Limestone = findViewById(R.id.et_al2o3_limestone)
        etAl2o3Shale = findViewById(R.id.et_al2o3_shale)
        etAl2o3Sand = findViewById(R.id.et_al2o3_sand)
        etAl2o3IronOre = findViewById(R.id.et_al2o3_ironore)

        etFe2o3Limestone = findViewById(R.id.et_fe2o3_limestone)
        etFe2o3Shale = findViewById(R.id.et_fe2o3_shale)
        etFe2o3Sand = findViewById(R.id.et_fe2o3_sand)
        etFe2o3IronOre = findViewById(R.id.et_fe2o3_ironore)

        etCaoLimestone = findViewById(R.id.et_cao_limestone)
        etCaoShale = findViewById(R.id.et_cao_shale)
        etCaoSand = findViewById(R.id.et_cao_sand)
        etCaoIronOre = findViewById(R.id.et_cao_ironore)

        etMgoLimestone = findViewById(R.id.et_mgo_limestone)
        etMgoShale = findViewById(R.id.et_mgo_shale)
        etMgoSand = findViewById(R.id.et_mgo_sand)
        etMgoIronOre = findViewById(R.id.et_mgo_ironore)

        etNa2oLimestone = findViewById(R.id.et_na2o_limestone)
        etNa2oShale = findViewById(R.id.et_na2o_shale)
        etNa2oSand = findViewById(R.id.et_na2o_sand)
        etNa2oIronOre = findViewById(R.id.et_na2o_ironore)

        etK2oLimestone = findViewById(R.id.et_k2o_limestone)
        etK2oShale = findViewById(R.id.et_k2o_shale)
        etK2oSand = findViewById(R.id.et_k2o_sand)
        etK2oIronOre = findViewById(R.id.et_k2o_ironore)

        etSo3Limestone = findViewById(R.id.et_so3_limestone)
        etSo3Shale = findViewById(R.id.et_so3_shale)
        etSo3Sand = findViewById(R.id.et_so3_sand)
        etSo3IronOre = findViewById(R.id.et_so3_ironore)

        etClLimestone = findViewById(R.id.et_cl_limestone)
        etClShale = findViewById(R.id.et_cl_shale)
        etClSand = findViewById(R.id.et_cl_sand)
        etClIronOre = findViewById(R.id.et_cl_ironore)

        etLoiLimestone = findViewById(R.id.et_loi_limestone)
        etLoiShale = findViewById(R.id.et_loi_shale)
        etLoiSand = findViewById(R.id.et_loi_sand)
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
        tvTotalSand = findViewById(R.id.tv_total_sand)
        tvTotalIronOre = findViewById(R.id.tv_total_ironore)
        tvTotalRawmeal = findViewById(R.id.tv_total_rawmeal)

        tvLsfLimestone = findViewById(R.id.tv_lsf_limestone)
        tvLsfShale = findViewById(R.id.tv_lsf_shale)
        tvLsfSand = findViewById(R.id.tv_lsf_sand)
        tvLsfIronOre = findViewById(R.id.tv_lsf_ironore)
        tvLsfRawmeal = findViewById(R.id.tv_lsf_rawmeal)

        tvSmLimestone = findViewById(R.id.tv_sm_limestone)
        tvSmShale = findViewById(R.id.tv_sm_shale)
        tvSmSand = findViewById(R.id.tv_sm_sand)
        tvSmIronOre = findViewById(R.id.tv_sm_ironore)
        tvSmRawmeal = findViewById(R.id.tv_sm_rawmeal)

        tvAmLimestone = findViewById(R.id.tv_am_limestone)
        tvAmShale = findViewById(R.id.tv_am_shale)
        tvAmSand = findViewById(R.id.tv_am_sand)
        tvAmIronOre = findViewById(R.id.tv_am_ironore)
        tvAmRawmeal = findViewById(R.id.tv_am_rawmeal)

        // Raw Material Percentage (Dry Basis) - Outputs
        tvDryLimestone = findViewById(R.id.tv_dry_limestone)
        tvDryShale = findViewById(R.id.tv_dry_shale)
        tvDrySand = findViewById(R.id.tv_dry_sand)
        tvDryIronOre = findViewById(R.id.tv_dry_ironore)
        tvDryTotal = findViewById(R.id.tv_dry_total)

        // Material Percentage (Weigh Feeder) - Inputs
        etWfDryLimestone = findViewById(R.id.et_wf_dry_limestone)
        etWfDryShale = findViewById(R.id.et_wf_dry_shale)
        etWfDrySand = findViewById(R.id.et_wf_dry_sand)
        etWfDryIronOre = findViewById(R.id.et_wf_dry_ironore)

        etWfH2oLimestone = findViewById(R.id.et_wf_h2o_limestone)
        etWfH2oShale = findViewById(R.id.et_wf_h2o_shale)
        etWfH2oSand = findViewById(R.id.et_wf_h2o_sand)
        etWfH2oIronOre = findViewById(R.id.et_wf_h2o_ironore)

        // Material Percentage (Weigh Feeder) - Outputs
        tvWfWetLimestone = findViewById(R.id.tv_wf_wet_limestone)
        tvWfWetShale = findViewById(R.id.tv_wf_wet_shale)
        tvWfWetSand = findViewById(R.id.tv_wf_wet_sand)
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
            etLsfTarget, etSmTarget, etAmTarget,
            etMixLimestone, etMixShale, etMixSand, etMixIronOre,
            etSio2Limestone, etSio2Shale, etSio2Sand, etSio2IronOre,
            etAl2o3Limestone, etAl2o3Shale, etAl2o3Sand, etAl2o3IronOre,
            etFe2o3Limestone, etFe2o3Shale, etFe2o3Sand, etFe2o3IronOre,
            etCaoLimestone, etCaoShale, etCaoSand, etCaoIronOre,
            etMgoLimestone, etMgoShale, etMgoSand, etMgoIronOre,
            etNa2oLimestone, etNa2oShale, etNa2oSand, etNa2oIronOre,
            etK2oLimestone, etK2oShale, etK2oSand, etK2oIronOre,
            etSo3Limestone, etSo3Shale, etSo3Sand, etSo3IronOre,
            etClLimestone, etClShale, etClSand, etClIronOre,
            etLoiLimestone, etLoiShale, etLoiSand, etLoiIronOre,
            etWfDryLimestone, etWfDryShale, etWfDrySand, etWfDryIronOre,
            etWfH2oLimestone, etWfH2oShale, etWfH2oSand, etWfH2oIronOre
        )
    }

    private fun setupTextWatchers() {
        allInputEditTexts.forEach {
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

    private fun getDoubleValue(editText: EditText): Double {
        return editText.text.toString().toDoubleOrNull() ?: 0.0
    }

    private fun setTextViewValue(textView: TextView, value: Double, defaultOnError: String = "0.00") {
        val idName = try {
            textView.resources.getResourceEntryName(textView.id)
        } catch (e: Exception) {
            ""
        }

        if (value.isInfinite() || value.isNaN()) {
            textView.text = defaultOnError
        } else {
            val formattedValue = when (idName) {
                // IDs with 1 decimal place formatting
                "tv_dry_limestone", "tv_dry_shale", "tv_dry_sand", "tv_dry_ironore", "tv_dry_total",
                "tv_wf_wet_limestone", "tv_wf_wet_shale", "tv_wf_wet_sand", "tv_wf_wet_ironore", "tv_wf_wet_total",
                "tv_wf_dry_total", "tv_wf_h2o_total" ->
                    String.format(Locale.US, "%.1f", value)
                else ->
                    String.format(Locale.US, "%.2f", value)
            }

            textView.text = formattedValue
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
                    dbHelper.saveData(6, data.toString(), if (saveName.isEmpty()) null else saveName)
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

    private fun calculateAll() {
        // --- Read Inputs ---
        // Target values
        val targetLsf = getDoubleValue(etLsfTarget)
        val targetSm = getDoubleValue(etSmTarget)
        val targetAm = getDoubleValue(etAmTarget)

        // Mix % values
        val mixLst = getDoubleValue(etMixLimestone)
        val mixShale = getDoubleValue(etMixShale)
        val mixSand = getDoubleValue(etMixSand)
        val mixIron = getDoubleValue(etMixIronOre)

        // Limestone values
        val sio2Lst = getDoubleValue(etSio2Limestone)
        val al2o3Lst = getDoubleValue(etAl2o3Limestone)
        val fe2o3Lst = getDoubleValue(etFe2o3Limestone)
        val caoLst = getDoubleValue(etCaoLimestone)
        val mgoLst = getDoubleValue(etMgoLimestone)
        val na2oLst = getDoubleValue(etNa2oLimestone)
        val k2oLst = getDoubleValue(etK2oLimestone)
        val so3Lst = getDoubleValue(etSo3Limestone)
        val clLst = getDoubleValue(etClLimestone)
        val loiLst = getDoubleValue(etLoiLimestone)

        // Shale values
        val sio2Shale = getDoubleValue(etSio2Shale)
        val al2o3Shale = getDoubleValue(etAl2o3Shale)
        val fe2o3Shale = getDoubleValue(etFe2o3Shale)
        val caoShale = getDoubleValue(etCaoShale)
        val mgoShale = getDoubleValue(etMgoShale)
        val na2oShale = getDoubleValue(etNa2oShale)
        val k2oShale = getDoubleValue(etK2oShale)
        val so3Shale = getDoubleValue(etSo3Shale)
        val clShale = getDoubleValue(etClShale)
        val loiShale = getDoubleValue(etLoiShale)

        // Sand values
        val sio2Sand = getDoubleValue(etSio2Sand)
        val al2o3Sand = getDoubleValue(etAl2o3Sand)
        val fe2o3Sand = getDoubleValue(etFe2o3Sand)
        val caoSand = getDoubleValue(etCaoSand)
        val mgoSand = getDoubleValue(etMgoSand)
        val na2oSand = getDoubleValue(etNa2oSand)
        val k2oSand = getDoubleValue(etK2oSand)
        val so3Sand = getDoubleValue(etSo3Sand)
        val clSand = getDoubleValue(etClSand)
        val loiSand = getDoubleValue(etLoiSand)

        // Iron Ore values
        val sio2Iron = getDoubleValue(etSio2IronOre)
        val al2o3Iron = getDoubleValue(etAl2o3IronOre)
        val fe2o3Iron = getDoubleValue(etFe2o3IronOre)
        val caoIron = getDoubleValue(etCaoIronOre)
        val mgoIron = getDoubleValue(etMgoIronOre)
        val na2oIron = getDoubleValue(etNa2oIronOre)
        val k2oIron = getDoubleValue(etK2oIronOre)
        val so3Iron = getDoubleValue(etSo3IronOre)
        val clIron = getDoubleValue(etClIronOre)
        val loiIron = getDoubleValue(etLoiIronOre)

        // Weigh Feeder values
        val wfDryLst = getDoubleValue(etWfDryLimestone)
        val wfDryShale = getDoubleValue(etWfDryShale)
        val wfDrySand = getDoubleValue(etWfDrySand)
        val wfDryIron = getDoubleValue(etWfDryIronOre)

        val wfH2oLst = getDoubleValue(etWfH2oLimestone)
        val wfH2oShale = getDoubleValue(etWfH2oShale)
        val wfH2oSand = getDoubleValue(etWfH2oSand)
        val wfH2oIron = getDoubleValue(etWfH2oIronOre)

        // --- Calculations ---
        // Total Mix
        val mixTotal = mixLst + mixShale + mixSand + mixIron

        // Calculate totals for each material
        val totalLst = sio2Lst + al2o3Lst + fe2o3Lst + caoLst + mgoLst + na2oLst + k2oLst + so3Lst + clLst + loiLst
        val totalShale = sio2Shale + al2o3Shale + fe2o3Shale + caoShale + mgoShale + na2oShale + k2oShale + so3Shale + clShale + loiShale
        val totalSand = sio2Sand + al2o3Sand + fe2o3Sand + caoSand + mgoSand + na2oSand + k2oSand + so3Sand + clSand + loiSand
        val totalIron = sio2Iron + al2o3Iron + fe2o3Iron + caoIron + mgoIron + na2oIron + k2oIron + so3Iron + clIron + loiIron

        // Calculate Hidden Coefficient values
        // a (N12) = 1 (constant value)
        val a = 1.0
        // b (N13) = 1 (constant value)
        val b = 1.0
        // c (N14) = 1 (constant value)
        val c = 1.0
        // d (N15) = 1 (constant value)
        val d = 1.0
        // e (N16) = 100 (constant value)
        val e = 100.0
        // f (N17) = I10*E15-E14 (targetAm * fe2o3Lst - al2o3Lst)
        val f = targetAm * fe2o3Lst - al2o3Lst
        // g (N18) = I10*G15-G14 (targetAm * fe2o3Sand - al2o3Sand)
        val g = targetAm * fe2o3Sand - al2o3Sand
        // h (N19) = I10*H15-H14 (targetAm * fe2o3Iron - al2o3Iron)
        val h = targetAm * fe2o3Iron - al2o3Iron
        // i (N20) = I10*F15-F14 (targetAm * fe2o3Shale - al2o3Shale)
        val i = targetAm * fe2o3Shale - al2o3Shale
        // k (N21) = I9*E14+I9*E15-E13 (targetSm * al2o3Lst + targetSm * fe2o3Lst - sio2Lst)
        val k = targetSm * al2o3Lst + targetSm * fe2o3Lst - sio2Lst
        // l (N22) = I9*G14+I9*G15-G13 (targetSm * al2o3Sand + targetSm * fe2o3Sand - sio2Sand)
        val l = targetSm * al2o3Sand + targetSm * fe2o3Sand - sio2Sand
        // m (N23) = I9*H14+I9*H15-H13 (targetSm * al2o3Iron + targetSm * fe2o3Iron - sio2Iron)
        val m = targetSm * al2o3Iron + targetSm * fe2o3Iron - sio2Iron
        // n (N24) = I9*F14+I9*F15-F13 (targetSm * al2o3Shale + targetSm * fe2o3Shale - sio2Shale)
        val n = targetSm * al2o3Shale + targetSm * fe2o3Shale - sio2Shale
        // p (N25) = I8*2.8*E13+I8*1.18*E14+I8*0.65*E15-100*E16 (targetLsf * 2.8 * sio2Lst + targetLsf * 1.18 * al2o3Lst + targetLsf * 0.65 * fe2o3Lst - 100 * caoLst)
        val p = targetLsf * 2.8 * sio2Lst + targetLsf * 1.18 * al2o3Lst + targetLsf * 0.65 * fe2o3Lst - 100 * caoLst
        // q (N26) = I8*2.8*G13+I8*1.18*G14+I8*0.65*G15-100*G16 (targetLsf * 2.8 * sio2Sand + targetLsf * 1.18 * al2o3Sand + targetLsf * 0.65 * fe2o3Sand - 100 * caoSand)
        val q = targetLsf * 2.8 * sio2Sand + targetLsf * 1.18 * al2o3Sand + targetLsf * 0.65 * fe2o3Sand - 100 * caoSand
        // r (N27) = I8*2.8*H13+I8*1.18*H14+I8*0.65*H15-100*H16 (targetLsf * 2.8 * sio2Iron + targetLsf * 1.18 * al2o3Iron + targetLsf * 0.65 * fe2o3Iron - 100 * caoIron)
        val r = targetLsf * 2.8 * sio2Iron + targetLsf * 1.18 * al2o3Iron + targetLsf * 0.65 * fe2o3Iron - 100 * caoIron
        // s (N28) = I8*2.8*F13+I8*1.18*F14+I8*0.65*F15-100*F16 (targetLsf * 2.8 * sio2Shale + targetLsf * 1.18 * al2o3Shale + targetLsf * 0.65 * fe2o3Shale - 100 * caoShale)
        val s = targetLsf * 2.8 * sio2Shale + targetLsf * 1.18 * al2o3Shale + targetLsf * 0.65 * fe2o3Shale - 100 * caoShale

        // Calculate Hidden Matrix values
        // Dw (Q12) = (N16*N18*N23*N28)+(N16*N19*N24*N26)+(N16*N20*N22*N27)-(N16*N20*N23*N26)-(N16*N18*N24*N27)-(N16*N19*N22*N28)
        val dw = (e * g * m * s) + (e * h * n * q) + (e * i * l * r) - (e * i * m * q) - (e * g * n * r) - (e * h * l * s)

        // Dx (Q13) = -N17*N16*N23*N28+N17*N16*N24*N27+N21*N16*N19*N28-N21*N16*N20*N27-N25*N16*N19*N24+N25*N16*N20*N23
        val dx = -f * e * m * s + f * e * n * r + k * e * h * s - k * e * i * r - p * e * h * n + p * e * i * m

        // Dy (Q14) = -N17*N16*N24*N26+N17*N16*N22*N28+N21*N16*N20*N26-N21*N16*N18*N28-N25*N16*N20*N22+N25*N16*N18*N24
        val dy = -f * e * n * q + f * e * l * s + k * e * i * q - k * e * g * s - p * e * i * l + p * e * g * n

        // Dz (Q15) = -N17*N16*N22*N27+N17*N16*N23*N26+N21*N16*N18*N27-N21*N16*N19*N26-N25*N16*N18*N23+N25*N16*N19*N22
        val dz = -f * e * l * r + f * e * m * q + k * e * g * r - k * e * h * q - p * e * g * m + p * e * h * l

        // D (Q16) = Complete Matrix Determinant formula
        val delta = (g * m * s) + (h * n * q) + (i * l * r) - (i * m * q) - (g * n * r) - (h * l * s) -
                (f * m * s) - (f * n * q) - (f * l * r) + (f * m * q) + (f * n * r) + (f * l * s) +
                (k * h * s) + (k * i * q) + (k * g * r) - (k * i * r) - (k * g * s) - (k * h * q) -
                (p * h * n) - (p * i * l) - (p * g * m) + (p * i * m) + (p * g * n) + (p * h * l)

        // Calculate Raw Material Percentage values
        // rmp-limestone (H28) = Q12/Q16
        val rmpLst = if (delta != 0.0) dw / delta else 0.0
        // rmp-shale (H29) = Q15/Q16
        val rmpShale = if (delta != 0.0) dz / delta else 0.0
        // rmp-sand (H30) = Q13/Q16
        val rmpSand = if (delta != 0.0) dx / delta else 0.0
        // rmp-iron (H31) = Q14/Q16
        val rmpIron = if (delta != 0.0) dy / delta else 0.0
        // rmp-total (H32) = SUM(H28:H31)
        val rmpTotal = rmpLst + rmpShale + rmpSand + rmpIron

        // Calculate Dry Basis Total and H2O Total
        val dryTotal = wfDryLst + wfDryShale + wfDrySand + wfDryIron
        val h2oTotal = wfH2oLst + wfH2oShale + wfH2oSand + wfH2oIron

        // Calculate Hidden Wet values
        // hidden-wet1 (M30) = H35/(1-(J35/100))
        val hiddenWet1 = wfDryLst / (1.0 - (wfH2oLst/100.0))
        // hidden-wet2 (M31) = H36/(1-(J36/100))
        val hiddenWet2 = wfDryShale / (1.0 - (wfH2oShale/100.0))
        // hidden-wet3 (M32) = H37/(1-(J37/100))
        val hiddenWet3 = wfDrySand / (1.0 - (wfH2oSand/100.0))
        // hidden-wet4 (M33) = H38/(1-(J38/100))
        val hiddenWet4 = wfDryIron / (1.0 - (wfH2oIron/100.0))
        // hidden-wet5 (M34) = M30+M31+M32+M33 (Sum of all hidden wet values)
        val hiddenWet5 = hiddenWet1 + hiddenWet2 + hiddenWet3 + hiddenWet4
        // hidden-wet6 (M35) = H32/M34 (where H32 is dryTotal)
        val hiddenWet6 = if (hiddenWet5 != 0.0) dryTotal / hiddenWet5 else 0.0

        // Calculate Wet Basis values - Apply formula correctly based on hidden-wet calculation
        val wetLst = hiddenWet1 * hiddenWet6
        val wetShale = hiddenWet2 * hiddenWet6
        val wetSand = hiddenWet3 * hiddenWet6
        val wetIron = hiddenWet4 * hiddenWet6
        val wetTotal = wetLst + wetShale + wetSand + wetIron

        // Calculate Rawmeal values
        val sio2Rawmeal = if (mixTotal != 0.0) ((mixLst * sio2Lst) + (mixSand * sio2Sand) + (mixIron * sio2Iron) + (mixShale * sio2Shale)) / mixTotal else 0.0
        val al2o3Rawmeal = if (mixTotal != 0.0) ((mixLst * al2o3Lst) + (mixSand * al2o3Sand) + (mixIron * al2o3Iron) + (mixShale * al2o3Shale)) / mixTotal else 0.0
        val fe2o3Rawmeal = if (mixTotal != 0.0) ((mixLst * fe2o3Lst) + (mixSand * fe2o3Sand) + (mixIron * fe2o3Iron) + (mixShale * fe2o3Shale)) / mixTotal else 0.0
        val caoRawmeal = if (mixTotal != 0.0) ((mixLst * caoLst) + (mixSand * caoSand) + (mixIron * caoIron) + (mixShale * caoShale)) / mixTotal else 0.0
        val mgoRawmeal = if (mixTotal != 0.0) ((mixLst * mgoLst) + (mixSand * mgoSand) + (mixIron * mgoIron) + (mixShale * mgoShale)) / mixTotal else 0.0
        val na2oRawmeal = if (mixTotal != 0.0) ((mixLst * na2oLst) + (mixSand * na2oSand) + (mixIron * na2oIron) + (mixShale * na2oShale)) / mixTotal else 0.0
        val k2oRawmeal = if (mixTotal != 0.0) ((mixLst * k2oLst) + (mixSand * k2oSand) + (mixIron * k2oIron) + (mixShale * k2oShale)) / mixTotal else 0.0
        val so3Rawmeal = if (mixTotal != 0.0) ((mixLst * so3Lst) + (mixSand * so3Sand) + (mixIron * so3Iron) + (mixShale * so3Shale)) / mixTotal else 0.0
        val clRawmeal = if (mixTotal != 0.0) ((mixLst * clLst) + (mixSand * clSand) + (mixIron * clIron) + (mixShale * clShale)) / mixTotal else 0.0
        val loiRawmeal = if (mixTotal != 0.0) ((mixLst * loiLst) + (mixSand * loiSand) + (mixIron * loiIron) + (mixShale * loiShale)) / mixTotal else 0.0
        val totalRawmeal = sio2Rawmeal + al2o3Rawmeal + fe2o3Rawmeal + caoRawmeal + mgoRawmeal + na2oRawmeal + k2oRawmeal + so3Rawmeal + clRawmeal + loiRawmeal

        // Calculate LSF for each material
        val lsfLst = if (sio2Lst != 0.0 || al2o3Lst != 0.0 || fe2o3Lst != 0.0)
            100.0 * caoLst / (2.8 * sio2Lst + 1.18 * al2o3Lst + 0.65 * fe2o3Lst) else 0.0
        val lsfShale = if (sio2Shale != 0.0 || al2o3Shale != 0.0 || fe2o3Shale != 0.0)
            100.0 * caoShale / (2.8 * sio2Shale + 1.18 * al2o3Shale + 0.65 * fe2o3Shale) else 0.0
        val lsfSand = if (sio2Sand != 0.0 || al2o3Sand != 0.0 || fe2o3Sand != 0.0)
            100.0 * caoSand / (2.8 * sio2Sand + 1.18 * al2o3Sand + 0.65 * fe2o3Sand) else 0.0
        val lsfIron = if (sio2Iron != 0.0 || al2o3Iron != 0.0 || fe2o3Iron != 0.0)
            100.0 * caoIron / (2.8 * sio2Iron + 1.18 * al2o3Iron + 0.65 * fe2o3Iron) else 0.0

        // Calculate SM for each material
        val smLst = if (al2o3Lst != 0.0 || fe2o3Lst != 0.0) sio2Lst / (al2o3Lst + fe2o3Lst) else 0.0
        val smShale = if (al2o3Shale != 0.0 || fe2o3Shale != 0.0) sio2Shale / (al2o3Shale + fe2o3Shale) else 0.0
        val smSand = if (al2o3Sand != 0.0 || fe2o3Sand != 0.0) sio2Sand / (al2o3Sand + fe2o3Sand) else 0.0
        val smIron = if (al2o3Iron != 0.0 || fe2o3Iron != 0.0) sio2Iron / (al2o3Iron + fe2o3Iron) else 0.0

        // Calculate AM for each material
        val amLst = if (fe2o3Lst != 0.0) al2o3Lst / fe2o3Lst else 0.0
        val amShale = if (fe2o3Shale != 0.0) al2o3Shale / fe2o3Shale else 0.0
        val amSand = if (fe2o3Sand != 0.0) al2o3Sand / fe2o3Sand else 0.0
        val amIron = if (fe2o3Iron != 0.0) al2o3Iron / fe2o3Iron else 0.0

        // Calculate LSF, SM, AM for Rawmeal
        val lsfRawmeal = if ((sio2Rawmeal != 0.0 || al2o3Rawmeal != 0.0 || fe2o3Rawmeal != 0.0) &&
            (2.8 * sio2Rawmeal + 1.18 * al2o3Rawmeal + 0.65 * fe2o3Rawmeal) != 0.0)
            100.0 * caoRawmeal / (2.8 * sio2Rawmeal + 1.18 * al2o3Rawmeal + 0.65 * fe2o3Rawmeal) else 0.0
        val smRawmeal = if ((al2o3Rawmeal + fe2o3Rawmeal) != 0.0)
            sio2Rawmeal / (al2o3Rawmeal + fe2o3Rawmeal) else 0.0
        val amRawmeal = if (fe2o3Rawmeal != 0.0)
            al2o3Rawmeal / fe2o3Rawmeal else 0.0

        // --- Update UI ---
        // Mix % Table
        setTextViewValue(tvMixRawmeal, mixTotal)
        setTextViewValue(tvSio2Rawmeal, sio2Rawmeal)
        setTextViewValue(tvAl2o3Rawmeal, al2o3Rawmeal)
        setTextViewValue(tvFe2o3Rawmeal, fe2o3Rawmeal)
        setTextViewValue(tvCaoRawmeal, caoRawmeal)
        setTextViewValue(tvMgoRawmeal, mgoRawmeal)
        setTextViewValue(tvNa2oRawmeal, na2oRawmeal)
        setTextViewValue(tvK2oRawmeal, k2oRawmeal)
        setTextViewValue(tvSo3Rawmeal, so3Rawmeal)
        setTextViewValue(tvClRawmeal, clRawmeal)
        setTextViewValue(tvLoiRawmeal, loiRawmeal)

        setTextViewValue(tvTotalLimestone, totalLst)
        setTextViewValue(tvTotalShale, totalShale)
        setTextViewValue(tvTotalSand, totalSand)
        setTextViewValue(tvTotalIronOre, totalIron)
        setTextViewValue(tvTotalRawmeal, totalRawmeal)

        setTextViewValue(tvLsfLimestone, lsfLst)
        setTextViewValue(tvLsfShale, lsfShale)
        setTextViewValue(tvLsfSand, lsfSand)
        setTextViewValue(tvLsfIronOre, lsfIron)
        setTextViewValue(tvLsfRawmeal, lsfRawmeal)

        setTextViewValue(tvSmLimestone, smLst)
        setTextViewValue(tvSmShale, smShale)
        setTextViewValue(tvSmSand, smSand)
        setTextViewValue(tvSmIronOre, smIron)
        setTextViewValue(tvSmRawmeal, smRawmeal)

        setTextViewValue(tvAmLimestone, amLst)
        setTextViewValue(tvAmShale, amShale)
        setTextViewValue(tvAmSand, amSand)
        setTextViewValue(tvAmIronOre, amIron)
        setTextViewValue(tvAmRawmeal, amRawmeal)

        // Raw Material Percentage Table
        setTextViewValue(tvDryLimestone, rmpLst)
        setTextViewValue(tvDryShale, rmpShale)
        setTextViewValue(tvDrySand, rmpSand)
        setTextViewValue(tvDryIronOre, rmpIron)
        setTextViewValue(tvDryTotal, rmpTotal)

        // Material Percentage (Weigh Feeder) Table
        setTextViewValue(tvWfWetLimestone, wetLst)
        setTextViewValue(tvWfWetShale, wetShale)
        setTextViewValue(tvWfWetSand, wetSand)
        setTextViewValue(tvWfWetIronOre, wetIron)
        setTextViewValue(tvWfWetTotal, wetTotal)

        setTextViewValue(tvWfDryTotal, dryTotal)
        setTextViewValue(tvWfH2oTotal, h2oTotal)

        // Coefficients for Mix Calculation Table
        setTextViewValue(tvCoeffA, a)
        setTextViewValue(tvCoeffB, b)
        setTextViewValue(tvCoeffC, c)
        setTextViewValue(tvCoeffD, d)
        setTextViewValue(tvCoeffE, e)
        setTextViewValue(tvCoeffF, f)
        setTextViewValue(tvCoeffG, g)
        setTextViewValue(tvCoeffH, h)
        setTextViewValue(tvCoeffI, i)
        setTextViewValue(tvCoeffJ, k)
        setTextViewValue(tvCoeffK, l)
        setTextViewValue(tvCoeffL, m)
        setTextViewValue(tvCoeffDelta, delta)

        // Wet Basis Column
        setTextViewValue(tvDelta1, hiddenWet1)
        setTextViewValue(tvDelta2, hiddenWet2)
        setTextViewValue(tvDelta3, hiddenWet3)
        setTextViewValue(tvDelta4, hiddenWet4)
        setTextViewValue(tvDelta5, hiddenWet5)
    }
    private fun page6Cache() {
        val fields = listOf(
            // Target Inputs
            Triple(etLsfTarget, { Page6DataCache.LsfTarget }, { v: Double -> Page6DataCache.LsfTarget = v }),
            Triple(etSmTarget, { Page6DataCache.SmTarget }, { v: Double -> Page6DataCache.SmTarget = v }),
            Triple(etAmTarget, { Page6DataCache.AmTarget }, { v: Double -> Page6DataCache.AmTarget = v }),

            // Mix % Inputs
            Triple(etMixLimestone, { Page6DataCache.MixLimestone }, { v: Double -> Page6DataCache.MixLimestone = v }),
            Triple(etMixShale, { Page6DataCache.MixShale }, { v: Double -> Page6DataCache.MixShale = v }),
            Triple(etMixSand, { Page6DataCache.MixSand }, { v: Double -> Page6DataCache.MixSand = v }),
            Triple(etMixIronOre, { Page6DataCache.MixIronOre }, { v: Double -> Page6DataCache.MixIronOre = v }),

            // SiO2
            Triple(etSio2Limestone, { Page6DataCache.Sio2Limestone }, { v: Double -> Page6DataCache.Sio2Limestone = v }),
            Triple(etSio2Shale, { Page6DataCache.Sio2Shale }, { v: Double -> Page6DataCache.Sio2Shale = v }),
            Triple(etSio2Sand, { Page6DataCache.Sio2Sand }, { v: Double -> Page6DataCache.Sio2Sand = v }),
            Triple(etSio2IronOre, { Page6DataCache.Sio2IronOre }, { v: Double -> Page6DataCache.Sio2IronOre = v }),

            // Al2O3
            Triple(etAl2o3Limestone, { Page6DataCache.Al2o3Limestone }, { v: Double -> Page6DataCache.Al2o3Limestone = v }),
            Triple(etAl2o3Shale, { Page6DataCache.Al2o3Shale }, { v: Double -> Page6DataCache.Al2o3Shale = v }),
            Triple(etAl2o3Sand, { Page6DataCache.Al2o3Sand }, { v: Double -> Page6DataCache.Al2o3Sand = v }),
            Triple(etAl2o3IronOre, { Page6DataCache.Al2o3IronOre }, { v: Double -> Page6DataCache.Al2o3IronOre = v }),

            // Fe2O3
            Triple(etFe2o3Limestone, { Page6DataCache.Fe2o3Limestone }, { v: Double -> Page6DataCache.Fe2o3Limestone = v }),
            Triple(etFe2o3Shale, { Page6DataCache.Fe2o3Shale }, { v: Double -> Page6DataCache.Fe2o3Shale = v }),
            Triple(etFe2o3Sand, { Page6DataCache.Fe2o3Sand }, { v: Double -> Page6DataCache.Fe2o3Sand = v }),
            Triple(etFe2o3IronOre, { Page6DataCache.Fe2o3IronOre }, { v: Double -> Page6DataCache.Fe2o3IronOre = v }),

            // CaO
            Triple(etCaoLimestone, { Page6DataCache.CaoLimestone }, { v: Double -> Page6DataCache.CaoLimestone = v }),
            Triple(etCaoShale, { Page6DataCache.CaoShale }, { v: Double -> Page6DataCache.CaoShale = v }),
            Triple(etCaoSand, { Page6DataCache.CaoSand }, { v: Double -> Page6DataCache.CaoSand = v }),
            Triple(etCaoIronOre, { Page6DataCache.CaoIronOre }, { v: Double -> Page6DataCache.CaoIronOre = v }),

            // MgO
            Triple(etMgoLimestone, { Page6DataCache.MgoLimestone }, { v: Double -> Page6DataCache.MgoLimestone = v }),
            Triple(etMgoShale, { Page6DataCache.MgoShale }, { v: Double -> Page6DataCache.MgoShale = v }),
            Triple(etMgoSand, { Page6DataCache.MgoSand }, { v: Double -> Page6DataCache.MgoSand = v }),
            Triple(etMgoIronOre, { Page6DataCache.MgoIronOre }, { v: Double -> Page6DataCache.MgoIronOre = v }),

            // Na2O
            Triple(etNa2oLimestone, { Page6DataCache.Na2oLimestone }, { v: Double -> Page6DataCache.Na2oLimestone = v }),
            Triple(etNa2oShale, { Page6DataCache.Na2oShale }, { v: Double -> Page6DataCache.Na2oShale = v }),
            Triple(etNa2oSand, { Page6DataCache.Na2oSand }, { v: Double -> Page6DataCache.Na2oSand = v }),
            Triple(etNa2oIronOre, { Page6DataCache.Na2oIronOre }, { v: Double -> Page6DataCache.Na2oIronOre = v }),

            // K2O
            Triple(etK2oLimestone, { Page6DataCache.K2oLimestone }, { v: Double -> Page6DataCache.K2oLimestone = v }),
            Triple(etK2oShale, { Page6DataCache.K2oShale }, { v: Double -> Page6DataCache.K2oShale = v }),
            Triple(etK2oSand, { Page6DataCache.K2oSand }, { v: Double -> Page6DataCache.K2oSand = v }),
            Triple(etK2oIronOre, { Page6DataCache.K2oIronOre }, { v: Double -> Page6DataCache.K2oIronOre = v }),

            // SO3
            Triple(etSo3Limestone, { Page6DataCache.So3Limestone }, { v: Double -> Page6DataCache.So3Limestone = v }),
            Triple(etSo3Shale, { Page6DataCache.So3Shale }, { v: Double -> Page6DataCache.So3Shale = v }),
            Triple(etSo3Sand, { Page6DataCache.So3Sand }, { v: Double -> Page6DataCache.So3Sand = v }),
            Triple(etSo3IronOre, { Page6DataCache.So3IronOre }, { v: Double -> Page6DataCache.So3IronOre = v }),

            // Cl
            Triple(etClLimestone, { Page6DataCache.ClLimestone }, { v: Double -> Page6DataCache.ClLimestone = v }),
            Triple(etClShale, { Page6DataCache.ClShale }, { v: Double -> Page6DataCache.ClShale = v }),
            Triple(etClSand, { Page6DataCache.ClSand }, { v: Double -> Page6DataCache.ClSand = v }),
            Triple(etClIronOre, { Page6DataCache.ClIronOre }, { v: Double -> Page6DataCache.ClIronOre = v }),

            // LOI
            Triple(etLoiLimestone, { Page6DataCache.LoiLimestone }, { v: Double -> Page6DataCache.LoiLimestone = v }),
            Triple(etLoiShale, { Page6DataCache.LoiShale }, { v: Double -> Page6DataCache.LoiShale = v }),
            Triple(etLoiSand, { Page6DataCache.LoiSand }, { v: Double -> Page6DataCache.LoiSand = v }),
            Triple(etLoiIronOre, { Page6DataCache.LoiIronOre }, { v: Double -> Page6DataCache.LoiIronOre = v }),

            // Weigh Feeder
            Triple(etWfDryLimestone, { Page6DataCache.WfDryLimestone }, { v: Double -> Page6DataCache.WfDryLimestone = v }),
            Triple(etWfDryShale, { Page6DataCache.WfDryShale }, { v: Double -> Page6DataCache.WfDryShale = v }),
            Triple(etWfDrySand, { Page6DataCache.WfDrySand }, { v: Double -> Page6DataCache.WfDrySand = v }),
            Triple(etWfDryIronOre, { Page6DataCache.WfDryIronOre }, { v: Double -> Page6DataCache.WfDryIronOre = v }),

            Triple(etWfH2oLimestone, { Page6DataCache.WfH2oLimestone }, { v: Double -> Page6DataCache.WfH2oLimestone = v }),
            Triple(etWfH2oShale, { Page6DataCache.WfH2oShale }, { v: Double -> Page6DataCache.WfH2oShale = v }),
            Triple(etWfH2oSand, { Page6DataCache.WfH2oSand }, { v: Double -> Page6DataCache.WfH2oSand = v }),
            Triple(etWfH2oIronOre, { Page6DataCache.WfH2oIronOre }, { v: Double -> Page6DataCache.WfH2oIronOre = v })
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