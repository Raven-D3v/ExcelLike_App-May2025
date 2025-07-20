package com.example.rawmixapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rawmixapp.R
import com.example.rawmixapp.db.SavedDataEntry

class SavedDataAdapter(
    private var entries: List<SavedDataEntry>,
    private val onItemClick: (SavedDataEntry) -> Unit,
    private val onDeleteClick: (SavedDataEntry) -> Unit
) : RecyclerView.Adapter<SavedDataAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPageType: TextView = view.findViewById(R.id.tv_page_type)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val tvTimestamp: TextView = view.findViewById(R.id.tv_timestamp)
        val btnDelete: ImageButton = view.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saved_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = entries[position]
        holder.tvPageType.text = when (entry.pageType) {
            1 -> "Control 3X (LSF & AM)"
            2 -> "Recipe 3X (LSF & AM)"
            3 -> "Control 3X (LSF & SM)"
            4 -> "Recipe 3X (LSF & SM)"
            5 -> "Control 4X (LSF,SM & AM)"
            6 -> "Recipe 4X (LSF,SM & AM)"
            7 -> "Fuel & Clinker Factor"
            8 -> "Raw Mix Design"
            else -> "Unknown Page"
        }
        holder.tvTitle.text = entry.title ?: "Untitled"
        holder.tvTimestamp.text = entry.getFormattedDate()
        
        holder.itemView.setOnClickListener { onItemClick(entry) }
        holder.btnDelete.setOnClickListener { onDeleteClick(entry) }
    }

    override fun getItemCount() = entries.size

    fun updateEntries(newEntries: List<SavedDataEntry>) {
        entries = newEntries
        notifyDataSetChanged()
    }
} 