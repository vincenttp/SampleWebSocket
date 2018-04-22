package mobile.pintusa.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule{
    @Singleton
    @Provides
    fun provRetrofit() : Retrofit =
            Retrofit.Builder()
                    .baseUrl("http://owlproject.web.id/apiphintusa/index.php/")
                    .client(provOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Singleton
    @Provides
    fun provOkHttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
                .addInterceptor {
                    val original: Request? = it.request()
                    val request = original!!.newBuilder()
                            .addHeader("Client-Service", "frontend-client")
                            .addHeader("Auth-Key", "simplerestapi")
                            .addHeader("Content-Type", "application/json")
                            .build()

                    val response = it.proceed(request)

                    response
                }
                .build()
    }

    @Singleton
    @Provides
    fun provApiService(retrofit: Retrofit): NetworkApi =
            retrofit.create(NetworkApi::class.java)
}