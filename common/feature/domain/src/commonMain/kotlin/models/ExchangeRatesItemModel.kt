package models

data class ExchangeRatesItemModel(
    val base: String,
    val date: String,
    val rates: List<RatesItemModel>
)