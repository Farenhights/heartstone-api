package br.com.ericandrade.hearthstoneapi.repository.remote.api

import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardResponse
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardTypeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HeartStoneApi {

    @GET("cards/classes/{playerClass}")
    fun getCardsByType(
        @Path("playerClass") playerClass: String
    ) : Observable<List<CardTypeResponse>>

    @GET("cards")
    fun getCards() : Observable<CardResponse>
}