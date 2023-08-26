package com.selincengiz.booksapp

import android.app.Application
import com.selincengiz.booksapp.common.Constants.BASE_URL
import com.selincengiz.booksapp.data.source.remote.BookService
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class MainApplication : Application()