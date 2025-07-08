package com.example.rawmixapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.rawmixapp.db.SavedDataDbHelper
import org.json.JSONObject

class Page8Activity : BaseActivity() {
    // --- Main Table Inputs (IRON ORE, SHALE, SAND, LIMESTONE, COAL ASH) ---
    // IRON ORE
    private lateinit var etSiO2Iron: EditText // P12
    private lateinit var etAl2O3Iron: EditText // P13
    private lateinit var etFe2O3Iron: EditText // P14
    private lateinit var etCaOIron: EditText // P15
    private lateinit var etMgOIron: EditText // P16
    private lateinit var etK2OIron: EditText // P17
    private lateinit var etNa2OIron: EditText // P18
    private lateinit var etSO3Iron: EditText // P19
    private lateinit var etClIron: EditText // P20
    private lateinit var etLoiIron: EditText // P21
    private lateinit var etH2OIron: EditText // P22
    // SHALE
    private lateinit var etSiO2Shale: EditText // Q12
    private lateinit var etAl2O3Shale: EditText // Q13
    private lateinit var etFe2O3Shale: EditText // Q14
    private lateinit var etCaOShale: EditText // Q15
    private lateinit var etMgOShale: EditText // Q16
    private lateinit var etK2OShale: EditText // Q17
    private lateinit var etNa2OShale: EditText // Q18
    private lateinit var etSO3Shale: EditText // Q19
    private lateinit var etClShale: EditText // Q20
    private lateinit var etLoiShale: EditText // Q21
    private lateinit var etH2OShale: EditText // Q22
    // SAND
    private lateinit var etSiO2Sand: EditText // R12
    private lateinit var etAl2O3Sand: EditText // R13
    private lateinit var etFe2O3Sand: EditText // R14
    private lateinit var etCaOSand: EditText // R15
    private lateinit var etMgOSand: EditText // R16
    private lateinit var etK2OSand: EditText // R17
    private lateinit var etNa2OSand: EditText // R18
    private lateinit var etSO3Sand: EditText // R19
    private lateinit var etClSand: EditText // R20
    private lateinit var etLoiSand: EditText // R21
    private lateinit var etH2OSand: EditText // R22
    // LIMESTONE
    private lateinit var etSiO2Limestone: EditText // S12
    private lateinit var etAl2O3Limestone: EditText // S13
    private lateinit var etFe2O3Limestone: EditText // S14
    private lateinit var etCaOLimestone: EditText // S15
    private lateinit var etMgOLimestone: EditText // S16
    private lateinit var etK2OLimestone: EditText // S17
    private lateinit var etNa2OLimestone: EditText // S18
    private lateinit var etSO3Limestone: EditText // S19
    private lateinit var etClLimestone: EditText // S20
    private lateinit var etLoiLimestone: EditText // S21
    private lateinit var etH2OLimestone: EditText // S22
    // COAL ASH
    private lateinit var etSiO2CoalAsh: EditText // T12
    private lateinit var etAl2O3CoalAsh: EditText // T13
    private lateinit var etFe2O3CoalAsh: EditText // T14
    private lateinit var etCaOCoalAsh: EditText // T15
    private lateinit var etMgOCoalAsh: EditText // T16
    private lateinit var etK2OCoalAsh: EditText // T17
    private lateinit var etNa2OCoalAsh: EditText // T18
    private lateinit var etSO3CoalAsh: EditText // T19
    private lateinit var etClCoalAsh: EditText // T20
    private lateinit var etLoiCoalAsh: EditText // T21
    private lateinit var etH2OCoalAsh: EditText // T22

    // --- Rawmeal, CKR-ASH FREE, CKR w/ ASH, etc. ---
    // RAWMEAL (U12-U22 are calculated, U21/U22 are input)
    private lateinit var etLoiRawmeal: EditText // U21
    private lateinit var etH2ORawmeal: EditText // U22
    // % Ash Absorbed, Hotmeal SO3
    private lateinit var etAshAbsorbed: EditText // W40
    private lateinit var etHotmealSO3: EditText // W39
    // FCaO Result
    private lateinit var etFCaOResult: EditText // T40

    // --- Material Percentage (Weigh Feeder) ---
    private lateinit var tvLstDryBasis: TextView // P29
    private lateinit var tvShaleDryBasis: TextView // P30
    private lateinit var tvSandDryBasis: TextView // P31
    private lateinit var tvIronDryBasis: TextView // P32
    private lateinit var tvTotalDryBasis: TextView // P33
    private lateinit var tvLstWetBasis: TextView // Q29
    private lateinit var tvShaleWetBasis: TextView // Q30
    private lateinit var tvSandWetBasis: TextView // Q31
    private lateinit var tvIronWetBasis: TextView // Q32
    private lateinit var tvTotalWetBasis: TextView // Q33

    // --- Target ---
    private lateinit var etLsfTarget: EditText // P38
    private lateinit var etSmTarget: EditText // P39
    private lateinit var etAmTarget: EditText // P40

    // --- Control Range ---
    private lateinit var etMinColumns: Array<EditText> // S29-S39
    private lateinit var etMaxColumns: Array<EditText> // T29-T39

    // --- Clinker Analysis ---
    private lateinit var tvClinkerColumns: Array<TextView> // V28-V38
    private lateinit var tvRemarksColumns: Array<TextView> // W28-W38

    // --- Main Table Outputs (TOTAL, LSF, SM, AM, etc.) ---
    // For each column, arrays for TOTAL, LSF, SM, AM
    private lateinit var tvTotal: Array<TextView> // P23, Q23, R23, S23, T23, U23, V23, W23
    private lateinit var tvLsf: Array<TextView> // P24, Q24, R24, S24, T24, U24, V24, W24
    private lateinit var tvSm: Array<TextView> // P25, Q25, R25, S25, T25, U25, V25, W25
    private lateinit var tvAm: Array<TextView> // P26, Q26, R26, S26, T26, U26, V26, W26

    // --- Main Table Outputs (RAWMEAL, CKR-ASH FREE, CKR w/ ASH) ---
    // For each row (SiO2, Al2O3, ...), arrays for each column
    private lateinit var tvRawmeal: Array<TextView> // U12-U20
    private lateinit var tvCkrAshFree: Array<TextView> // V12-V20
    private lateinit var tvCkrWithAsh: Array<TextView> // W12-W20

    // --- All EditText for input tracking ---
    private lateinit var allInputEditTexts: List<EditText>

    private lateinit var dbHelper: SavedDataDbHelper
    private var isDataModified = false
    private var currentSavedDataId: Long = -1L
    private var originalDataJson: String? = null
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            if (currentSavedDataId != -1L) isDataModified = true
            calculateAll()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Raw Mix Design"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page8)

        dbHelper = SavedDataDbHelper(this)
        // --- Initialize all views ---
        initializeViews()
        Page8Cache()
        setupTextWatchers()
        calculateAll()
        findViewById<Button>(R.id.btn_clear).setOnClickListener { clearAllData() }
        findViewById<Button>(R.id.btn_save).setOnClickListener { saveCurrentData() }

        // Load saved data if present
        val savedDataId = intent.getLongExtra("saved_data_id", -1)
        if (savedDataId != -1L) {
            loadSavedData(savedDataId)
        }
    }

    private fun initializeViews() {
        // IRON ORE
        etSiO2Iron = findViewById(R.id.sio2_iron_p12)
        etAl2O3Iron = findViewById(R.id.al2o3_iron_p13)
        etFe2O3Iron = findViewById(R.id.fe2o3_iron_p14)
        etCaOIron = findViewById(R.id.cao_iron_p15)
        etMgOIron = findViewById(R.id.mgo_iron_p16)
        etK2OIron = findViewById(R.id.k2o_iron_p17)
        etNa2OIron = findViewById(R.id.na2o_iron_p18)
        etSO3Iron = findViewById(R.id.so3_iron_p19)
        etClIron = findViewById(R.id.cl_iron_p20)
        etLoiIron = findViewById(R.id.loi_iron_p21)
        etH2OIron = findViewById(R.id.h2o_iron_p22)
        // SHALE
        etSiO2Shale = findViewById(R.id.sio2_shale_q12)
        etAl2O3Shale = findViewById(R.id.al2o3_shale_q13)
        etFe2O3Shale = findViewById(R.id.fe2o3_shale_q14)
        etCaOShale = findViewById(R.id.cao_shale_q15)
        etMgOShale = findViewById(R.id.mgo_shale_q16)
        etK2OShale = findViewById(R.id.k2o_shale_q17)
        etNa2OShale = findViewById(R.id.na2o_shale_q18)
        etSO3Shale = findViewById(R.id.so3_shale_q19)
        etClShale = findViewById(R.id.cl_shale_q20)
        etLoiShale = findViewById(R.id.loi_shale_q21)
        etH2OShale = findViewById(R.id.h2o_shale_q22)
        // SAND
        etSiO2Sand = findViewById(R.id.sio2_sand_r12)
        etAl2O3Sand = findViewById(R.id.al2o3_sand_r13)
        etFe2O3Sand = findViewById(R.id.fe2o3_sand_r14)
        etCaOSand = findViewById(R.id.cao_sand_r15)
        etMgOSand = findViewById(R.id.mgo_sand_r16)
        etK2OSand = findViewById(R.id.k2o_sand_r17)
        etNa2OSand = findViewById(R.id.na2o_sand_r18)
        etSO3Sand = findViewById(R.id.so3_sand_r19)
        etClSand = findViewById(R.id.cl_sand_r20)
        etLoiSand = findViewById(R.id.loi_sand_r21)
        etH2OSand = findViewById(R.id.h2o_sand_r22)
        // LIMESTONE
        etSiO2Limestone = findViewById(R.id.sio2_limestone_s12)
        etAl2O3Limestone = findViewById(R.id.al2o3_limestone_s13)
        etFe2O3Limestone = findViewById(R.id.fe2o3_limestone_s14)
        etCaOLimestone = findViewById(R.id.cao_limestone_s15)
        etMgOLimestone = findViewById(R.id.mgo_limestone_s16)
        etK2OLimestone = findViewById(R.id.k2o_limestone_s17)
        etNa2OLimestone = findViewById(R.id.na2o_limestone_s18)
        etSO3Limestone = findViewById(R.id.so3_limestone_s19)
        etClLimestone = findViewById(R.id.cl_limestone_s20)
        etLoiLimestone = findViewById(R.id.loi_limestone_s21)
        etH2OLimestone = findViewById(R.id.h2o_limestone_s22)
        // COAL ASH
        etSiO2CoalAsh = findViewById(R.id.sio2_coal_ash_t12)
        etAl2O3CoalAsh = findViewById(R.id.al2o3_coal_ash_t13)
        etFe2O3CoalAsh = findViewById(R.id.fe2o3_coal_ash_t14)
        etCaOCoalAsh = findViewById(R.id.cao_coal_ash_t15)
        etMgOCoalAsh = findViewById(R.id.mgo_coal_ash_t16)
        etK2OCoalAsh = findViewById(R.id.k2o_coal_ash_t17)
        etNa2OCoalAsh = findViewById(R.id.na2o_coal_ash_t18)
        etSO3CoalAsh = findViewById(R.id.so3_coal_ash_t19)
        etClCoalAsh = findViewById(R.id.cl_coal_ash_t20)
        etLoiCoalAsh = findViewById(R.id.loi_coal_ash_t21)
        etH2OCoalAsh = findViewById(R.id.h2o_coal_ash_t22)
        // RAWMEAL, CKR-ASH FREE, CKR w/ ASH, etc.
        etLoiRawmeal = findViewById(R.id.loi_rawmeal_u21)
        etH2ORawmeal = findViewById(R.id.h2o_rawmeal_u22)
        etAshAbsorbed = findViewById(R.id.ash_absorbed_w40)
        etHotmealSO3 = findViewById(R.id.hotmeal_so3_w39)
        etFCaOResult = findViewById(R.id.fcao_result_t40)
        // Material Percentage (Weigh Feeder)
        tvLstDryBasis = findViewById(R.id.lst_dry_basis_p29)
        tvShaleDryBasis = findViewById(R.id.shale_dry_basis_p30)
        tvSandDryBasis = findViewById(R.id.sand_dry_basis_p31)
        tvIronDryBasis = findViewById(R.id.iron_dry_basis_p32)
        tvTotalDryBasis = findViewById(R.id.total_dry_basis_p33)
        tvLstWetBasis = findViewById(R.id.lst_wet_basis_q29)
        tvShaleWetBasis = findViewById(R.id.shale_wet_basis_q30)
        tvSandWetBasis = findViewById(R.id.sand_wet_basis_q31)
        tvIronWetBasis = findViewById(R.id.iron_wet_basis_q32)
        tvTotalWetBasis = findViewById(R.id.total_wet_basis_q33)
        // Target
        etLsfTarget = findViewById(R.id.lsf_target_p38)
        etSmTarget = findViewById(R.id.sm_target_p39)
        etAmTarget = findViewById(R.id.am_target_p40)
        // Control Range
        etMinColumns = arrayOf(
            findViewById(R.id.min_column1_s29), findViewById(R.id.min_column2_s30), findViewById(R.id.min_column3_s31),
            findViewById(R.id.min_column4_s32), findViewById(R.id.min_column5_s33), findViewById(R.id.min_column6_s34),
            findViewById(R.id.min_column7_s35), findViewById(R.id.min_column8_s36), findViewById(R.id.min_column9_s37),
            findViewById(R.id.min_column10_s38), findViewById(R.id.min_column11_s39)
        )
        etMaxColumns = arrayOf(
            findViewById(R.id.max_column1_t29), findViewById(R.id.max_column2_t30), findViewById(R.id.max_column3_t31),
            findViewById(R.id.max_column4_t32), findViewById(R.id.max_column5_t33), findViewById(R.id.max_column6_t34),
            findViewById(R.id.max_column7_t35), findViewById(R.id.max_column8_t36), findViewById(R.id.max_column9_t37),
            findViewById(R.id.max_column10_t38), findViewById(R.id.max_column11_t39)
        )
        // Clinker Analysis
        tvClinkerColumns = arrayOf(
            findViewById(R.id.clinker_column1_v28), findViewById(R.id.clinker_column2_v29), findViewById(R.id.clinker_column3_v30),
            findViewById(R.id.clinker_column4_v31), findViewById(R.id.clinker_column5_v32), findViewById(R.id.clinker_column6_v33),
            findViewById(R.id.clinker_column7_v34), findViewById(R.id.clinker_column8_v35), findViewById(R.id.clinker_column9_v36),
            findViewById(R.id.clinker_column10_v37), findViewById(R.id.clinker_column11_v38)
        )
        tvRemarksColumns = arrayOf(
            findViewById(R.id.remarks_column1_w28), findViewById(R.id.remarks_column2_w29), findViewById(R.id.remarks_column3_w30),
            findViewById(R.id.remarks_column4_w31), findViewById(R.id.remarks_column5_w32), findViewById(R.id.remarks_column6_w33),
            findViewById(R.id.remarks_column7_w34), findViewById(R.id.remarks_column8_w35), findViewById(R.id.remarks_column9_w36),
            findViewById(R.id.remarks_column10_w37), findViewById(R.id.remarks_column11_w38)
        )
        // Main Table Outputs (TOTAL, LSF, SM, AM)
        tvTotal = arrayOf(
            findViewById(R.id.total_iron_p23), findViewById(R.id.total_shale_q23), findViewById(R.id.total_sand_r23),
            findViewById(R.id.total_limestone_s23), findViewById(R.id.total_coal_ash_t23), findViewById(R.id.total_rawmeal_u23),
            findViewById(R.id.total_ckrashfree_v23), findViewById(R.id.total_ckwithash_w23)
        )
        tvLsf = arrayOf(
            findViewById(R.id.lsf_iron_p24), findViewById(R.id.lsf_shale_q24), findViewById(R.id.lsf_sand_r24),
            findViewById(R.id.lsf_limestone_s24), findViewById(R.id.lsf_coal_ash_t24), findViewById(R.id.lsf_rawmeal_u24),
            findViewById(R.id.lsf_ckrashfree_v24), findViewById(R.id.lsf_ckwithash_w24)
        )
        tvSm = arrayOf(
            findViewById(R.id.sm_iron_p25), findViewById(R.id.sm_shale_q25), findViewById(R.id.sm_sand_r25),
            findViewById(R.id.sm_limestone_s25), findViewById(R.id.sm_coal_ash_t25), findViewById(R.id.sm_rawmeal_u25),
            findViewById(R.id.sm_ckrashfree_v25), findViewById(R.id.sm_ckwithash_w25)
        )
        tvAm = arrayOf(
            findViewById(R.id.am_iron_p26), findViewById(R.id.am_shale_q26), findViewById(R.id.am_sand_r26),
            findViewById(R.id.am_limestone_s26), findViewById(R.id.am_coal_ash_t26), findViewById(R.id.am_rawmeal_u26),
            findViewById(R.id.am_ckrashfree_v26), findViewById(R.id.am_ckwithash_w26)
        )
        // Main Table Outputs (RAWMEAL, CKR-ASH FREE, CKR w/ ASH)
        tvRawmeal = arrayOf(
            findViewById(R.id.sio2_rawmeal_u12), findViewById(R.id.al2o3_rawmeal_u13), findViewById(R.id.fe2o3_rawmeal_u14),
            findViewById(R.id.cao_rawmeal_u15), findViewById(R.id.mgo_rawmeal_u16), findViewById(R.id.k2o_rawmeal_u17),
            findViewById(R.id.na2o_rawmeal_u18), findViewById(R.id.so3_rawmeal_u19), findViewById(R.id.cl_rawmeal_u20)
        )
        tvCkrAshFree = arrayOf(
            findViewById(R.id.sio2_ckrashfree_v12), findViewById(R.id.al2o3_ckrashfree_v13), findViewById(R.id.fe2o3_ckrashfree_v14),
            findViewById(R.id.cao_ckrashfree_v15), findViewById(R.id.mgo_ckrashfree_v16), findViewById(R.id.k2o_ckrashfree_v17),
            findViewById(R.id.na2o_ckrashfree_v18), findViewById(R.id.so3_ckrashfree_v19), findViewById(R.id.cl_ckrashfree_v20)
        )
        tvCkrWithAsh = arrayOf(
            findViewById(R.id.sio2_ckwithash_w12), findViewById(R.id.al2o3_ckwithash_w13), findViewById(R.id.fe2o3_ckwithash_w14),
            findViewById(R.id.cao_ckwithash_w15), findViewById(R.id.mgo_ckwithash_w16), findViewById(R.id.k2o_ckwithash_w17),
            findViewById(R.id.na2o_ckwithash_w18), findViewById(R.id.so3_ckwithash_w19), findViewById(R.id.cl_ckwithash_w20)
        )
        // All input EditTexts for tracking
        allInputEditTexts = listOf(
            etSiO2Iron, etAl2O3Iron, etFe2O3Iron, etCaOIron, etMgOIron, etK2OIron, etNa2OIron, etSO3Iron, etClIron, etLoiIron, etH2OIron,
            etSiO2Shale, etAl2O3Shale, etFe2O3Shale, etCaOShale, etMgOShale, etK2OShale, etNa2OShale, etSO3Shale, etClShale, etLoiShale, etH2OShale,
            etSiO2Sand, etAl2O3Sand, etFe2O3Sand, etCaOSand, etMgOSand, etK2OSand, etNa2OSand, etSO3Sand, etClSand, etLoiSand, etH2OSand,
            etSiO2Limestone, etAl2O3Limestone, etFe2O3Limestone, etCaOLimestone, etMgOLimestone, etK2OLimestone, etNa2OLimestone, etSO3Limestone, etClLimestone, etLoiLimestone, etH2OLimestone,
            etSiO2CoalAsh, etAl2O3CoalAsh, etFe2O3CoalAsh, etCaOCoalAsh, etMgOCoalAsh, etK2OCoalAsh, etNa2OCoalAsh, etSO3CoalAsh, etClCoalAsh, etLoiCoalAsh, etH2OCoalAsh,
            etLoiRawmeal, etH2ORawmeal, etAshAbsorbed, etHotmealSO3, etFCaOResult,
            etLsfTarget, etSmTarget, etAmTarget
        ) + etMinColumns.toList() + etMaxColumns.toList()
    }

    private fun setupTextWatchers() {
        allInputEditTexts.forEach { editText ->
            editText.addTextChangedListener(textWatcher)
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
                "lst_dry_basis_p29", "shale_dry_basis_p30","sand_dry_basis_p31","iron_dry_basis_p32","total_dry_basis_p33"
                    ,"lst_wet_basis_q29","shale_wet_basis_q30","sand_wet_basis_q31","iron_wet_basis_q32","total_wet_basis_q33"->

                    String.format(Locale.US, "%.1f", value)
                else ->
                    String.format(Locale.US, "%.2f", value)
            }

            textView.text = formattedValue
        }
    }

    private fun calculateAll() {
        // --- Read all input values ---
        // IRON ORE
        val p12 = getDoubleValue(etSiO2Iron)
        val p13 = getDoubleValue(etAl2O3Iron)
        val p14 = getDoubleValue(etFe2O3Iron)
        val p15 = getDoubleValue(etCaOIron)
        val p16 = getDoubleValue(etMgOIron)
        val p17 = getDoubleValue(etK2OIron)
        val p18 = getDoubleValue(etNa2OIron)
        val p19 = getDoubleValue(etSO3Iron)
        val p20 = getDoubleValue(etClIron)
        val p21 = getDoubleValue(etLoiIron)
        val p22 = getDoubleValue(etH2OIron)
        // SHALE
        val q12 = getDoubleValue(etSiO2Shale)
        val q13 = getDoubleValue(etAl2O3Shale)
        val q14 = getDoubleValue(etFe2O3Shale)
        val q15 = getDoubleValue(etCaOShale)
        val q16 = getDoubleValue(etMgOShale)
        val q17 = getDoubleValue(etK2OShale)
        val q18 = getDoubleValue(etNa2OShale)
        val q19 = getDoubleValue(etSO3Shale)
        val q20 = getDoubleValue(etClShale)
        val q21 = getDoubleValue(etLoiShale)
        val q22 = getDoubleValue(etH2OShale)
        // SAND
        val r12 = getDoubleValue(etSiO2Sand)
        val r13 = getDoubleValue(etAl2O3Sand)
        val r14 = getDoubleValue(etFe2O3Sand)
        val r15 = getDoubleValue(etCaOSand)
        val r16 = getDoubleValue(etMgOSand)
        val r17 = getDoubleValue(etK2OSand)
        val r18 = getDoubleValue(etNa2OSand)
        val r19 = getDoubleValue(etSO3Sand)
        val r20 = getDoubleValue(etClSand)
        val r21 = getDoubleValue(etLoiSand)
        val r22 = getDoubleValue(etH2OSand)
        // LIMESTONE
        val s12 = getDoubleValue(etSiO2Limestone)
        val s13 = getDoubleValue(etAl2O3Limestone)
        val s14 = getDoubleValue(etFe2O3Limestone)
        val s15 = getDoubleValue(etCaOLimestone)
        val s16 = getDoubleValue(etMgOLimestone)
        val s17 = getDoubleValue(etK2OLimestone)
        val s18 = getDoubleValue(etNa2OLimestone)
        val s19 = getDoubleValue(etSO3Limestone)
        val s20 = getDoubleValue(etClLimestone)
        val s21 = getDoubleValue(etLoiLimestone)
        val s22 = getDoubleValue(etH2OLimestone)
        // COAL ASH
        val t12 = getDoubleValue(etSiO2CoalAsh)
        val t13 = getDoubleValue(etAl2O3CoalAsh)
        val t14 = getDoubleValue(etFe2O3CoalAsh)
        val t15 = getDoubleValue(etCaOCoalAsh)
        val t16 = getDoubleValue(etMgOCoalAsh)
        val t17 = getDoubleValue(etK2OCoalAsh)
        val t18 = getDoubleValue(etNa2OCoalAsh)
        val t19 = getDoubleValue(etSO3CoalAsh)
        val t20 = getDoubleValue(etClCoalAsh)
        val t21 = getDoubleValue(etLoiCoalAsh)
        val t22 = getDoubleValue(etH2OCoalAsh)
        // RAWMEAL
        val u21 = getDoubleValue(etLoiRawmeal)
        val u22 = getDoubleValue(etH2ORawmeal)
        // % Ash Absorbed, Hotmeal SO3, FCaO Result
        val w40 = getDoubleValue(etAshAbsorbed) / 100.0
        val w39 = getDoubleValue(etHotmealSO3)
        val t40 = getDoubleValue(etFCaOResult)
        // Target
        val p38 = getDoubleValue(etLsfTarget)
        val p39 = getDoubleValue(etSmTarget)
        val p40 = getDoubleValue(etAmTarget)
        // Control Range
        val s29 = getDoubleValue(etMinColumns[0])
        val s30 = getDoubleValue(etMinColumns[1])
        val s31 = getDoubleValue(etMinColumns[2])
        val s32 = getDoubleValue(etMinColumns[3])
        val s33 = getDoubleValue(etMinColumns[4])
        val s34 = getDoubleValue(etMinColumns[5])
        val s35 = getDoubleValue(etMinColumns[6])
        val s36 = getDoubleValue(etMinColumns[7])
        val s37 = getDoubleValue(etMinColumns[8])
        val s38 = getDoubleValue(etMinColumns[9])
        val s39 = getDoubleValue(etMinColumns[10])
        val t29 = getDoubleValue(etMaxColumns[0])
        val t30 = getDoubleValue(etMaxColumns[1])
        val t31 = getDoubleValue(etMaxColumns[2])
        val t32 = getDoubleValue(etMaxColumns[3])
        val t33 = getDoubleValue(etMaxColumns[4])
        val t34 = getDoubleValue(etMaxColumns[5])
        val t35 = getDoubleValue(etMaxColumns[6])
        val t36 = getDoubleValue(etMaxColumns[7])
        val t37 = getDoubleValue(etMaxColumns[8])
        val t38 = getDoubleValue(etMaxColumns[9])
        val t39 = getDoubleValue(etMaxColumns[10])

        // --- MAIN TABLE CALCULATIONS ---
        // IRON ORE
        val totalIron = p12 + p13 + p14 + p15 + p16 + p17 + p18 + p19 + p20 + p21
        setTextViewValue(tvTotal[0], totalIron)
        val lsfIron = if ((2.8 * p12 + 1.18 * p13 + 0.65 * p14) != 0.0) 100 * p15 / (2.8 * p12 + 1.18 * p13 + 0.65 * p14) else 0.0
        setTextViewValue(tvLsf[0], lsfIron)
        val smIron = if ((p13 + p14) != 0.0) p12 / (p13 + p14) else 0.0
        setTextViewValue(tvSm[0], smIron)
        val amIron = if (p14 != 0.0) p13 / p14 else 0.0
        setTextViewValue(tvAm[0], amIron)
        // SHALE
        val totalShale = q12 + q13 + q14 + q15 + q16 + q17 + q18 + q19 + q20 + q21
        setTextViewValue(tvTotal[1], totalShale)
        val lsfShale = if ((2.8 * q12 + 1.18 * q13 + 0.65 * q14) != 0.0) 100 * q15 / (2.8 * q12 + 1.18 * q13 + 0.65 * q14) else 0.0
        setTextViewValue(tvLsf[1], lsfShale)
        val smShale = if ((q13 + q14) != 0.0) q12 / (q13 + q14) else 0.0
        setTextViewValue(tvSm[1], smShale)
        val amShale = if (q14 != 0.0) q13 / q14 else 0.0
        setTextViewValue(tvAm[1], amShale)
        // SAND
        val totalSand = r12 + r13 + r14 + r15 + r16 + r17 + r18 + r19 + r20 + r21
        setTextViewValue(tvTotal[2], totalSand)
        val lsfSand = if ((2.8 * r12 + 1.18 * r13 + 0.65 * r14) != 0.0) 100 * r15 / (2.8 * r12 + 1.18 * r13 + 0.65 * r14) else 0.0
        setTextViewValue(tvLsf[2], lsfSand)
        val smSand = if ((r13 + r14) != 0.0) r12 / (r13 + r14) else 0.0
        setTextViewValue(tvSm[2], smSand)
        val amSand = if (r14 != 0.0) r13 / r14 else 0.0
        setTextViewValue(tvAm[2], amSand)
        // LIMESTONE
        val totalLimestone = s12 + s13 + s14 + s15 + s16 + s17 + s18 + s19 + s20 + s21
        setTextViewValue(tvTotal[3], totalLimestone)
        val lsfLimestone = if ((2.8 * s12 + 1.18 * s13 + 0.65 * s14) != 0.0) 100 * s15 / (2.8 * s12 + 1.18 * s13 + 0.65 * s14) else 0.0
        setTextViewValue(tvLsf[3], lsfLimestone)
        val smLimestone = if ((s13 + s14) != 0.0) s12 / (s13 + s14) else 0.0
        setTextViewValue(tvSm[3], smLimestone)
        val amLimestone = if (s14 != 0.0) s13 / s14 else 0.0
        setTextViewValue(tvAm[3], amLimestone)
        // COAL ASH
        val totalCoalAsh = t12 + t13 + t14 + t15 + t16 + t17 + t18 + t19 + t20 + t21 + t22
        setTextViewValue(tvTotal[4], totalCoalAsh)
        val lsfCoalAsh = if ((2.8 * t12 + 1.18 * t13 + 0.65 * t14) != 0.0) 100 * t15 / (2.8 * t12 + 1.18 * t13 + 0.65 * t14) else 0.0
        setTextViewValue(tvLsf[4], lsfCoalAsh)
        val smCoalAsh = if ((t13 + t14) != 0.0) t12 / (t13 + t14) else 0.0
        setTextViewValue(tvSm[4], smCoalAsh)
        val amCoalAsh = if (t14 != 0.0) t13 / t14 else 0.0
        setTextViewValue(tvAm[4], amCoalAsh)

        // --- RAWMEAL COLUMN (U12-U20) ---
        // Material Percentage (Weigh Feeder) - Dry Basis (P29-P32)
        // Hidden Table: Coefficients and Determinants
        val q44 = 1.0
        val q45 = 1.0
        val q46 = 1.0
        val q47 = 1.0
        val q48 = 100.0
        val q49 = p40 * s14 - s13
        val q50 = p40 * r14 - r13
        val q51 = p40 * p14 - p13
        val q52 = p40 * q14 - q13
        val q53 = p39 * s13 + p39 * s14 - s12
        val q54 = p39 * r13 + p39 * r14 - r12
        val q55 = p39 * p13 + p39 * p14 - p12
        val q56 = p39 * q13 + p39 * q14 - q12
        val q57 = p38 * 2.8 * s12 + p38 * 1.18 * s13 + p38 * 0.65 * s14 - 100 * s15
        val q58 = p38 * 2.8 * r12 + p38 * 1.18 * r13 + p38 * 0.65 * r14 - 100 * r15
        val q59 = p38 * 2.8 * p12 + p38 * 1.18 * p13 + p38 * 0.65 * p14 - 100 * p15
        val q60 = p38 * 2.8 * q12 + p38 * 1.18 * q13 + p38 * 0.65 * q14 - 100 * q15
        val q62 = (q48 * q50 * q55 * q60) + (q48 * q51 * q56 * q58) + (q48 * q52 * q54 * q59) - (q48 * q52 * q55 * q58) - (q48 * q50 * q56 * q59) - (q48 * q51 * q54 * q60)
        val q63 = -q49 * q48 * q55 * q60 + q49 * q48 * q56 * q59 + q53 * q48 * q51 * q60 - q53 * q48 * q52 * q59 - q57 * q48 * q51 * q56 + q57 * q48 * q52 * q55
        val q64 = -q49 * q48 * q56 * q58 + q49 * q48 * q54 * q60 + q53 * q48 * q52 * q58 - q53 * q48 * q50 * q60 - q57 * q48 * q52 * q54 + q57 * q48 * q50 * q56
        val q65 = -q49 * q48 * q54 * q59 + q49 * q48 * q55 * q58 + q53 * q48 * q50 * q59 - q53 * q48 * q51 * q58 - q57 * q48 * q50 * q55 + q57 * q48 * q51 * q54
        val q66 = (q50 * q55 * q60) + (q51 * q56 * q58) + (q52 * q54 * q59) - (q52 * q55 * q58) - (q50 * q56 * q59) - (q51 * q54 * q60) - (q49 * q55 * q60) - (q49 * q56 * q58) - (q49 * q54 * q59) + (q49 * q55 * q58) + (q49 * q56 * q59) + (q49 * q54 * q60) + (q53 * q51 * q60) + (q53 * q52 * q58) + (q53 * q50 * q59) - (q53 * q51 * q58) - (q53 * q52 * q59) - (q53 * q50 * q60) - (q57 * q51 * q56) - (q57 * q52 * q54) - (q57 * q50 * q55) + (q57 * q51 * q54) + (q57 * q52 * q55) + (q57 * q50 * q56)
        // Dry Basis
        val p29 = if (q66 != 0.0) q62 / q66 else 0.0
        val p30 = if (q66 != 0.0) q65 / q66 else 0.0
        val p31 = if (q66 != 0.0) q63 / q66 else 0.0
        val p32 = if (q66 != 0.0) q64 / q66 else 0.0
        setTextViewValue(tvLstDryBasis, p29)
        setTextViewValue(tvShaleDryBasis, p30)
        setTextViewValue(tvSandDryBasis, p31)
        setTextViewValue(tvIronDryBasis, p32)
        val p33 = p29 + p30 + p31 + p32
        setTextViewValue(tvTotalDryBasis, p33)
        // Wet Basis
        val r44 = if ((1 - s22 / 100.0) != 0.0) p29 / (1 - s22 / 100.0) else 0.0
        val r45 = if ((1 - q22 / 100.0) != 0.0) p30 / (1 - q22 / 100.0) else 0.0
        val r46 = if ((1 - r22 / 100.0) != 0.0) p31 / (1 - r22 / 100.0) else 0.0
        val r47 = if ((1 - p22 / 100.0) != 0.0) p32 / (1 - p22 / 100.0) else 0.0
        val r48 = r45 + r46 + r47 + r44
        val r49 = if (r48 != 0.0) p33 / r48 else 0.0
        val q29 = r44 * r49
        val q30 = r45 * r49
        val q31 = r46 * r49
        val q32 = r47 * r49
        setTextViewValue(tvLstWetBasis, q29)
        setTextViewValue(tvShaleWetBasis, q30)
        setTextViewValue(tvSandWetBasis, q31)
        setTextViewValue(tvIronWetBasis, q32)
        val q33 = q29 + q30 + q31 + q32
        setTextViewValue(tvTotalWetBasis, q33)

        // --- RAWMEAL COLUMN (U12-U20) ---
        val u12 = (p29 * s12 + p31 * r12 + p32 * p12 + p30 * q12) / p33
        val u13 = (p29 * s13 + p31 * r13 + p32 * p13 + p30 * q13) / p33
        val u14 = (p29 * s14 + p31 * r14 + p32 * p14 + p30 * q14) / p33
        val u15 = (p29 * s15 + p31 * r15 + p32 * p15 + p30 * q15) / p33
        val u16 = (p29 * s16 + p31 * r16 + p32 * p16 + p30 * q16) / p33
        val u17 = (p29 * s17 + p31 * r17 + p32 * p17 + p30 * q17) / p33
        val u18 = (p29 * s18 + p31 * r18 + p32 * p18 + p30 * q18) / p33
        val u19 = (p29 * s19 + p31 * r19 + p32 * p19 + p30 * q19) / p33
        val u20 = (p29 * s20 + p31 * r20 + p32 * p20 + p30 * q20) / p33
        setTextViewValue(tvRawmeal[0], u12)
        setTextViewValue(tvRawmeal[1], u13)
        setTextViewValue(tvRawmeal[2], u14)
        setTextViewValue(tvRawmeal[3], u15)
        setTextViewValue(tvRawmeal[4], u16)
        setTextViewValue(tvRawmeal[5], u17)
        setTextViewValue(tvRawmeal[6], u18)
        setTextViewValue(tvRawmeal[7], u19)
        setTextViewValue(tvRawmeal[8], u20)
        val u21_ = u21 // input
        val u22_ = u22 // input
        val totalRawmeal = u12 + u13 + u14 + u15 + u16 + u17 + u18 + u19 + u20 + u21_ +u22_
        setTextViewValue(tvTotal[5], totalRawmeal)
        val lsfRawmeal = if ((2.8 * u12 + 1.18 * u13 + 0.65 * u14) != 0.0) 100 * u15 / (2.8 * u12 + 1.18 * u13 + 0.65 * u14) else 0.0
        setTextViewValue(tvLsf[5], lsfRawmeal)
        val smRawmeal = if ((u13 + u14) != 0.0) u12 / (u13 + u14) else 0.0
        setTextViewValue(tvSm[5], smRawmeal)
        val amRawmeal = if (u14 != 0.0) u13 / u14 else 0.0
        setTextViewValue(tvAm[5], amRawmeal)

        // --- CKR-ASH FREE COLUMN (V12-V20) ---
        val v12 = if ((1 - u21_ / 100.0) != 0.0) u12 / (1 - u21_ / 100.0) else 0.0
        val v13 = if ((1 - u21_ / 100.0) != 0.0) u13 / (1 - u21_ / 100.0) else 0.0
        val v14 = if ((1 - u21_ / 100.0) != 0.0) u14 / (1 - u21_ / 100.0) else 0.0
        val v15 = if ((1 - u21_ / 100.0) != 0.0) u15 / (1 - u21_ / 100.0) else 0.0
        val v16 = if ((1 - u21_ / 100.0) != 0.0) u16 / (1 - u21_ / 100.0) else 0.0
        val v17 = if ((1 - u21_ / 100.0) != 0.0) u17 / (1 - u21_ / 100.0) else 0.0
        val v18 = if ((1 - u21_ / 100.0) != 0.0) u18 / (1 - u21_ / 100.0) else 0.0
        val v19 = if ((1 - u21_ / 100.0) != 0.0) u19 / (1 - u21_ / 100.0) else 0.0
        val v20 = if ((1 - u21_ / 100.0) != 0.0) u20 / (1 - u21_ / 100.0) else 0.0
        setTextViewValue(tvCkrAshFree[0], v12)
        setTextViewValue(tvCkrAshFree[1], v13)
        setTextViewValue(tvCkrAshFree[2], v14)
        setTextViewValue(tvCkrAshFree[3], v15)
        setTextViewValue(tvCkrAshFree[4], v16)
        setTextViewValue(tvCkrAshFree[5], v17)
        setTextViewValue(tvCkrAshFree[6], v18)
        setTextViewValue(tvCkrAshFree[7], v19)
        setTextViewValue(tvCkrAshFree[8], v20)
        val totalCkrAshFree = v12 + v13 + v14 + v15 + v16 + v17 + v18 + v19 + v20
        setTextViewValue(tvTotal[6], totalCkrAshFree)
        val lsfCkrAshFree = if ((2.8 * v12 + 1.18 * v13 + 0.65 * v14) != 0.0) 100 * v15 / (2.8 * v12 + 1.18 * v13 + 0.65 * v14) else 0.0
        setTextViewValue(tvLsf[6], lsfCkrAshFree)
        val smCkrAshFree = if ((v13 + v14) != 0.0) v12 / (v13 + v14) else 0.0
        setTextViewValue(tvSm[6], smCkrAshFree)
        val amCkrAshFree = if (v14 != 0.0) v13 / v14 else 0.0
        setTextViewValue(tvAm[6], amCkrAshFree)

        // --- CKR w/ ASH COLUMN (W12-W20) ---
        val w12 = v12 * (1 - w40) + (t12 * w40)
        val w13 = v13 * (1 - w40) + (t13 * w40)
        val w14 = v14 * (1 - w40) + (t14 * w40)
        val w15 = v15 * (1 - w40) + (t15 * w40)
        val w16 = v16 * (1 - w40) + (t16 * w40)
        val w17 = v17 * (1 - w40) + (t17 * w40)
        val w18 = v18 * (1 - w40) + (t18 * w40)
        val w19 = v19 * (1 - w40) + (t19 * w40)
        val w20 = v20 * (1 - w40) + (t20 * w40) // Note: Cl-ckwithash (W20) formula in your sheet uses R51, but not defined, so using w40 for consistency
        setTextViewValue(tvCkrWithAsh[0], w12)
        setTextViewValue(tvCkrWithAsh[1], w13)
        setTextViewValue(tvCkrWithAsh[2], w14)
        setTextViewValue(tvCkrWithAsh[3], w15)
        setTextViewValue(tvCkrWithAsh[4], w16)
        setTextViewValue(tvCkrWithAsh[5], w17)
        setTextViewValue(tvCkrWithAsh[6], w18)
        setTextViewValue(tvCkrWithAsh[7], w19)
        setTextViewValue(tvCkrWithAsh[8], w20)
        val totalCkrWithAsh = w12 + w13 + w14 + w15 + w16 + w17 + w18 + w19 + w20
        setTextViewValue(tvTotal[7], totalCkrWithAsh)
        val lsfCkrWithAsh = if ((2.8 * w12 + 1.18 * w13 + 0.65 * w14) != 0.0) 100 * w15 / (2.8 * w12 + 1.18 * w13 + 0.65 * w14) else 0.0
        setTextViewValue(tvLsf[7], lsfCkrWithAsh)
        val smCkrWithAsh = if ((w13 + w14) != 0.0) w12 / (w13 + w14) else 0.0
        setTextViewValue(tvSm[7], smCkrWithAsh)
        val amCkrWithAsh = if (w14 != 0.0) w13 / w14 else 0.0
        setTextViewValue(tvAm[7], amCkrWithAsh)

        // --- CLINKER ANALYSIS (V28-V38) ---
        val v28 = 4.071 * w15 - 7.6 * w12 - 6.72 * w13 - 1.43 * w14
        val v29 = 4.071 * (w15 - t40) - 7.6024 * w12 - 6.718 * w13 - 1.4297 * w14
        val v30 = 8.6024 * w12 + 5.0683 * w13 + 1.0785 * w14 - 3.071 * (w15 - t40)
        val v31 = 2.65 * w13 - 1.692 * w14
        val v32 = 3.0432 * w14
        val v33 = w17 + 0.659 * w18
        val v34 = 3 * w13 + 2.25 * w14 + w17 + w16 + w18 + w19
        val v35 = v31 + v32 + 0.2 * v30 + 2 * w14
        val v36 = if (w13 != 0.0) w12 / w13 else 0.0
        val v37 = (lsfCkrWithAsh + (10 * smCkrWithAsh)) - (3 * (w16 + v33))
        val v38 = if ((v32 + v31) != 0.0) v29 / (v32 + v31) else 0.0
        setTextViewValue(tvClinkerColumns[0], v28)
        setTextViewValue(tvClinkerColumns[1], v29)
        setTextViewValue(tvClinkerColumns[2], v30)
        setTextViewValue(tvClinkerColumns[3], v31)
        setTextViewValue(tvClinkerColumns[4], v32)
        setTextViewValue(tvClinkerColumns[5], v33)
        setTextViewValue(tvClinkerColumns[6], v34)
        setTextViewValue(tvClinkerColumns[7], v35)
        setTextViewValue(tvClinkerColumns[8], v36)
        setTextViewValue(tvClinkerColumns[9], v37)
        setTextViewValue(tvClinkerColumns[10], v38)

        // --- REMARKS (W28-W38) ---
        tvRemarksColumns[0].text = if (v28 < t29 && v28 > s29) "Normal" else "Abnormal"
        tvRemarksColumns[1].text = if (v29 < t30 && v29 > s30) "Normal" else "Abnormal"
        tvRemarksColumns[2].text = if (v30 < t31 && v30 > s31) "Normal" else "Abnormal"
        tvRemarksColumns[3].text = if (v31 < p22 && v31 > r22) "Normal" else "Abnormal"
        tvRemarksColumns[4].text = if (v32 < totalIron && v32 > totalSand) "Normal" else "Abnormal"
        tvRemarksColumns[5].text = if (v33 < smIron && v33 > smSand) "Normal" else "Abnormal"
        tvRemarksColumns[6].text = if (v34 < t35 && v34 > s35) "Normal" else "Abnormal"
        tvRemarksColumns[7].text = if (v35 < t36 && v35 > s36) "Normal Coating" else "Abnormal Coating"
        tvRemarksColumns[8].text = if (v36 < s37 && v36 > t37) "Normal" else "Abnormal Coating"
        tvRemarksColumns[9].text = if (v37 < t38 && v37 > t38) "Normal" else "Abnormal"
        tvRemarksColumns[10].text = if (v38 < s39 && v38 > t39) "Normal" else "Abnormal"
    }

    private fun clearAllData() {
        allInputEditTexts.forEach { it.setText("") }
        calculateAll()
        Toast.makeText(this, "All data cleared", Toast.LENGTH_SHORT).show()
    }

    private fun saveCurrentData() {
        try {
            val dialogView = layoutInflater.inflate(R.layout.dialog_save_name, null)
            val etSaveName = dialogView.findViewById<EditText>(R.id.et_save_name)
            AlertDialog.Builder(this)
                .setTitle("Save Data")
                .setView(dialogView)
                .setPositiveButton("Save") { _, _ ->
                    val saveName = etSaveName.text.toString().trim()
                    val data = JSONObject()
                    allInputEditTexts.forEach { editText ->
                        val idName = resources.getResourceEntryName(editText.id)
                        data.put(idName, editText.text.toString())
                    }
                    dbHelper.saveData(8, data.toString(), if (saveName.isEmpty()) null else saveName)
                    Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel", null)
                .show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error saving data: "+e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun loadSavedData(savedDataId: Long) {
        try {
            val entry = dbHelper.getSavedData(savedDataId)
            if (entry != null) {
                currentSavedDataId = savedDataId
                originalDataJson = entry.data
                val data = JSONObject(entry.data)
                // Remove listeners
                allInputEditTexts.forEach { it.removeTextChangedListener(textWatcher) }
                // Load values
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
                calculateAll()
                Toast.makeText(this, "Data loaded successfully!", Toast.LENGTH_SHORT).show()
                isDataModified = false
            } else {
                Toast.makeText(this, "Saved data not found", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error loading saved data: "+e.message, Toast.LENGTH_LONG).show()
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
            allInputEditTexts.forEach { editText ->
                val idName = resources.getResourceEntryName(editText.id)
                data.put(idName, editText.text.toString())
            }
            dbHelper.updateSavedData(currentSavedDataId, data.toString())
            Toast.makeText(this, "Data updated successfully!", Toast.LENGTH_SHORT).show()
            finish()
        } catch (e: Exception) {
            Toast.makeText(this, "Error updating data: "+e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
    private fun Page8Cache() {
        val fields = listOf(
            // IronOre
            Triple(etSiO2Iron, { Page8DataCache.SiO2Iron }, { v: Double -> Page8DataCache.SiO2Iron = v }),
            Triple(etAl2O3Iron, { Page8DataCache.Al2O3Iron }, { v: Double -> Page8DataCache.Al2O3Iron = v }),
            Triple(etFe2O3Iron, { Page8DataCache.Fe2O3Iron }, { v: Double -> Page8DataCache.Fe2O3Iron = v }),
            Triple(etCaOIron, { Page8DataCache.CaOIron }, { v: Double -> Page8DataCache.CaOIron = v }),
            Triple(etMgOIron, { Page8DataCache.MgOIron }, { v: Double -> Page8DataCache.MgOIron = v }),
            Triple(etK2OIron, { Page8DataCache.K2OIron }, { v: Double -> Page8DataCache.K2OIron = v }),
            Triple(etNa2OIron, { Page8DataCache.Na2OIron }, { v: Double -> Page8DataCache.Na2OIron = v }),
            Triple(etSO3Iron, { Page8DataCache.SO3Iron }, { v: Double -> Page8DataCache.SO3Iron = v }),
            Triple(etClIron, { Page8DataCache.ClIron }, { v: Double -> Page8DataCache.ClIron = v }),
            Triple(etLoiIron, { Page8DataCache.LoiIron }, { v: Double -> Page8DataCache.LoiIron = v }),
            Triple(etH2OIron, { Page8DataCache.H2OIron }, { v: Double -> Page8DataCache.H2OIron = v }),

            // Shale
            Triple(etSiO2Shale, { Page8DataCache.SiO2Shale }, { v: Double -> Page8DataCache.SiO2Shale = v }),
            Triple(etAl2O3Shale, { Page8DataCache.Al2O3Shale }, { v: Double -> Page8DataCache.Al2O3Shale = v }),
            Triple(etFe2O3Shale, { Page8DataCache.Fe2O3Shale }, { v: Double -> Page8DataCache.Fe2O3Shale = v }),
            Triple(etCaOShale, { Page8DataCache.CaOShale }, { v: Double -> Page8DataCache.CaOShale = v }),
            Triple(etMgOShale, { Page8DataCache.MgOShale }, { v: Double -> Page8DataCache.MgOShale = v }),
            Triple(etK2OShale, { Page8DataCache.K2OShale }, { v: Double -> Page8DataCache.K2OShale = v }),
            Triple(etNa2OShale, { Page8DataCache.Na2OShale }, { v: Double -> Page8DataCache.Na2OShale = v }),
            Triple(etSO3Shale, { Page8DataCache.SO3Shale }, { v: Double -> Page8DataCache.SO3Shale = v }),
            Triple(etClShale, { Page8DataCache.ClShale }, { v: Double -> Page8DataCache.ClShale = v }),
            Triple(etLoiShale, { Page8DataCache.LoiShale }, { v: Double -> Page8DataCache.LoiShale = v }),
            Triple(etH2OShale, { Page8DataCache.H2OShale }, { v: Double -> Page8DataCache.H2OShale = v }),

            // Sand
            Triple(etSiO2Sand, { Page8DataCache.SiO2Sand }, { v: Double -> Page8DataCache.SiO2Sand = v }),
            Triple(etAl2O3Sand, { Page8DataCache.Al2O3Sand }, { v: Double -> Page8DataCache.Al2O3Sand = v }),
            Triple(etFe2O3Sand, { Page8DataCache.Fe2O3Sand }, { v: Double -> Page8DataCache.Fe2O3Sand = v }),
            Triple(etCaOSand, { Page8DataCache.CaOSand }, { v: Double -> Page8DataCache.CaOSand = v }),
            Triple(etMgOSand, { Page8DataCache.MgOSand }, { v: Double -> Page8DataCache.MgOSand = v }),
            Triple(etK2OSand, { Page8DataCache.K2OSand }, { v: Double -> Page8DataCache.K2OSand = v }),
            Triple(etNa2OSand, { Page8DataCache.Na2OSand }, { v: Double -> Page8DataCache.Na2OSand = v }),
            Triple(etSO3Sand, { Page8DataCache.SO3Sand }, { v: Double -> Page8DataCache.SO3Sand = v }),
            Triple(etClSand, { Page8DataCache.ClSand }, { v: Double -> Page8DataCache.ClSand = v }),
            Triple(etLoiSand, { Page8DataCache.LoiSand }, { v: Double -> Page8DataCache.LoiSand = v }),
            Triple(etH2OSand, { Page8DataCache.H2OSand }, { v: Double -> Page8DataCache.H2OSand = v }),

            // Limestone
            Triple(etSiO2Limestone, { Page8DataCache.SiO2Limestone }, { v: Double -> Page8DataCache.SiO2Limestone = v }),
            Triple(etAl2O3Limestone, { Page8DataCache.Al2O3Limestone }, { v: Double -> Page8DataCache.Al2O3Limestone = v }),
            Triple(etFe2O3Limestone, { Page8DataCache.Fe2O3Limestone }, { v: Double -> Page8DataCache.Fe2O3Limestone = v }),
            Triple(etCaOLimestone, { Page8DataCache.CaOLimestone }, { v: Double -> Page8DataCache.CaOLimestone = v }),
            Triple(etMgOLimestone, { Page8DataCache.MgOLimestone }, { v: Double -> Page8DataCache.MgOLimestone = v }),
            Triple(etK2OLimestone, { Page8DataCache.K2OLimestone }, { v: Double -> Page8DataCache.K2OLimestone = v }),
            Triple(etNa2OLimestone, { Page8DataCache.Na2OLimestone }, { v: Double -> Page8DataCache.Na2OLimestone = v }),
            Triple(etSO3Limestone, { Page8DataCache.SO3Limestone }, { v: Double -> Page8DataCache.SO3Limestone = v }),
            Triple(etClLimestone, { Page8DataCache.ClLimestone }, { v: Double -> Page8DataCache.ClLimestone = v }),
            Triple(etLoiLimestone, { Page8DataCache.LoiLimestone }, { v: Double -> Page8DataCache.LoiLimestone = v }),
            Triple(etH2OLimestone, { Page8DataCache.H2OLimestone }, { v: Double -> Page8DataCache.H2OLimestone = v }),

            // CoalAsh
            Triple(etSiO2CoalAsh, { Page8DataCache.SiO2CoalAsh }, { v: Double -> Page8DataCache.SiO2CoalAsh = v }),
            Triple(etAl2O3CoalAsh, { Page8DataCache.Al2O3CoalAsh }, { v: Double -> Page8DataCache.Al2O3CoalAsh = v }),
            Triple(etFe2O3CoalAsh, { Page8DataCache.Fe2O3CoalAsh }, { v: Double -> Page8DataCache.Fe2O3CoalAsh = v }),
            Triple(etCaOCoalAsh, { Page8DataCache.CaOCoalAsh }, { v: Double -> Page8DataCache.CaOCoalAsh = v }),
            Triple(etMgOCoalAsh, { Page8DataCache.MgOCoalAsh }, { v: Double -> Page8DataCache.MgOCoalAsh = v }),
            Triple(etK2OCoalAsh, { Page8DataCache.K2OCoalAsh }, { v: Double -> Page8DataCache.K2OCoalAsh = v }),
            Triple(etNa2OCoalAsh, { Page8DataCache.Na2OCoalAsh }, { v: Double -> Page8DataCache.Na2OCoalAsh = v }),
            Triple(etSO3CoalAsh, { Page8DataCache.SO3CoalAsh }, { v: Double -> Page8DataCache.SO3CoalAsh = v }),
            Triple(etClCoalAsh, { Page8DataCache.ClCoalAsh }, { v: Double -> Page8DataCache.ClCoalAsh = v }),
            Triple(etLoiCoalAsh, { Page8DataCache.LoiCoalAsh }, { v: Double -> Page8DataCache.LoiCoalAsh = v }),
            Triple(etH2OCoalAsh, { Page8DataCache.H2OCoalAsh }, { v: Double -> Page8DataCache.H2OCoalAsh = v }),

            // Other Inputs
            Triple(etLoiRawmeal, { Page8DataCache.LoiRawmeal }, { v: Double -> Page8DataCache.LoiRawmeal = v }),
            Triple(etH2ORawmeal, { Page8DataCache.H2ORawmeal }, { v: Double -> Page8DataCache.H2ORawmeal = v }),
            Triple(etAshAbsorbed, { Page8DataCache.AshAbsorbed }, { v: Double -> Page8DataCache.AshAbsorbed = v }),
            Triple(etHotmealSO3, { Page8DataCache.HotmealSO3 }, { v: Double -> Page8DataCache.HotmealSO3 = v }),
            Triple(etFCaOResult, { Page8DataCache.FCaOResult }, { v: Double -> Page8DataCache.FCaOResult = v }),

            // Targets
            Triple(etLsfTarget, { Page8DataCache.LsfTarget }, { v: Double -> Page8DataCache.LsfTarget = v }),
            Triple(etSmTarget, { Page8DataCache.SmTarget }, { v: Double -> Page8DataCache.SmTarget = v }),
            Triple(etAmTarget, { Page8DataCache.AmTarget }, { v: Double -> Page8DataCache.AmTarget = v })
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
        // Min Columns
        for (i in etMinColumns.indices) {
            etMinColumns[i].setText(
                Page8DataCache.minColumnValues[i].takeIf { it != 0.0 }?.toString() ?: ""
            )
            etMinColumns[i].addTextChangedListener {
                Page8DataCache.minColumnValues[i] = it.toString().toDoubleOrNull() ?: 0.0
            }
        }
        // Max Columns
        for (i in etMaxColumns.indices) {
            etMaxColumns[i].setText(
                Page8DataCache.maxColumnValues[i].takeIf { it != 0.0 }?.toString() ?: ""
            )
            etMaxColumns[i].addTextChangedListener {
                Page8DataCache.maxColumnValues[i] = it.toString().toDoubleOrNull() ?: 0.0
            }
        }
    }
}