package br.com.ericandrade.hearthstoneapi.ui.home.viewModel

import androidx.lifecycle.MutableLiveData
import br.com.ericandrade.hearthstoneapi.domain.general.CardByType
import br.com.ericandrade.hearthstoneapi.repository.remote.HearthStoneRepository
import br.com.ericandrade.hearthstoneapi.ui.base.BaseViewModel
import java.lang.Exception

class HomeViewModel(
   private val hearthStoneRepository: HearthStoneRepository
): BaseViewModel() {

    internal val cardsByTypeListLiveData = MutableLiveData<List<CardByType>>()

    fun getCardsByType(playerClass: String) {
        hearthStoneRepository.getCardsByType(
            playerClass,
            ::onGetCardsByTypeSuccess,
            ::onFailure
        )
    }

    private fun onGetCardsByTypeSuccess(cardsByType: List<CardByType>) {
        cardsByTypeListLiveData.value = cardsByType
    }

    private fun onFailure(throwable: Throwable) {
        when (throwable) {
        }
    }
}