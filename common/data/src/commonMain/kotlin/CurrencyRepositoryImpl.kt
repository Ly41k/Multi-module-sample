import ktor.KtorCurrencyRemoteDataSource
import models.ExchangeRatesResponse

class CurrencyRepositoryImpl(
    private val remoteDataSource: KtorCurrencyRemoteDataSource
) : CurrencyRepository {
    override suspend fun getCurrencyExchangeRates(): ExchangeRatesResponse =
        remoteDataSource.performGetCurrencyExchangeRates()
}
