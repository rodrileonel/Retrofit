package com.appstuddio.retrofit.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appstuddio.retrofit.network.StudentClient
import com.appstuddio.retrofit.network.response.Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentRepository{
    private lateinit var students: MutableLiveData<List<Student>>

    fun getStudents(): LiveData<List<Student>> {
        students = MutableLiveData()
        val call: Call<List<Student>> = StudentClient.instance!!.getStudents()
        call.enqueue(object : Callback<List<Student>> {
            override fun onResponse(call: Call<List<Student>>, response: Response<List<Student>>) {
                if(response.isSuccessful){
                    students.value = response.body()
                    Log.i("students","datos correctos")
                }
                else
                    Log.e("students","error al obtener los datos")
            }
            override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                Log.e("students","falla de conexion")
            }
        })
        return students
    }
}