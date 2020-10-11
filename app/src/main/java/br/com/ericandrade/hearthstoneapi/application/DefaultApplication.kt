package br.com.ericandrade.hearthstoneapi.application

import android.app.Application
import br.com.ericandrade.hearthstoneapi.di.apiConnectionModule
import br.com.ericandrade.hearthstoneapi.di.repositoryModule
import br.com.ericandrade.hearthstoneapi.di.serviceModule
import br.com.ericandrade.hearthstoneapi.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DefaultApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DefaultApplication)
            koin.loadModules(
                listOf(
                    apiConnectionModule,
                    viewModelModule,
                    repositoryModule,
                    serviceModule
                )
            )
            koin.createRootScope()
        }
    }
}