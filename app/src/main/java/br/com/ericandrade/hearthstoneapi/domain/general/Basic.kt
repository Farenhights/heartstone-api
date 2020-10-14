package br.com.ericandrade.hearthstoneapi.domain.general

import java.io.Serializable

class Basic(
    val cardId: String,
    val dbfId: Int,
    val name: String,
    val cardSet: String,
    val type: String,
    val text: String,
    val race: String,
    val playerClass: String,
    val locale: String
): Serializable