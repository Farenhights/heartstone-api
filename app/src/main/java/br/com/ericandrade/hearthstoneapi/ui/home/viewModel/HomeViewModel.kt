package br.com.ericandrade.hearthstoneapi.ui.home.viewModel

import androidx.lifecycle.MutableLiveData
import br.com.ericandrade.hearthstoneapi.domain.general.Card
import br.com.ericandrade.hearthstoneapi.domain.general.CardType
import br.com.ericandrade.hearthstoneapi.repository.remote.HearthStoneRepository
import br.com.ericandrade.hearthstoneapi.ui.base.BaseViewModel

class HomeViewModel(
   private val hearthStoneRepository: HearthStoneRepository
): BaseViewModel() {

    internal val cardsListLiveData = MutableLiveData<List<CardType>>()
    internal val cardLiveData = MutableLiveData<Card>()

    fun getCardsByType(playerClass: String) {
        hearthStoneRepository.getCardsByType(
            playerClass,
            ::onGetCardsByTypeSuccess,
            ::onFailure
        )
    }

    private fun onGetCardsByTypeSuccess(cardTypes: List<CardType>) {
        cardsListLiveData.value = cardTypes
    }

    fun getCards() {
        hearthStoneRepository.getCards(
            ::onGetCardsSuccess,
            ::onFailure
        )
    }

    private fun onGetCardsSuccess(card: Card) {
        cardLiveData.value = card
    }

    private fun onFailure(throwable: Throwable) {
        when (throwable) {
        }
    }
}