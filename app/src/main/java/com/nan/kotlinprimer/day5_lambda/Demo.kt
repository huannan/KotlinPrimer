package com.nan.kotlinprimer.day5_lambda

fun main() {
    // Kotlin 的 Lambda 形式（Unit可以省略）
    Thread({ ->
        Unit
        println("hello")
    }).start()

    // 如果你的 Lambda 是没有参数的，你是可以省略 -> 符号的
    Thread({
        println("hello")
    }).start()

    // 如果 Lambda 是函数的最后一个参数，可以将大括号放在小括号外面
    Thread() {
        println("hello")
    }.start()

    // 如果函数只有一个参数且这个参数是 Lambda，可以省略小括号
    Thread {
        println("hello")
    }.start()

    // Lambda 闭包声明
    // 首先给闭包声明一个变量名，同时用闭包声明给它赋值，闭包也是可以有参数的，参数声明与变量声明基本相同，变量名: 变量类型 -> Lambda 闭包体
    // Lambda 闭包原理
    // 我们所写的闭包被转换成了 Function1 的类，实际上 Function1 是 Kotlin 标准库中的接口
    val echo = { name: String ->
        println(name)
    }
    // 通过示例可以看出，闭包调用分为两种形式，一种是直接使用小括号添加参数调用，另外一种方式是调用它的 invoke 方法
    echo("小楠总")
    echo.invoke("小楠总")
}