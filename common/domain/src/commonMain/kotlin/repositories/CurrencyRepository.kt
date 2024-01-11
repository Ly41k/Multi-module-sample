package repositories

import models.ExchangeRatesItemModel

interface CurrencyRepository {
    suspend fun getCurrencyExchangeRates(): ExchangeRatesItemModel
}