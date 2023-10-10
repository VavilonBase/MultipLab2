package com.example.multip

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import kotlin.random.Random


class TestAllNumbers : AppCompatActivity() {
    private lateinit var answerText: EditText
    private lateinit var textQuestion: TextView
    private lateinit var buttonAnswer: Button

    private var a: Int = 0
    private var b: Int = 0
    private var count: Int = 0
    private var rightCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_all_numbers)

        answerText = findViewById(R.id.editTextResult)
        textQuestion = findViewById(R.id.textViewQuestion)
        buttonAnswer = findViewById(R.id.buttonAnswer)
        setParams()
    }

    fun onCLickButtonAnswer(view: View) {
        val answer = answerText.text.toString().toInt()
        val rightAnswer = a * b
        if (answer == rightAnswer) {
            val toast = Toast.makeText(this, "Правильный ответ", Toast.LENGTH_SHORT)
            toast.show()
            rightCount++
        } else {
            val toast = Toast.makeText(this, "Неправильный ответ", Toast.LENGTH_SHORT)
            toast.show()
        }
        answerText.text.clear()
        count++
        if (count > 5) {
            answerText.isEnabled = false
            buttonAnswer.isEnabled = false
            val formattedNumber = DecimalFormat("#.##").format(rightCount.toFloat() / count * 100)
            val toast = Toast.makeText(this, "Тест завершен\nПроцент правильных ответов: ${formattedNumber}%", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            setParams()
        }
    }

    fun setParams() {
        a = Random.nextInt(2, 10)
        b = Random.nextInt(2, 10)
        textQuestion.text = "Решите пример: ${a}x${b}"
    }

    fun onClickBackArrow(view: View) {
        val intent = Intent(this@TestAllNumbers, MainActivity::class.java)
        startActivity(intent)
    }
}