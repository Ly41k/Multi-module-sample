import models.ExchangeRatesResponse

interface CurrencyRepository {
    suspend fun getCurrencyExchangeRates(): ExchangeRatesResponse
}