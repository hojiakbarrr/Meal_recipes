package com.example.meal_recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Meak_Adapter(val list: ArrayList<DetailsMeal>,
                   val clickListener: FoodClickListener) :
    RecyclerView.Adapter<Meak_Adapter.MealHolder> (){

    inner class MealHolder(item : View) : RecyclerView.ViewHolder(item){
        var imageIdtransfer: ImageView = itemView.findViewById(R.id.imageView)
        var titletransfer: TextView = itemView.findViewById(R.id.textView)
        var descriptiontransfer:TextView = itemView.findViewById(R.id.textView2)
        var timetransfer:TextView = itemView.findViewById(R.id.textView3)
        var like:ImageView = itemView.findViewById(R.id.imageView3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_shablon,parent,false)
        return MealHolder(view)
    }

    override fun onBindViewHolder(holder: MealHolder, position: Int) {
        holder.itemView.apply {
            holder.titletransfer.text = list[position].title
            holder.descriptiontransfer.text = list[position].description
            holder.imageIdtransfer.setImageResource(list[position].imageId)
            holder.timetransfer.text = list[position].gotovit
            holder.like.setImageResource(list[position].likeIdImage)
        }
        holder.itemView.setOnClickListener {
            clickListener.fonItemClick(position)
        }
        holder.like.setOnClickListener {
            clickListener.fonLikeClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface FoodClickListener {
        fun fonItemClick(position: Int)
        fun fonLikeClick(position: Int)
        fun deletefav(position: Int)
    }

}

