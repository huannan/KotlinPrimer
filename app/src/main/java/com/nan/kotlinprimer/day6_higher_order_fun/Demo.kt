package com.nan.kotlinprimer.day6_higher_order_fun

/**
 * 高阶函数
 *
 * 高阶函数就是指函数或者 Lambda 的参数又是一个函数或者 Lambda
 *
 * 通过下面示例简单的了解下。首先，高阶函数也是函数，所以同样需要使用 fun 关键字来修饰，示例中的高阶函数 onlyIf，需要接收两个参数，第一个参数为 Boolean 的变量，第二个参数是参数为空返回值为 Unit 的函数。
 * 其中 Unit 就是一个没有返回值的函数的类型，同样的示例中的 main 函数也会有个隐藏的 Unit 返回值类型，如果作为函数进行声明通常是可以省略的（ main 函数），但是如果作为参数则必须要显式的声明（ onlyIf 的第二个参数）
 */
fun onlyIf(isDebug: Boolean, block: () -> Unit) {
    if (isDebug) {
        block()
    }
}

/**
 * 用内联优化代码
 *
 * Kotlin 的 Lambda 表达式会被编译成匿名内部类的形式，如果在代码中有大量重复的 Lambda 表达式的话，会生成很多无用对象。
 * 可以使用 inline 关键字修饰方法，这样的方法在编译时会把方法的调用拆解为语句的调用，进而减少创建不必要的对象。
 * 加上 inline 关键字修饰，之后我们查看一下它对应的 Java 源码，会发现函数中的代码直接被拆解开进行执行了
 * 需要注意的是，过度使用 inline 关键字会增加编译器的负担，同时使代码块变得很庞大，查找问题会变得麻烦。因此，inline 关键字通常只会修饰高阶函数而不会滥用它。
 */
inline fun onlyIfInline(isDebug: Boolean, block: () -> Unit) {
    if (isDebug) {
        block()
    }
}

fun main() {
    onlyIf(true) {
        println("hello")
    }

    /**
     * 函数是“一等公民”
     *
     * 在 Kotlin 中函数是“一等公民”，可以直接使用对象加两个冒号（::）进行分割，后面紧跟着方法名，使用这种方式来引用一个函数声明，而不是像一个对象一样使用 . 来执行函数。可以通过示例体会一下
     * 【注】在高阶函数的参数中要想作为参数传递给高阶函数时，必须传的是函数的声明，如果传的是直接执行一个函数的话，那么实际上传递的是函数的返回值！
     */
    val runnable = Runnable {
        println("run")
    }
    onlyIf(true, runnable::run)

    onlyIfInline(true) {
        println("hello")
    }
}