package com.example.park_ease

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class NavigationMenu : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_menu)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navigationView)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_nearby -> showToast("Nearby")
                R.id.nav_saved -> showToast("Saved")
                R.id.nav_history -> showToast("History")
                R.id.nav_payment -> showToast("Payment")
                R.id.nav_support -> showToast("Support")
                R.id.nav_community -> showToast("Community")
                R.id.nav_logout -> showToast("Logged out")
            }
            drawerLayout.closeDrawers()
            true
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}