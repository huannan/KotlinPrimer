package com.nan.kotlinprimer.day11_operator

import com.nan.kotlinprimer.day9_destructuring.User

/**
 * 集合操作符
 *
 * 原理：其实 Kotlin 的所有操作符都是一个 inline 的扩展函数来实现的。
 */
fun testOperator() {
    val a = arrayOf("4", "0", "7", "i", "f", "w", "0", "9")
    val index = arrayOf(5, 3, 9, 4, 8, 3, 1, 9, 2, 1, 7)

    index
        .filter {
            it < a.size
        }
        .map {
            a[it]
        }
        .reduce { s, s1 ->
            "$s$s1"
        }
        .also {
            println("密码是：$it")
        }
}

/**
 * 自定义集合操作符
 *
 * 比如这里我们定一个 convert，它的功能实际上跟 map 的功能是一致的，将我们输入的参数转换成另外一种类型的数据输出，它扩展的是一个迭代器，也就是说我们所有的集合都可以使用这个扩展函数
 */
inline fun <T, R> Iterable<T>.convert(action: (T) -> R): MutableList<R> {
    val list = mutableListOf<R>()
    for (item in this) {
        list.add(action(item))
    }
    return list
}

fun testCustomOperator() {
    val list = listOf(1, 2, 3)
    list.convert {
        it + 1
    }.forEach {
        println(it)
    }
}

/**
 * 作用域函数
 *
 *  作用域函数是 Kotlin 内置的可以对数据做一系列变换的函数。
 * 它们与集合的操作符非常的相似，但是集合的操作符只能用于集合的数据变换，而作用域函数可以应用于所有对象，它可以对所有对象做一系列的操作。
 */
fun testScopeFun() {
    val user = User("小楠总", 20)

    /**
     * let 与 run
     *
     * let 与 run 都会返回闭包的执行结果
     * 区别在于 let 有闭包参数，而 run 没有闭包参数，其中 run 可以通过 this 来获取是谁来调用 run 的，也就是说 this 指代了外层的调用对象。这是他们的唯一区别。
     */
    user.let {
        println(it.name)
    }
    user.run {
        println(this.name)
    }

    /**
     * also 与 apply
     *
     * also 与 apply 都不返回闭包的执行结果，与上面类似，区别在于 also 有闭包参数，而 apply 没有闭包参数。
     * 打开该作用域函数的声明发现，其实这个作用域函数是对泛型 T 做的扩展函数，对于 also/apply 返回的都是它本身。也就是说，我们可以连续的去调用这个作用域函数，适合链式操作某个对象
     */
    user.also {
        println(it.name)
    }
    user.apply {
        println(this.name)
    }

    /**
     * takeIf 与 takeUnless
     *
     * takeIf 与 takeUnless 主要是用于判断。
     * 我们看下 takeIf 作用域函数，发现闭包只能返回一个 Boolean 类型的值，并且会根据你传入的 Lambda 表达式的执行结果来做判断，如果执行结果为 true 则返回当前对象，否则会返回 null，这也就是为什么 takeIf 的返回值为 T? 。
     * 通常在使用时，在闭包后面使用 ?. 继续执行该对象不为空时的代码，后面通过 ?: 执行该对象为空时的代码
     * takeUnless 则与 takeIf 完全相反，如果 Lambda 表达式执行结果为 false 返回当前对象，否则返回 null
     */
    user.takeIf {
        it.name.length > 0
    }?.also {
        println(it.name)
    } ?: println("空")
    user.takeUnless {
        it.name.length < 0
    }?.also {
        println(it.name)
    } ?: println("空")

    /**
     * repeat
     *
     * 这个函数在之前已经提到过，其实是对 for-in 形式的循环做的封装
     */
    repeat(3) {
        println("test")
    }

    /**
     * with
     *
     * 查看 with 函数发现与其他作用域函数不同，它不是扩展函数，而是一个顶级的函数，传入参数 receiver 和 闭包 block，返回 receiver 执行闭包的结果，返回值类型为泛型 R。
     * with 一般用于对某个对象的整体赋值，这点在 Android 开发中尤其突出，例如对某个 View 属性的整体赋值，可以使用 with。
     */
    with(user) {
        this.name = "楠总"
        this.age = 20
    }
}

/**
 * 为了方便理解，我们把作用域函数和集合操作符统称为 Kotlin 的操作符
 * 作用域函数与集合操作符的原理是完全一致的，基本上不管是作用域函数还是之前提到的集合操作符，它的本质都是扩展函数，或者类似于扩展函数的形式为我们的代码进行一系列的扩展操作。
 */
fun main() {
    testOperator()
    testCustomOperator()
    testScopeFun()
}