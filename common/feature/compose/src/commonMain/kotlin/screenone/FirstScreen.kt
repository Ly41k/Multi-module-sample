package screenone

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import screenone.models.FirstScreenAction
import utils.NavigationTree

@Composable
fun FirstScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { FirstScreenViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState().value
        val action = viewModel.viewActions().observeAsState().value

        FirstView(state = state) { viewModel.obtainEvent(it) }

        when (action) {
            is FirstScreenAction.OpenSecondScreen ->
                rootController.push(
                    screen = NavigationTree.SomeFeature.FeatureScreenTwo.name,
                    params = action.value
                )

            null -> {}

        }
    }

}