import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:notification_listener_service/notification_listener_service.dart';

class ActiveNotificationListenerService {
  static const platform =
      MethodChannel('com.yt.prevent_screenshot_tutorial/notifications');

  // static Future<List<Map<String, String>>> getActiveNotifications() async {
  //   try {
  //     // final List<dynamic> notifications =
  //     //     await platform.invokeMethod('getActiveNotifications');
  //     // return notifications.cast<Map<String, String>>();

  //     // NotificationListenerService.notificationsStream.toList();
  //   } on PlatformException catch (e) {
  //     print("Error getting notifications: $e");
  //     return [];
  //   }
  // }
}
