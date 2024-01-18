package mappers

import models.ExchangeRatesItemModel
import models.ExchangeRatesViewItemModel
import models.RatesItemModel
import models.RatesViewItemModel

fun ExchangeRatesItemModel.toExchangeRatesViewItemModel(): ExchangeRatesViewItemModel {
    return ExchangeRatesViewItemModel(
        baseCurrency = base,
        rates = rates.map { it.toRatesViewItemModel() }
    )
}

private fun RatesItemModel.toRatesViewItemModel(): RatesViewItemModel = RatesViewItemModel(key, rate)
