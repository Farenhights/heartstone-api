package br.com.ericandrade.hearthstoneapi.ui.cards.viewModel

import androidx.lifecycle.MutableLiveData
import br.com.ericandrade.hearthstoneapi.domain.general.CardType
import br.com.ericandrade.hearthstoneapi.repository.remote.HearthStoneRepository
import br.com.ericandrade.hearthstoneapi.ui.base.BaseViewModel
import br.com.ericandrade.hearthstoneapi.ui.cards.model.CardsModel

class CardsViewModel(
    private val hearthStoneRepository: HearthStoneRepository
): BaseViewModel() {

    internal val cardsLiveData = MutableLiveData<List<CardType>>()
    var cardsModel = CardsModel()

    fun getCardsByClass(playerClass: String) {
        loadingLiveData.value = true
        hearthStoneRepository.getCardsByClass(
            playerClass,
            ::onGetCardsSuccess,
            ::onFailure
        )
    }

    fun getCardsByRace(race: String) {
        loadingLiveData.value = true
        hearthStoneRepository.getCardsByRace(
            race,
            ::onGetCardsSuccess,
            ::onFailure
        )
    }

    fun getCardsByQuality(quality: String) {
        loadingLiveData.value = true
        hearthStoneRepository.getCardsByQuality(
            quality,
            ::onGetCardsSuccess,
            ::onFailure
        )
    }

    fun getCardsByType(type: String) {
        loadingLiveData.value = true
        hearthStoneRepository.getCardsByType(
            type,
            ::onGetCardsSuccess,
            ::onFailure
        )
    }

    fun getCardsByFaction(faction: String) {
        loadingLiveData.value = true
        hearthStoneRepository.getCardsByFaction(
            faction,
            ::onGetCardsSuccess,
            ::onFailure
        )
    }

    private fun onGetCardsSuccess(cards: List<CardType>) {
        loadingLiveData.value = false
        cardsLiveData.value = cards
    }

    private fun onFailure(throwable: Throwable) {
        loadingLiveData.value = false
        when (throwable) {
        }
    }

    internal fun setTitle(title: String) {
        cardsModel.title = title
    }
}