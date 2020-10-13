package br.com.ericandrade.hearthstoneapi.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel(): ViewModel() {
    var loadingLiveData = MutableLiveData<Boolean>()
    val disposable = CompositeDisposable()
}