package br.com.ericandrade.hearthstoneapi.mapper

import br.com.ericandrade.hearthstoneapi.domain.general.Basic
import br.com.ericandrade.hearthstoneapi.domain.general.Card
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.BasicResponse
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardResponse

class CardMapper {
    companion object {
        fun toDomain(cardResponse: CardResponse) =
            Card(basic = toDomain(cardResponse.basicResponse))

        fun toDomain(basicListResponse: List<BasicResponse>): List<Basic> {
            val basicList = arrayListOf<Basic>()

            basicListResponse.forEach { basicResponse ->
                basicList.add(
                    Basic(
                        cardId = basicResponse.cardId ?: String(),
                        dbfId = basicResponse.dbfId ?: Int.MIN_VALUE,
                        name = basicResponse.name ?: String(),
                        cardSet = basicResponse.cardSet ?: String(),
                        type = basicResponse.type ?: String(),
                        faction = basicResponse.faction ?: String(),
                        rarity = basicResponse.rarity ?: String(),
                        text = basicResponse.text ?: String(),
                        race = basicResponse.race ?: String(),
                        playerClass = basicResponse.playerClass ?: String(),
                        locale = basicResponse.locale ?: String()
                    )
                )
            }
            return basicList
        }
    }
}