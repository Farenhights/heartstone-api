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

    @GET("cards/races/{playerClass}")
    fun getCardsByRace(
        @Path("playerClass") playerClass: String
    ) : Observable<List<CardTypeResponse>>

    @GET("cards/qualities/{playerClass}")
    fun getCardsByQuality(
        @Path("playerClass") playerClass: String
    ) : Observable<List<CardTypeResponse>>

    @GET("cards/types/{playerClass}")
    fun getCardsByType(
        @Path("playerClass") playerClass: String
    ) : Observable<List<CardTypeResponse>>

    @GET("cards/factions/{playerClass}")
    fun getCardsByFaction(
        @Path("playerClass") playerClass: String
    ) : Observable<List<CardTypeResponse>>
}