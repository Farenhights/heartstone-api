package br.com.ericandrade.hearthstoneapi.repository.remote.service

import br.com.ericandrade.hearthstoneapi.BuildConfig
import br.com.ericandrade.hearthstoneapi.repository.remote.api.HeartStoneApi
import br.com.ericandrade.hearthstoneapi.repository.remote.settings.ApiConnection

class HeartStoneService(apiConnection: ApiConnection) {

    private val api = apiConnection.create(BuildConfig.API_BASE_URL, HeartStoneApi::class.java)
}