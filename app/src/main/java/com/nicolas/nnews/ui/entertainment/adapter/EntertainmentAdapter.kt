package com.nicolas.nnews.ui.entertainment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicolas.nnews.R
import com.nicolas.nnews.data.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_entertainment.view.*

class EntertainmentAdapter(
    private val listNewsEntertainment: List<News>,
    private val onItemClickListener: ((news: News) -> Unit)
) :
    RecyclerView.Adapter<EntertainmentAdapter.EntertainmentViewHolder>() {

    inner class EntertainmentViewHolder(
        itemView: View,
        private val onItemClickListener: ((news: News) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val titleEntertainment: TextView = itemView.titleNewsEntertainment
        private val sourceEntertainment: TextView = itemView.sourceNameEntertainment
        private val imgEntertainment: ImageView = itemView.imgNewsEntertainment

        fun bind(news: News) {
            titleEntertainment.text = news.title
            sourceEntertainment.text = news.name
            itemView.setOnClickListener {
                onItemClickListener.invoke(news)
            }

            Picasso.get().load(news.urlToImage).into(imgEntertainment)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntertainmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entertainment, parent, false)
        return EntertainmentViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: EntertainmentViewHolder, position: Int) {
        holder.bind(listNewsEntertainment[position])
    }

    override fun getItemCount() = listNewsEntertainment.size
}