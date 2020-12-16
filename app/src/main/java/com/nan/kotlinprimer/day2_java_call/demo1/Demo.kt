// 可以通过这个注解修改Kotlin编译器默认生成的文件名 + Kt，实现自定义命名
@file:JvmName("HelloWorld")

package com.nan.kotlinprimer.day2_java_call.demo1

/**
 * Kotlin 文件中的函数
 *
 * Kotlin 的代码编译以后依旧是 JVM 平台的一个 class
 */
fun testJavaCall() {
    println("call from java")
}

/**
 * object 关键字
 *
 * Kotlin 中特殊的语法，object + 类声明，这种写法是在 Kotlin 中创建一个内部所有方法和变量都是类似静态的类的写法
 * 其实构造方法变成了私有方法，暴露了一个静态的当前实例 INSTANCE， object 关键字的类其实是 Kotlin 单例的一种写法
 */
object Utils {

    /**
     * 由于 Kotlin 中没有静态变量和静态方法，我们可以通过上一节中提到的 object 关键字声明的类来间接实现类似 Java 中的静态方法。
     */
    fun sayHello() {
        println("Hello1")
    }

    /**
     * 如果让其变成真正的静态方法，可以通过使用 @JvmStatic 注解使其变成 Java 的静态方法，这时就可以方便在 Java 类中调用。
     */
    @JvmStatic
    fun sayHelloStatic() {
        println("Hello2")
    }
}

fun main() {
    // 如果在 Kotlin 代码中则可以直接调用
    Utils.sayHello()
}
