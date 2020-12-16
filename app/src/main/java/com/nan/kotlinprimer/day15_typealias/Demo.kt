package com.nan.kotlinprimer.day15_typealias

import java.io.File

/**
 * Kotlin 中类型映射
 *
 * Kotlin 中有一个比较有意思的关键字：typealias，有点类似于 C/C++ 代码中的 define，可以将一个类映射到另一类上，但是不同的是 C/C++ define 是宏定义会在编译时转换成对应的类，而 Kotlin 中的 typealias 则表示两个类是完全一致的。
 * 其实 typealias 关键字相当于给一个类起一个别名。在写代码时，不管是写原始类还是映射类，都是可以的。
 *
 * 为什么要这么做呢？为了跨平台
 * 在 Kotlin 中，非常多的对象都是通过 typealias 来映射过来的，例如 HashMap 对象，就是通过 typealias 直接映射了 Java 的 HashMap。
 * public actual typealias HashMap<K, V> = java.util.HashMap<K, V>
 * 如果将来 Kotlin 对 HashMap 做一些特性优化的时候，就可以直接在 Kotlin 中优化而不需要去兼容 Java 的 HashMap。
 * 也可以做一些特性的定制，或者说跨平台的定制，我们知道 Kotlin 是不光运行在 JVM 平台的，也可以其他的非 JVM 平台，这样的话，可以直接修改映射的类做到跨平台的支持。
 */
public typealias KFile = File

fun main() {
    val kFile: KFile = File("")
}