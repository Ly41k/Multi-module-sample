import ktor.KtorCurrencyRemoteDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val dataModule = DI.Module("dataModule") {
    bind<CurrencyRepository>() with singleton {
        CurrencyRepositoryImpl(instance())
    }

    bind<KtorCurrencyRemoteDataSource>() with provider {
        KtorCurrencyRemoteDataSource(instance())
    }
}
