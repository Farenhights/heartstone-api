package br.com.ericandrade.hearthstoneapi.repository.remote.service.response

import com.google.gson.annotations.SerializedName

class CardTypeResponse(
    @SerializedName("cardId") val cardId: String,
    @SerializedName("dbfId") val dbfId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("cardSet") val cardSet: String,
    @SerializedName("type") val type: String,
    @SerializedName("text") val text: String,
    @SerializedName("playerClass") val playerClass: String,
    @SerializedName("img") val img: String,
    @SerializedName("locale") val locale: String,
    @SerializedName("mechanics") val mechanics: List<MechanicResponse>
)