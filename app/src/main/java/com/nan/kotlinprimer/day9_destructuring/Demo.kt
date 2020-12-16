package com.nan.kotlinprimer.day9_destructuring

/**
 * 解构
 *
 * 在 Kotlin 中允许直接将一个类拆解之后并分别赋值，就像示例中的 User 对象一样，可以赋值给一个拆解开的 age 和 name 变量。
 *
 * 解构的格式固定，val/var 括号后的第一个值与 User 类中的 component1 方法对应，相应的第二个值与 component2 方法对应，且都需要使用 operator 关键字修饰。当然完全可以再声明一个 component3，与 User 对象的变量个数无关
 */
class User(var name: String, var age: Int) {
    // operator 表示将一个函数标记为重载一个操作符或者实现一个约定。
    operator fun component1() = name
    operator fun component2() = age
    operator fun component3() = "我叫${name}，今年${age}岁"
}

/**
 * 特别的，对于数据类，也就是之前提到的以 data 关键字修饰的类，会默认为每个字段生成 componentX 方法。
 */
data class User1(val name: String, var age: Int)

fun main() {
    val (name, age, desc) = User("小楠总", 20)
    println(name)
    println(age)
    println(desc)

    val (name1, age1) = User1("小楠总", 20)

    /**
     * 解构的应用场景
     * 例如，声明一个 Map 对象，关键字 to 的左侧表示 key，右侧表示对应的 value，在遍历时可以直接使用解构将Pair里面的 key 和 value 取出，非常方便
     */
    val map = mapOf("k1" to "v1", "k2" to "v2")
    for ((key, value) in map) {
        println("$key->$value")
    }
}