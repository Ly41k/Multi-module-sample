package screenone

import com.adeo.kviewmodel.BaseSharedViewModel
import screenone.models.FirstScreenAction
import screenone.models.FirstScreenEvent
import screenone.models.FirstScreenViewState

class FirstScreenViewModel : BaseSharedViewModel<FirstScreenViewState, FirstScreenAction, FirstScreenEvent>(
    initialState = FirstScreenViewState()
) {
    override fun obtainEvent(viewEvent: FirstScreenEvent) {
        TODO("Not yet implemented")
    }
}