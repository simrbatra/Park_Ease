package com.example.park_ease


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ExtendTimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extend_time)

//        val sharedPref = getSharedPreferences("ParkEasePrefs", MODE_PRIVATE)
//        val isRegistered = sharedPref.getBoolean("isRegistered", false)
//        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)
//
//        when {
//            !isRegistered -> {
//                startActivity(Intent(this, RegisterActivity::class.java))
//            }
//            !isLoggedIn -> {
//                startActivity(Intent(this, LoginActivity::class.java))
//            }
//            else -> {
//                startActivity(Intent(this, HomeActivity::class.java))
//            }
//        }

    }

}
