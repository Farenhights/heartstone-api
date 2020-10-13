package br.com.ericandrade.hearthstoneapi.ui.cards.viewModel

import androidx.lifecycle.MutableLiveData
import br.com.ericandrade.hearthstoneapi.domain.general.CardType
import br.com.ericandrade.hearthstoneapi.repository.remote.HearthStoneRepository
import br.com.ericandrade.hearthstoneapi.ui.base.BaseViewModel

class CardsViewModel(
    private val hearthStoneRepository: HearthStoneRepository
): BaseViewModel() {

    internal val cardsLiveData = MutableLiveData<List<CardType>>()

    fun getCardsByType(playerClass: String) {
        loadingLiveData.value = true
        hearthStoneRepository.getCardsByType(
            playerClass,
            ::onGetCardsByTypeSuccess,
            ::onFailure
        )
    }

    private fun onGetCardsByTypeSuccess(cards: List<CardType>) {
        loadingLiveData.value = false
        cardsLiveData.value = cards
    }

    private fun onFailure(throwable: Throwable) {
        loadingLiveData.value = false
        when (throwable) {
        }
    }
}