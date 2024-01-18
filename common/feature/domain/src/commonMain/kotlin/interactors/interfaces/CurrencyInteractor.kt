package interactors.interfaces

import kotlinx.coroutines.flow.Flow
import models.ExchangeRatesViewItemModel
import models.RatesViewItemModel

interface CurrencyInteractor {
    val currencyRatesFlow: Flow<ExchangeRatesViewItemModel>
}
