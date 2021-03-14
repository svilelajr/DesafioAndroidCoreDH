package com.example.desafioandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R
import com.example.desafioandroid.adapter.RestaurantAdapter
import com.example.desafioandroid.model.Restaurant

class RestaurantActivity : AppCompatActivity() {

    val recycle: RecyclerView by lazy {findViewById<RecyclerView>(R.id.recyclerViewRestaurants)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)


        val restaurants: List<Restaurant> = getRestaurants()
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = RestaurantAdapter(restaurants)

    }

    private fun getRestaurants(): List<Restaurant> {
        val restaurantList: MutableList<Restaurant> = mutableListOf<Restaurant>()
        var image : Int

        for (index in 0..20){
            if (index % 2 == 1){
                image = R.drawable.mcdonalds
            }else{
                image = R.drawable.bk
            }

            val restaurant = Restaurant("Restaurante $index","Endereço $index", "$index:00", image)
            restaurantList.add(restaurant)
        }

        return restaurantList.toList()
    }
}