package br.com.ericandrade.hearthstoneapi.repository.remote.settings

import br.com.ericandrade.hearthstoneapi.BuildConfig
import br.com.ericandrade.hearthstoneapi.repository.remote.settings.interceptor.HeaderInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnection {

    private val headerInterceptor: HeaderInterceptor by inject(HeaderInterceptor::class.java)

    fun <S> create(
        host: String,
        serviceClass: Class<S>
    ): S {

        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) interceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(headerInterceptor)
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
