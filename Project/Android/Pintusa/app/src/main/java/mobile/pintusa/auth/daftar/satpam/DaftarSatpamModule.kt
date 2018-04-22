package mobile.pintusa.auth.daftar.satpam

import dagger.Module
import dagger.Provides
import mobile.pintusa.base.BasePresenter

@Module
class DaftarSatpamModule{
    @Provides
    fun provideDaftarSatpamModule(presenter: DaftarSatpamPresenter): BasePresenter = presenter
}