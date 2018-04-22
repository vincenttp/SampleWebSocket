package mobile.pintusa.auth.daftar

import dagger.Module
import dagger.Provides
import mobile.pintusa.base.BasePresenter

@Module
class DaftarModule {
    @Provides
    fun provDaftarPresenter(presenter: DaftarPresenter): BasePresenter = presenter
}