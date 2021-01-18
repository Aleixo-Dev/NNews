package com.nicolas.nnews.data.response

import com.nicolas.nnews.data.model.News
import com.squareup.moshi.Json

data class NewsDetailsResponse(
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "url")
    val url: String,
    @field:Json(name = "content")
    val content: String,
    @field:Json(name = "urlToImage")
    val urlImage: String,
    @field:Json(name = "source")
    val source: Source
) {
    fun getNewsModel() = News(
        title = this.title,
        url = this.url,
        urlToImage = this.urlImage,
        content = this.content,
        name = source.name
    )
}
