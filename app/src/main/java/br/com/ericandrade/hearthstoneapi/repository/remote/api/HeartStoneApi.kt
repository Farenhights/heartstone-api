package br.com.ericandrade.hearthstoneapi.repository.remote.api

import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardResponse
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardTypeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HeartStoneApi {

    @GET("cards")
    fun getCards() : Observable<CardResponse>

    @GET("cards/classes/{playerClass}")
    fun getCardsByClass(
        @Path("playerClass") playerClass: String
    ) : Observable<List<CardTypeResponse>>

    @GET("cards/races/{race}")
    fun getCardsByRace(
        @Path("race") playerClass: String
    ) : Observable<List<CardTypeResponse>>

    @GET("cards/qualities/{quality}")
    fun getCardsByQuality(
        @Path("quality") playerClass: String
    ) : Observable<List<CardTypeResponse>>

    @GET("cards/types/{type}")
    fun getCardsByType(
        @Path("type") playerClass: String
    ) : Observable<List<CardTypeResponse>>

    @GET("cards/factions/{faction}")
    fun getCardsByFaction(
        @Path("faction") playerClass: String
    ) : Observable<List<CardTypeResponse>>
}