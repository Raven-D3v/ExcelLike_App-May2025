package com.example.rawmixapp
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rawmixapp.databinding.ActivityPage2Binding
import com.example.rawmixapp.databinding.ActivityPage2chemrowBinding

class Page2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPage2Binding

    // Declaration of Variables

    // Single EditTexts and TextViews
    private lateinit var target_lsf: EditText
    private lateinit var target_am: EditText

    private lateinit var mix_limestone: EditText
    private lateinit var mix_shale: EditText
    private lateinit var mix_ironore: EditText
    private lateinit var mix_rawmeal: TextView

    private lateinit var total_limestone: TextView
    private lateinit var total_shale: TextView
    private lateinit var total_ironore: TextView
    private lateinit var total_rawmeal: TextView

    private lateinit var lsf_limestone: TextView
    private lateinit var lsf_shale: TextView
    private lateinit var lsf_ironore: TextView
    private lateinit var lsf_rawmeal: TextView

    private lateinit var sm_limestone: TextView
    private lateinit var sm_shale: TextView
    private lateinit var sm_ironore: TextView
    private lateinit var sm_rawmeal: TextView

    private lateinit var am_limestone: TextView
    private lateinit var am_shale: TextView
    private lateinit var am_ironore: TextView
    private lateinit var am_rawmeal: TextView

    private lateinit var coefficientA: TextView
    private lateinit var coefficientB: TextView
    private lateinit var coefficientC: TextView
    private lateinit var coefficientD: TextView
    private lateinit var coefficientE: TextView
    private lateinit var coefficientF: TextView
    private lateinit var coefficientG: TextView
    private lateinit var coefficientH: TextView
    private lateinit var coefficientI: TextView
    private lateinit var coefficientJ: TextView
    private lateinit var coefficientK: TextView
    private lateinit var coefficientL: TextView
    private lateinit var coefficientDelta: TextView

    private lateinit var rmpLimestone: TextView
    private lateinit var rmpShale: TextView
    private lateinit var rmpIron: TextView
    private lateinit var rmpTotal: TextView

    private lateinit var mplimewet: TextView
    private lateinit var mplimedry: EditText
    private lateinit var mplimeh2o: EditText

    private lateinit var mpshalewet: TextView
    private lateinit var mpshaledry: EditText
    private lateinit var mpshaleh2o: EditText

    private lateinit var mpironwet: TextView
    private lateinit var mpirondry: EditText
    private lateinit var mpironh2o: EditText

    private lateinit var mptotalwet: TextView
    private lateinit var mptotaldry: TextView
    private lateinit var mptotalh2o: TextView

    private lateinit var wetbasis1: TextView
    private lateinit var wetbasis2: TextView
    private lateinit var wetbasis3: TextView
    private lateinit var wetbasis4: TextView
    private lateinit var wetbasis5: TextView

    // Chemical rows
    private lateinit var rowSio2: ActivityPage2chemrowBinding
    private lateinit var rowCao: ActivityPage2chemrowBinding
    private lateinit var rowFe2o3: ActivityPage2chemrowBinding
    private lateinit var rowAl2o3: ActivityPage2chemrowBinding
    private lateinit var rowMgo: ActivityPage2chemrowBinding
    private lateinit var rowNa2o: ActivityPage2chemrowBinding
    private lateinit var rowK2o: ActivityPage2chemrowBinding
    private lateinit var rowSo3: ActivityPage2chemrowBinding
    private lateinit var rowCl: ActivityPage2chemrowBinding
    private lateinit var rowLoi: ActivityPage2chemrowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPage2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize all the simple EditTexts and TextViews
        target_lsf = findViewById(R.id.lsf_value)
        target_am = findViewById(R.id.am_value)

        mix_limestone = findViewById(R.id.editTextMixLimeStone)
        mix_shale = findViewById(R.id.editTextMixShale)
        mix_ironore = findViewById(R.id.editTextMixIronOre)
        mix_rawmeal = findViewById(R.id.editTextMixRawMeal)

        total_limestone = findViewById(R.id.total_limestone)
        total_shale = findViewById(R.id.total_shale)
        total_ironore = findViewById(R.id.total_iron_ore)
        total_rawmeal = findViewById(R.id.total_raw_meal)

        lsf_limestone = findViewById(R.id.lsf_limestone)
        lsf_shale = findViewById(R.id.lsf_shale)
        lsf_ironore = findViewById(R.id.lsf_iron)
        lsf_rawmeal = findViewById(R.id.lsf_rawmeal)

        sm_limestone = findViewById(R.id.sm_limestone)
        sm_shale = findViewById(R.id.sm_shale)
        sm_ironore = findViewById(R.id.sm_iron)
        sm_rawmeal = findViewById(R.id.sm_rawmeal)

        am_limestone = findViewById(R.id.am_limestone)
        am_shale = findViewById(R.id.am_shale)
        am_ironore = findViewById(R.id.am_iron)
        am_rawmeal = findViewById(R.id.am_rawmeal)

        coefficientA = findViewById(R.id.coefficientA)
        coefficientB = findViewById(R.id.coefficientB)
        coefficientC = findViewById(R.id.coefficientC)
        coefficientD = findViewById(R.id.coefficientD)
        coefficientE = findViewById(R.id.coefficientE)
        coefficientF = findViewById(R.id.coefficientF)
        coefficientG = findViewById(R.id.coefficientG)
        coefficientH = findViewById(R.id.coefficientH)
        coefficientI = findViewById(R.id.coefficientI)
        coefficientJ = findViewById(R.id.coefficientJ)
        coefficientK = findViewById(R.id.coefficientK)
        coefficientL = findViewById(R.id.coefficientL)
        coefficientDelta = findViewById(R.id.coefficientDelta)

        rmpLimestone = findViewById(R.id.rmpLimestone)
        rmpShale = findViewById(R.id.rmpShale)
        rmpIron = findViewById(R.id.rmpIron)
        rmpTotal = findViewById(R.id.rmpTotal)

        mplimewet = findViewById(R.id.mplimewet)
        mplimedry = findViewById(R.id.mplimedry)
        mplimeh2o = findViewById(R.id.mplimeh2o)

        mpshalewet = findViewById(R.id.mpshalewet)
        mpshaledry = findViewById(R.id.mpshaledry)
        mpshaleh2o = findViewById(R.id.mpshaleh2o)

        mpironwet = findViewById(R.id.mpironwet)
        mpirondry = findViewById(R.id.mpirondry)
        mpironh2o = findViewById(R.id.mpironh2o)

        mptotalwet = findViewById(R.id.mptotalwet)
        mptotaldry = findViewById(R.id.mptotaldry)
        mptotalh2o = findViewById(R.id.mptotalh2o)

        wetbasis1 = findViewById(R.id.wetbasis1)
        wetbasis2 = findViewById(R.id.wetbasis2)
        wetbasis3 = findViewById(R.id.wetbasis3)
        wetbasis4 = findViewById(R.id.wetbasis4)
        wetbasis5 = findViewById(R.id.wetbasis5)

        // Initialize chemical row bindings
        rowSio2 = binding.rowSio2
        rowCao = binding.rowCao
        rowFe2o3 = binding.rowFe2o3
        rowAl2o3 = binding.rowAl2o3
        rowMgo = binding.rowMgo
        rowNa2o = binding.rowNa2o
        rowK2o = binding.rowK2o
        rowSo3 = binding.rowSo3
        rowCl = binding.rowCl
        rowLoi = binding.rowLoi

        // Group chemical rows with their labels and ID prefixes
        val chemicalRows = listOf(
            Triple(rowSio2, "SiO₂", "siO2"),
            Triple(rowCao, "CaO", "caO"),
            Triple(rowFe2o3, "Fe₂O₃", "fe2o3"),
            Triple(rowAl2o3, "Al₂O₃", "al2o3"),
            Triple(rowMgo, "MgO", "mgo"),
            Triple(rowNa2o, "Na₂O", "na2o"),
            Triple(rowK2o, "K₂O", "k2o"),
            Triple(rowSo3, "SO₃", "so3"),
            Triple(rowCl, "Cl", "cl"),
            Triple(rowLoi, "LOI", "loi"),
        )

        // Initialize IDs and add TextWatchers for each chemical row input
        for ((row, label, prefix) in chemicalRows) {
            row.labelComponent.text = label

            row.editLimestone.id = resources.getIdentifier("${prefix}_limestone", "id", packageName)
            row.editShale.id = resources.getIdentifier("${prefix}_shale", "id", packageName)
            row.editIron.id = resources.getIdentifier("${prefix}_iron", "id", packageName)
            row.textRawmeal.id = resources.getIdentifier("${prefix}_rawmeal", "id", packageName)

            row.editLimestone.addTextChangedListener(textWatcher)
            row.editShale.addTextChangedListener(textWatcher)
            row.editIron.addTextChangedListener(textWatcher)
        }

        // Add TextWatchers to other inputs to trigger recalculation
        listOf(
            mix_limestone,
            mix_shale,
            mix_ironore,
            mplimedry,
            mplimeh2o,
            mpshaledry,
            mpshaleh2o,
            mpirondry,
            mpironh2o
        ).forEach { it.addTextChangedListener(textWatcher) }
    }

    private fun safeDivide(numerator: Double, denominator: Double): Double =
        if (denominator == 0.0) 0.0 else numerator / denominator

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            updateAllCalculations()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun updateAllCalculations() {
        // Sum for raw meal total
        val limestone = mix_limestone.text.toString().toDoubleOrNull() ?: 0.0
        val shale = mix_shale.text.toString().toDoubleOrNull() ?: 0.0
        val ironOre = mix_ironore.text.toString().toDoubleOrNull() ?: 0.0
        val totalRawMeal = limestone + shale + ironOre
        mix_rawmeal.text = String.format("%.2f", totalRawMeal)

        // Calculate SiO2
        val sio2Limestone = rowSio2.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val sio2Shale = rowSio2.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val sio2Iron = rowSio2.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val sio2Result = if (totalRawMeal != 0.0) (limestone * sio2Limestone + shale * sio2Shale + ironOre * sio2Iron) / totalRawMeal
        else 0.0

        rowSio2.textRawmeal.text = String.format("%.2f", sio2Result)

        // Calculate Al2O3
        val alLimestone = rowAl2o3.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val alShale = rowAl2o3.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val alIron = rowAl2o3.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val al2o3Result = if (totalRawMeal != 0.0) (limestone * alLimestone + shale * alShale + ironOre * alIron) / totalRawMeal
        else 0.0

        rowAl2o3.textRawmeal.text = String.format("%.2f", al2o3Result)

        // Calculate Fe2O3
        val feLimestone = rowFe2o3.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val feShale = rowFe2o3.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val feIron = rowFe2o3.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val fe2o3Result = if (totalRawMeal != 0.0) (limestone * feLimestone + shale * feShale + ironOre * feIron) / totalRawMeal else 0.0
        rowFe2o3.textRawmeal.text = String.format("%.2f", fe2o3Result)

        // CaO
        val caoLimestone = rowCao.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val caoShale = rowCao.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val caoIron = rowCao.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val caoResult = if (totalRawMeal != 0.0) (limestone * caoLimestone + shale * caoShale + ironOre * caoIron) / totalRawMeal else 0.0
        rowCao.textRawmeal.text = String.format("%.2f", caoResult)

        // MgO
        val mgLimestone = rowMgo.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val mgShale = rowMgo.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val mgIron = rowMgo.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val mgoResult = if (totalRawMeal != 0.0) (limestone * mgLimestone + shale * mgShale + ironOre * mgIron) / totalRawMeal else 0.0
        rowMgo.textRawmeal.text = String.format("%.2f", mgoResult)

        // Na2O
        val naLimestone = rowNa2o.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val naShale = rowNa2o.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val naIron = rowNa2o.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val na2oResult = if (totalRawMeal != 0.0) (limestone * naLimestone + shale * naShale + ironOre * naIron) / totalRawMeal else 0.0
        rowNa2o.textRawmeal.text = String.format("%.2f", na2oResult)

        // K2O
        val kLimestone = rowK2o.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val kShale = rowK2o.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val kIron = rowK2o.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val k2oResult = if (totalRawMeal != 0.0) (limestone * kLimestone + shale * kShale + ironOre * kIron) / totalRawMeal else 0.0
        rowK2o.textRawmeal.text = String.format("%.2f", k2oResult)

        // SO3
        val soLimestone = rowSo3.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val soShale = rowSo3.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val soIron = rowSo3.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val so3Result = if (totalRawMeal != 0.0) (limestone * soLimestone + shale * soShale + ironOre * soIron) / totalRawMeal else 0.0
        rowSo3.textRawmeal.text = String.format("%.2f", so3Result)

        // Cl
        val clLimestone = rowCl.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val clShale = rowCl.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val clIron = rowCl.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val clResult = if (totalRawMeal != 0.0) (limestone * clLimestone + shale * clShale + ironOre * clIron) / totalRawMeal else 0.0
        rowCl.textRawmeal.text = String.format("%.2f", clResult)

        // LOI
        val loiLimestone = rowLoi.editLimestone.text.toString().toDoubleOrNull() ?: 0.0
        val loiShale = rowLoi.editShale.text.toString().toDoubleOrNull() ?: 0.0
        val loiIron = rowLoi.editIron.text.toString().toDoubleOrNull() ?: 0.0
        val loiResult = if (totalRawMeal != 0.0) (limestone * loiLimestone + shale * loiShale + ironOre * loiIron) / totalRawMeal else 0.0
        rowLoi.textRawmeal.text = String.format("%.2f", loiResult)

        //Total
        //Sum of Limestone
        val sumoflimestone =
                (rowSio2.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowAl2o3.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowFe2o3.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowCao.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowMgo.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowNa2o.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowK2o.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowSo3.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowCl.editLimestone.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowLoi.editLimestone.text.toString().toDoubleOrNull() ?: 0.0)

        //Sum of Shale
        val sumofshale =
                (rowSio2.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowAl2o3.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowFe2o3.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowCao.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowMgo.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowNa2o.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowK2o.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowSo3.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowCl.editShale.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowLoi.editShale.text.toString().toDoubleOrNull() ?: 0.0)

        //Sum of Iron ore
        val sumofiron =
                (rowSio2.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowAl2o3.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowFe2o3.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowCao.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowMgo.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowNa2o.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowK2o.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowSo3.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowCl.editIron.text.toString().toDoubleOrNull() ?: 0.0) +
                (rowLoi.editIron.text.toString().toDoubleOrNull() ?: 0.0)

        //Total Row
        //Sum of Rawmeal
        val sumofrawmeal =  sio2Result + al2o3Result + fe2o3Result + caoResult +
                mgoResult + na2oResult + k2oResult + so3Result + clResult + loiResult

        //Display of Total Row
        total_limestone.text = String.format("%.2f", sumoflimestone)
        total_shale.text = String.format("%.2f", sumofshale)
        total_ironore.text = String.format("%.2f", sumofiron)
        total_rawmeal.text = String.format("%.2f", sumofrawmeal)

// LSF calculations
        val lsf_limestoneCalculation = safeDivide(
            100 * caoLimestone,
            2.8 * sio2Limestone + 1.18 * alLimestone + 0.65 * feLimestone
        )

        val lsf_shaleCalculation = safeDivide(
            100 * caoShale,
            2.8 * sio2Shale + 1.18 * alShale + 0.65 * feShale
        )

        val lsf_ironoreCalculation = safeDivide(
            100 * caoIron,
            2.8 * sio2Iron + 1.18 * alIron + 0.65 * feIron
        )

        val lsf_rawmealCalculation = safeDivide(
            100 * caoResult,
            2.8 * sio2Result + 1.18 * al2o3Result + 0.65 * fe2o3Result
        )

// SM calculations
        val sm_limestoneCalculation = safeDivide(sio2Limestone, alLimestone + feLimestone)
        val sm_shaleCalculation = safeDivide(sio2Shale, alShale + feShale)
        val sm_ironoreCalculation = safeDivide(sio2Iron, alIron + feIron)
        val sm_rawmealCalculation = safeDivide(sio2Result, al2o3Result + fe2o3Result)

// AM calculations
        val am_limestoneCalculation = safeDivide(alLimestone, feLimestone)
        val am_shaleCalculation = safeDivide(alShale, feShale)
        val am_ironoreCalculation = safeDivide(alIron, feIron)
        val am_rawmealCalculation = safeDivide(al2o3Result, fe2o3Result)

// Display all values formatted
        lsf_limestone.text = String.format("%.2f", lsf_limestoneCalculation)
        lsf_shale.text = String.format("%.2f", lsf_shaleCalculation)
        lsf_ironore.text = String.format("%.2f", lsf_ironoreCalculation)
        lsf_rawmeal.text = String.format("%.2f", lsf_rawmealCalculation)

        sm_limestone.text = String.format("%.2f", sm_limestoneCalculation)
        sm_shale.text = String.format("%.2f", sm_shaleCalculation)
        sm_ironore.text = String.format("%.2f", sm_ironoreCalculation)
        sm_rawmeal.text = String.format("%.2f", sm_rawmealCalculation)

        am_limestone.text = String.format("%.2f", am_limestoneCalculation)
        am_shale.text = String.format("%.2f", am_shaleCalculation)
        am_ironore.text = String.format("%.2f", am_ironoreCalculation)
        am_rawmeal.text = String.format("%.2f", am_rawmealCalculation)

        //Coefficient Calculation
        //Retrieval of LSF and AM inputted value from xml
        val targetLsf = target_lsf.text.toString().toDoubleOrNull() ?: 0.0
        val targetAm = target_am.text.toString().toDoubleOrNull() ?: 0.0

        // calculation of coefficients
        val coefficientAcalculation = 1.0
        val coefficientBCalculation = 1.0
        val coefficientCCalculation = 1.0
        val coefficientDCalculation = 100.0
        val coefficientECalculation = (targetAm*feLimestone)-alLimestone
        val coefficientFCalculation = (targetAm*feShale)-alShale
        val coefficientGCalculation = (targetAm*feIron)-alIron
        val coefficientHCalculation = 0.0
        val coefficientICalculation = targetLsf*(2.8*sio2Limestone+1.18*alLimestone+0.65*feLimestone)-100*caoLimestone
        val coefficientJCalculation = targetLsf*(2.8*sio2Shale+1.18*alShale+0.65*feShale)-100*caoShale
        val coefficientKCalculation = targetLsf*(2.8*sio2Iron+1.18*alIron+0.65*feIron)-100*caoIron
        val coefficientLCalculation = 0.0
        val coefficientDeltaCalculation =
            (coefficientAcalculation * coefficientFCalculation * coefficientKCalculation) +
                    (coefficientBCalculation * coefficientGCalculation * coefficientICalculation) +
                    (coefficientCCalculation * coefficientECalculation * coefficientJCalculation) -
                    (coefficientCCalculation * coefficientFCalculation * coefficientICalculation) -
                    (coefficientAcalculation * coefficientGCalculation * coefficientJCalculation) -
                    (coefficientBCalculation * coefficientECalculation * coefficientKCalculation)


        //Coefficients Display of Value
        coefficientA.text = String.format("%.2f", coefficientAcalculation)
        coefficientB.text = String.format("%.2f", coefficientBCalculation)
        coefficientC.text = String.format("%.2f", coefficientCCalculation)
        coefficientD.text = String.format("%.2f", coefficientDCalculation)
        coefficientE.text = String.format("%.2f", coefficientECalculation)
        coefficientF.text = String.format("%.2f", coefficientFCalculation)
        coefficientG.text = String.format("%.2f", coefficientGCalculation)
        coefficientH.text = String.format("%.2f", coefficientHCalculation)
        coefficientI.text = String.format("%.3f", coefficientICalculation)
        coefficientJ.text = String.format("%.2f", coefficientJCalculation)
        coefficientK.text = String.format("%.2f", coefficientKCalculation)
        coefficientL.text = String.format("%.2f", coefficientLCalculation)
        coefficientDelta.text = String.format("%.3f", coefficientDeltaCalculation)

        //RMP DRY BASIS ROW
        //RMP CALCULATION

        val rmplimestonecalculation = safeDivide(
            (coefficientDCalculation * coefficientFCalculation * coefficientKCalculation -
                    coefficientDCalculation * coefficientGCalculation * coefficientJCalculation),
            coefficientDeltaCalculation
        )

        val rmpshalecalculation = safeDivide(
            (coefficientDCalculation * coefficientGCalculation * coefficientICalculation -
                    coefficientDCalculation * coefficientECalculation * coefficientKCalculation),
            coefficientDeltaCalculation
        )

        val rmpironcalculation = 100.0 - rmpshalecalculation - rmplimestonecalculation
        val rmptotalcalculation = rmplimestonecalculation + rmpshalecalculation + rmpironcalculation


        rmpLimestone.text = String.format("%.1f", rmplimestonecalculation)
        rmpShale.text = String.format("%.1f", rmpshalecalculation)
        rmpIron.text = String.format("%.1f", rmpironcalculation)
        rmpTotal.text = String.format("%.2f", rmptotalcalculation)

        //MP ROW and Wet Basis Row
        //MP CALCULATION

        val mplimedryValue = mplimedry.text.toString().toDoubleOrNull() ?: 0.0
        val mplimeh2oValue = mplimeh2o.text.toString().toDoubleOrNull() ?: 0.0

        val mpshaledryValue = mpshaledry.text.toString().toDoubleOrNull() ?: 0.0
        val mpshaleh2oValue = mpshaleh2o.text.toString().toDoubleOrNull() ?: 0.0

        val mpirondryValue = mpirondry.text.toString().toDoubleOrNull() ?: 0.0
        val mpironh2oValue = mpironh2o.text.toString().toDoubleOrNull() ?: 0.0

        //WET BASIS ROW
        //WET BASIS CALCULATION

        val wetbasis1calculation = rmplimestonecalculation/(1-(mplimeh2oValue/100))
        val wetbasis2calculation = rmpshalecalculation/(1-(mpshaleh2oValue/100))
        val wetbasis3calculation = rmpironcalculation/(1-(mpironh2oValue/100))
        val wetbasis4calculation = wetbasis1calculation+wetbasis2calculation+wetbasis3calculation
        val wetbasis5calculation = rmptotalcalculation/wetbasis4calculation

        val mptotaldrycalculation = mplimedryValue+mpshaledryValue+mpirondryValue

        val mptotalh2ocalculation = mplimeh2oValue+mpshaleh2oValue+mpironh2oValue

        val mplimewetcalculation = wetbasis1calculation*wetbasis5calculation
        val mpshalewetcalculation = wetbasis2calculation*wetbasis5calculation
        val mpironwetcalculation = wetbasis3calculation*wetbasis5calculation
        val mptotalwetcalculation = mplimewetcalculation+mpshalewetcalculation+mpironwetcalculation

        mplimewet.text = String.format("%.1f", mplimewetcalculation)
        mpshalewet.text = String.format("%.1f", mpshalewetcalculation)
        mpironwet.text = String.format("%.1f", mpironwetcalculation)
        mptotalwet.text = String.format("%.1f", mptotalwetcalculation)
        mptotaldry.text = String.format("%.2f", mptotaldrycalculation)
        mptotalh2o.text = String.format("%.2f", mptotalh2ocalculation)

        wetbasis1.text = String.format("%.2f", wetbasis1calculation)
        wetbasis2.text = String.format("%.2f", wetbasis2calculation)
        wetbasis3.text = String.format("%.2f", wetbasis3calculation)
        wetbasis4.text = String.format("%.2f", wetbasis4calculation)
        wetbasis5.text = String.format("%.3f", wetbasis5calculation)

    }

}
