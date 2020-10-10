package ru.webanimal.test46podlodkacrewlinttest.screens.first

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.webanimal.test46podlodkacrewlinttest.R
import ru.webanimal.test46podlodkacrewlinttest.di.DaggerFirstScreenComponent
import ru.webanimal.test46podlodkacrewlinttest.di.FirstScreenComponent
import javax.inject.Inject

class FirstScreenFragment: MvpAppCompatFragment(), FirstScreenView {

    private var firstScreenComponent: FirstScreenComponent? = null
        get() {
            if (field == null) {
                field = DaggerFirstScreenComponent.create()
            }
            return field
        }

    @Inject
    @InjectPresenter
    @get:ProvidePresenter
    lateinit var presenter: FirstScreenPresenter

    override fun onAttach(context: Context) {
        Log.d(this::class.java.simpleName, "TEST::onAttach")
        firstScreenComponent?.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(this::class.java.simpleName, "TEST::onCreateView")
        return LayoutInflater.from(context).inflate(R.layout.fragment_first_screen, container, false)
    }

    override fun onDetach() {
        Log.d(this::class.java.simpleName, "TEST::onDetach")
        super.onDetach()
        firstScreenComponent = null
    }

    override fun bindData(data: String) {
        Log.d(this::class.java.simpleName, "TEST::bindData $data")
    }
}