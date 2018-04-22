package mobile.pintusa.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import mobile.pintusa.AndroidApp
import mobile.pintusa.helper.UtilModule
import mobile.pintusa.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (ActivityBuilder::class),
    (AppModule::class),
    (NetworkModule::class),
    (UtilModule::class)
])

interface AppComponent{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder
        fun build():AppComponent
    }

    fun inject(app: AndroidApp)
}