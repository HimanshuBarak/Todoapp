package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val listener:DeleteItemclicked): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

      inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
                  var textView: TextView = itemView.findViewById(R.id.text)
                  var delbtn:ImageView = itemView.findViewById(R.id.delbtn)
      }

    private var alltodos = ArrayList<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_node,parent,false)
        val  viewHolder = TodoViewHolder(view)
        viewHolder.delbtn.setOnClickListener{
            listener.onItemClicked(alltodos[viewHolder.adapterPosition])
        }

        return viewHolder


    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentitem = alltodos[position]
        holder.textView.text= currentitem.text
    }

    override fun getItemCount(): Int {
         return alltodos.size
    }

    fun updatetodos(updatedtodo:List<Todo>){
        //clearing the list so that the new results can be displayed this time
        alltodos.clear()
        //adding the new fetched results
        alltodos.addAll(updatedtodo)
        //telling the adapter that the dataset has changed so it can all its function again for the updated data

        notifyDataSetChanged()

    }

}

interface DeleteItemclicked{
    fun onItemClicked(todo:Todo)
}