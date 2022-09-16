package com.example.mvvmexample.Network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST

interface RetrofitService {

    @GET("0cFMmd")
    fun getAllCountries(): Call<List<Model>>

    companion object {
        private var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.jsonserve.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                // создание экземпляра для класса API
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}