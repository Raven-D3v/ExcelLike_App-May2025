package com.example.rawmixapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar // Keep if Toolbar is directly accessed, but setup is in Base

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Home"
        // Lock to landscape
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        // Set the content for this activity within the BaseActivity's layout
        setActivityContent(R.layout.activity_main)

        // Toolbar is set up in BaseActivity

        // Set up click listeners for the cards
        setupCardClickListeners()
    }

    private fun setupCardClickListeners() {
        // Map each card to its corresponding activity
        val cardIds = listOf(
            R.id.btn_page1 to Page1Activity::class.java,  // 3 Materials LSF & AM
            R.id.btn_page2 to Page2Activity::class.java,  // Recipe LSF and AM
            R.id.btn_page3 to Page3Activity::class.java,  // 3 Materials LSF & SM
            R.id.btn_page4 to Page4Activity::class.java,  // Recipe LSF and SM
            R.id.btn_page5 to Page5Activity::class.java,  // 4 Materials LSF, SM & AM
            R.id.btn_page6 to Page6Activity::class.java,  // Recipe LSF, SM and AM
            R.id.btn_page7 to Page7Activity::class.java,  // Fuel & Clinker Factor
            R.id.btn_page8 to Page8Activity::class.java,  // Raw Mix Design
            R.id.btn_page9 to Page9Activity::class.java,  // Graph
            R.id.btn_page10 to Page10Activity::class.java  // Previous Information Data List
        )

        // Set click listeners for each card
        cardIds.forEach { (cardId, activityClass) ->
            findViewById<LinearLayout>(cardId).setOnClickListener {
                startActivity(Intent(this, activityClass))
            }
        }
    }
}
