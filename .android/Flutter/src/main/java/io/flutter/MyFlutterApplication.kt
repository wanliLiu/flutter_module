package io.flutter

import android.app.Activity
import android.app.Application
import android.content.Context
import com.taobao.idlefish.flutterboost.Debuger
import com.taobao.idlefish.flutterboost.FlutterBoostPlugin
import com.taobao.idlefish.flutterboost.interfaces.IPlatform
import io.flutter.app.FlutterApplication

/**
 *
 * @author Soli
 * @Time 2019-08-20 17:19
 */
abstract class MyFlutterApplication : FlutterApplication() {

    override fun onCreate() {
        super.onCreate()

        initFlutterBoost()
    }

    /**
     *
     */
    private fun initFlutterBoost() {
        FlutterBoostPlugin.init(object : IPlatform {

            override fun getApplication(): Application = this@MyFlutterApplication

            /**
             * 获取应用入口的Activity,这个Activity在应用交互期间应该是一直在栈底的
             * @return
             */
            override fun getMainActivity(): Activity? = returnMainActivity()

            override fun isDebug(): Boolean = inDebug()


            /**
             * 如果flutter想打开一个本地页面，将会回调这个方法，页面参数将会拼接在url中
             *
             * 例如：sample://nativePage?aaa=bbb
             *
             * 参数就是类似 aaa=bbb 这样的键值对
             *
             * @param context
             * @param url
             * @param requestCode
             * @return
             */
            override fun startActivity(context: Context?, url: String?, requestCode: Int): Boolean {
                Debuger.log("startActivity url=$url")
                return true
            }

            override fun getSettings(): HashMap<String, String> {
                val te = HashMap<String, String>()
                te["type"] = "Android"
                return te
            }

        })
    }


    abstract fun returnMainActivity(): Activity?

    abstract fun inDebug(): Boolean
}