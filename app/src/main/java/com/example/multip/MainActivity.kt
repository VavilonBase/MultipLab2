package com.example.multip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var numberEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberEditText = findViewById(R.id.editTextNumber)
    }

    fun onClickButtonAllNumbers(view: View) {
        val intent = Intent(this@MainActivity, TestAllNumbers::class.java)
        startActivity(intent)
    }

    fun onCLickButtonChoice(view: View) {
        val intent = Intent(this@MainActivity, TestChoiceNumber::class.java)
        val number =  if (numberEditText.text.isNotEmpty()) numberEditText.text.toString().toInt() else 2
        intent.putExtra(MainActivity.PARAM_A, number)
        startActivity(intent)
    }


    companion object {

        const val PARAM_A = "number_a"

    }

}