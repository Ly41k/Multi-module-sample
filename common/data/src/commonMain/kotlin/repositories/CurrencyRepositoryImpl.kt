package repositories

import KtorCurrencyRemoteDataSource
import mappers.interfaces.CurrencyMapper
import models.ExchangeRatesItemModel

class CurrencyRepositoryImpl(
    private val remoteDataSource: KtorCurrencyRemoteDataSource,
    private val currencyMapper: CurrencyMapper
) : CurrencyRepository {
    override suspend fun getCurrencyExchangeRates(): ExchangeRatesItemModel {
        return remoteDataSource.performGetCurrencyExchangeRates().run {
            currencyMapper.toExchangeRatesItemModel(this)
        }
    }
}
