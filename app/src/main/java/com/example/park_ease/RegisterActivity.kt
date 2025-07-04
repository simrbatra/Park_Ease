package com.example.park_ease



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val phoneInput = findViewById<EditText>(R.id.etPhone)
        val registerBtn = findViewById<Button>(R.id.btnRegister)
        val loginText = findViewById<TextView>(R.id.tvLogin)

        val termsTextView = findViewById<TextView>(R.id.tvTerms)

        termsTextView.setOnClickListener {
            val bottomSheet = TermsBottomSheet()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        registerBtn.setOnClickListener {
            val phone = phoneInput.text.toString().trim()
            if (phone.isNotEmpty()) {
                val intent = Intent(this, VerificationActivity::class.java)
                intent.putExtra("phone_number", phone)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
            }
        }

        loginText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}
