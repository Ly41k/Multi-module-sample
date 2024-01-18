package models

data class ExchangeRatesViewItemModel(
    val baseCurrency: String,
    val rates: List<RatesViewItemModel>
){
    fun getRandomRateOrNull(): RatesViewItemModel? = rates.randomOrNull()
}