package com.example.desafioandroid.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R
import com.example.desafioandroid.activity.RestaurantDetailActivity
import com.example.desafioandroid.model.Restaurant
import com.example.desafioandroid.viewholder.RestaurantViewHolder

class RestaurantAdapter (private val restaurantList: List<Restaurant>): RecyclerView.Adapter<RestaurantViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent,false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
       val restaurant = restaurantList[position]

        val name: TextView = holder.name
        name.text = restaurantList[position].name

        val adress: TextView = holder.adress
        adress.text = restaurantList[position].adress

        val closing: TextView = holder.closing
        closing.text = restaurantList[position].closing

        val image: ImageView = holder.image
        image.setImageResource(restaurantList[position].image)

        holder.cardView.setOnClickListener{
            val intent = Intent(it.context, RestaurantDetailActivity::class.java)
            intent.putExtra("NAME",restaurant.name)
            intent.putExtra("IMAGE",restaurant.image)
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount() =  restaurantList.size


}