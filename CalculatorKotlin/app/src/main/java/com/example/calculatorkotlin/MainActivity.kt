package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        One.setOnClickListener { expadd("1", true) }
        Two.setOnClickListener { expadd("2", true) }
        Three.setOnClickListener { expadd("3", true) }
        Four.setOnClickListener { expadd("4", true) }
        Five.setOnClickListener { expadd("5", true) }
        Six.setOnClickListener { expadd("6", true) }
        Seven.setOnClickListener { expadd("7", true) }
        Eight.setOnClickListener { expadd("8", true) }
        Nine.setOnClickListener { expadd("9", true) }
        Zero.setOnClickListener { expadd("0", true) }
        Dot.setOnClickListener { expadd(".", true) }
        Plus.setOnClickListener { expadd("+", false) }
        Minus.setOnClickListener { expadd("-", false) }
        Mul.setOnClickListener { expadd("*", false) }
        Divide.setOnClickListener { expadd("/", false) }
        Open.setOnClickListener { expadd("(", false) }
        Close.setOnClickListener { expadd(")", false) }
        Clear.setOnClickListener {
            Expression.text = ""
            Result.text = ""
        }

        Back.setOnClickListener {
            val string = Expression.text.toString()
            if (string.isNotEmpty()) {
                Expression.text = string.substring(0, string.length - 1)
            }
            Result.text = ""
        }

        Equals.setOnClickListener {
            try {

                val expression = ExpressionBuilder(Expression.text.toString()).build()
                if(Expression.text.toString()=="1+")
                {
                    Result.text="NEVER SETTLE"
                }
                else {
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble())
                        Result.text = longResult.toString()
                    else
                        Result.text = result.toString()
                }

            }
            catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }

    }

    fun expadd(string: String, canClear: Boolean) {
        if (Result.text.isNotEmpty()) {
            Expression.text = ""
        }
        if (canClear) {
            Result.text = ""
            Expression.append(string)
        } else {
            Expression.append(Result.text)
            Expression.append(string)
            Result.text = ""
        }
    }
}
