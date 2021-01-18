package com.nicolas.nnews.data.response

import com.squareup.moshi.Json

data class NewsResponseBody(
    @field:Json(name = "articles")
    val listNewsArticles: List<NewsDetailsResponse>
)