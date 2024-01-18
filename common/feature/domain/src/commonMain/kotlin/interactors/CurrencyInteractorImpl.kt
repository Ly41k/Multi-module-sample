package interactors

import interactors.interfaces.CurrencyInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import mappers.toExchangeRatesViewItemModel
import models.ExchangeRatesViewItemModel
import repositories.CurrencyRepository

class CurrencyInteractorImpl(
    private val currencyRepository: CurrencyRepository
) : CurrencyInteractor {

    private val _currencyRatesFlow = flow {
        emit(currencyRepository.getCurrencyExchangeRates())
    }.map { it.toExchangeRatesViewItemModel() }

    override val currencyRatesFlow: Flow<ExchangeRatesViewItemModel> = _currencyRatesFlow

}
