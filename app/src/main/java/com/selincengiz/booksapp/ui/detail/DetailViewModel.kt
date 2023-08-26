package com.selincengiz.booksapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.selincengiz.booksapp.data.model.Book
import com.selincengiz.booksapp.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val booksRepository: BooksRepository)  : ViewModel() {


    private var _bookDetail = MutableLiveData<Book?>()
    val bookDetail: MutableLiveData<Book?>
        get() = _bookDetail

    private var _error = MutableLiveData<String?>()
    val error: MutableLiveData<String?>
        get() = _error

    private var _loading = MutableLiveData<Boolean?>()
    val loading: MutableLiveData<Boolean?>
        get() = _loading

    init {
        _bookDetail = booksRepository.bookDetail
        _error = booksRepository.errorMessage
        _loading=booksRepository.loading
    }

    fun getBookDetail(id: Int) {
        booksRepository.getBookDetail(id)
    }
}