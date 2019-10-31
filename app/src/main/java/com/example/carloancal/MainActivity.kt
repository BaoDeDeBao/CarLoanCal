package com.example.carloancal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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
        val car_price = editTextCarPrice.text.toString().toInt()
        val down_payment = editTextDP.text.toString().toInt()
        val loan_period = editTextLP.text.toString().toInt()
        val interest_rate = editTextIR.text.toString().toFloat()

        val loan = car_price - down_payment
        val interest = loan * (interest_rate/100) * loan_period
        val monthly_repayment = (loan + interest) / loan_period / 12

        val textViewLoan = findViewById<TextView>(R.id.textViewLoan)
        textViewLoan.text = getString(R.string.loan) + ": " + loan.toString() // loan must be convert to string if adding it to text view

        val textViewInterest = findViewById<TextView>(R.id.textViewInterest)
        textViewInterest.text = getString(R.string.interest) + ": ${interest}" //R.string.interest - Retreiving interest from resource

        val textViewMonthlyRepayment = findViewById<TextView>(R.id.textViewMR)
        textViewMonthlyRepayment.text = getString(R.string.monthly_repayment) + ": " + monthly_repayment.toString()

    }

    private fun resetInput(view: View) {
        val editTextCP = findViewById<TextView>(R.id.editTextCarPrice)
        editTextCP.text = ""

        val editTextDP = findViewById<TextView>(R.id.editTextDP)
        editTextDP.text = ""

        val editTextLP = findViewById<TextView>(R.id.editTextLP)
        editTextLP.text = ""

        val editTextIR = findViewById<TextView>(R.id.editTextIR)
        editTextIR.text = ""

        val textViewLoan = findViewById<TextView>(R.id.textViewLoan)
        textViewLoan.text = ""

        val textViewInterest = findViewById<TextView>(R.id.textViewInterest)
        textViewInterest.text = ""

        val textViewMonthlyRepayment = findViewById<TextView>(R.id.textViewMR)
        textViewMonthlyRepayment.text = ""
    }
}
