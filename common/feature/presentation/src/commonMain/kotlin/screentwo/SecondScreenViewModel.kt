package screentwo

import com.adeo.kviewmodel.BaseSharedViewModel
import screentwo.models.SecondScreenAction
import screentwo.models.SecondScreenEvent
import screentwo.models.SecondScreenViewState

class SecondScreenViewModel : BaseSharedViewModel<SecondScreenViewState, SecondScreenAction, SecondScreenEvent>(
    initialState = SecondScreenViewState()
) {
    override fun obtainEvent(viewEvent: SecondScreenEvent) {
        TODO("Not yet implemented")
    }
}
