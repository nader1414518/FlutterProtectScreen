package com.yt.prevent_screenshot_tutorial

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.os.Build
import androidx.annotation.RequiresApi

class ActiveNotificationServiceListener : NotificationListenerService() {

    companion object {
        private val activeNotifications = mutableListOf<Map<String, String>>()

        fun getActiveNotifications(): List<Map<String, String>> {
            return activeNotifications
        }
    }

    override fun onListenerConnected() {
        super.onListenerConnected()
        refreshActiveNotifications()
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        // Add notification to active list
        val notificationInfo = mapOf(
            "packageName" to sbn.packageName,
            "title" to sbn.notification.extras.getString("android.title", ""),
            "text" to sbn.notification.extras.getString("android.text", "")
        )
        activeNotifications.add(notificationInfo)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        super.onNotificationRemoved(sbn)
        // Remove notification from active list
        val notificationInfo = mapOf(
            "packageName" to sbn.packageName,
            "title" to sbn.notification.extras.getString("android.title", ""),
            "text" to sbn.notification.extras.getString("android.text", "")
        )
        activeNotifications.remove(notificationInfo)
    }

    private fun refreshActiveNotifications() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val sbns = activeNotifications
            // Broadcast active notifications to Flutter
            val intent = Intent("ACTIVE_NOTIFICATIONS")
            intent.putParcelableArrayListExtra("notifications", ArrayList(sbns))
            sendBroadcast(intent)
        }
    }
}
