package com.example.rawmixapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rawmixapp.adapters.SavedDataAdapter
import com.example.rawmixapp.db.SavedDataDbHelper
import com.example.rawmixapp.db.SavedDataEntry
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView

class Page10Activity : BaseActivity() {
    private lateinit var dbHelper: SavedDataDbHelper
    private lateinit var adapter: SavedDataAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyStateContainer: View
    private lateinit var tvEmpty: TextView
    private lateinit var spinnerCategory: Spinner

    private var allEntries: List<SavedDataEntry> = emptyList()
    private val categories = listOf(
        "All Pages",
        "3 Materials LSF & AM",
        "Recipe LSF & AM",
        "3 Materials LSF & SM",
        "Recipe LSF & SM",
        "4 Materials LSF, SM & AM",
        "Recipe LSF, SM & AM",
        "Fuel & Clinker Factor",
        "Raw Mix Design",
        "Graph"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Previous Data List"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page10)

        dbHelper = SavedDataDbHelper(this)
        recyclerView = findViewById(R.id.recycler_view)
        emptyStateContainer = findViewById(R.id.empty_state_container)
        tvEmpty = findViewById(R.id.tv_empty)
        spinnerCategory = findViewById(R.id.spinner_category)

        setupSpinner()
        setupRecyclerView()
        loadSavedData()
    }

    override fun onResume() {
        super.onResume()
        loadSavedData()
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter(this, R.layout.spinner_selected_item, categories)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerCategory.adapter = adapter
        
        // Set initial selection based on current page
        val currentPageType = when (supportActionBar?.title) {
            "3 Materials LSF & AM" -> "3 Materials LSF & AM"
            "Recipe LSF & AM" -> "Recipe LSF & AM"
            "3 Materials LSF & SM" -> "3 Materials LSF & SM"
            "Recipe LSF & SM" -> "Recipe LSF & SM"
            "4 Materials LSF, SM & AM" -> "4 Materials LSF, SM & AM"
            "Recipe LSF, SM & AM" -> "Recipe LSF, SM & AM"
            "Fuel & Clinker Factor" -> "Fuel & Clinker Factor"
            "Raw Mix Design" -> "Raw Mix Design"
            "Graph" -> "Graph"
            else -> "All Pages"
        }
        val initialPosition = categories.indexOf(currentPageType)
        if (initialPosition != -1) {
            spinnerCategory.setSelection(initialPosition)
        }
        
        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                filterEntriesByCategory(categories[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun setupRecyclerView() {
        adapter = SavedDataAdapter(
            emptyList(),
            onItemClick = { entry -> navigateToPage(entry) },
            onDeleteClick = { entry -> showDeleteConfirmation(entry) }
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@Page10Activity)
            adapter = this@Page10Activity.adapter
        }
    }

    private fun loadSavedData() {
        allEntries = dbHelper.getAllSavedData()
        filterEntriesByCategory(spinnerCategory.selectedItem?.toString() ?: "All Pages")
    }

    private fun filterEntriesByCategory(category: String) {
        val filtered = when (category) {
            "All Pages" -> allEntries
            "3 Materials LSF & AM" -> allEntries.filter { it.pageType == 1 }
            "Recipe LSF & AM" -> allEntries.filter { it.pageType == 2 }
            "3 Materials LSF & SM" -> allEntries.filter { it.pageType == 3 }
            "Recipe LSF & SM" -> allEntries.filter { it.pageType == 4 }
            "4 Materials LSF, SM & AM" -> allEntries.filter { it.pageType == 5 }
            "Recipe LSF, SM & AM" -> allEntries.filter { it.pageType == 6 }
            "Fuel & Clinker Factor" -> allEntries.filter { it.pageType == 7 }
            "Raw Mix Design" -> allEntries.filter { it.pageType == 8 }
            "Graph" -> allEntries.filter { it.pageType == 9 }
            else -> allEntries
        }
        adapter.updateEntries(filtered)
        updateEmptyView(filtered.isEmpty())
    }

    private fun updateEmptyView(isEmpty: Boolean) {
        emptyStateContainer.visibility = if (isEmpty) View.VISIBLE else View.GONE
        recyclerView.visibility = if (isEmpty) View.GONE else View.VISIBLE
        tvEmpty.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }

    private fun navigateToPage(entry: SavedDataEntry) {
        val intent = when (entry.pageType) {
            1 -> Intent(this, Page1Activity::class.java)
            2 -> Intent(this, Page2Activity::class.java)
            3 -> Intent(this, Page3Activity::class.java)
            4 -> Intent(this, Page4Activity::class.java)
            5 -> Intent(this, Page5Activity::class.java)
            6 -> Intent(this, Page6Activity::class.java)
            7 -> Intent(this, Page7Activity::class.java)
            8 -> Intent(this, Page8Activity::class.java)
            9 -> Intent(this, Page9Activity::class.java)
            else -> return
        }
        intent.putExtra("saved_data_id", entry.id)
        startActivity(intent)
    }

    private fun showDeleteConfirmation(entry: SavedDataEntry) {
        AlertDialog.Builder(this)
            .setTitle("Delete Entry")
            .setMessage("Are you sure you want to delete this entry?")
            .setPositiveButton("Delete") { _, _ ->
                deleteEntry(entry)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun deleteEntry(entry: SavedDataEntry) {
        dbHelper.deleteSavedData(entry.id)
        loadSavedData()
    }
}