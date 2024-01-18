package navigation

import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import screenone.FirstScreen
import screentwo.SecondScreen
import utils.NavigationTree

fun RootComposeBuilder.featureFlow() {
    flow(name = NavigationTree.SomeFeature.FeatureFlow.name) {
        screen(name = NavigationTree.SomeFeature.FeatureScreenOne.name) { FirstScreen() }
        screen(name = NavigationTree.SomeFeature.FeatureScreenTwo.name) { SecondScreen(currentRate = it as String) }
    }
}