package org.example.multimodulesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import compose.theme.AppTheme
import di.PlatformConfiguration
import di.PlatformSDK
import navigation.navigationGraph
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PlatformSDK.init(configuration = PlatformConfiguration(applicationContext = this))
        setContent {
            AppTheme(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = true,
            ) {
                val configuration = OdysseyConfiguration(canvas = this)
                setNavigationContent(configuration) { navigationGraph() }
            }
        }
    }
}
