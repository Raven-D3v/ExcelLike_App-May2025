package com.example.rawmixapp

import android.os.Bundle

class Page8Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Raw Mix Design"
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setActivityContent(R.layout.activity_page8)
    }
}