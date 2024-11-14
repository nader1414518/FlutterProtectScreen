import 'dart:io';

import 'package:flutter/material.dart';
import 'package:screen_protector/screen_protector.dart';
import 'package:youtube_player_flutter/youtube_player_flutter.dart';

class HomeScreen extends StatefulWidget {
  @override
  HomeScreenState createState() => HomeScreenState();
}

class HomeScreenState extends State<HomeScreen> with WidgetsBindingObserver {
  bool isActive = true;
  bool isRecording = false;

  final YoutubePlayerController _controller = YoutubePlayerController(
    initialVideoId: 'QNatk05W9Fw',
    flags: const YoutubePlayerFlags(
      autoPlay: false,
      mute: false,
      hideControls: false,
    ),
  );

  void _preventRecording() async {
    if (Platform.isAndroid) {
      await ScreenProtector.protectDataLeakageOn();
    } else if (Platform.isIOS) {
      await ScreenProtector.preventScreenshotOn();
    }
  }

  void _allowRecording() async {
    if (Platform.isAndroid) {
      await ScreenProtector.protectDataLeakageOff();
    } else if (Platform.isIOS) {
      await ScreenProtector.preventScreenshotOff();
    }
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) async {
    if (state == AppLifecycleState.inactive) {
      // Code to run when the app is overlayed by Control Center
      debugPrint("App is inactive - overlayed by Control Center");
      isActive = false;
    } else if (state == AppLifecycleState.resumed) {
      // Code to run when returning from Control Center
      debugPrint("App is resumed");
      if (Platform.isIOS) {
        var recordingStatus = await ScreenProtector.isRecording();
        setState(() {
          isRecording = recordingStatus;
          isActive = true;
        });

        if (isRecording) {
          _controller.mute();
        } else {
          _controller.unMute();
        }
      }
    }
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    WidgetsBinding.instance.addObserver(this);

    _preventRecording();
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();

    WidgetsBinding.instance.removeObserver(this);

    _allowRecording();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: YoutubePlayer(
          controller: _controller,
          showVideoProgressIndicator: true,
          progressIndicatorColor: Colors.amber,
          progressColors: const ProgressBarColors(
            playedColor: Colors.amber,
            handleColor: Colors.amberAccent,
          ),
          onReady: () {
            // _controller.addListener(listener);
          },
        ),
      ),
    );
  }
}