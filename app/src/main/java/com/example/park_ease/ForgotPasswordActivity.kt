package com.example.park_ease



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var etPhone: EditText
    private lateinit var btnContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        etPhone = findViewById(R.id.etPhone)
        btnContinue = findViewById(R.id.btnContinue)

        btnContinue.setOnClickListener {
            val phone = etPhone.text.toString()
            if (phone.isNotEmpty()) {
                Toast.makeText(this, "OTP sent to $phone", Toast.LENGTH_SHORT).show()
                // Navigate to OTP or Reset screen
            } else {
                etPhone.error = "Phone number is required"
            }
        }
    }
}
