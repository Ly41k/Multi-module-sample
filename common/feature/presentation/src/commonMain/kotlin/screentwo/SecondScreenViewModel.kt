package screentwo

import presentation.CoreSharedViewModel
import screentwo.models.SecondScreenAction
import screentwo.models.SecondScreenEvent
import screentwo.models.SecondScreenViewState

class SecondScreenViewModel(
    currentRate: String?
) : CoreSharedViewModel<SecondScreenViewState, SecondScreenAction, SecondScreenEvent>(
    initialState = SecondScreenViewState(currentRate = currentRate.orEmpty())
) {

    override fun obtainEvent(viewEvent: SecondScreenEvent) {
        when (viewEvent) {
            SecondScreenEvent.BackClick -> popBackStack()
        }
    }

    private fun popBackStack() {
        viewSingleAction = SecondScreenAction.Back
    }
}
