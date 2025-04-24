package com.example.park_ease



import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.park_ease.R

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        // Delay before closing or navigating to another screen
        Handler(Looper.getMainLooper()).postDelayed({
            // Uncomment the below line to go to HomeActivity instead of just finishing
             startActivity(Intent(this, HomeActivity::class.java))

            // Just close the SuccessActivity

        }, 2500) // 2.5 seconds delay
    }
}
