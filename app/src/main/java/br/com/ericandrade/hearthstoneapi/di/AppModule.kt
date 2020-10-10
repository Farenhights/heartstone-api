package br.com.ericandrade.hearthstoneapi.di

import br.com.ericandrade.hearthstoneapi.repository.remote.settings.ApiConnection
import org.koin.dsl.module

val apiConnectionModule = module {
    factory { ApiConnection() }
}

val viewModelModule = module { }

val repositoryModule = module { }
