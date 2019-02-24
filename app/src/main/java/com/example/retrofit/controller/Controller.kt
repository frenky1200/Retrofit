package com.example.retrofit.controller

import com.google.gson.GsonBuilder

import com.example.retrofit.api.UmoriliApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Controller {
    private const val BASE_URL = "http://umorili.herokuapp.com/"

    val api: UmoriliApi
        get() {
            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()

            return retrofit.create(UmoriliApi::class.java)

        }
}
