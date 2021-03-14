package com.example.desafioandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.desafioandroid.R

class DishDetailActivity : AppCompatActivity() {

    val tvdishName : TextView by lazy {findViewById<TextView>(R.id.tv_dish_name)}
    val tvdishDescription: TextView by lazy {findViewById<TextView>(R.id.tv_dish_description)}
    val imdishImage: ImageView by lazy {findViewById<ImageView>(R.id.iv_dish)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)

        val info = intent.extras

        if(info!=null){

            val dishName = info.getString("NAME")
            val dishImage = info.getInt("IMAGE")
            val dishDescription = info.getString("DESCRIPTION")

            tvdishName.text = dishName
            tvdishDescription.text = dishDescription
            imdishImage.setImageResource(dishImage)

        }else  {
            Toast.makeText(this, "Erro ao Carregar os Detalhes do Restaurante", Toast.LENGTH_LONG).show()
        }


    }
}