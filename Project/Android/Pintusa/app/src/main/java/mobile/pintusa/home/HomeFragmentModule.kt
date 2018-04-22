package mobile.pintusa.home

import dagger.Module
import dagger.Provides
import mobile.pintusa.base.BasePresenter

@Module
class HomeFragmentModule{
    @Provides
    fun provHomeFragmentPresenter(presenter: HomeFragmentPresenter) : BasePresenter = presenter
}