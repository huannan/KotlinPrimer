package com.nan.kotlinprimer.day17_generics

import android.widget.Button
import android.widget.TextView

/**
 * 泛型
 * 泛型的意思是把具体的类型泛化，编码的时候用符号来指代类型，在使用的时候，再确定它的类型
 *
 * 使用关键字 out 来支持协变，等同于 Java 中的上界通配符 ? extends。
 * 使用关键字 in 来支持逆变，等同于 Java 中的下界通配符 ? super。
 * out 表示，我这个变量或者参数只用来输出，不用来输入，你只能读我不能写我；in 就反过来，表示它只用来输入，不用来输出，你只能写我不能读我。
 */
fun main() {
    val producer: Producer<out TextView> = Producer()
    val produce: TextView? = producer.produce()

    val consumer: Consumer<in Button> = Consumer()
    consumer.consume(Button(null))
}

class Producer<T> {
    fun produce(): T? {
        return null
    }
}

class Consumer<T> {
    fun consume(t: T) {

    }
}

/**
 * where关键字
 */
open class Human
interface Animal

class Monster<T> where T : Human, T : Animal {

}

inline fun <reified T> printIfTypeMatch(item: Any) {
    if (item is T) {
        println("true")
    }
}