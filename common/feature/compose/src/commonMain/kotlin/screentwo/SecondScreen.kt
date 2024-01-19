package screentwo

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import screentwo.models.SecondScreenAction

@Composable
fun SecondScreen(currentRate: String? = null) {

    val rootController = LocalRootController.current

    StoredViewModel(factory = { SecondScreenViewModel(currentRate) }) { viewModel ->
        val state = viewModel.viewStates().observeAsState().value
        val action = viewModel.viewSingleActions().observeAsState().value

        SecondView(state = state) { viewModel.obtainEvent(it) }

        when (action) {
            SecondScreenAction.Back -> rootController.popBackStack()
            null -> {}
        }
    }
}