package com.nan.kotlinprimer.day18_coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun main() {
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    coroutineScope.launch {
        println("thread=${Thread.currentThread().name}")
        repeat(10) {
            println(it)
        }
    }
}