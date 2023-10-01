package ru.kubsu.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var leftEdt: EditText
    private lateinit var rightEdt: EditText
    private lateinit var signTv: TextView
    private lateinit var mainTv: TextView
    private lateinit var equallyBt: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftEdt = findViewById(R.id.etOperationLeft)
        leftEdt.requestFocus()
        leftEdt.showSoftInputOnFocus = false
        rightEdt = findViewById(R.id.etOperationRight)
        rightEdt.showSoftInputOnFocus = false
        signTv = findViewById(R.id.tvOperationSign)
        mainTv = findViewById(R.id.tvOperationInput)

        val btnPlus: Button=findViewById(R.id.btPlus)
        val btnMinus: Button=findViewById(R.id.btMinus)
        val btnMultiply: Button=findViewById(R.id.btMultiply)
        val btnDivide: Button=findViewById(R.id.btDivide)
        btnPlus.setOnClickListener{signButton("+")}
        btnMinus.setOnClickListener{signButton("-")}
        btnMultiply.setOnClickListener{signButton("*")}
        btnDivide.setOnClickListener({signButton("/")})

        equallyBt = findViewById(R.id.btEqually)
        equallyBt.setOnClickListener{equallyButton()}

        val b1: Button=findViewById(R.id.bt1)
        val b2: Button=findViewById(R.id.bt2)
        val b3: Button=findViewById(R.id.bt3)
        val b4: Button=findViewById(R.id.bt4)
        val b5: Button=findViewById(R.id.bt5)
        val b6: Button=findViewById(R.id.bt6)
        val b7: Button=findViewById(R.id.bt7)
        val b8: Button=findViewById(R.id.bt8)
        val b9: Button=findViewById(R.id.bt9)
        val b0: Button=findViewById(R.id.bt0)
        b1.setOnClickListener{numButton("1")}
        b2.setOnClickListener{numButton("2")}
        b3.setOnClickListener{numButton("3")}
        b4.setOnClickListener{numButton("4")}
        b5.setOnClickListener{numButton("5")}
        b6.setOnClickListener{numButton("6")}
        b7.setOnClickListener{numButton("7")}
        b8.setOnClickListener{numButton("8")}
        b9.setOnClickListener{numButton("9")}
        b0.setOnClickListener{numButton("0")}
    }

    private fun equallyButton() {
        if (leftEdt.text.toString().isBlank() || (leftEdt.text.toString().isBlank()
                    && rightEdt.text.toString().isBlank())) {
            leftEdt.error = "Введите число"
        }
        else {if (signTv.text.toString().isBlank()) {
            signTv.error = "Выберите знак"
            }
        else {if (!leftEdt.text.toString().isBlank() && rightEdt.text.toString().isBlank())
            rightEdt.error = "Введите число"
        else {
            mainTv.text = calculate()
            leftEdt.setText("")
            rightEdt.setText("")
            leftEdt.requestFocus()
            signTv.setText("")
        }
        }
        }
    }

    private fun signButton(op: String) {
        leftEdt.error=null

        if (!mainTv.text.toString().isBlank() && mainTv.text.toString() != "NaN" &&
            leftEdt.text.toString().isBlank()) {
            val mainNum = mainTv.text.toString().toDouble()
            leftEdt.setText(mainNum.toString())
            rightEdt.setText("")
            mainTv.text = ""
        }

        if (mainTv.text.toString().isBlank() && !leftEdt.text.toString().isBlank() &&
            !rightEdt.text.toString().isBlank() && op.toString() == signTv.text.toString()) {
                leftEdt.setText(calculate())
                rightEdt.setText("")
                mainTv.text = ""
        }

        if (!leftEdt.text.toString().isBlank() && !mainTv.text.toString().isBlank()) {
            mainTv.text = ""
        }

        if (!leftEdt.text.toString().isBlank() && !rightEdt.text.toString().isBlank()
            && !signTv.text.toString().isBlank() && op.toString() != signTv.text.toString()) {
            leftEdt.setText(calculate(op))
            rightEdt.setText("")
            rightEdt.requestFocus()
            mainTv.text = ""
        }

        signTv.setText(op)
        rightEdt.requestFocus()
    }

    private fun numButton(s: String) {
        if (leftEdt.isFocused)
            leftEdt.append(s)
        else if (rightEdt.isFocused)
            rightEdt.append(s)
    }

    private fun calculate() : String? {
        var leftNum = leftEdt.text.toString().toDoubleOrNull()
        var rightNum = rightEdt.text.toString().toDoubleOrNull()
        val operation = signTv.text.toString()
        var result : String? = null
        if (mainTv.text.toString().isBlank()) {
            if (leftNum != null && rightNum != null) {
                val result = when (operation) {
                    "+" -> leftNum + rightNum
                    "-" -> leftNum - rightNum
                    "*" -> leftNum * rightNum
                    "/" -> {
                        if (rightNum != 0.0) {
                            leftNum / rightNum
                        } else {
                            Double.NaN
                        }
                    }
                    else -> {
                        Double.NaN
                    }
                }
                return result.toString()
            }
        }
        return null
    }

    private fun calculate(newOperation : String) : String? {
        var leftNum = leftEdt.text.toString().toDoubleOrNull()
        var rightNum = rightEdt.text.toString().toDoubleOrNull()
        val operation = newOperation
        var result : String? = null
        if (mainTv.text.toString().isBlank()) {
            if (leftNum != null && rightNum != null) {
                val result = when (operation) {
                    "+" -> leftNum + rightNum
                    "-" -> leftNum - rightNum
                    "*" -> leftNum * rightNum
                    "/" -> {
                        if (rightNum != 0.0) {
                            leftNum / rightNum
                        } else {
                            Double.NaN
                        }
                    }
                    else -> {
                        Double.NaN
                    }
                }
                return result.toString()
            }
        }
        return null
    }


}