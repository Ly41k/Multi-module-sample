package di

import KtorCurrencyRemoteDataSource
import mappers.CurrencyMapperImpl
import mappers.interfaces.CurrencyMapper
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import repositories.CurrencyRepository
import repositories.CurrencyRepositoryImpl

val dataModule = DI.Module("dataModule") {
    bind<CurrencyRepository>() with singleton {
        CurrencyRepositoryImpl(instance(), instance())
    }

    bind<KtorCurrencyRemoteDataSource>() with provider {
        KtorCurrencyRemoteDataSource(instance())
    }

    bind<CurrencyMapper>() with provider {
        CurrencyMapperImpl(instance())
    }
}
