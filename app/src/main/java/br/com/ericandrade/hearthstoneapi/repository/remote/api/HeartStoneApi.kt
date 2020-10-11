package br.com.ericandrade.hearthstoneapi.repository.remote.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeartStoneApi {

    @GET("cards/classes/{playerClass}")
    fun getSecurityFeatures(
        @Path("playerClass") playerClass: String
    ) : Observable<CardSecurityFeaturesResponse>
}