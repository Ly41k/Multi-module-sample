package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path
import models.ExchangeRatesResponse

class KtorCurrencyRemoteDataSource(private val httpClient: HttpClient) {
    suspend fun performGetCurrencyExchangeRates(): ExchangeRatesResponse {
        return httpClient.get { url { path("currency-exchange-rates") } }.body()
    }
}
