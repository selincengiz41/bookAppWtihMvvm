package com.selincengiz.booksapp.data.model


import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("author")
    val author: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("is_best_seller")
    val isBestSeller: Boolean?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("publisher")
    val publisher: String?
)