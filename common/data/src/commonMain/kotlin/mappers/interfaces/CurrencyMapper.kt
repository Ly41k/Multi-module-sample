package mappers.interfaces

import models.ExchangeRatesItemModel
import models.ExchangeRatesResponse

interface CurrencyMapper {
    suspend fun toExchangeRatesItemModel(response: ExchangeRatesResponse): ExchangeRatesItemModel
}
