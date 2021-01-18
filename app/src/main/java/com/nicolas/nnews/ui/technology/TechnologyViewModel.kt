package com.nicolas.nnews.ui.technology

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nicolas.nnews.data.model.News
import com.nicolas.nnews.data.network.ApiService
import com.nicolas.nnews.data.response.NewsResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TechnologyViewModel : ViewModel() {

    val listNewsTechnology: MutableLiveData<List<News>> = MutableLiveData()

    fun initNewsTechnology() {

        ApiService.service.getListNewsTechnology().enqueue(object : Callback<NewsResponseBody> {
            override fun onResponse(
                call: Call<NewsResponseBody>,
                response: Response<NewsResponseBody>
            ) {
                if (response.isSuccessful) {

                    val listTechnology: MutableList<News> = mutableListOf()
                    response.body()?.let { technologyResponseBody ->

                        for (resultTechnology in technologyResponseBody.listNewsArticles) {
                            val newListTechnology = resultTechnology.getNewsModel()
                            listTechnology.add(newListTechnology)
                        }
                    }
                    listNewsTechnology.value = listTechnology
                }
            }

            override fun onFailure(call: Call<NewsResponseBody>, t: Throwable) {

            }
        })
    }
}