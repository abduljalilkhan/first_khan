package com.example.githubmvvm.Network_Stuff

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrofit {

    companion object {
        var BASE_URL = "https://mypcp.us/v/1/"
    fun getRetrofitInstance(): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }
}
}
