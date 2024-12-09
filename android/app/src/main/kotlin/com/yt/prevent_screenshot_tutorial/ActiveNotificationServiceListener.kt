// package com.yt.prevent_screenshot_tutorial

// import android.service.notification.NotificationListenerService
// import android.service.notification.StatusBarNotification
// import android.content.Intent
// import android.os.Build
// import androidx.annotation.RequiresApi

// class ActiveNotificationServiceListener : NotificationListenerService() {
//     // public val activeNotifications: MutableList<String> = mutableListOf<String>()

//     // Declare a mutable list to store notification information
//     // companion object {
//     //     private val activeNotifications: MutableList<String> = mutableListOf<String>()  // List of strings to hold notification info

//     //     fun getCurrentActiveNotifications(): List<String> {
//     //         return activeNotifications
//     //     }

//     //     // fun getCurrentActiveNotifications(): MutableList<String> {
//     //     //     return activeNotifications
//     //     // }
//     // }

//     // public fun getCurrentActiveNotifications(): MutableList<String> {
//     //     return activeNotifications
//     // }

//     override fun getActiveNotifications() {
//         super.getActiveNotifications()
//     }

//     override fun onListenerConnected() {
//         super.onListenerConnected()
//         refreshActiveNotifications()
//     }

//     override fun onNotificationPosted(sbn: StatusBarNotification) {
//         super.onNotificationPosted(sbn)

//         // // Create a string representation of the notification
//         // val notificationInfo = "${sbn.packageName}: ${sbn.notification.extras.getString("android.title", "")}"

//         // // Add the notification to the list of active notifications
//         // activeNotifications.add(notificationInfo)
//     }

//     override fun onNotificationRemoved(sbn: StatusBarNotification) {
//         super.onNotificationRemoved(sbn)

//         // // Create a string representation of the notification to remove
//         // val notificationInfo = "${sbn.packageName}: ${sbn.notification.extras.getString("android.title", "")}"

//         // // Remove the notification from the list if it exists
//         // activeNotifications.removeAll { it == notificationInfo }
//     }

//     private fun refreshActiveNotifications() {
//         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//             val intent = Intent("ACTIVE_NOTIFICATIONS")
//             // Send the list of notification strings via Intent
//             intent.putStringArrayListExtra("notifications", ArrayList(activeNotifications))
//             sendBroadcast(intent)
//         }
//     }


//     // // companion object {
//     // //     private val activeNotifications = mutableListOf<Map<String, String>>()

//     // //     fun getActiveNotifications(): List<Map<String, String>> {
//     // //         return activeNotifications
//     // //     }
//     // // }

//     // public fun getCurrentActiveNotifications(): List<Map<String, String>> {
//     //     return activeNotifications
//     // }

//     // override fun onListenerConnected() {
//     //     super.onListenerConnected()
//     //     refreshActiveNotifications()
//     // }

//     // override fun onNotificationPosted(sbn: StatusBarNotification) {
//     //     super.onNotificationPosted(sbn)

//     //     // Create a map of notification details to store
//     //     val notificationInfo = mapOf(
//     //         "packageName" to sbn.packageName,
//     //         "title" to sbn.notification.extras.getString("android.title", ""),
//     //         "text" to sbn.notification.extras.getString("android.text", "")
//     //     )

//     //     // Add the notification to the mutable list
//     //     activeNotifications.add(notificationInfo)
//     // }

//     // override fun onNotificationRemoved(sbn: StatusBarNotification) {
//     //     super.onNotificationRemoved(sbn)

//     //     // Create a map of notification details to remove
//     //     val notificationInfo = mapOf(
//     //         "packageName" to sbn.packageName,
//     //         "title" to sbn.notification.extras.getString("android.title", ""),
//     //         "text" to sbn.notification.extras.getString("android.text", "")
//     //     )

//     //     // Remove the notification from the list
//     //     activeNotifications.removeAll { it == notificationInfo }
//     // }

//     // private fun refreshActiveNotifications() {
//     //     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//     //         val sbns = activeNotifications
//     //         val intent = Intent("ACTIVE_NOTIFICATIONS")
//     //         // Ensure the list is passed properly
//     //         // Flatten the List<Map<String, String>> into a List<KeyValuePair>
//     //         val parcelableList = ArrayList<KeyValuePair>()
//     //         activeNotifications.forEach { map ->
//     //             map.forEach { (key, value) ->
//     //                 parcelableList.add(KeyValuePair(key, value))
//     //             }
//     //         }
//     //         intent.putParcelableArrayListExtra("notifications", parcelableList)
//     //         sendBroadcast(intent)
//     //     }
//     // }
// }
