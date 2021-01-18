package com.nicolas.nnews.ui.entertainment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nicolas.nnews.data.model.News
import com.nicolas.nnews.data.network.ApiService
import com.nicolas.nnews.data.response.NewsResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EntertainmentViewModel : ViewModel() {

    val listNewsEntertainment: MutableLiveData<List<News>> = MutableLiveData()

    fun initEntertainmentNews() {

        ApiService.service.getListNewsEntertainment().enqueue(object : Callback<NewsResponseBody> {
            override fun onResponse(
                call: Call<NewsResponseBody>,
                response: Response<NewsResponseBody>
            ) {

                if (response.isSuccessful) {

                    val listEntertainment: MutableList<News> = mutableListOf()

                    response.body()?.let { entertainmentBody ->

                        for (resultEntertainment in entertainmentBody.listNewsArticles) {
                            val newsEntertainment = resultEntertainment.getNewsModel()
                            listEntertainment.add(newsEntertainment)
                        }
                    }
                    listNewsEntertainment.value = listEntertainment
                }
            }

            override fun onFailure(call: Call<NewsResponseBody>, t: Throwable) {
            }
        })
    }
}