package com.nan.kotlinprimer.day4_fun_extend

class User(var name: String)

/**
 * 扩展函数
 *
 * 首先扩展函数也是一个函数，所以也需要 fun 关键字进行声明，后面紧跟着的是你需要扩展的类的类名
 * 比如示例中是给 User 类扩展一个成员方法，之后是一个 . 它用来分割类名和函数名，后面紧跟着的是扩展函数名，后面则与普通函数声明无异，参数、返回值以及函数体。
 *
 * 扩展函数的主要用途是对一些第三方 SDK，或者说那个类是你不能控制的，你要想给它新增些你需要用到的方法时会用到的函数
 */
fun User.sayHello() {
    println(this.name)
}

open class Animal
class Dog : Animal()

fun Animal.getName() = "Animal"
fun Dog.getName() = "Dog"

fun Animal.sayHello(animal: Animal) {
    println(animal.getName())
}

fun main() {
    val user = User("小楠总")
    // 在 Kotlin 中，可以直接在类的对象上面调用这个扩展函数
    user.sayHello()

    // 扩展函数的静态解析
    // 扩展函数需要大家注意的一点就是，它是静态的给一个类添加成员变量和成员方法
    // Kotlin 的扩展函数实际上是静态的给一个类添加的方法，它是不具备运行时的多态效应的
    // 实际上会被强转成Animal：sayHello((Animal)(new Dog()), (Animal)(new Dog()));
    Dog().sayHello(Dog())
}