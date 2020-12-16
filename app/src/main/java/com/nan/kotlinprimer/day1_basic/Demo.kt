package com.nan.kotlinprimer.day1_basic

// var 表示一个变量
var age1: Int = 18

// val 表示一个不可变的变量，相当于加了final修饰
// val 是 Kotlin 在 Java 的「变量」类型之外，又增加的一种变量类型：只读变量。它只能赋值一次，不能修改。而 var 是一种可读可写变量。
val age2: Int = 18

// 类型是编译器可以推断出来的就不用写类型
var age3 = 18

// 不可空变量
var name1: String = "小楠总"

// 可空变量
var name2: String? = null

// 延迟初始化
// 这个 lateinit 的意思是：告诉编译器我没法第一时间就初始化，但我肯定会在使用它之前完成初始化的。
// 它的作用就是让 IDE 不要对这个变量检查初始化和报错。换句话说，加了这个 lateinit 关键字，这个变量的初始化就全靠你自己了，编译器不帮你检查了。
lateinit var name3: String

fun main() {
    testNullSafe()

    val res = testFunction(name1)

    testTemplate()

    name3 = ""
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
