package com.example.desafioandroid.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R

class RestaurantDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val name: TextView by lazy {view.findViewById<TextView>(R.id.tv_dish_name)}
    val image: ImageView by lazy {view.findViewById<ImageView>(R.id.iv_dish)}
    val cardView: CardView by lazy {view.findViewById<CardView>(R.id.cv_dish)}

}