package com.nan.kotlinprimer.day1_basic

// var 表示一个变量
var age1: Int = 18

// val 表示一个不可变的变量，相当于加了final修饰
val age2: Int = 18

// 类型是编译器可以推断出来的就不用写类型
var age3 = 18

// 不可空变量
var name1: String = "小楠总"

// 可空变量
var name2: String? = null

fun main() {
    testNullSafe()

    val res = testFunction(name1)

    testTemplate()
}

/**
 * 空安全
 *
 * 可空变量类型 包含了 不可空变量类型
 * 不可随意互相赋值
 */
fun testNullSafe() {
    // 不可空变量赋值给可空变量
    name2 = name1
    // 可空变量赋值给不可空变量
    // 如果非要要赋值的话，可以使用 !!，表示该变量不可能为空，一旦为空则报 KotlinNullPointerException
    name1 = name2!!
}

/**
 * 函数定义
 */
fun testFunction(str: String): Int {
    return str.length
}

/**
 * 字符串模板语法
 */
fun testTemplate() {
    println("我是$name1, 今年$age1")
}
