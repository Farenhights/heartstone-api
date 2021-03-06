package br.com.ericandrade.hearthstoneapi.repository.remote.service

import br.com.ericandrade.hearthstoneapi.BuildConfig
import br.com.ericandrade.hearthstoneapi.repository.remote.api.HeartStoneApi
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardResponse
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardTypeResponse
import br.com.ericandrade.hearthstoneapi.repository.remote.settings.ApiConnection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HeartStoneService(apiConnection: ApiConnection) {

    private val api = apiConnection.create(BuildConfig.API_BASE_URL, HeartStoneApi::class.java)

    internal fun getCards(): Observable<CardResponse> {
        return api
            .getCards()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    internal fun getCardsByClass(playerClass: String): Observable<List<CardTypeResponse>> {
        return api
            .getCardsByClass(playerClass)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    internal fun getCardsByRace(race: String): Observable<List<CardTypeResponse>> {
        return api
            .getCardsByRace(race)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    internal fun getCardsByQuality(quality: String): Observable<List<CardTypeResponse>> {
        return api
            .getCardsByQuality(quality)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    internal fun getCardsByType(type: String): Observable<List<CardTypeResponse>> {
        return api
            .getCardsByType(type)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    internal fun getCardsByFaction(faction: String): Observable<List<CardTypeResponse>> {
        return api
            .getCardsByFaction(faction)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}