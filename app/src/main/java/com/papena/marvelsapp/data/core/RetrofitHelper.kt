package com.papena.marvelsapp.data.core

import com.papena.marvelsapp.utils.PRIVATE_KEY
import com.papena.marvelsapp.utils.PUBLIC_KEY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient(PUBLIC_KEY, PRIVATE_KEY))
            .build()
    }

    fun createHttpClient(publicKey: String, privateKey: String): OkHttpClient? {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(
                MarvelInterceptor(publicKey, privateKey)
            )
            .addNetworkInterceptor(logging)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(45, TimeUnit.SECONDS)
            .build()
    }
}