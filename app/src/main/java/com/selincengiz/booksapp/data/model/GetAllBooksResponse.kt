package com.selincengiz.booksapp.data.model


import com.google.gson.annotations.SerializedName

data class GetAllBooksResponse(
    @SerializedName("books")
    val books: List<Book>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Int?
)