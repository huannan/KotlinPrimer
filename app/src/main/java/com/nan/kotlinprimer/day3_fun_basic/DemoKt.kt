package com.nan.kotlinprimer.day3_fun_basic

/**
 * 函数声明
 *
 * 在 kotlin 中以 fun 关键字表示我要声明的是一个函数，函数的参数与变量声明类似，变量名 : 变量类型，如果需要返回值，则直接在后面添加 : 返回值类型
 *
 * Kotlin 函数参数默认是 val 类型，所以参数前不需要写 val 关键字，Kotlin 里这样设计的原因是保证了参数不会被修改，而 Java 的参数可修改（默认没 final 修饰）会增加出错的概率。
 */
fun getLen1(string: String): Int {
    return string.length
}

/**
 * 函数体省略
 *
 * 如果一个函数的函数体只要一个语句的话，我们是可以直接将这个语句赋值给这个函数
 */
fun getLen2(string: String) = string.length

/**
 * 函数参数默认值
 *
 * Kotlin 中允许函数的参数有默认值的
 * 注意：Java调用这个函数必须传入参数；可以加上@JvmOverloads让编译器生成重载函数，方便Java使用
 */
@JvmOverloads
fun sayHello(name: String = "default") {
    println(name)
}

/**
 * 可变长参数
 */
fun testVar(vararg arg: Int) {
    for (i in arg) {
        println(i)
    }
}

/**
 * 函数嵌套
 *
 * 与内部类有些类似，内部函数可以访问外部函数的局部变量，例如代码中的 name，内部函数是可以访问的
 * 使用场景：在某些条件下会触发递归的函数；不希望被外部函数访问到的函数
 * 【注】需要注意的是，在一般情况下我们是不推荐使用嵌套函数的，因为这样会大大降低代码的可读性。
 */
fun repeat() {

    val name = "hello"

    fun run(count: Int = 10) {
        println(name)
        if (count > 0) {
            run(count - 1)
        }
    }

    run()
}

fun main() {
    sayHello()
    sayHello("小楠总")

    repeat()

    testVar(1, 2, 3, 4, 5, 6)
}