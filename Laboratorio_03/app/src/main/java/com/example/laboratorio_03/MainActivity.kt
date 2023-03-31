package com.example.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var totalText : TextView
    private lateinit var fiveCents: ImageView
    private lateinit var tenCents : ImageView
    private lateinit var quarter : ImageView
    private lateinit var dollar: ImageView
    private var total = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        eventListener()

    }

    private fun binding (){
        fiveCents = findViewById(R.id.image_five_cents)
        tenCents= findViewById(R.id.image_ten_cents)
        quarter = findViewById(R.id.image_quarter)
        dollar = findViewById(R.id.image_dollar)
        totalText = findViewById(R.id.total_text)
    }

    private fun eventListener (){
        fiveCents.setOnClickListener(){
            total = total + 0.05
            total = (total * 100.0).roundToInt() / 100.0
            totalText.text = total.toString()
        }
        tenCents. setOnClickListener(){
            total = total + 0.10
            total = (total * 100.0).roundToInt() / 100.0
            totalText.text = total.toString()
        }
        quarter.setOnClickListener(){
            total = total + 0.25
            totalText.text = total.toString()

        }
        dollar.setOnClickListener(){
            total = total + 1
            totalText.text = total.toString()
        }
    }
}