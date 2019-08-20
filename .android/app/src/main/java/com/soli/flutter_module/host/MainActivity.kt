package com.soli.flutter_module.host

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.flutter.MyFlutterActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var sRef: WeakReference<MainActivity>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sRef = WeakReference(this)

        setContentView(R.layout.activity_main)
        inFlutter.setOnClickListener {
//            openActivity<MyFlutterActivity>()
            startActivity(Intent(this, MyFlutterActivity::class.java))
        }
        inFlutter1.setOnClickListener { openActivity<SimpleFlutterActivity>() }
    }
}
