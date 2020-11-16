package com.appstuddio.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.appstuddio.retrofit.ui.StudentAdapter
import com.appstuddio.retrofit.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val studentViewModel by lazy { ViewModelProvider(this).get(StudentViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = StudentAdapter(this)
        rvStudents.adapter = adapter
        rvStudents.layoutManager = LinearLayoutManager(this)

        studentViewModel.getStudents().observe(this, Observer {
            it?.let { adapter.setStudents(it) }
        })
    }
}