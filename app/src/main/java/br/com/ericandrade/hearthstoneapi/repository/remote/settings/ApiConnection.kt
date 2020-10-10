package br.com.ericandrade.hearthstoneapi.repository.remote.settings

import br.com.ericandrade.hearthstoneapi.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnection {

    fun <S> create(
        host: String,
        serviceClass: Class<S>
    ): S {

        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) interceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(host)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(serviceClass)
    }
}

//private val api = apiConnection.create(BuildConfig.API_URL_CARD, CardApi::class.java)
//}

/*
val repositoryModule = module {
    single { CardRepository( get(), get()) }
    single { UserRepository( get(), get()) }
    single { SessionRepository( get()) }
    single { NavigationRepository( get()) }
    single { PromotionRepository( get()) }
    single { AppCacheRepository( get()) }
    single { SecurityRepository( get()) }
    single { FacebookRepository( get()) }
    single { PlaceRepository( get()) }
    single { SelfServiceRepository( get(), get()) }
    single { MarketCloudRepository( get(), get(), get() ) }
    single { GoogleAdsBuilder() }
    single { NetworkDeliveryRepository( get() ) }
    single { GooglePlacesRepository( get() ) }
    single { RemoteConfigRepository() }

    single { CardService( get()) }
    single { PromotionService( get()) }
    single { UserService( get()) }
    single { SecurityService( get()) }
    single { PlaceService( get()) }
    single { SelfService( get()) }
    single { NetworkDeliveryService( get() ) }
    single { GooglePlacesService( get() ) }
}*/
