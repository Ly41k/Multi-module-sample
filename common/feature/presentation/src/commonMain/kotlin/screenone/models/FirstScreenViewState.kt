package screenone.models

import models.RatesViewItemModel

data class FirstScreenViewState(
    val title: String = "First Screen",
    val baseCurrency: String = "",
    val rates: List<RatesViewItemModel> = emptyList(),
    val isRatesLoading: Boolean = false,
    val randomRate: RatesViewItemModel? = null
) {

    fun getCurrencyRate(): String {
        val rateString = getRateString()
        return when {
            baseCurrency.isEmpty() -> "Not receive"
            rateString.isEmpty() -> "Not receive"
            else -> "1 $baseCurrency = $rateString"
        }
    }

    private fun getRateString(model: RatesViewItemModel? = null): String {
        val rate = model ?: randomRate
        return rate?.let { "${it.key}: ${it.rate}" } ?: ""
    }
}