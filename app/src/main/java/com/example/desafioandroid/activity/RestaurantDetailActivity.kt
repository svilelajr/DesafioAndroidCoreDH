package com.example.desafioandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R
import com.example.desafioandroid.adapter.RestaurantAdapter
import com.example.desafioandroid.adapter.RestaurantDetailAdapter
import com.example.desafioandroid.model.Dish
import com.example.desafioandroid.model.Restaurant

class RestaurantDetailActivity : AppCompatActivity() {

    val tvRestaurantName: TextView by lazy { findViewById<TextView>(R.id.tv_restaurant_name) }
    val ivRestaurantImage: ImageView by lazy { findViewById<ImageView>(R.id.iv_restaurant)}
    val recycle: RecyclerView by lazy {findViewById<RecyclerView>(R.id.recyclerViewDishes)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        getDishes()

        val info = intent.extras

        if(info!=null){
            val restaurantName = info.getString("NAME")
            val restaurantImage = info.getInt("IMAGE")

            tvRestaurantName.text = restaurantName
            ivRestaurantImage.setImageResource(restaurantImage)

        }else  {
            Toast.makeText(this, "Erro ao Carregar os Detalhes do Restaurante", Toast.LENGTH_LONG).show()
        }

        val dishes: List<Dish> = getDishes()
        recycle.layoutManager = GridLayoutManager(this, 2)
        recycle.adapter = RestaurantDetailAdapter(dishes)


    }

    private fun getDishes(): List<Dish> {
        val dishList: MutableList<Dish> = mutableListOf<Dish>()
        var image : Int

        for (index in 0..20){
            if (index % 2 == 1){
                image = R.drawable.mcdonalds
            }else{
                image = R.drawable.bk
            }

            val dish = Dish("Dish $index","descrição prato bla bla bla bla bla $index", image)
            dishList.add(dish)
        }

        return dishList.toList()
    }
}