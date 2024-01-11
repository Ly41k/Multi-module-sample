package screentwo

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun SecondScreen() {

    val rootController = LocalRootController.current

    StoredViewModel(factory = { SecondScreenViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState().value
        val action = viewModel.viewActions().observeAsState().value

        SecondView(state = state) { viewModel.obtainEvent(it) }

        when (action) {


            null -> {}

        }
    }

}