package com.appstuddio.retrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StudentClient{
    private var api: StudentService? = null
    private const val BASE_URL = "http://www.mocky.io/v3/"

    val instance: StudentService? by lazy {
        if (api == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            api = retrofit.create(StudentService::class.java)
        }
        api
    }
}