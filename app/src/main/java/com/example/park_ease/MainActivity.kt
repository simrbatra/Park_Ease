package com.example.park_ease

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("ParkEasePrefs", MODE_PRIVATE)
            val isRegistered = sharedPref.getBoolean("isRegistered", false)
            val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

            when {
                !isRegistered -> {
                    startActivity(Intent(this, RegisterActivity::class.java))
                }
                !isLoggedIn -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                else -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                }
            }

            finish() // Optional: to close MainActivity so user can't return with back button
        }, 1000) // 1 second delay
    }
}
