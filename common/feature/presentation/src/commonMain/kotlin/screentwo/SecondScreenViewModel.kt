package screentwo

import com.adeo.kviewmodel.BaseSharedViewModel
import screentwo.models.SecondScreenAction
import screentwo.models.SecondScreenEvent
import screentwo.models.SecondScreenViewState

class SecondScreenViewModel(
    currentRate: String?
) : BaseSharedViewModel<SecondScreenViewState, SecondScreenAction, SecondScreenEvent>(
    initialState = SecondScreenViewState(currentRate = currentRate.orEmpty())
) {
    init {
        println("TESTING_TAG - currentRate -$currentRate")
    }

    override fun obtainEvent(viewEvent: SecondScreenEvent) {
        when (viewEvent) {
            SecondScreenEvent.BackClick -> popBackStack()
        }
    }

    private fun popBackStack() {
        viewAction = SecondScreenAction.Back
    }
}
