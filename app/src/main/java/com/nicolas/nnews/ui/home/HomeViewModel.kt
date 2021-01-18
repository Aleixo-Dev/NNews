package com.nicolas.nnews.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nicolas.nnews.data.model.News
import com.nicolas.nnews.data.network.ApiService
import com.nicolas.nnews.data.response.NewsResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val listNewsFootballData: MutableLiveData<List<News>> = MutableLiveData()

    fun getListNewsSports() {

        ApiService.service.getListNewsSports().enqueue(object : Callback<NewsResponseBody> {
            override fun onResponse(
                call: Call<NewsResponseBody>,
                response: Response<NewsResponseBody>
            ) {
                if (response.isSuccessful) {

                    val listNewsFootball: MutableList<News> = mutableListOf()
                    response.body()?.let { newResponseBody ->
                        for (result in newResponseBody.listNewsArticles) {

                            val news = result.getNewsModel()
                            listNewsFootball.add(news)
                        }
                    }
                    listNewsFootballData.value = listNewsFootball
                }
            }
            override fun onFailure(call: Call<NewsResponseBody>, t: Throwable) {
            }
        })
    }
}