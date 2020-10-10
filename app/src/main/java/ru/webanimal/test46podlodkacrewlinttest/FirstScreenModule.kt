package ru.webanimal.test46podlodkacrewlinttest

import dagger.Module
import dagger.Provides

@Module
class FirstScreenModule {

    @Provides
    fun provideFirstScreenPresenter(): FirstScreenPresenter {
        return FirstScreenPresenter()
    }
}