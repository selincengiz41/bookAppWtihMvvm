package com.selincengiz.booksapp.di

import com.selincengiz.booksapp.data.repository.BooksRepository
import com.selincengiz.booksapp.data.source.remote.BookService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
 @InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(bookService: BookService)= BooksRepository(bookService)
}