package ru.webanimal.test46podlodkacrewlinttest.di

import dagger.Module
import dagger.Provides
import ru.webanimal.test46podlodkacrewlinttest.screens.first.FirstScreenPresenter

@Module
class FirstScreenModule {

    @Provides
    fun provideFirstScreenPresenter(): FirstScreenPresenter {
        return FirstScreenPresenter()
    }
}