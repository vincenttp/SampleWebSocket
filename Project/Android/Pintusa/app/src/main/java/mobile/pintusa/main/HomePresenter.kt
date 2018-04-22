package mobile.pintusa.main

import javax.inject.Inject

class HomePresenter @Inject constructor(): HomeContract.HomeView{
    lateinit var view: HomeContract.HomeView
}