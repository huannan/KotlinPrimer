package com.nan.kotlinprimer.day13_backquote

/**
 * Kotlin 中的反引号
 *
 * 应用场景: 如果你确定你的类是不希望被 Java 访问到的话，就可以在类名上做一些特殊不合法的字符，这样的话就可以只在 Kotlin 中访问而不能被 Java 访问。
 */
fun main() {
    // 可以解决关键字冲突的问题
    println(TestJava.`in`)

    // 可以强行将一个不合法的字符变为合法
    fun `1234`() {
        println("1234")
    }
    `1234`()
}