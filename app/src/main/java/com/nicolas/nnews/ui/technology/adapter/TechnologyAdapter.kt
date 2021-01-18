package com.nicolas.nnews.ui.technology.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicolas.nnews.R
import com.nicolas.nnews.data.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_technology.view.*

class TechnologyAdapter(
    private val listTechnologyNews: List<News>,
    private val onItemClickListener: ((news: News) -> Unit)

) : RecyclerView.Adapter<TechnologyAdapter.TechnologyViewHolder>() {
    class TechnologyViewHolder(
        itemView: View,
        private val onItemClickListener: ((news: News) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val titleNewsTechnology: TextView = itemView.titleNewsTechnology
        private val sourceNewsTechnology: TextView = itemView.sourceNameTec
        private val imgNewsTechnology: ImageView = itemView.imgNewsTechnology

        fun bind(news: News) {
            titleNewsTechnology.text = news.title
            sourceNewsTechnology.text = news.name

            itemView.setOnClickListener {
                onItemClickListener.invoke(news)
            }
            Picasso.get().load(news.urlToImage).into(imgNewsTechnology)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TechnologyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_technology, parent, false
        )
        return TechnologyViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: TechnologyViewHolder, position: Int) {
        holder.bind(listTechnologyNews[position])
    }

    override fun getItemCount() = listTechnologyNews.size
}