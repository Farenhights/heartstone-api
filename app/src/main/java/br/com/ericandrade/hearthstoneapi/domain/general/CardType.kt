package br.com.ericandrade.hearthstoneapi.domain.general

import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.MechanicResponse

class CardType(
    val cardId: String,
    val dbfId: Int,
    val name: String,
    val cardSet: String,
    val type: String,
    val text: String,
    val playerClass: String,
    val locale: String,
    val mechanics: List<MechanicResponse>
)