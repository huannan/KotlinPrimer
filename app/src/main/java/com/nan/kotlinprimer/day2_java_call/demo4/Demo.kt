package com.nan.kotlinprimer.day2_java_call.demo4

/**
 * Kotlin 在语言层面简化了 Java 中的 int 和 Integer
 *
 * 但是我们对是否装箱的场景还是要有一个概念，因为这个牵涉到程序运行时的性能开销。因此在日常的使用中，对于 Int 这样的基本类型，尽量用不可空变量。
 * 简单来说，原先在 Java 里的基本类型，类比到 Kotlin 里面，条件满足如下之一就不装箱：不可空类型、使用 IntArray、FloatArray 等
 */
fun main() {
    // 你会发现只调用了 int 参数的方法，通过这个示例可以看出来 Kotlin 是没有装箱类的概念的
    val printInteger = IntegerPrinter()
    printInteger.printNum(10)

    // 可空类型，实质上是装箱类
    var num: Int? = 10
    printInteger.printNum(num)

    // 这里也不是装箱
    var array: IntArray = intArrayOf(1, 2)
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