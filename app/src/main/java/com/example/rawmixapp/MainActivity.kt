package com.example.rawmixapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Lock to landscape
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContentView(R.layout.activity_main)

        // Set up the toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

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
              // Fuel & Kiln Feed to Clinker Ratio
        )

        // Set click listeners for each card
        cardIds.forEach { (cardId, activityClass) ->
            findViewById<MaterialCardView>(cardId).setOnClickListener {
                startActivity(Intent(this, activityClass))
            }
        }
    }
}
