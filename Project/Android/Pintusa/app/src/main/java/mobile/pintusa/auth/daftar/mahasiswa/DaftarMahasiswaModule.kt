package mobile.pintusa.auth.daftar.mahasiswa

import dagger.Module
import dagger.Provides
import mobile.pintusa.base.BasePresenter

@Module
class DaftarMahasiswaModule{
    @Provides
    fun provideDaftarMahasiswa(presenter: DaftarMahasiswaPresenter): BasePresenter = presenter
}