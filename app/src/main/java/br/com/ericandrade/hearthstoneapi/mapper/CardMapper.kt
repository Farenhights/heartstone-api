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
                        cardId = basicResponse.cardId,
                        dbfId = basicResponse.dbfId,
                        name = basicResponse.name,
                        cardSet = basicResponse.cardSet,
                        type = basicResponse.type,
                        text = basicResponse.text,
                        playerClass = basicResponse.playerClass,
                        locale = basicResponse.locale
                    )
                )
            }
            return basicList
        }
    }
}