package br.com.ericandrade.hearthstoneapi.repository.remote

import br.com.ericandrade.hearthstoneapi.domain.general.CardByType
import br.com.ericandrade.hearthstoneapi.mapper.CardByTypeMapper
import br.com.ericandrade.hearthstoneapi.repository.remote.service.HeartStoneService
import io.reactivex.disposables.Disposable

class HearthStoneRepository(
    private val heartStoneService: HeartStoneService
) {
    fun getCardsByType(
        playerClass: String,
        onSuccess: (List<CardByType>) -> Unit,
        onFailure: (Throwable) -> Unit
    ): Disposable {
        return heartStoneService
            .getCardsByType(playerClass)
            .map { cardsByTypeResponse -> CardByTypeMapper.toDomain(cardsByTypeResponse) }
            .subscribe(onSuccess, onFailure)
    }
}