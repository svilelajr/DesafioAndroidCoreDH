package com.example.desafioandroid.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R
import com.example.desafioandroid.activity.DishDetailActivity
import com.example.desafioandroid.activity.RestaurantDetailActivity
import com.example.desafioandroid.model.Dish
import com.example.desafioandroid.viewholder.RestaurantDetailViewHolder

class RestaurantDetailAdapter(private val dishList: List<Dish>): RecyclerView.Adapter<RestaurantDetailViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantDetailViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.dishes_item, parent,false)
        return RestaurantDetailViewHolder(view)

    }

    override fun onBindViewHolder(holder: RestaurantDetailViewHolder, position: Int) {

        val dish = dishList[position]

        val image: ImageView = holder.image
        image.setImageResource(dishList[position].dishImage)

        val name: TextView = holder.name
        name.text = dishList[position].dishName


        holder.cardView.setOnClickListener{
            val intent = Intent(it.context, DishDetailActivity::class.java)
            intent.putExtra("NAME",dish.dishName)
            intent.putExtra("IMAGE",dish.dishImage)
            intent.putExtra("DESCRIPTION",dish.dishDescription)
            it.context.startActivity(intent)
        }
    }



    override fun getItemCount() = dishList.size


}