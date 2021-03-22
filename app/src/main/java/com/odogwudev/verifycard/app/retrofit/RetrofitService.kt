package com.odogwudev.verifycard.app.retrofit

import androidx.viewbinding.BuildConfig
import com.odogwudev.verifycard.app.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private val sLogLevel =
    Level.BODY


val interceptor = HttpLoggingInterceptor()

object RetrofitService {
    /**
     * Creates retrofit instance of api service.
     */

    operator fun invoke(): CardServicesClient {

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor.setLevel(sLogLevel))
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        val retrofit by lazy {
            Retrofit.Builder().baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val service: CardServicesClient by lazy {
            retrofit.create(CardServicesClient::class.java)
        }

        return service


    }


}