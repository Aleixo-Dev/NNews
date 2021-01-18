package com.nicolas.nnews.data.model

import java.io.Serializable

data class News(
    val title: String,
    val url: String,
    val urlToImage: String? = null,
    val content: String? = null,
    val name: String? = null
) : Serializable