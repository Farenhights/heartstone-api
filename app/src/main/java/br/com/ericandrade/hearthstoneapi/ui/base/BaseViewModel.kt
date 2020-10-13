package br.com.ericandrade.hearthstoneapi.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel(): ViewModel() {
    var loadingLiveData = MutableLiveData<Boolean>()

}