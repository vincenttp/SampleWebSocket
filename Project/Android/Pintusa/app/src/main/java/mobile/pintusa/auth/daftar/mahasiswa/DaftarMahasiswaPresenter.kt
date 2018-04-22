package mobile.pintusa.auth.daftar.mahasiswa

import mobile.pintusa.auth.daftar.Daftar
import mobile.pintusa.base.BasePresenter
import mobile.pintusa.base.BaseResponse
import mobile.pintusa.helper.UtilModule
import mobile.pintusa.network.NetworkApi
import mobile.pintusa.network.response.RegisterResponse
import javax.inject.Inject

class DaftarMahasiswaPresenter @Inject constructor(): BasePresenter{
    lateinit var view: DaftarMahasiswaContract.DaftarMahasiswaView
    lateinit var activity: Daftar

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

    fun daftar(nama:String, nim:String, jurusan:String, email:String, password:String){
        activity.loading.show()
        val map = HashMap<String, String>()
        map["username"] = nama
        map["name"] = nama
        map["password"] = password
        map["nim"] = nim
        map["jurusan"] = jurusan
        map["email"] = email
        map["role_id"] = "1"
        map["created_at"] = utilModule.currentTimeString()
        map["updated_at"] = utilModule.currentTimeString()

        val call = BaseResponse<RegisterResponse>()
        call.call(api.daftar(map), object: BaseResponse.HttpListener<RegisterResponse> {
            override fun onSuccess(data: RegisterResponse) {
                activity.loading.dismiss()
                if (data.status==201){
                    activity.finish()
                }
                utilModule.toastShort(activity, data.message)
            }

            override fun onError(message: String) {
                activity.loading.dismiss()
                utilModule.toastShort(activity, message)
            }
        })
    }
}