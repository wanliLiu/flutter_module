package com.soli.flutter_module.host

import android.app.Activity
import io.flutter.MyFlutterApplication

/**
 *
 * @author Soli
 * @Time 2019-08-20 17:19
 */
class DemoApplication : MyFlutterApplication() {

    override fun returnMainActivity(): Activity? {
        return MainActivity.sRef.get()
    }

    override fun inDebug(): Boolean = BuildConfig.DEBUG
}