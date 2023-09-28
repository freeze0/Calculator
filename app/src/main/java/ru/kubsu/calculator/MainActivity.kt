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
        rightEdt = findViewById(R.id.etOperationRight)
        signTv = findViewById(R.id.tvOperationSign)
        mainTv = findViewById(R.id.tvOperationInput)
        equallyBt = findViewById(R.id.btEqually)

//        val clNumToTv = View.OnClickListener {
//            val s="${mainTv.text.toString()}${(it as Button).text}"
//            mainTv.setText(s) переделать под левый и правый ввод
//        }

        val clSignToTv = View.OnClickListener {
            val s="${(it as Button).text}"
            signTv.setText(s)
        }
        val bPlus: Button=findViewById(R.id.btPlus)
        val bMinus: Button=findViewById(R.id.btMinus)
        val bMultiply: Button=findViewById(R.id.btMultiply)
        val bDivide: Button=findViewById(R.id.btDivide)
        bPlus.setOnClickListener(clSignToTv)
        bMinus.setOnClickListener(clSignToTv)
        bMultiply.setOnClickListener(clSignToTv)
        bDivide.setOnClickListener(clSignToTv)

        val clEqually = View.OnClickListener {
//            if (leftEdt.text.toString().isBlank() || rightEdt.text.toString().isBlank())
//                mainTv.error = "Пустая ячейка!" // защиту от букв пока не делал
//            else {
                val leftNum = leftEdt.text.toString().toDoubleOrNull()
                val rightNum = rightEdt.text.toString().toDoubleOrNull()
                val operation = signTv.text.toString()
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
                    mainTv.text = result.toString()
                }
        }
        equallyBt.setOnClickListener(clEqually)


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
//        b1.setOnClickListener(clNumToTv)
//        b2.setOnClickListener(clNumToTv)
//        b3.setOnClickListener(clNumToTv)
//        b4.setOnClickListener(clNumToTv)
//        b5.setOnClickListener(clNumToTv)
//        b6.setOnClickListener(clNumToTv)
//        b7.setOnClickListener(clNumToTv)
//        b8.setOnClickListener(clNumToTv)
//        b9.setOnClickListener(clNumToTv)
//        b0.setOnClickListener(clNumToTv)

    }
}