package mobile.pintusa.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mobile.pintusa.auth.daftar.Daftar
import mobile.pintusa.auth.daftar.DaftarModule
import mobile.pintusa.auth.daftar.mahasiswa.DaftarMahasiswa
import mobile.pintusa.auth.daftar.mahasiswa.DaftarMahasiswaModule
import mobile.pintusa.auth.daftar.satpam.DaftarSatpam
import mobile.pintusa.auth.daftar.satpam.DaftarSatpamModule
import mobile.pintusa.auth.login.Login
import mobile.pintusa.auth.login.LoginModule
import mobile.pintusa.home.HomeFragment
import mobile.pintusa.home.HomeFragmentModule
import mobile.pintusa.main.Home
import mobile.pintusa.main.HomeModule

@Module
abstract class ActivityBuilder{
    @ContributesAndroidInjector(modules = [(HomeModule::class)])
    abstract fun provideHome(): Home

    @ContributesAndroidInjector(modules = [(LoginModule::class)])
    abstract fun provideLogin():Login

    @ContributesAndroidInjector(modules = [(HomeFragmentModule::class)])
    abstract fun provideHomeFragment():HomeFragment

    @ContributesAndroidInjector(modules = [DaftarModule::class])
    abstract fun provideDaftar():Daftar

    @ContributesAndroidInjector(modules = [(DaftarMahasiswaModule::class)])
    abstract fun provideDaftarMahasiswa():DaftarMahasiswa

    @ContributesAndroidInjector(modules = [(DaftarSatpamModule::class)])
    abstract fun provideDaftarSatpam():DaftarSatpam
}