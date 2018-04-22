package mobile.pintusa.auth.login

import dagger.Module
import dagger.Provides
import mobile.pintusa.base.BasePresenter

@Module
class LoginModule {
    @Provides
    fun provLoginPresenter(presenter: LoginPresenter):BasePresenter = presenter
}