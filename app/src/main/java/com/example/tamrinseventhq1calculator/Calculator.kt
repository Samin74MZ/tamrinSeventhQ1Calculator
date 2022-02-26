package com.example.tamrinseventhq1calculator

import java.lang.Exception

object Calculator {
    var memory = 0
    fun add(input: Int, input1: Int): Int {
        this.memory = input + input1
        return this.memory
    }

    fun add(input: Int): Int {
        this.memory += input
        return this.memory
    }

    fun minus(input: Int, input1: Int): Int {
        this.memory = input - input1
        return this.memory
    }

    fun minus(input: Int): Int {
        this.memory -= input
        return this.memory
    }

    fun multiplication(input: Int, input1: Int): Int {
        this.memory = input * input1
        return this.memory
    }

    fun multiplication(input: Int): Int {
        this.memory = this.memory*input
        return this.memory
    }

    fun division(input: Int, input1: Int): Int {
            this.memory = input / input1
            return this.memory
    }

    fun division(input: Int): Int {
        return try {
            this.memory /= input
            this.memory
        } catch (e: Exception) {
            println("error")
            0
        }
    }
}
