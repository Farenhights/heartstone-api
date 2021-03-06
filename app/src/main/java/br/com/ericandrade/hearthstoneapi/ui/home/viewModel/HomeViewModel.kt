package br.com.ericandrade.hearthstoneapi.ui.home.viewModel

import androidx.lifecycle.MutableLiveData
import br.com.ericandrade.hearthstoneapi.domain.general.Basic
import br.com.ericandrade.hearthstoneapi.domain.general.Card
import br.com.ericandrade.hearthstoneapi.domain.general.CardType
import br.com.ericandrade.hearthstoneapi.repository.remote.HearthStoneRepository
import br.com.ericandrade.hearthstoneapi.ui.base.BaseViewModel

class HomeViewModel(
    private val hearthStoneRepository: HearthStoneRepository
) : BaseViewModel() {

    internal val cardBasicInformationListLiveData = MutableLiveData<List<Basic>>()

    fun getCards() {
        loadingLiveData.value = true
        hearthStoneRepository.getCards(
            ::onGetCardsSuccess,
            ::onFailure
        )
    }

    private fun onGetCardsSuccess(card: Card) {
        loadingLiveData.value = false
        val cardBasicInformationList = card.basic.distinctBy { it.playerClass }
        cardBasicInformationListLiveData.value = cardBasicInformationList
    }

    private fun onFailure(throwable: Throwable) {
        loadingLiveData.value = false
        when (throwable) {
        }
    }
}