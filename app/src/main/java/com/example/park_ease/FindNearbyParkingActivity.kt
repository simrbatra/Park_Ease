package com.example.park_ease

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.park_ease.databinding.ActivityFindNearbyParkingBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class FindNearbyParkingActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityFindNearbyParkingBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindNearbyParkingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide action bar for splash-like feel
        supportActionBar?.hide()

        // Init location client
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Set up the map fragment
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true

        // Check location permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
            return
        }

        mMap.isMyLocationEnabled = true

        // Show user location
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val userLocation = LatLng(it.latitude, it.longitude)
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 15f))
                mMap.addMarker(
                    MarkerOptions()
                        .position(userLocation)
                        .title("You are here")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                )
            }
        }

        // Add example parking markers
        addParkingMarker(LatLng(28.7041, 77.1025), "Connaught Place Parking")
        addParkingMarker(LatLng(28.6139, 77.2090), "Rajiv Chowk Parking")

        // Delay 3 seconds then move to BookAndParkActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, BookAndParkActivity::class.java))// Prevent going back to this screen
        }, 2000)
    }

    private fun addParkingMarker(position: LatLng, title: String) {
        mMap.addMarker(
            MarkerOptions()
                .position(position)
                .title(title)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
    }
}
