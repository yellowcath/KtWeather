package com.hw.ktexercise

import kotlinx.coroutines.*

/**
 * Created by waylonhuang on 2019/1/2.
 */

fun main() {
    coroutineDemo()
}

fun coroutineDemo() {
    GlobalScope.launch {
        delay(500)
        println("Coroutine")
    }
    println("Hello")
    Thread.sleep(1000)
}

fun doSomething():String{
    return "Finished"
}

