package com.selincengiz.booksapp.data.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.selincengiz.booksapp.MainApplication
import com.selincengiz.booksapp.common.Extension.loadUrl
import com.selincengiz.booksapp.data.model.Book
import com.selincengiz.booksapp.data.model.GetAllBooksResponse
import com.selincengiz.booksapp.data.model.GetBookDetailResponse
import com.selincengiz.booksapp.data.source.remote.BookService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository(private val bookService: BookService) {

    val books = MutableLiveData<List<Book>?>()
    val bookDetail = MutableLiveData<Book?>()
    val errorMessage = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean?>()

    fun getAllBooks() {
        loading.value = true
        bookService.getAllBooks().enqueue(object : Callback<GetAllBooksResponse> {
            override fun onResponse(
                call: Call<GetAllBooksResponse>,
                response: Response<GetAllBooksResponse>
            ) {
                loading.value = false
                books.value = response.body()?.books
            }

            override fun onFailure(call: Call<GetAllBooksResponse>, t: Throwable) {
                loading.value = false
                errorMessage.value = t.message
            }

        })
    }

    fun getBookDetail(id: Int) {
        loading.value = true
        bookService.getBookDetail(id)
            .enqueue(object : Callback<GetBookDetailResponse> {
                override fun onResponse(
                    call: Call<GetBookDetailResponse>,
                    response: Response<GetBookDetailResponse>
                ) {
                    loading.value = false
                    bookDetail.value = response.body()?.book
                }

                override fun onFailure(call: Call<GetBookDetailResponse>, t: Throwable) {
                    errorMessage.value = t.message
                    loading.value = false
                }

            })
    }


}