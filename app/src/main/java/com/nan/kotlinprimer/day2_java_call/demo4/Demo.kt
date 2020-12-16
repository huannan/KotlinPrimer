package com.nan.kotlinprimer.day2_java_call.demo4

/**
 * Kotlin 没有装箱类
 */
fun main() {
    // 你会发现只调用了 int 参数的方法，通过这个示例可以看出来 Kotlin 是没有装箱类的概念的
    val printInteger = IntegerPrinter()
    printInteger.printNum(10)
}

/**
 * 为了进一步说明，我们让 Kotlin 的类来实现这个接口
 */
class IntegerPrinterKt : IIntegerPrinter {

    /**
     * Kotlin中没有装箱类，只实现其中一个即可
     */
    override fun printNum(num: Int) {

    }
}