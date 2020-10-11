package br.com.ericandrade.hearthstoneapi.repository.remote.service

import br.com.ericandrade.hearthstoneapi.BuildConfig
import br.com.ericandrade.hearthstoneapi.repository.remote.api.HeartStoneApi
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardByTypeResponse
import br.com.ericandrade.hearthstoneapi.repository.remote.settings.ApiConnection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HeartStoneService(apiConnection: ApiConnection) {

    private val api = apiConnection.create(BuildConfig.API_BASE_URL, HeartStoneApi::class.java)

    internal fun getCardsByType(playerClass: String): Observable<List<CardByTypeResponse>> {
        return api
            .getCardsByType(playerClass)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}