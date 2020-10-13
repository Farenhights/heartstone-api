package br.com.ericandrade.hearthstoneapi.repository.remote.service.response

import com.google.gson.annotations.SerializedName

class CardResponse(
    @SerializedName("Basic") val basicResponse: List<BasicResponse>
)