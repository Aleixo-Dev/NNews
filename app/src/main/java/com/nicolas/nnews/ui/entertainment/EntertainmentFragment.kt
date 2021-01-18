package com.nicolas.nnews.ui.entertainment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolas.nnews.R
import com.nicolas.nnews.ui.entertainment.adapter.EntertainmentAdapter
import kotlinx.android.synthetic.main.fragment_entertainment.*

class EntertainmentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entertainment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeNewsEntertainment()
    }

    private fun makeNewsEntertainment() {

        val viewModelEntertainment =
            ViewModelProviders.of(this).get(EntertainmentViewModel::class.java)
        viewModelEntertainment.initEntertainmentNews()
        viewModelEntertainment.listNewsEntertainment.observe(viewLifecycleOwner, {
            it?.let { entertainmentNews ->

                with(entertainmentRecyclerView) {
                    layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = EntertainmentAdapter(entertainmentNews) { entertainment ->
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(entertainment.url)))
                    }
                }
            }
        })
    }
}