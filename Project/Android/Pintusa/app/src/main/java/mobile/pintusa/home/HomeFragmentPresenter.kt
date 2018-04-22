package mobile.pintusa.home

import mobile.pintusa.base.BasePresenter
import javax.inject.Inject

class HomeFragmentPresenter @Inject constructor(): BasePresenter{
    lateinit var view: HomeFragmentContract.HomeFragmentView

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }
}