package com.nan.kotlinprimer.day2_java_call.demo5


/**
 * Kotlin 空值敏感
 *
 * 总结：当我们调用 Java 的方法返回类对象的时候，如果你不确定返回值是否可能为空，你一定要赋值给一个可空类型，这样才能利用 Kotlin 的空安全！
 */
fun main() {
    // 首先看第一种编译器推断类型的方式，当我们使用编译器查看类型时你会发现它返回的是 String! 的类型，这种类型我们不能直接声明，这是 Kotlin 与 Java 互调时的一种特有的类型，也可以说成是 Java 的 String 类型
    val format1 = TestJava.format("")
    // 这个位置报错，说明为空的值给不可为空的 String 类型赋值会报错！
    val format2: String = TestJava.format("")
    // format3不会报错，这就是 Kotlin 的空安全
    val format3: String? = TestJava.format("")
}