package com.nan.kotlinprimer.day12_operator

/**
 * 运算符重载
 *
 * 在 Kotlin 中有非常多的运算符是通过重载来完成的，例如用于 String 拼接的 +，for 循环中的 ..
 * 运算符的重载有个特点，它一定是提前在 Kotlin 中定义好的运算符，不能凭空去重载一个运算符，所以这就有个限制，运算符的数量是有上限的，解决方案是中缀表达式。
 */
fun test1() {
    /**
     * .. 是通过运算符重载完成。step 是通过中缀来实现的
     * .. 的具体实现是public operator fun rangeTo(other: Int): IntRange{...}
     * operator 在解构一节有过描述：operator 表示将一个函数标记为重载一个操作符或者实现一个约定。 这里就表示标记这个函数为重载一个操作符。
     */
    for (i in 1..5 step 2) {
        println("$i")
    }
}

/**
 * 中缀表达式
 *
 * 我们知道运算符的数量是有上限的，虽然跟随 Kotlin 版本迭代会有相应的变化但是对开发者而言还是固定的，因此当运算符不够的时候我就需要通过中缀表达式的形式去扩展我们所需要的逻辑。
 * step 的具体实现是public infix fun IntProgression.step(step: Int): IntProgression{...}
 * 在 Kotlin 中通过 infix 关键字修饰一个函数就表示这个函数是允许使用中缀的形式去调用。
 */
fun test2() {
    for (i in 1..5 step 2) {
        println("$i")
    }
}

/**
 * 自定义中缀表达式
 *
 * 写一个中缀表达式，根据当前值（this）与输入值（入参）进行比较判断大小并返回对应的密闭类
 */
infix fun Int.vs(num: Int) =
    when {
        this - num > 0 -> CompareResult.MORE
        this - num < 0 -> CompareResult.LESS
        else -> CompareResult.EQUAL
    }

fun test3() {
    println(7 vs 6)
    println(7 vs 8)
    println(7 vs 7)
    // 特别的，infix 只是表示允许该函数使用中缀形式去调用，所以也可以使用扩展函数的形式调用
    println(7.vs(7))
}

sealed class CompareResult {
    object LESS : CompareResult() {
        override fun toString(): String {
            return "小于"
        }
    }

    object MORE : CompareResult() {
        override fun toString(): String {
            return "大于"
        }
    }

    object EQUAL : CompareResult() {
        override fun toString(): String {
            return "等于"
        }
    }
}

fun main() {
    test1()
    test2()
    test3()
}