package ru.webanimal.test46podlodkacrewlinttest

import android.content.Context
import android.util.Log
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class FirstScreenFragment: MvpAppCompatFragment(), FirstScreenView {

    @Inject
    @InjectPresenter
    @get:ProvidePresenter
    lateinit var presenter: FirstScreenPresenter

    override fun onAttach(context: Context) {
        DaggerFirstScreenComponent.create().injectFirstScreen(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        // TODO Sergio D. 09.10.20: Add clear component
    }

    override fun bindData(data: String) {
        Log.d(this::class.java.simpleName, "TEST::bindData $data")
    }
}