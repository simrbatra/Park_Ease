package com.example.park_ease

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class NotificationsActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var notifications: List<NotificationModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        listView = findViewById(R.id.listNotifications)

        notifications = listOf(
            NotificationModel("Your vehicle is parked", "The time will be counted down", "Now", true),
            NotificationModel("You have arrived", "Please scan the code on the parking area", "6 min", false),
            NotificationModel("Successful transaction", "1 parking slot already booked", "1 hour", false)
        )

        listView.adapter = NotificationAdapter(this, notifications)
    }
}
