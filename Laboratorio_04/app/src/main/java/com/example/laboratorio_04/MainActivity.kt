package com.example.laboratorio_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var name : TextView
    private lateinit var email : TextView
    private lateinit var cel : TextView
    private lateinit var save : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding()
        data()

    }

    private fun binding (){
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        cel  = findViewById(R.id.cel)
        save = findViewById(R.id.btnSave)
    }

        fun data (){
        save.setOnClickListener(){

            val name_send = name.text.toString()
            val email_send = email.text.toString()
            val cel_send = cel.text.toString()

        val intent = Intent(this , secondActivity::class.java)
            intent.putExtra("name", name_send )
            intent.putExtra("email",  email_send)
            intent.putExtra("cel",  cel_send)
            startActivity(intent)
            }

        }

    }


