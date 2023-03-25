package com.example.laboratorio_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {


    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculatebutton : Button
    private lateinit var bmiTextView : TextView
    private lateinit var resultTextView: TextView
    private lateinit var infoTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding()

        calculatebutton.setOnClickListener{
            val height = weightEditText.text.toString()
            val weight = weightEditText.text.toString()

            if (!validateInput(height,weight)){
                return@setOnClickListener
            }
            else {

                val result = calculateBMI(weight.toFloat(), height.toFloat())

                resultTextView.text = result.toString()

                if (result < 18.5)
                    bmiTextView.text = result.toString()
                else if (result in 18.5..24.99)
                    bmiTextView.text = result.toString()
                else if (result > 25)
                    bmiTextView.text = result.toString()
            }
        }
    }

    private fun binding() {
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        calculatebutton = findViewById(R.id.calculate_button)
        bmiTextView = findViewById(R.id.bmi_text_view)
        resultTextView = findViewById(R.id.result_text_view)
        infoTextView = findViewById(R.id.info_text_view)
    }

    private fun calculateBMI(weight: Float, height: Float): Float {
        return weight / ((height / 100) * (height / 100))
    }

    private fun validateInput(weight: String?, height: String?): Boolean{

        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "weight is empty!", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty!", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> true
        }

    }


}














