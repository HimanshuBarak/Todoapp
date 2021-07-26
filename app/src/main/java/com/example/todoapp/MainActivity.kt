package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DeleteItemclicked {

    //defining a variable to type TodoViewModel
    lateinit var viewModel: TodoViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = TodoAdapter(this)
        recyclerview.adapter=adapter


       //initalizing the viewmodel
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(TodoViewModel::class.java)

        viewModel.alltodos.observe(this, Observer { list->
           list?.let{
               adapter.updatetodos(it)
           }

        })
    }

    override fun onItemClicked(todo: Todo) {
        viewModel.deletetodo(todo)
    }

    fun submitdata(view: View) {
        val todotext = input.text.toString()
        if(todotext.isNotEmpty())
        {
            viewModel.inserttodo(Todo(todotext))
        }
    }
}