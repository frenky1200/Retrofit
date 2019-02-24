package com.example.retrofit.api

import com.example.retrofit.model.AnekdotModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface UmoriliApi {

    @GET("api/get?site=bash.im")
    fun getData(@Query("name") resourceName: String, @Query("num") count: Int): Call<List<AnekdotModel>>
}
