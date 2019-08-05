package com.yoshi1125hisa.qearch

import android.content.ClipData
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaClient {
    @GET("/api/v2/items")
    fun items(@Query("query") query: String? = null,
              @Query("page") page: Int = 1,
              @Query("per_page") perPage: Int = 50): Call<List<ClipData.Item>>

    companion object {
        fun create(): QiitaClient {
            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl("http://qiita.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(QiitaClient::class.java)
        }
    }
}