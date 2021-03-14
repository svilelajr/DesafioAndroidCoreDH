package com.example.desafioandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafioandroid.R

class MainActivity : AppCompatActivity() {

    val btnRegister: Button by lazy { findViewById<Button>(R.id.btn_register)}
    val btnLogin: Button by lazy {findViewById<Button>(R.id.btn_login)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DesafioAndroid)
        setContentView(R.layout.activity_main)


        btnRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }
    }
}