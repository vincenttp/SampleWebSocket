package mobile.pintusa.base

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BaseResponse<T>{
    fun call(call: Call<T>, listener: HttpListener<T>) {
        call.enqueue(object: Callback<T> {
            override fun onFailure(call: Call<T>?, t: Throwable?) {
                listener.onError(t!!.message.toString())
            }

            override fun onResponse(call: Call<T>?, response: Response<T>?) {
                if (response!!.code()==200){
                    listener.onSuccess(response.body()!!)
                }else{
                    listener.onError(response.message())
                }
            }
        })
    }

    interface HttpListener<T>{
        fun onSuccess(data: T)
        fun onError(message: String)
    }
}