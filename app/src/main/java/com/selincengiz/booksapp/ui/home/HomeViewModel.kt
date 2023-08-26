package com.selincengiz.booksapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.selincengiz.booksapp.data.model.Book
import com.selincengiz.booksapp.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val booksRepository: BooksRepository) :
    ViewModel() {


    private var _books = MutableLiveData<List<Book>?>()
    val books: MutableLiveData<List<Book>?>
        get() = _books

    private var _error = MutableLiveData<String?>()
    val error: MutableLiveData<String?>
        get() = _error

    private var _loading = MutableLiveData<Boolean?>()
    val loading: MutableLiveData<Boolean?>
        get() = _loading

    init {
        _books = booksRepository.books
        _error = booksRepository.errorMessage
        _loading = booksRepository.loading
    }


    fun getAllBooks() {
        booksRepository.getAllBooks()
    }

}