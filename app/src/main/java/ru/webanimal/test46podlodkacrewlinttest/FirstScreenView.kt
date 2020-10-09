package ru.webanimal.test46podlodkacrewlinttest

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface FirstScreenView: MvpView {
    fun bindData(data: String = "")
}