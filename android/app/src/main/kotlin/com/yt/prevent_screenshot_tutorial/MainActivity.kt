package com.yt.prevent_screenshot_tutorial

import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {

    // private val CHANNEL = "com.yt.prevent_screenshot_tutorial/notifications"

    // override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
    //     super.configureFlutterEngine(flutterEngine)
    //     MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
    //         if (call.method == "getActiveNotifications") {
    //             // Call the service to fetch notifications
    //             val notifications = ActiveNotificationServiceListener.getActiveNotifications()
    //             result.success(notifications)
    //         } else {
    //             result.notImplemented()
    //         }
    //     }
    // }

}
