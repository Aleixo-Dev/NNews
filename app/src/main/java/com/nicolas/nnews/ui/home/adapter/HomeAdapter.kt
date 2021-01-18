package com.nicolas.nnews.ui.home.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nicolas.nnews.R
import com.nicolas.nnews.data.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_football.view.*
import java.net.URI

class HomeAdapter(
    private val listNewsFootball: List<News>,
    private val onItemClickListener: ((news: News) -> Unit)
) : RecyclerView.Adapter<HomeAdapter.NewViewHolderFootball>() {
    class NewViewHolderFootball(
        itemView: View,
        private val onItemClickListener: ((news: News) -> Unit)
    ) :
        RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.titleNewsFootball
        private val imgFootball: ImageView = itemView.imgNewsFootball
        private val source: TextView = itemView.sourceNameFootball

        fun bind(news: News) {
            title.text = news.title
            source.text = news.name

            itemView.setOnClickListener {
                onItemClickListener.invoke(news)
            }
            Picasso.get().load(news.urlToImage).into(imgFootball)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolderFootball {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_football, parent, false)
        return NewViewHolderFootball(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: NewViewHolderFootball, position: Int) {
        holder.bind(listNewsFootball[position])
    }

    override fun getItemCount() = listNewsFootball.size
}