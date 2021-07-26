package com.example.todoapp

import androidx.lifecycle.LiveData

//single source of truth
class TodoRepository(private val tododao: todoDao) {

       //geting alltodos returned by the dao
         val alltodos:LiveData<List<Todo>> = tododao.getalltodos()

         suspend fun insert(todo:Todo){
             tododao.insert(todo)
         }
         suspend fun delete(todo:Todo){
            tododao.delete(todo)
       }
}