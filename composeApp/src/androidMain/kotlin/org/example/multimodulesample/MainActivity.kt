package org.example.multimodulesample

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        PlatformSDK.init(configuration = PlatformConfiguration(applicationContext = this))
        setContent { App() }
    }
}
