package mobile.pintusa.auth.login

import android.content.Intent
import mobile.pintusa.base.BasePresenter
import mobile.pintusa.base.BaseResponse
import mobile.pintusa.helper.UtilModule
import mobile.pintusa.main.Home
import mobile.pintusa.network.NetworkApi
import mobile.pintusa.network.response.LoginResponse
import javax.inject.Inject

class LoginPresenter @Inject constructor():BasePresenter{
    lateinit var view: LoginContract.LoginView
    lateinit var activity: Login

    @Inject
    lateinit var api: NetworkApi
    @Inject
    lateinit var utilModule: UtilModule

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }

    fun login(username: String, password: String){
        activity.loading.show()
        val map = HashMap<String, String>()
        map["username"] = username
        map["password"] = password

        val call = BaseResponse<LoginResponse>()
        call.call(api.login(map), object: BaseResponse.HttpListener<LoginResponse> {
            override fun onSuccess(data: LoginResponse) {
                activity.loading.dismiss()
                if (data.status==200){
                    activity.startActivity(Intent(activity, Home::class.java))
                    activity.finish()
                }else{
                    utilModule.toastShort(activity, data.message)
                }
            }

            override fun onError(message: String) {
                activity.loading.dismiss()
                utilModule.toastShort(activity, message)
            }
        })
    }
}