package com.example.tamrinseventhq1calculator

import java.lang.Exception

class Calculator{
    private var memory=0
    fun add(input:Int,input1: Int):Int{
        memory=input+input1
        return memory
    }
    fun add(input: Int):Int{
        memory+=input
        return memory
    }
    fun minus(input: Int,input1: Int):Int{
        memory=input-input1
        return memory
    }
    fun minus(input: Int):Int{
        memory-=input
        return input
    }
    fun multiplication(input: Int,input1: Int):Int{
        memory=input*input1
        return memory
    }
    fun multiplication(input: Int):Int{
        memory*=input
        return memory
    }
    fun division(input: Int,input1: Int):Int{
        memory=input/input1
        return memory
    }
    fun division(input: Int):Int{
        return try {
            memory/=input
            memory
        }catch (e:Exception){
            println("error")
            0
        }
    }
}
