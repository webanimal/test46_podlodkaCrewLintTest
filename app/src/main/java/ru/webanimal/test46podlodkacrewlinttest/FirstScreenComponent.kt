package ru.webanimal.test46podlodkacrewlinttest

import dagger.Component
import javax.inject.Singleton

@Component(modules = [FirstScreenModule::class])
@Singleton
interface FirstScreenComponent {

    fun getFirstScreenPresenter(): FirstScreenPresenter
    fun injectFirstScreen(view: FirstScreenView)
}