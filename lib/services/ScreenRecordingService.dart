import 'package:flutter/services.dart';
import 'package:notification_listener_service/notification_listener_service.dart';

class ScreenRecordingService {
  static Future<void> startScreenRecordingListener(
      Function disableAudio, Function enableAudio) async {
    /// check if notification permession is enebaled
    bool status = await NotificationListenerService.isPermissionGranted();

    /// request notification permission
    /// it will open the notifications settings page and return `true` once the permission granted.
    if (!status) {
      status = await NotificationListenerService.requestPermission();
    }

    if (status) {
      /// stream the incoming notification events
      NotificationListenerService.notificationsStream.listen((event) {
        // print("Current notification: $event");
        if (!event.hasRemoved!) {
          if (event.title!.toLowerCase().trim().contains("screen recording") ||
              event.title!.toLowerCase().trim().contains("recording") ||
              event.title!.toLowerCase().trim().contains("screen")) {
            disableAudio();
          }
        }
      });
    }
  }
}
