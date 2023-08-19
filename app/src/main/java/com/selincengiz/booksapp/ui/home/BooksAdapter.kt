package com.selincengiz.booksapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selincengiz.booksapp.common.Extension.loadUrl
import com.selincengiz.booksapp.data.model.Book
import com.selincengiz.booksapp.databinding.ItemBookBinding


class BooksAdapter(private val bookListener: BookListener) :
    ListAdapter<Book, BooksAdapter.BookViewHolder>(BookDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            bookListener
        )

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) =
        holder.bind(getItem(position))

    class BookViewHolder(
        private val binding: ItemBookBinding,
        private val bookListener: BookListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) = with(binding) {

            tvPrice.text= "${book.price} ₺"
            tvName.text=book.name
            ivBook.loadUrl(book.imageUrl)

            book.isBestSeller?.let {
            if(it){
                bookIcon.visibility=View.VISIBLE
            }
            }

            root.setOnClickListener {
                 bookListener.bookClicked(book.id)
            }
        }
    }

    class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

    }

    interface BookListener {
        fun bookClicked(id: Int?)
    }
}