package ru.webanimal.test46podlodkacrewlinttest

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FirstScreenPresenter: MvpPresenter<FirstScreenView>() {

    override fun onFirstViewAttach() {
        viewState.bindData(data = this::class.java.simpleName)
    }
}