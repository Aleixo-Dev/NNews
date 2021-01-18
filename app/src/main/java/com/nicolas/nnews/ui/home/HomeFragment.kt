package com.nicolas.nnews.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolas.nnews.R
import com.nicolas.nnews.data.model.News
import com.nicolas.nnews.ui.details.DetailsActivity
import com.nicolas.nnews.ui.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeNewsFootBall()
    }

    private fun makeNewsFootBall() {
        val viewModel: HomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getListNewsSports()
        viewModel.listNewsFootballData.observe(viewLifecycleOwner, {
            it?.let { news ->
                with(footballRecyclerView) {
                    layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = HomeAdapter(news) { iNewsFootball ->
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(iNewsFootball.url)))
                    }
                }
            }
        })
    }
}