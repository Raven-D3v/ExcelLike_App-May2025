package com.example.rawmixapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnPage1: Button
    private lateinit var btnPage2: Button
    private lateinit var btnPage3: Button
    private lateinit var btnPage4: Button
    private lateinit var btnPage5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        // Lock to landscape
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContentView(R.layout.activity_main)

        btnPage1 = findViewById(R.id.btn_page1)
        btnPage2 = findViewById(R.id.btn_page2)
        btnPage3 = findViewById(R.id.btn_page3)
        btnPage4 = findViewById(R.id.btn_page4)
        btnPage5 = findViewById(R.id.btn_page5)

        btnPage1.setOnClickListener {
            startActivity(Intent(this, Page1Activity::class.java))
        }

        btnPage2.setOnClickListener {
            startActivity(Intent(this, Page2Activity::class.java))
        }

        btnPage3.setOnClickListener {
            startActivity(Intent(this, Page3Activity::class.java))
        }

        btnPage4.setOnClickListener {
            startActivity(Intent(this, Page4Activity::class.java))
        }

        btnPage5.setOnClickListener {
            startActivity(Intent(this, Page5Activity::class.java))
        }
    }
}
