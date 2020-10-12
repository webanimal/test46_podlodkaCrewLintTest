package ru.webanimal.test46podlodkacrewlinttest.screens.first

import android.app.Fragment
import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FirstScreenPresenter: MvpPresenter<FirstScreenView>() {

    override fun onFirstViewAttach() {
        Log.d(this::class.java.simpleName, "TEST::onFirstViewAttach")
        viewState.bindData(data = this::class.java.simpleName)
    }

    fun onStart(context: Context, contextCompat: ContextCompat, appContext: Fragment) {
    }
}