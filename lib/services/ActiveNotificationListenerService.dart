import 'package:flutter/services.dart';

class Activenotificationlistenerservice {
  static const platform =
      MethodChannel('com.example.my_flutter_app/notifications');

  static Future<List<Map<String, String>>> getActiveNotifications() async {
    try {
      final List<dynamic> notifications =
          await platform.invokeMethod('getActiveNotifications');
      return notifications.cast<Map<String, String>>();
    } on PlatformException catch (e) {
      print("Error getting notifications: $e");
      return [];
    }
  }
}
