package com.nan.kotlinprimer.day8_by

interface Bank {
    fun apply1()
    fun apply2()
}

class BankWorker : Bank {
    override fun apply1() {
        println("办卡1")
    }

    override fun apply2() {
        println("办卡2")
    }
}

/**
 * Kotlin 中的动态代理
 *
 * Kotlin 在语言层面已经原生支持了动态代理，只需要一个 by 关键字就可以实现，通过示例了解下。
 *
 * 需要注意的是，代理类中实现了被代理接口的方法，代理对象调用时实际执行的就是代理对象的所实现的方法。
 * 如果代理类中实现了被代理接口的方法，则可以加上一些类似埋点的代码
 *
 * 注：实际上，Kotlin 会将动态代理在编译以后转换为静态代理去调用，而 Java 的动态代理本质上是通过反射去调用的，所以 Kotlin 的动态代理一定要比 Java 的动态代理效率高。
 */
class BankWorkerProxy(private val bank: Bank) : Bank by bank {

    override fun apply2() {
        println("埋点开始")
        bank.apply2()
        println("埋点结束")
    }

}

fun main() {
    val proxy = BankWorkerProxy(BankWorker())
    proxy.apply1()
    proxy.apply2()
}