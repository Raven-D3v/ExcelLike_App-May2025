package com.example.rawmixapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.text.InputType

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        // Removed manual toggle logic, as TextInputLayout handles it

        login.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()
            if (user == "FrancoBaca" && pass == "landoOrtiz") {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                // Go to main activity or finish
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}