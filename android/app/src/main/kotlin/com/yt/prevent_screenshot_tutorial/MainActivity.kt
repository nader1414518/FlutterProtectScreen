package com.yt.prevent_screenshot_tutorial

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;

class MainActivity : FlutterActivity() {

    // private val CHANNEL = "audioMuteChannel"

    // override fun onCreate(savedInstanceState: Bundle?) {
    //     super.onCreate(savedInstanceState)

    //     // Safe access to flutterEngine to avoid NullPointerException
    //     flutterEngine?.let { engine ->
    //         MethodChannel(engine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
    //             if (call.method == "isRecordingAudio") {
    //                 // Ensure only one response is sent
    //                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    //                     val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
    //                     try {
    //                         val method = audioManager::class.java.getMethod("isAudioRecording")
    //                         val isRecording = method.invoke(audioManager) as Boolean
    //                         result.success(isRecording)  // Only one result.success() here
    //                     } catch (e: Exception) {
    //                         println(e);
    //                         result.error("UNAVAILABLE", "Method isAudioRecording is not available", null) // Only one error response
    //                     }
    //                 } else {
    //                     result.success(false)  // Only one result.success() here
    //                 }
    //             } else {
    //                 result.notImplemented()  // Make sure only one response is sent
    //             }
    //         }
    //     }
    // }

}
