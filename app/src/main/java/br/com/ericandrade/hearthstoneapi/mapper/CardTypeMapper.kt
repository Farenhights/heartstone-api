package br.com.ericandrade.hearthstoneapi.mapper

import br.com.ericandrade.hearthstoneapi.domain.general.CardType
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardTypeResponse

class CardTypeMapper {

    companion object {
        fun toDomain(cardsTypeResponse: List<CardTypeResponse>): List<CardType> {
            val cardsByType = arrayListOf<CardType>()

            cardsTypeResponse.forEach {
                val cardByType =
                    CardType(
                        cardId = it.cardId ?: String(),
                        dbfId = it.dbfId ?: Int.MIN_VALUE,
                        name = it.name ?: String(),
                        cardSet = it.cardSet ?: String(),
                        type = it.type ?: String(),
                        text = it.text ?: String(),
                        playerClass = it.playerClass ?: String(),
                        locale = it.locale ?: String(),
                        mechanics = it.mechanics ?: listOf()
                    )
                cardsByType.add(cardByType)
            }
            return cardsByType
        }
    }
}