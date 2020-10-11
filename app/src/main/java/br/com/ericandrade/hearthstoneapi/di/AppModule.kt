package br.com.ericandrade.hearthstoneapi.di

import br.com.ericandrade.hearthstoneapi.repository.remote.settings.ApiConnection
import br.com.ericandrade.hearthstoneapi.repository.remote.settings.interceptor.HeaderInterceptor
import org.koin.dsl.module

val apiConnectionModule = module {
    factory { ApiConnection() }
    factory { HeaderInterceptor() }
}

val viewModelModule = module { }

val repositoryModule = module { }
