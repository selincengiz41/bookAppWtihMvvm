package com.selincengiz.booksapp.di

import com.selincengiz.booksapp.MainApplication
import com.selincengiz.booksapp.common.Constants
import com.selincengiz.booksapp.data.source.remote.BookService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TIMEOUT = 60L

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().apply {
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        }.build()



    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(Constants.BASE_URL)
            client(okHttpClient)
        }.build()


    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit)=  retrofit.create(BookService::class.java)

}