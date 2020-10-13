package br.com.ericandrade.hearthstoneapi.domain.general

import com.google.gson.annotations.SerializedName

class Basic(
    val cardId: String,
    val dbfId: Int,
    val name: String,
    val cardSet: String,
    val type: String,
    val text: String,
    val playerClass: String,
    val locale: String
)