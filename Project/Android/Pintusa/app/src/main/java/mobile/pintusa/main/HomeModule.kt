package mobile.pintusa.main

import dagger.Module
import dagger.Provides

@Module
class HomeModule{
    @Provides
    fun provideHomePresenter(presenter: HomePresenter): HomePresenter = presenter
}