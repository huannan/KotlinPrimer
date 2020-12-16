package com.nan.kotlinprimer.day2_java_call.demo3


/**
 * 解决与 Java 在关键字上的冲突
 *
 * 正确调用方法应该是将该变量使用两个反引号包裹(`)
 */
fun main() {
    println(TestJava.`in`)
}