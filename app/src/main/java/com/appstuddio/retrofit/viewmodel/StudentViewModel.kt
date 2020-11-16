package com.appstuddio.retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.appstuddio.retrofit.network.response.Student
import com.appstuddio.retrofit.repository.StudentRepository

class StudentViewModel(application: Application): AndroidViewModel(application){

    private val studentRepository: StudentRepository

    init {
        studentRepository = StudentRepository()
    }

    fun getStudents(): LiveData<List<Student>> {
        return studentRepository.getStudents()
    }

}