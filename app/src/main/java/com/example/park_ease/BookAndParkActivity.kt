package com.example.park_ease

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.park_ease.databinding.ActivityBookAndParkBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class BookAndParkActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityBookAndParkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookAndParkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Optional: Hide action bar for cleaner transition
        supportActionBar?.hide()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Delay and navigate to ExtendTimeActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, ExtendTimeActivity::class.java))

        }, 3000)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val currentLocation = LatLng(-34.0, 151.0) // Replace with actual location
        mMap.addMarker(MarkerOptions().position(currentLocation).title("You're here"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f))
    }
}
