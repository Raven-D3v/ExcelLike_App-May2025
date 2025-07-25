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

class Page7Activity : BaseActivity() {

    // 1ST LVM ROW
    private lateinit var etLvm1Row1: EditText // H7
    private lateinit var etLvm1Row2: EditText // I7
    private lateinit var tvLvm1Row3: TextView // J7

    // 1ST HVM ROW
    private lateinit var etHvm1Row1: EditText // H8
    private lateinit var etHvm1Row2: EditText // I8
    private lateinit var tvHvm1Row3: TextView // J8

    // Combined values
    private lateinit var tvCombinedFuel: TextView // J9
    private lateinit var tvCombinedAsh: TextView // J10

    // 2ND LVM ROW
    private lateinit var etLvm2Row1: EditText // G11
    private lateinit var etLvm2Row2: EditText // H11
    private lateinit var tvLvm2Row3: TextView // I11

    // 2ND HVM ROW
    private lateinit var etHvm2Row1: EditText // G12
    private lateinit var etHvm2Row2: EditText // H12
    private lateinit var tvHvm2Row3: TextView // I12

    // Combined VCM
    private lateinit var tvCombinedVcm: TextView // J13

    // 3RD LVM ROW
    private lateinit var etLvm3Row1: EditText // G14
    private lateinit var etLvm3Row2: EditText // H14
    private lateinit var tvLvm3Row3: TextView // I14

    // 3RD HVM ROW
    private lateinit var etHvm3Row1: EditText // G15
    private lateinit var etHvm3Row2: EditText // H15
    private lateinit var tvHvm3Row3: TextView // I15

    // Other inputs and outputs
    private lateinit var etSpecificHeat: EditText // J16
    private lateinit var tvKgFuelPerKgClinker: TextView // J17
    private lateinit var etViscosity: EditText // H18
    private lateinit var etDensity: EditText // J18
    private lateinit var tvAshAbsorbed: TextView // J19
    private lateinit var etAshContent: EditText // J20
    private lateinit var etFuelTph: EditText // J21
    private lateinit var etKilnFeedTph: EditText // J22
    private lateinit var etKilnFeedLoi: EditText // J23
    private lateinit var etKilnFeedH2o: EditText // J24
    private lateinit var etDustLossToSilo: EditText // J25
    private lateinit var etDustLossToSiloLoi: EditText // J26
    private lateinit var tvClinkerProductionTph: TextView // J27
    private lateinit var tvClinkerFactor: TextView // J28
    private lateinit var etKilnFeedTph2: EditText // J30
    private lateinit var etClinkerFactor2: EditText // J31
    private lateinit var tvClinkerProductionTph2: TextView // J32
    private lateinit var tvTphIdeal: TextView // J33
    private lateinit var tvCmh: TextView // J34

    private lateinit var dbHelper: SavedDataDbHelper
    private lateinit var btnSave: Button
    private lateinit var btnClear: Button

    private lateinit var allInputEditTexts: List<EditText>

    // Add tracking variables
    private var isDataModified = false
    private var currentSavedDataId: Long = -1L
    private var originalDataJson: String? = null

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            calculateAll()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Fuel & Clinker Factor"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page7)

        dbHelper = SavedDataDbHelper(this)
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        initializeViews()
        page7Cache()
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
        // 1ST LVM ROW
        etLvm1Row1 = findViewById(R.id.et_lvm1_row1) // H7
        etLvm1Row2 = findViewById(R.id.et_lvm1_row2) // I7
        tvLvm1Row3 = findViewById(R.id.tv_lvm1_row3) // J7

        // 1ST HVM ROW
        etHvm1Row1 = findViewById(R.id.et_hvm1_row1) // H8
        etHvm1Row2 = findViewById(R.id.et_hvm1_row2) // I8
        tvHvm1Row3 = findViewById(R.id.tv_hvm1_row3) // J8

        // Combined values
        tvCombinedFuel = findViewById(R.id.tv_combined_fuel) // J9
        tvCombinedAsh = findViewById(R.id.tv_combined_ash) // J10

        // 2ND LVM ROW
        etLvm2Row1 = findViewById(R.id.et_lvm2_row1) // G11
        etLvm2Row2 = findViewById(R.id.et_lvm2_row2) // H11
        tvLvm2Row3 = findViewById(R.id.tv_lvm2_row3) // I11

        // 2ND HVM ROW
        etHvm2Row1 = findViewById(R.id.et_hvm2_row1) // G12
        etHvm2Row2 = findViewById(R.id.et_hvm2_row2) // H12
        tvHvm2Row3 = findViewById(R.id.tv_hvm2_row3) // I12

        // Combined VCM
        tvCombinedVcm = findViewById(R.id.tv_combined_vcm) // J13

        // 3RD LVM ROW
        etLvm3Row1 = findViewById(R.id.et_lvm3_row1) // G14
        etLvm3Row2 = findViewById(R.id.et_lvm3_row2) // H14
        tvLvm3Row3 = findViewById(R.id.tv_lvm3_row3) // I14

        // 3RD HVM ROW
        etHvm3Row1 = findViewById(R.id.et_hvm3_row1) // G15
        etHvm3Row2 = findViewById(R.id.et_hvm3_row2) // H15
        tvHvm3Row3 = findViewById(R.id.tv_hvm3_row3) // I15

        // Other inputs and outputs
        etSpecificHeat = findViewById(R.id.et_specific_heat) // J16
        tvKgFuelPerKgClinker = findViewById(R.id.tv_kg_fuel_per_kg_clinker) // J17
        etViscosity = findViewById(R.id.et_viscosity) // H18
        etDensity = findViewById(R.id.et_density) // J18
        tvAshAbsorbed = findViewById(R.id.tv_ash_absorbed) // J19
        etAshContent = findViewById(R.id.et_ash_content) // J20
        etFuelTph = findViewById(R.id.et_fuel_tph) // J21
        etKilnFeedTph = findViewById(R.id.et_kiln_feed_tph) // J22
        etKilnFeedLoi = findViewById(R.id.et_kiln_feed_loi) // J23
        etKilnFeedH2o = findViewById(R.id.et_kiln_feed_h2o) // J24
        etDustLossToSilo = findViewById(R.id.et_dust_loss_to_silo) // J25
        etDustLossToSiloLoi = findViewById(R.id.et_dust_loss_to_silo_loi) // J26
        tvClinkerProductionTph = findViewById(R.id.tv_clinker_production_tph) // J27
        tvClinkerFactor = findViewById(R.id.tv_clinker_factor) // J28
        etKilnFeedTph2 = findViewById(R.id.et_kiln_feed_tph_2) // J30
        etClinkerFactor2 = findViewById(R.id.et_clinker_factor_2) // J31
        tvClinkerProductionTph2 = findViewById(R.id.tv_clinker_production_tph_2) // J32
        tvTphIdeal = findViewById(R.id.tv_tph_ideal) // J33
        tvCmh = findViewById(R.id.tv_cmh) // J34

        // Create list of all input EditTexts
        allInputEditTexts = listOf(
            etLvm1Row1, etLvm1Row2,
            etHvm1Row1, etHvm1Row2,
            etLvm2Row1, etLvm2Row2,
            etHvm2Row1, etHvm2Row2,
            etLvm3Row1, etLvm3Row2,
            etHvm3Row1, etHvm3Row2,
            etSpecificHeat, etViscosity, etDensity,
            etAshContent, etFuelTph, etKilnFeedTph,
            etKilnFeedLoi, etKilnFeedH2o,
            etDustLossToSilo, etDustLossToSiloLoi,
            etKilnFeedTph2,etClinkerFactor2
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

    private fun getPercentageValue(editText: EditText): Double {
        return getDoubleValue(editText) / 100.0
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
                "tv_clinker_factor", "tv_kg_fuel_per_kg_clinker" -> String.format(Locale.US, "%.3f", value)
                else -> String.format(Locale.US, "%.2f", value)
            }
            textView.text = formattedValue
        }
    }





    private fun calculateAll() {
        // 1ST LVM ROW
        val h7 = getPercentageValue(etLvm1Row1) // Convert percentage to decimal
        val i7 = getDoubleValue(etLvm1Row2)
        val j7 = i7 * h7

        // 1ST HVM ROW
        val h8 = getPercentageValue(etHvm1Row1) // Convert percentage to decimal
        val i8 = getDoubleValue(etHvm1Row2)
        val j8 = i8 * h8

        // Combined fuel
        val j9 = j7 + j8

        // 2ND LVM ROW
        val g11 = getDoubleValue(etLvm2Row1)
        val h11 = getPercentageValue(etLvm2Row2) // Convert percentage to decimal
        val i11 = g11 * h11

        // 2ND HVM ROW
        val g12 = getDoubleValue(etHvm2Row1)
        val h12 = getPercentageValue(etHvm2Row2) // Convert percentage to decimal
        val i12 = g12 * h12

        // Combined ash
        val j10 = i11 + i12

        // 3RD LVM ROW
        val g14 = getDoubleValue(etLvm3Row1)
        val h14 = getPercentageValue(etLvm3Row2) // Convert percentage to decimal
        val i14 = g14 * h14

        // 3RD HVM ROW
        val g15 = getDoubleValue(etHvm3Row1)
        val h15 = getPercentageValue(etHvm3Row2) // Convert percentage to decimal
        val i15 = g15 * h15

        // Combined VCM
        val j13 = i14 + i15

        // Other calculations
        val j16 = getDoubleValue(etSpecificHeat)
        val j17 = if (j9 == 0.0) 0.0 else j16 / j9
        val h18 = getDoubleValue(etViscosity)
        val j18 = getDoubleValue(etDensity)
        val j20 = getDoubleValue(etAshContent)
        val j19 = j20 * j17
        val j21 = getDoubleValue(etFuelTph)
        val j22 = getDoubleValue(etKilnFeedTph)
        val j23 = getDoubleValue(etKilnFeedLoi)
        val j24 = getDoubleValue(etKilnFeedH2o)
        val j25 = getDoubleValue(etDustLossToSilo)
        val j26 = getDoubleValue(etDustLossToSiloLoi)
        val j27 = j22 * (1 - j23/100) * (1 - j24/100) * (1 - j25/100) + (j21 * j20/100)
        val j28 = if (j27 == 0.0) 0.0 else j22 / j27

        val j30 = getDoubleValue(etKilnFeedTph2)
        val j31 = getDoubleValue(etClinkerFactor2) // Clinker factor is the same as j28
        val j32 = if (j31 == 0.0) 0.0 else (j30 / j31)
        val j33 = j32 * j17
        val j34 = if (j18 == 0.0) 0.0 else j33 / j18

        // Update UI with calculated values
        setTextViewValue(tvLvm1Row3, j7)
        setTextViewValue(tvHvm1Row3, j8)
        setTextViewValue(tvCombinedFuel, j9)
        setTextViewValue(tvLvm2Row3, i11)
        setTextViewValue(tvHvm2Row3, i12)
        setTextViewValue(tvCombinedAsh, j10)
        setTextViewValue(tvLvm3Row3, i14)
        setTextViewValue(tvHvm3Row3, i15)
        setTextViewValue(tvCombinedVcm, j13)
        setTextViewValue(tvKgFuelPerKgClinker, j17)
        setTextViewValue(tvAshAbsorbed, j19)
        setTextViewValue(tvClinkerProductionTph, j27)
        setTextViewValue(tvClinkerFactor, j28)
        setTextViewValue(tvClinkerProductionTph2, j32)
        setTextViewValue(tvTphIdeal, j33)
        setTextViewValue(tvCmh, j34)
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
                    dbHelper.saveData(7, data.toString(), if (saveName.isEmpty()) null else saveName)
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

    private fun page7Cache() {
        val fields = listOf(
            // 1st LVM and HVM Row
            Triple(etLvm1Row1, { Page7DataCache.Lvm1Row1 }, { v: Double -> Page7DataCache.Lvm1Row1 = v }),
            Triple(etLvm1Row2, { Page7DataCache.Lvm1Row2 }, { v: Double -> Page7DataCache.Lvm1Row2 = v }),
            Triple(etHvm1Row1, { Page7DataCache.Hvm1Row1 }, { v: Double -> Page7DataCache.Hvm1Row1 = v }),
            Triple(etHvm1Row2, { Page7DataCache.Hvm1Row2 }, { v: Double -> Page7DataCache.Hvm1Row2 = v }),

            // 2nd LVM and HVM Row
            Triple(etLvm2Row1, { Page7DataCache.Lvm2Row1 }, { v: Double -> Page7DataCache.Lvm2Row1 = v }),
            Triple(etLvm2Row2, { Page7DataCache.Lvm2Row2 }, { v: Double -> Page7DataCache.Lvm2Row2 = v }),
            Triple(etHvm2Row1, { Page7DataCache.Hvm2Row1 }, { v: Double -> Page7DataCache.Hvm2Row1 = v }),
            Triple(etHvm2Row2, { Page7DataCache.Hvm2Row2 }, { v: Double -> Page7DataCache.Hvm2Row2 = v }),

            // 3rd LVM and HVM Row
            Triple(etLvm3Row1, { Page7DataCache.Lvm3Row1 }, { v: Double -> Page7DataCache.Lvm3Row1 = v }),
            Triple(etLvm3Row2, { Page7DataCache.Lvm3Row2 }, { v: Double -> Page7DataCache.Lvm3Row2 = v }),
            Triple(etHvm3Row1, { Page7DataCache.Hvm3Row1 }, { v: Double -> Page7DataCache.Hvm3Row1 = v }),
            Triple(etHvm3Row2, { Page7DataCache.Hvm3Row2 }, { v: Double -> Page7DataCache.Hvm3Row2 = v }),

            // Other inputs
            Triple(etSpecificHeat, { Page7DataCache.SpecificHeat }, { v: Double -> Page7DataCache.SpecificHeat = v }),
            Triple(etViscosity, { Page7DataCache.Viscosity }, { v: Double -> Page7DataCache.Viscosity = v }),
            Triple(etDensity, { Page7DataCache.Density }, { v: Double -> Page7DataCache.Density = v }),
            Triple(etAshContent, { Page7DataCache.AshContent }, { v: Double -> Page7DataCache.AshContent = v }),

            Triple(etFuelTph, { Page7DataCache.FuelTph }, { v: Double -> Page7DataCache.FuelTph = v }),
            Triple(etKilnFeedTph, { Page7DataCache.KilnFeedTph }, { v: Double -> Page7DataCache.KilnFeedTph = v }),
            Triple(etKilnFeedLoi, { Page7DataCache.KilnFeedLoi }, { v: Double -> Page7DataCache.KilnFeedLoi = v }),
            Triple(etKilnFeedH2o, { Page7DataCache.KilnFeedH2o }, { v: Double -> Page7DataCache.KilnFeedH2o = v }),

            Triple(etDustLossToSilo, { Page7DataCache.DustLossToSilo }, { v: Double -> Page7DataCache.DustLossToSilo = v }),
            Triple(etDustLossToSiloLoi, { Page7DataCache.DustLossToSiloLoi }, { v: Double -> Page7DataCache.DustLossToSiloLoi = v }),
            Triple(etKilnFeedTph2, { Page7DataCache.KilnFeedTph2 }, { v: Double -> Page7DataCache.KilnFeedTph2 = v }),
            Triple(etClinkerFactor2, { Page7DataCache.ClinkerFactor2 }, { v: Double -> Page7DataCache.ClinkerFactor2 = v })
        )

        fields.forEach { (editText, getter, setter) ->
            editText.setText(getter().takeIf { it != 0.0 }?.toString() ?: "")  // Don't show 0.0 by default
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
