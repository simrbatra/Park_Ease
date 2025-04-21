package com.example.park_ease

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val checkbox = findViewById<CheckBox>(R.id.cbTerms)
        val createBtn = findViewById<Button>(R.id.btnCreateAccount)

        createBtn.setOnClickListener {
            if (!checkbox.isChecked) {
                Toast.makeText(this, "Please accept Terms and Conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Handle form submission
            Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()
        }
    }
}
