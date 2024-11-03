package com.example.calculatorapp2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var firstNumber: Double? = null
    private var secondNumber: Double? = null
    private var operation: String? = null
    private var isNewInput = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        Numbers

        val num1 = findViewById<Button>(R.id.numOne)
        val num2 = findViewById<Button>(R.id.num2)
        val num3 = findViewById<Button>(R.id.num3)
        val num4 = findViewById<Button>(R.id.num4)
        val num5 = findViewById<Button>(R.id.num5)
        val num6 = findViewById<Button>(R.id.num6)
        val num7 = findViewById<Button>(R.id.num7)
        val num8 = findViewById<Button>(R.id.num8)
        val num9 = findViewById<Button>(R.id.num9)
        val num0 = findViewById<Button>(R.id.numZero)

//Text View
        val display = findViewById<TextView>(R.id.textDisplay)
        val result = findViewById<TextView>(R.id.result)
        val OperationDisplay = findViewById<TextView>(R.id.textOperation)

//        Operations
        val mul = findViewById<Button>(R.id.oprMul)
        val sub = findViewById<Button>(R.id.oprSub)
        val add = findViewById<Button>(R.id.oprAdd)
        val div = findViewById<Button>(R.id.oprDiv)
        val mod = findViewById<Button>(R.id.oprMod)
        val equalTo = findViewById<Button>(R.id.oprEqualsTo)
        val AC = findViewById<Button>(R.id.btnAc)
        val del = findViewById<Button>(R.id.btnDel)



        num1.setOnClickListener {
            if (isNewInput) {
                display.text = "1"
                isNewInput = false
            } else {
                display.append("1")
            }
//            display.append("1")
        }

        num2.setOnClickListener {
//            display.append("2")

            if (isNewInput) {
                display.text = "2"
                isNewInput = false
            } else {
                display.append("2")
            }
        }

        num3.setOnClickListener {
//            display.append("3")
            if (isNewInput) {
                display.text = "3"
                isNewInput = false
            } else {
                display.append("3")
            }
        }

        num4.setOnClickListener {
//            display.append("4")
            if (isNewInput) {
                display.text = "4"
                isNewInput = false
            } else {
                display.append("4")
            }
        }

        num5.setOnClickListener {
//            display.append("5")
            if (isNewInput) {
                display.text = "5"
                isNewInput = false
            } else {
                display.append("5")
            }
        }

        num6.setOnClickListener {
//            display.append("6")
            if (isNewInput) {
                display.text = "6"
                isNewInput = false
            } else {
                display.append("6")
            }
        }

        num7.setOnClickListener {
//            display.append("7")
            if (isNewInput) {
                display.text = "7"
                isNewInput = false
            } else {
                display.append("7")
            }
        }

        num8.setOnClickListener {
//            display.append("8")
            if (isNewInput) {
                display.text = "8"
                isNewInput = false
            } else {
                display.append("8")
            }
        }

        num9.setOnClickListener {
//            display.append("9")
            if (isNewInput) {
                display.text = "9"
                isNewInput = false
            } else {
                display.append("9")
            }
        }

        num0.setOnClickListener {
//            display.append("0")
            if (isNewInput) {
                display.text = "0"
                isNewInput = false
            } else {
                display.append("0")
            }
        }

        add.setOnClickListener {
            firstNumber = display.text.toString().toDoubleOrNull()
            operation = "+"
            isNewInput = true
            OperationDisplay.text = "+"
        }

        sub.setOnClickListener {
            firstNumber = display.text.toString().toDoubleOrNull()
            operation = "-"
            isNewInput = true
            OperationDisplay.text = "-"
        }

        mul.setOnClickListener {
            firstNumber = display.text.toString().toDoubleOrNull()
            operation = "*"
            isNewInput = true
            OperationDisplay.text = "x"
        }

        div.setOnClickListener {
            firstNumber = display.text.toString().toDoubleOrNull()
            operation = "/"
            isNewInput = true
            OperationDisplay.text = "/"
        }

        mod.setOnClickListener {
            firstNumber = display.text.toString().toDoubleOrNull()
            operation = "%"
            isNewInput = true
            OperationDisplay.text = "%"
        }

        equalTo.setOnClickListener {
            secondNumber = display.text.toString().toDoubleOrNull()
            val resultValue = when (operation) {
                "+" -> firstNumber?.plus(secondNumber!!)
                "-" -> firstNumber?.minus(secondNumber!!)
                "*" -> firstNumber?.times(secondNumber!!)
                "/" -> if (secondNumber != 0.0) firstNumber?.div(secondNumber!!) else "Error"
                "%" -> firstNumber?.rem(secondNumber!!)
                else -> null
            }

            result.text = resultValue.toString()
            display.text = ""
            isNewInput = true
            OperationDisplay.text = ""
        }

        AC.setOnClickListener {
            result.text=""
            OperationDisplay.text = ""
        }

        del.setOnClickListener {
            val currentText = display.text.toString()

            if(currentText.isNotEmpty()){
                display.text = currentText.substring(0,currentText.length-1)
            }
        }


    }
}