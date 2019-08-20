package com.soli.flutter_module.host

import android.os.Bundle
import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant

/**
 *
 * @author Soli
 * @Time 2019-08-20 18:11
 */
class SimpleFlutterActivity : FlutterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegistrant.registerWith(this)
    }
}