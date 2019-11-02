package com.example.carloancal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.RenderProcessGoneDetail
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCal : Button = findViewById(R.id.buttonCal)
        btnCal.setOnClickListener { calculateLoan(it) }

        val btnReset : Button = findViewById(R.id.buttonReset)
        btnReset.setOnClickListener { resetInput(it) }
    }

    private fun calculateLoan(view: View) {
        val imageViewStatus = findViewById<ImageView>(R.id.imageViewStatus)
        val weight = editTextWeight.text.toString().toDouble()
        val height = editTextHeight.text.toString().toDouble()
        val textViewValue = findViewById<TextView>(R.id.textViewValue)
        val textViewStatus = findViewById<TextView>(R.id.textViewStatus)

        val value = weight/Math.sqrt(height)

        if(value < 18.5) {
            textViewValue.text = getString(R.string.value) + ": ${value}"
            textViewStatus.text = getString(R.string.status) + ": Underweight"
            imageViewStatus.setImageResource(R.drawable.underweight)
            imageViewStatus.visibility = View.VISIBLE
        }
        else if(value < 24.9) {
            textViewValue.text = getString(R.string.value) + ": ${value}"
            textViewStatus.text = getString(R.string.status) + ": Normal"
            imageViewStatus.setImageResource(R.drawable.normal)
            imageViewStatus.visibility = View.VISIBLE
        }
        else if(value >= 25.0) {
            textViewValue.text = getString(R.string.value) + ": ${value}"
            textViewStatus.text = getString(R.string.status) + ": Overweight"
            imageViewStatus.setImageResource(R.drawable.overweight)
            imageViewStatus.visibility = View.VISIBLE
        }


    }

    private fun resetInput(view: View) {
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        editTextWeight.setText("")

        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        editTextHeight.setText("")

        val textViewValue = findViewById<TextView>(R.id.textViewValue)
        textViewValue.text = ""

        val textViewStatus = findViewById<TextView>(R.id.textViewStatus)
        textViewStatus.text = ""

        imageViewStatus.visibility = View.INVISIBLE
    }
}
