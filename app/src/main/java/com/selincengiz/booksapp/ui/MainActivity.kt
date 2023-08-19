package com.selincengiz.booksapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selincengiz.booksapp.MainApplication
import com.selincengiz.booksapp.R
import com.selincengiz.booksapp.common.viewBinding
import com.selincengiz.booksapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MainApplication.provideRetrofit()
    }
}