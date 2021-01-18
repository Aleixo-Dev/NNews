package com.nicolas.nnews.data.network

import com.nicolas.nnews.data.response.NewsResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    fun getListNewsSports(
        @Query("country") country: String = "br",
        @Query("apiKey") apiKey: String = "9fb83e5bab6242a3b71c927ed2f9294a",
        @Query("category") category: String = "sports"
    ): Call<NewsResponseBody>

    @GET("top-headlines")
    fun getListNewsEntertainment(
        @Query("country") country: String = "br",
        @Query("apiKey") apiKey: String = "9fb83e5bab6242a3b71c927ed2f9294a",
        @Query("category") category: String = "entertainment"
    ): Call<NewsResponseBody>


    @GET("top-headlines")
    fun getListNewsTechnology(
        @Query("country") country: String = "br",
        @Query("apiKey") apiKey: String = "9fb83e5bab6242a3b71c927ed2f9294a",
        @Query("category") category: String = "technology"
    ): Call<NewsResponseBody>

}