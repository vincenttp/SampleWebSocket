package mobile.pintusa.network

import mobile.pintusa.network.response.LoginResponse
import mobile.pintusa.network.response.RegisterResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkApi{
    @POST("auth/login")
    fun login(@Body body: Map<String, String>): Call<LoginResponse>

    @POST("user/create")
    fun daftar(@Body body: Map<String, String>): Call<RegisterResponse>
}