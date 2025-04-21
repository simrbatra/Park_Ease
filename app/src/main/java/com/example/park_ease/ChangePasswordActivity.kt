package com.example.park_ease

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var etNewPassword: EditText
    private lateinit var ivTogglePassword: ImageView
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        etNewPassword = findViewById(R.id.etNewPassword)
        ivTogglePassword = findViewById(R.id.ivTogglePassword)

        // Toggle password visibility
        ivTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                etNewPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_eye)
            } else {
                etNewPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_eye)
            }
            etNewPassword.setSelection(etNewPassword.text.length)
        }

        findViewById<Button>(R.id.btnChangePassword).setOnClickListener {
            val newPassword = etNewPassword.text.toString().trim()
            if (newPassword.isEmpty()) {
                etNewPassword.error = "Password cannot be empty"
            } else {
                // Handle password change logic
                Toast.makeText(this, "Password changed successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            onBackPressed()
        }
    }
}
