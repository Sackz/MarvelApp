package com.papena.marvelsapp.di

import com.papena.marvelsapp.data.core.RetrofitHelper
import com.papena.marvelsapp.data.network.MarvelApiClient
import com.papena.marvelsapp.utils.PRIVATE_KEY
import com.papena.marvelsapp.utils.PUBLIC_KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(RetrofitHelper.createHttpClient(PUBLIC_KEY, PRIVATE_KEY))
            .build()
    }

    @Singleton
    @Provides
    fun provideMarvelApiClient(retrofit: Retrofit): MarvelApiClient {
        return retrofit.create(MarvelApiClient::class.java)
    }
}