package com.example.rawmixapp

import android.os.Bundle
// import androidx.appcompat.app.AppCompatActivity // Replaced by BaseActivity

class Page5Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "4 Materials LSF, SM & AM"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page5) // Use BaseActivity's content frame
        // Add any specific Page5Activity initialization here
    }
}