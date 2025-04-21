package com.example.park_ease



import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class VerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        val etCode1 = findViewById<EditText>(R.id.etCode1)
        val etCode2 = findViewById<EditText>(R.id.etCode2)
        val etCode3 = findViewById<EditText>(R.id.etCode3)
        val etCode4 = findViewById<EditText>(R.id.etCode4)
        val etCode5 = findViewById<EditText>(R.id.etCode5)

        val btnVerify = findViewById<Button>(R.id.btnVerify)
        val tvResend = findViewById<TextView>(R.id.tvResend)
        val ivBack = findViewById<ImageView>(R.id.ivBack)

        btnVerify.setOnClickListener {
            val code = etCode1.text.toString() + etCode2.text +
                    etCode3.text + etCode4.text + etCode5.text

            if (code.length == 5) {
                Toast.makeText(this, "Code: $code", Toast.LENGTH_SHORT).show()
                // Proceed with verification
            } else {
                Toast.makeText(this, "Enter complete code", Toast.LENGTH_SHORT).show()
            }
        }

        tvResend.setOnClickListener {
            Toast.makeText(this, "Code resent", Toast.LENGTH_SHORT).show()
            // Logic to resend code
        }

        ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
