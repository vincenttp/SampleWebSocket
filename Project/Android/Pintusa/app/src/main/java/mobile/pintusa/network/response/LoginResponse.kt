package mobile.pintusa.network.response

import com.google.gson.annotations.SerializedName

class LoginResponse{
    @SerializedName("status")
    var status: Int = 0
    @SerializedName("message")
    lateinit var message: String
    @SerializedName("id")
    lateinit var id: String
    @SerializedName("token")
    lateinit var token: String
    @SerializedName("role")
    lateinit var role: String
}