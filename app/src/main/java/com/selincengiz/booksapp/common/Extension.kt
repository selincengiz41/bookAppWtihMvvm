package com.selincengiz.booksapp.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.selincengiz.booksapp.common.Extension.loadUrl

object Extension {

    fun ImageView.loadUrl(url :String?){
        Glide.with(this.context).load(url).into(this)
    }
}