package com.selincengiz.booksapp.data.model


import com.google.gson.annotations.SerializedName

data class GetBookDetailResponse(
    @SerializedName("book")
    val book: Book?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Int?
)