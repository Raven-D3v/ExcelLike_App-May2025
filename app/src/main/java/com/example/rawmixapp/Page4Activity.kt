package com.example.rawmixapp

import android.os.Bundle
// import androidx.appcompat.app.AppCompatActivity // Replaced by BaseActivity

class Page4Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Recipe LSF & SM"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page4) // Use BaseActivity's content frame
        // Add any specific Page4Activity initialization here
    }
}