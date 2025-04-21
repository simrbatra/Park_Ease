package com.example.park_ease

data class NotificationModel(
    val title: String,
    val message: String,
    val time: String,
    val isActive: Boolean = false
)
