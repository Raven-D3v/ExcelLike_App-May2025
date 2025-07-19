package com.example.rawmixapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Page9Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Other information"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page9)

        val topics = listOf(
            Topic("Raw Material Compositions, Mass %", R.drawable.raw_material_compositions_mass),
            Topic("Reactions During Heating", R.drawable.reactions_during_heating),
            Topic("Grindability Factors", R.drawable.grindability_factors),
            Topic("Clinker Burning Condition (LSF vs SM)", R.drawable.clinker_burning_condition_lsf_vs_sm),
            Topic("Coating Behaviour (AM vs SM)", R.drawable.coating_behaviour_am_vs_sm),
            Topic("The Modulus of Silica (MS) and Liquid Phase Formation (SM vs Liq. Phase)", R.drawable.the_modulus_of_silica_ms_and_liquid_phase_formation_sm_vs_liq_phase),
            Topic("Coating in the preheater (Cl vs SO3)", R.drawable.coating_in_the_preheater_cl_vs_so3),
            Topic("The Freelime", R.drawable.the_freelime),
            Topic("LSF, C3S, Hard & Easy to burn", R.drawable.lsf_c3s_hard_and_easy_to_burn),
            Topic("Typical Heat Consumption for Different Systems", R.drawable.typical_heat_consumption_for_different_systems),
            Topic("Transformation of Raw Mix into Clinker", R.drawable.transformation_of_raw_mix_into_clinker)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvTopics)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TopicAdapter(topics) { topic ->
            val intent = Intent(this, ImageViewerActivity::class.java)
            intent.putExtra("imageResId", topic.imageResId)
            startActivity(intent)
        }
    }
}

data class Topic(val title: String, val imageResId: Int)

class TopicAdapter(
    private val topics: List<Topic>,
    private val onClick: (Topic) -> Unit
) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false)
        return TopicViewHolder(view)
    }
    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(topics[position], onClick)
    }
    override fun getItemCount() = topics.size
    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(topic: Topic, onClick: (Topic) -> Unit) {
            val tv = itemView.findViewById<TextView>(R.id.tvTopic)
            tv.text = topic.title
            tv.setOnClickListener { onClick(topic) }
        }
    }
}