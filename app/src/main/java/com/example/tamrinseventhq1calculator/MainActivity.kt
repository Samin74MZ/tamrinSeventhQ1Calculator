package com.example.tamrinseventhq1calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tamrinseventhq1calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var listOfNumberButton = mutableListOf<Button>()
    var listOfOperatorButton = mutableListOf<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    fun initButton() {
        listOfNumberButton.add(binding.butZero)
        listOfNumberButton.add(binding.butOne)
        listOfNumberButton.add(binding.butTwe)
        listOfNumberButton.add(binding.butThree)
        listOfNumberButton.add(binding.butFour)
        listOfNumberButton.add(binding.butFive)
        listOfNumberButton.add(binding.butSix)
        listOfNumberButton.add(binding.butSeven)
        listOfNumberButton.add(binding.butEight)
        listOfNumberButton.add(binding.butNine)
        listOfOperatorButton.add(binding.butPlus)
        listOfOperatorButton.add(binding.butMinus)
        listOfOperatorButton.add(binding.butTimes)
        listOfOperatorButton.add(binding.butDivide)
        listOfOperatorButton.add(binding.butDot)
        listOfOperatorButton.add(binding.butDelete)

    }

    fun updateTextview(view: View) {
        if (view is Button) {
            if (view in listOfNumberButton)
                binding.tvEnterAndResult.text = binding.tvEnterAndResult.text.toString() + view.text
            if (view in listOfOperatorButton) {
                if (binding.tvEnterAndResult.text.isEmpty()) {
                    if (view == binding.butDot) {
                        binding.tvEnterAndResult.text =
                            binding.tvEnterAndResult.text.toString() + "0" + view.text
                    } else if (view == binding.butMinus) {
                        binding.tvEnterAndResult.text =
                            binding.tvEnterAndResult.text.toString() + view.text
                    } else {
                        view.isEnabled = true
                    }
                } else {
                    if (view == binding.butDelete) {
                        binding.tvEnterAndResult.text = ""
                        Calculator.memory=0
                    } else {
                        binding.tvEnterAndResult.text =
                            binding.tvEnterAndResult.text.toString() + view.text
                    }
                }
            }
            Toast.makeText(this, "${view.text}", Toast.LENGTH_SHORT).show()
        }
    }

    fun solutionOfText(view: View) {
        if (view is Button) {
            if (view == binding.butEqual) {
                var solution = checkTextForSolve(binding.tvEnterAndResult.text.toString())
                binding.tvEnterAndResult.text = solution
                Toast.makeText(this, "${view.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkTextForSolve(checkS: String): String {
        var listButtonText = arrayListOf('+', '-', 'x', '÷')
        var checkString = checkS
        var x = 0
        var numberOfOperator = 0
        val opInText: MutableList<Char> = ArrayList()
        var indexOfOp: MutableList<Int> = ArrayList()
        for (i in checkS.indices) {
            for (operator in listButtonText) {
                if (checkS[i] == operator) {
                    numberOfOperator++
                    opInText.add(checkS[i])
                    indexOfOp.add(i)
                }
            }
        }
        val numInText: MutableList<Int> = ArrayList()
        var j = 0
        for (i in indexOfOp) {
            if (j < checkString.length) {
                var c = checkString.substring(j, i).toInt()
                numInText.add(c)
                j += i + 1
            }
        }
        var finalNumber = checkString.drop(indexOfOp[indexOfOp.lastIndex]).toInt()
        var f=finalNumber
        numInText.add(finalNumber)

        for (k in 0 until opInText.size) {
            var l=k
            if (opInText[0]=='-'&& indexOfOp[0]==0){
                Calculator.memory=Calculator.minus(numInText[0])
                l=0
            }else{
                Calculator.memory=Calculator.add(numInText[0])
                l=k
            }
                when (opInText[l]) {
                    '+' -> {
                        x = Calculator.add(numInText[l + 1])
                    }
                    '-' -> {
                        x = Calculator.minus(-numInText[l + 1])
                    }
                    'x' -> {
                        x = Calculator.multiplication(numInText[l + 1])
                    }
                    '÷' -> {
                        x = Calculator.division(numInText[l + 1])
                    }
                }
        }
        return x.toString()
    }
}