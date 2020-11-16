package com.appstuddio.retrofit.network

import com.appstuddio.retrofit.network.response.Student
import retrofit2.Call
import retrofit2.http.GET

interface StudentService {

    @GET("f7b4cba2-a9a7-4021-93fc-5d4cbd9c0b05")
    fun getStudents() : Call<List<Student>>
}
