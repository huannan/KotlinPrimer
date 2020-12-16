package com.nan.kotlinprimer.day2_java_call.demo2

import kotlin.reflect.KClass

class TestKotlinClass {

}

/**
 *  Class 和 KClass
 *
 *  Kotlin 的 class 和 Java 的 class 格式是不一致的。
 *  Kotlin 中，所有的类并不是编译成 Class，而是编译成 KClass
 */
fun main() {
    // 使用Java的class
    testJavaClass(TestJava::class.java)

    // 使用Kotlin的class
    testKotlinClass(TestKotlinClass::class)
}

fun testJavaClass(clazz: Class<TestJava>) {
    println()
}

fun testKotlinClass(clazz: KClass<TestKotlinClass>) {
    println()
}