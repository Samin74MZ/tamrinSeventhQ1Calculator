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
                    }else if (view==binding.butMinus){
                        binding.tvEnterAndResult.text =
                            binding.tvEnterAndResult.text.toString() + view.text
                    } else {
                        view.isEnabled = true
                    }
                } else {
                    if (view == binding.butDelete) {
                        binding.tvEnterAndResult.text = ""
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

    private fun checkTextForSolve(checkS: String):String {
        var listButtonText = arrayListOf('+', '-', 'x', '÷')
        var checkString = checkS//binding.tvEnterAndResult.text.toString()
        var calculator=Calculator()
        var x=0
        //if (binding.tvEnterAndResult.text.isNotBlank()) {
        for (i in checkString.indices) {
            val opInText: MutableList<Char> = ArrayList()
            for (operator in listButtonText) {
                if (checkString[i] == operator) {
                    var c = checkString.substring(0, i - 1).toInt()
                    opInText.add(operator)
                //    var b = checkString.drop(i ).toInt()
             //       x= calculator.add(c)
//                    when (operator) {
//                        '+' -> Calculator.add(c, b)
//                        '-' -> Calculator.minus(c, b)
//                        'x' -> Calculator.multiplication(c, b)
//                        '÷' -> Calculator.division(c, b)
//                    }
                        if (opInText.isEmpty()) {
                          x= calculator.add(c)
                        } else {
                           when (opInText[opInText.indexOf(operator) - 1]) {
                                '+' -> x=calculator.add(c)
                                '-' -> x=calculator.minus(c)
                                'x' -> x=calculator.multiplication(c)
                                '÷' -> x=calculator.division(c)
                            }
                        }
                }

            }
        }
       return x.toString()
    }
    //}
}