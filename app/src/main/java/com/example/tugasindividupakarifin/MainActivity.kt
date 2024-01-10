package com.example.tugasindividupakarifin

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView


class MainActivity : Activity() {
    private var gender:String= "Laki-laki"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        buttonCalculate.setOnClickListener {
            calculateBMI()
        }
        buttonReset.setOnClickListener {
            reset()
        }
    }

    private fun reset() {
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        editTextHeight.setText("")
        editTextWeight.setText("")
        textViewResult.setText("")
        editTextName.setText("")
        editTextAddress.setText("")

    }

    private fun calculateBMI() {
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)

        val name = editTextName.text.toString()
        val address = editTextAddress.text.toString()
        val height = editTextHeight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()

        val selectedGenderId = radioGroupGender.checkedRadioButtonId
        gender = when (selectedGenderId) {
            R.id.radioButtonMale -> "Laki-laki"
            R.id.radioButtonFemale -> "Perempuan"
            else -> "Laki-laki"
        }
        val bmi = when (gender) {
            "Laki-laki" -> weight / ((height / 100) * (height / 100))
            "Perempuan" -> weight / ((height / 100) * (height / 100)) * 0.9
                    else -> 0.0
        }
        val result = when {
            bmi < 18.5 -> "Berat badan kurang"
            bmi >= 18.5 && bmi < 24.9 -> "Berat badan normal"
            bmi >= 25 && bmi < 29.9 -> "Berat badan berlebih"
            else -> "Obesitas"
        }
        textViewResult.text = "$name\n$address\nBMI: %.2f\n$result".format(bmi)
    }
}
