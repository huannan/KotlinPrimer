package com.nan.kotlinprimer.day8_by

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Demo2 {

    /**
     * 通用的属性操作，我们可以通过委托的⽅式，让它只实现⼀次
     * Kotlin官方还提供了lazy等方式供我们使用
     */
    var token1: String by TestProxy("key1")
    var token2: String by TestProxy("key2")

    class TestProxy(private val key: String) : ReadWriteProperty<Demo2, String> {
        override fun setValue(thisRef: Demo2, property: KProperty<*>, token: String) {
            TokenHelper.saveToken(key, token)
        }

        override fun getValue(thisRef: Demo2, property: KProperty<*>): String {
            return TokenHelper.getToken(key)
        }

    }

    object TokenHelper {
        private val tokenMap = mutableMapOf<String, String>()

        fun saveToken(key: String, token: String) {
            tokenMap[key] = token
        }

        fun getToken(key: String): String {
            return tokenMap[key] ?: ""
        }
    }
}

interface TestAbstractProperty {
    /**
     * 抽象属性
     * 在 Kotlin 中，我们可以声明抽象属性，⼦类对抽象属性重写的时候需要重写对应的setter/getter
     */
    var property: String
}

class TestAbstractPropertyImpl : TestAbstractProperty {
    override var property: String
        get() = TODO("Not yet implemented")
        set(value) {}
}

fun main() {
    val demo = Demo2()
    demo.token1 = "haha"
    print(demo.token1)
}