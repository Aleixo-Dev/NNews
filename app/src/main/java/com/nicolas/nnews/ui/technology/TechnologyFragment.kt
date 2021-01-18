package com.nicolas.nnews.ui.technology

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolas.nnews.R
import com.nicolas.nnews.ui.technology.adapter.TechnologyAdapter
import kotlinx.android.synthetic.main.fragment_technology.*

class TechnologyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_technology, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListTechnology()
    }

    private fun initListTechnology() {

        val viewModelTec: TechnologyViewModel =
            ViewModelProviders.of(this).get(TechnologyViewModel::class.java)
        viewModelTec.initNewsTechnology()
        viewModelTec.listNewsTechnology.observe(viewLifecycleOwner, {

            it?.let { newsTechnology ->
                with(recyclerViewTechnology) {

                    layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = TechnologyAdapter(newsTechnology) {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it.url)))
                    }
                }
            }
        })
    }
}