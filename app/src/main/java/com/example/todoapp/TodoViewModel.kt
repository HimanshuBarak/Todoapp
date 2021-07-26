package com.example.todoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

       val alltodos : LiveData<List<Todo>>
       private val repository:TodoRepository


    init {
           //getting the dao
           val dao = Tododatabase.getDatabase(application).gettododao()

            repository = TodoRepository(dao)
           alltodos = repository.alltodos
       }

      fun deletetodo(todo:Todo) = viewModelScope.launch (Dispatchers.IO){
               repository.delete(todo)
      }
      fun inserttodo(todo:Todo) = viewModelScope.launch (Dispatchers.IO){
            repository.insert(todo)
      }
}