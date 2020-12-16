package com.nan.kotlinprimer.day10_loop

/**
 * Kotlin 的循环语法
 * 原理：运算符重载、中缀表达式
 */
fun main() {
    /**
     * 第一种，其中声明一个 i 用于迭代，之后 1..10 表示的是从 1 到 10 的闭区间（1 <= x <=10)
     */
    for (i in 1..10) {
        println(i)
    }
    println("---------------")

    /**
     * 当我们把循环 1 到 10 改成 10 到 1 时，发现编译器发出警告，说我们的区间是空的，你的意思是不是使用 downTo 关键字。这就说明，关键字 .. 只能用递增的循环，如果使用递减的循环应使用  downTo
     */
    for (i in 10..1) {
        println(i)
    }
    println("---------------")

    /**
     * 第二种，1 until 10 表示的是从 1 到 10 的半开区间（1 <= x < 10)
     */
    for (i in 1 until 10) {
        println(i)
    }
    println("---------------")

    /**
     * 第三种，上面已经提到，10 downTo 1 表示遍历从 10 到 1 的闭区间（10 <= x <= 1)
     */
    for (i in 10 downTo 1) {
        println(i)
    }
    println("---------------")

    /**
     * 第四种，带有步长 step 的循环，相当于 Java for 循环中的 count += 2。
     */
    for (i in 1..10 step 2) {
        println(i)
    }
    println("---------------")

    /**
     * 第五种，Kotlin 提供了海量的扩展函数，其中有一个扩展函数 repeat 可以用来循环
     */
    repeat(10) {
        println(it)
    }
    println("---------------")

    /**
     * 我们知道循环大多数用于集合，针对集合 for-in 形式的循环可直接把 list 中的元素取出
     */
    val list = arrayListOf("a", "b", "c", "d")
    for (str in list) {
        println(str)
    }
    println("---------------")

    /**
     * 特别的，Kotlin 还允许我们使用解构的形式来获取对应的 index 和 value
     */
    for ((index, str) in list.withIndex()) {
        println("第${index}个元素是$str")
    }
    println("---------------")

    /**
     * 需要注意的是，如果我们使用的是 map 的话是可以直接使用解构的
     * 解构的应用场景
     * 例如，声明一个 Map 对象，关键字 to 的左侧表示 key，右侧表示对应的 value，在遍历时可以直接使用解构将Pair里面的 key 和 value 取出，非常方便
     */
    val map = mapOf("k1" to "v1", "k2" to "v2")
    for ((key, value) in map) {
        println("$key->$value")
    }
    println("---------------")
}