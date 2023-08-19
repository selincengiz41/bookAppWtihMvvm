package com.selincengiz.booksapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.selincengiz.booksapp.MainApplication
import com.selincengiz.booksapp.R
import com.selincengiz.booksapp.common.Extension.loadUrl
import com.selincengiz.booksapp.data.model.GetBookDetailResponse
import com.selincengiz.booksapp.databinding.FragmentDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar!!.setTitle("")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBookDetail(args.id)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_back -> {
                findNavController().navigateUp()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun getBookDetail(id: Int) {

        MainApplication.bookService?.getBookDetail(id)
            ?.enqueue(object : Callback<GetBookDetailResponse> {
                override fun onResponse(
                    call: Call<GetBookDetailResponse>,
                    response: Response<GetBookDetailResponse>
                ) {
                    var book = response.body()?.book
                    with(binding) {


                        ivBookDetail.loadUrl(book?.imageUrl)
                        tvAuthorDetail.text = book?.author
                        tvNameDetail.text = book?.name
                        tvPriceDetail.text = "${book?.price} ₺"
                        tvPublisherDetail.text = book?.publisher

                    }


                }

                override fun onFailure(call: Call<GetBookDetailResponse>, t: Throwable) {

                    Toast.makeText(
                        requireContext(),
                        "Kitap detayına ulaşılamamaktadır!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
    }
}