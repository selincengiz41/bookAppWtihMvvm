package com.selincengiz.booksapp.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.selincengiz.booksapp.MainApplication
import com.selincengiz.booksapp.R
import com.selincengiz.booksapp.common.viewBinding
import com.selincengiz.booksapp.data.model.GetAllBooksResponse
import com.selincengiz.booksapp.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) , BooksAdapter.BookListener {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val adapter by lazy { BooksAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerBook.adapter=adapter
        getAllBooks()

    }

    fun getAllBooks(){
        MainApplication.bookService?.getAllBooks()?.enqueue(object :Callback<GetAllBooksResponse>{
            override fun onResponse(
                call: Call<GetAllBooksResponse>,
                response: Response<GetAllBooksResponse>
            ) {
                adapter.submitList(response.body()?.books)
            }

            override fun onFailure(call: Call<GetAllBooksResponse>, t: Throwable) {

                Toast.makeText(requireContext(), "Kitap verilerine ulaşılamamaktadır!!", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun bookClicked(id: Int?) {
        id?.let {
            val action= HomeFragmentDirections.homeToDetail(id)
            findNavController().navigate(action)
        }


    }
}