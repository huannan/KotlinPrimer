package com.nan.kotlinprimer.day14_compare

/**
 * Kotlin 比较对象
 *
 * 在 Kotlin 中是不需要通过 equals 方法判断两个对象的值是否相同，而是通过 ==，如果判断对象是否相同则需要使用 ===
 */
fun main() {
    val string = "string"
    val newString = String("string".toByteArray())
    println("string == newString: ${string == newString}")
    println("string === newString: ${string === newString}")
}