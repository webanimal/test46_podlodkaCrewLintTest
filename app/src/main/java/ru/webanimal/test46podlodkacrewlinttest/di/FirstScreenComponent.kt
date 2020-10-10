package ru.webanimal.test46podlodkacrewlinttest.di

import dagger.Component
import ru.webanimal.test46podlodkacrewlinttest.screens.first.FirstScreenFragment
import javax.inject.Singleton

@Component(modules = [FirstScreenModule::class])
@Singleton
interface FirstScreenComponent {
    fun inject(fragment: FirstScreenFragment)
}