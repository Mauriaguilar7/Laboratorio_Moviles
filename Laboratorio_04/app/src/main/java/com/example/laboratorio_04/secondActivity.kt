    package com.example.laboratorio_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

    class secondActivity : AppCompatActivity() {

        private lateinit var textName: TextView
        private lateinit var textEmail: TextView
        private lateinit var textCel: TextView
        private lateinit var btnShare: Button


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_second)

            binding()
            info()
        }


        fun binding() {
            textName = findViewById(R.id.text_name)
            textEmail = findViewById(R.id.text_email)
            textCel = findViewById(R.id.text_cel)
            btnShare = findViewById(R.id.btnShare)
        }


        fun info() {
            val userName = intent.getStringExtra("name").toString()
            val userEmail = intent.getStringExtra("email").toString()
            val userCel = intent.getStringExtra("cel").toString()

            textName.text = userName
            textEmail.text = userEmail
            textCel.text = userCel

            btnShare.setOnClickListener(){
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "name: $userName \n email: $userEmail \n cel: $userCel")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }

}