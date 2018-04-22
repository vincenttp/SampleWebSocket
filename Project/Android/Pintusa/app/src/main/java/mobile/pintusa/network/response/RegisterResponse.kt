package mobile.pintusa.network.response

import com.google.gson.annotations.SerializedName

class RegisterResponse{
    @SerializedName("status")
    var status: Int = 0
    @SerializedName("message")
    lateinit var message: String
}