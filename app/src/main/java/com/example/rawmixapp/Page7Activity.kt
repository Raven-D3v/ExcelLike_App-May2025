package com.example.rawmixapp

import android.os.Bundle

class Page7Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Fuel & Clinker Factor"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page7)
    }
}