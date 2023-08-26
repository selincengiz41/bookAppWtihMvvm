package com.selincengiz.booksapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.selincengiz.booksapp.MainApplication
import com.selincengiz.booksapp.R
import com.selincengiz.booksapp.common.viewBinding
import com.selincengiz.booksapp.data.model.GetAllBooksResponse
import com.selincengiz.booksapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class HomeFragment : Fragment() , BooksAdapter.BookListener {

    private lateinit var binding : FragmentHomeBinding
    private val adapter by lazy { BooksAdapter(this) }
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerBook.adapter=adapter

        viewModel.getAllBooks()
        observe()

    }

    private fun observe(){
        viewModel.books.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(viewLifecycleOwner){
            it?.let {
                binding.progressBar.isVisible=it
            }
        }

    }


    override fun bookClicked(id: Int?) {
        id?.let {
            val action= HomeFragmentDirections.homeToDetail(id)
            findNavController().navigate(action)
        }


    }
}