package com.example.restusingretrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*


class ToDoAdapter(private val mCtx: Context, private val list:List<ToDO>) :
    RecyclerView.Adapter<ToDoAdapter.ToDOViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ToDOViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(com.example.restusingretrofit.R.layout.item_view, parent, false)
        return ToDOViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDOViewHolder, position: Int) {
        val p = list.get(position)
        holder.item_title.setText(p.title)
        holder.item_comp.setText(p.completed)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ToDOViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var item_title: TextView
        var item_comp: TextView

        init {

            item_title= itemView.findViewById(com.example.restusingretrofit.R.id.item_title)
            item_comp = itemView.findViewById(com.example.restusingretrofit.R.id.item_comp)


            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {

        }
    }
}




