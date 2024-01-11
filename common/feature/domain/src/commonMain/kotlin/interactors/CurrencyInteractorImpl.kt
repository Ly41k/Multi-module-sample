package interactors

import interactors.interfaces.CurrencyInteractor
import repositories.CurrencyRepository

class CurrencyInteractorImpl(
    private val currencyRepository: CurrencyRepository
) : CurrencyInteractor {


    override fun getCurrencyExchangeRates() {
        TODO("Not yet implemented")
    }

    fun get() {


    }


}


