package mappers

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import mappers.interfaces.CurrencyMapper
import models.ExchangeRatesItemModel
import models.ExchangeRatesResponse
import models.RatesItemModel

class CurrencyMapperImpl(private val json: Json) : CurrencyMapper {
    override suspend fun toExchangeRatesItemModel(response: ExchangeRatesResponse): ExchangeRatesItemModel {
        val rates = json.encodeToJsonElement(response.rates).jsonObject.toMap()
            .mapNotNull { map ->
                map.value.toString().toDoubleOrNull()?.let { rate -> RatesItemModel(key = map.key, rate = rate) }
            }
        return ExchangeRatesItemModel(
            base = response.base.orEmpty(),
            date = response.date.orEmpty(),
            rates = rates
        )
    }
}