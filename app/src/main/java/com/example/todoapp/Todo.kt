package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

//defining our table schema

@Entity(tableName = "todo_table")
class Todo( val text:String) {
        //auto generating a id for each record
       @PrimaryKey(autoGenerate = true) var id=0
}