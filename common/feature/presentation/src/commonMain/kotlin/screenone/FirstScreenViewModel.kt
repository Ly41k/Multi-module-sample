package screenone

import di.Inject
import interactors.interfaces.CurrencyInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import models.ExchangeRatesViewItemModel
import presentation.CoreSharedViewModel
import screenone.models.FirstScreenAction
import screenone.models.FirstScreenEvent
import screenone.models.FirstScreenViewState

class FirstScreenViewModel : CoreSharedViewModel<FirstScreenViewState, FirstScreenAction, FirstScreenEvent>(
    initialState = FirstScreenViewState()
) {

    private val currencyInteractor: CurrencyInteractor = Inject.instance()

    init {
        observeCurrencyRatesFlow()
    }

    override fun obtainEvent(viewEvent: FirstScreenEvent) {
        when (viewEvent) {
            FirstScreenEvent.ButtonClick -> openSecondScreen()
        }
    }

    private fun observeCurrencyRatesFlow() {
        currencyInteractor.currencyRatesFlow
            .onStart { updateRatesLoading(true) }
            .map { viewItem -> viewItem.copy(rates = viewItem.rates.filter { it.rate > 0 }) }
            .onEach { obtainCurrencyRates(it) }
            .onCompletion { updateRatesLoading(false) }
            .catch { throwable -> handleThrowable(throwable) }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    private fun openSecondScreen() {
        val currencyRate = viewState.getCurrencyRate()
        viewSingleAction = FirstScreenAction.OpenSecondScreen(currencyRate)
    }

    private fun obtainCurrencyRates(viewItem: ExchangeRatesViewItemModel) {
        viewState = viewState.copy(
            rates = viewItem.rates,
            baseCurrency = viewItem.baseCurrency,
            randomRate = viewItem.getRandomRateOrNull()
        )
    }

    private fun handleThrowable(error: Throwable) {
        println(error)
        updateRatesLoading(false)
    }

    private fun updateRatesLoading(isLoading: Boolean) {
        viewState = viewState.copy(isRatesLoading = isLoading)
    }
}