package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.selects.select

//this a Data object is used to access data in a more modular way
@Dao
interface  todoDao {

       //if case of duplicate entry ignore the duplicate
       @Insert(onConflict = OnConflictStrategy.IGNORE)
       suspend fun insert(todo:Todo)

       @Delete
       suspend fun delete(todo:Todo)

       @Query("Select * from todo_table")
       fun getalltodos() :LiveData<List<Todo>>
}