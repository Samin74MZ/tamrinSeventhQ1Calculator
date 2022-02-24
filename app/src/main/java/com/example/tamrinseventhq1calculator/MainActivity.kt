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
                    } else {
                        view.isEnabled = true
                    }
                } else {
                    if (view == binding.butDelete) {
                        binding.tvEnterAndResult.text=" "
                    }
                    else {
                        binding.tvEnterAndResult.text = binding.tvEnterAndResult.text.toString() + view.text
                    }
                }
            }
            Toast.makeText(this,"${view.text}",Toast.LENGTH_SHORT).show()
        }
    }
    fun solutionOfText(view:View){
        if(view is Button){
            if (view==binding.butEqual){
                binding.tvEnterAndResult.text="0"
                Toast.makeText(this,"${view.text}",Toast.LENGTH_SHORT).show()
            }
        }
    }
   fun checkTextForSolve(){
       var listButtonText= mutableListOf(binding.butPlus.text,binding.butMinus.text,binding.butTimes.text,binding.butDivide.text)
       var checkString=binding.tvEnterAndResult.text.toString()
       if (!binding.tvEnterAndResult.text.isBlank()){
          for (i in checkString.indices){

          }
       }
   }
}