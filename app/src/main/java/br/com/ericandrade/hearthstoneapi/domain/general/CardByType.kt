package br.com.ericandrade.hearthstoneapi.domain.general

import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.MechanicResponse

class CardByType(
    val cardId: String = String(),
    val dbfId: Int = Int.MIN_VALUE,
    val name: String = String(),
    val cardSet: String = String(),
    val type: String = String(),
    val text: String = String(),
    val playerClass: String = String(),
    val locale: String = String(),
    val mechanics: List<MechanicResponse> = listOf()
)