package br.com.ericandrade.hearthstoneapi.mapper

import br.com.ericandrade.hearthstoneapi.domain.general.CardByType
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardByTypeResponse

class CardByTypeMapper {

    companion object {
        fun toDomain(cardsByTypeListResponse: List<CardByTypeResponse>): List<CardByType> {
            val cardsByType = arrayListOf<CardByType>()

            cardsByTypeListResponse.forEach {
                val cardByType =
                    CardByType(
                        cardId = it.cardId,
                        dbfId = it.dbfId,
                        name = it.name,
                        cardSet = it.cardSet,
                        type = it.type,
                        text = it.text,
                        playerClass = it.playerClass,
                        locale = it.locale,
                        mechanics = it.mechanics
                    )
                cardsByType.add(cardByType)
            }
            return cardsByType
        }
    }
}