import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import compose.theme.AppTheme
import di.PlatformConfiguration
import di.PlatformSDK
import navigation.navigationGraph
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

fun MainViewController() = ComposeUIViewController {
    PlatformSDK.init(PlatformConfiguration())
    val isDarkTheme =
        UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark

    AppTheme(
        darkTheme = isDarkTheme,
        dynamicColor = false
    ) {
        val backgroundColor = MaterialTheme.colorScheme.background

        val odysseyConfiguration = OdysseyConfiguration(
            backgroundColor = backgroundColor
        )

        Column {
            Box(modifier = Modifier.fillMaxWidth().height(30.dp).background(backgroundColor))
            setNavigationContent(odysseyConfiguration) { navigationGraph() }
            Box(modifier = Modifier.fillMaxWidth().height(30.dp).background(backgroundColor))
        }
    }
}
