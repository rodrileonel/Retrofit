package com.appstuddio.retrofit.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appstuddio.retrofit.R
import com.appstuddio.retrofit.network.response.Student
import kotlinx.android.synthetic.main.row_student.view.*

class StudentAdapter (context: Context)
    :RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    var students = emptyList<Student>()
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount() = students.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = StudentViewHolder(inflater.inflate(R.layout.row_student,parent,false))

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int)
            = holder.bind(students[position])

    internal fun setStudents(students:List<Student>){
        this.students = students
        notifyDataSetChanged()
    }
    class StudentViewHolder(item: View): RecyclerView.ViewHolder(item){
        fun bind(student:Student) {
            itemView.apply {
                name.text = student.name
            }
        }
    }
}