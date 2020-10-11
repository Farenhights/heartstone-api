package br.com.ericandrade.hearthstoneapi.repository.remote.service.response

import com.google.gson.annotations.SerializedName

class MechanicResponse(
    @SerializedName("name") val name: String
)