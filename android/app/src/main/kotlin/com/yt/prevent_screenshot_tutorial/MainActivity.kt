package com.yt.prevent_screenshot_tutorial

import io.flutter.embedding.android.FlutterFragmentActivity

import com.prongbang.screenprotect.AndroidScreenProtector

class MainActivity : FlutterFragmentActivity() {

    private val screenProtector by lazy { AndroidScreenProtector.newInstance(this) }

    // For Android 12+
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        screenProtector.process(hasFocus.not())
    }
}
