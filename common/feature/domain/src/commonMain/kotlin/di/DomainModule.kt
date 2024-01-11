package di

import interactors.CurrencyInteractorImpl
import interactors.interfaces.CurrencyInteractor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val domainModule = DI.Module("domainModule") {
    bind<CurrencyInteractor>() with singleton {
        CurrencyInteractorImpl(instance())
    }
}