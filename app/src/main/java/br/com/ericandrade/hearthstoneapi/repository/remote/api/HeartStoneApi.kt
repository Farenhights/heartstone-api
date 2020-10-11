package br.com.ericandrade.hearthstoneapi.repository.remote.api

import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardByTypeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeartStoneApi {

    @GET("cards/classes/{playerClass}")
    fun getCardsByType(
        @Path("playerClass") playerClass: String
    ) : Observable<List<CardByTypeResponse>>
}