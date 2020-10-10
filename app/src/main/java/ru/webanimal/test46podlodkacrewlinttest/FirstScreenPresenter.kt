package ru.webanimal.test46podlodkacrewlinttest

import android.util.Log
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FirstScreenPresenter: MvpPresenter<FirstScreenView>() {

    override fun onFirstViewAttach() {
        Log.d(this::class.java.simpleName, "TEST::onFirstViewAttach")
        viewState.bindData(data = this::class.java.simpleName)
    }
}