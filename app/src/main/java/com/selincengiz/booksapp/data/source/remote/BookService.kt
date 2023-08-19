package com.selincengiz.booksapp.data.source.remote

import com.selincengiz.booksapp.common.Constants.GET_ALL_BOOKS
import com.selincengiz.booksapp.common.Constants.GET_BOOK_DETAIL
import com.selincengiz.booksapp.data.model.GetAllBooksResponse
import com.selincengiz.booksapp.data.model.GetBookDetailResponse
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET(GET_ALL_BOOKS)
    fun getAllBooks():Call<GetAllBooksResponse>

    @GET(GET_BOOK_DETAIL)
    fun getBookDetail(@Query("id") id:Int):Call<GetBookDetailResponse>
}