package com.nan.kotlinprimer.day7_class_basic

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nan.kotlinprimer.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 类的声明
 *
 * 与 Java 类似，同样使用 class 关键字来声明一个类，后面紧跟着类名，如果该类有父类的话使用 : 分割，如果该类需要实现接口，则直接使用 , 跟在后面即可，而不是用 implement 关键字。接口和父类没有先后顺序。
 * 特别地，Kotlin 中如果没有显式的声明一个父类，那么它的父类为 Any，而不是 Object。
 * Kotlin 会对所有的类默认添加 public final 修饰符，如果不需要 final 来修饰的话，则需要使用 open 关键字修饰 Kotlin 的类， open 就表示这个类“不 final”。
 */
open abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }

}

/**
 * 构造函数
 *
 * 在 Kotlin 中分为主构造函数和次级构造函数，其中主构造函数只能有一个，次构造函数可以有多个。
 * 如果构造函数只有一个且没有参数，则可以直接省略不写，如上面的示例中 BaseActivity 省略了无参构造函数，父类后面的括号表示调用父类无参数的构造函数。
 * 如果构造函数需要参数，则可以在类名后添加参数，如果需要在构造函数中执行语句的话，则需要添加 init 代码块，将语句写在代码块中，像这种直接跟在类名后面的构造函数就称之为主构造函数。（init 代码块是可以写多个的）。
 * 通过示例我们就可以看出，init 代码块执行顺序受声明的顺序影响，且优先于次级构造函数。Kotlin 的 init 代码块和 Java 一样，都在实例化时执行，并且执行顺序都在构造器之前。
 *
 * 总体顺序：主-init-次
 *
 * 主构造函数中，加上var/val可以定义属性；次级构造函数中则不可以
 */
class Person1 constructor(val name: String) {

    constructor(age: Int) : this("哈哈") {
        println("constructor")
    }

    init {
        println("hello1$name")
    }

    init {
        println("hello2$name")
    }
}

/**
 * 如果需要多个构造函数，则可以使用 constructor 关键字声明次级构造函数，特别地，如果声明了次级构造函数，主构造函数的无参隐藏的特性就会失效。例如示例中的类，就没有无参构造函数。
 */
class Person2 {
    constructor(name: String) : this(name, 18) {
        println("constructor1")
    }

    constructor(name: String, age: Int) {
        println("constructor2")
    }
}

/**
 * 如果主构造函数和次级构造函数都存在时，次级构造函数要使用 this 关键字调用主构造函数
 * 注：这个编译器会提示
 *
 * 访问修饰符
 *
 * 在 Kotlin 中有四种访问符：public/protected/private/internal
 * public 具有最大的访问权限，可以访问任意路径的类、接口、成员变量；
 * protected 表示子类可以访问它修饰的父类成员变量；
 * private 表示访问权限仅限于类的内部；
 * internal 是 Kotlin 特有的访问修饰符，表示一个模块内都能访问到这个对象。internal 修饰符更多用于项目中的结构化扩展以及模块化等场景
 */
class Person3 private constructor(var name: String) {
    constructor(age: Int) : this("") {

    }
}

/**
 * 属性的 getter/setter 函数
 *
 * 关于「钩子」的作用，除了修改取值和赋值，也可以加一些自己的逻辑，
 */
class Person4 {
    val name: String = ""
        /**
         * val 所声明的只读变量，在取值的时候仍然可能被修改，这也是和 Java 里的 final 的不同之处。大部分情况下 val 还是对应于 Java 中的 final 使用的
         */
        get() {
            return "我的名字是$field"
        }

    var age: Int = 0
        get() {
            return field
        }
        set(value) {
            field = value
        }
}

/**
 * 伴生对象
 *
 * object声明的东西都是类似静态的，如果一个类中你只想让它一部分是类似静态的，那么就要使用companion object
 *
 * 类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，我们就可以直接通过外部类访问到对象的内部元素。
 * 伴生对象一定要写在一个类的内部，作为这个类的一个伴生对象存在，伴生对象使用 companion object 两个关键字来声明。在 Kotlin 中就可以像 Java 调用静态方法一样，直接使用 类名.方法名 来使用。
 * 而在 Java  中则需要通过静态变量 Companion 来调用，实际上，这个 Companion 是编译器帮我们生成的一个对象，用来访问内部的方法和变量。
 *
 * 如果想写工具类的功能，直接创建文件，写 top-level「顶层」函数。
 * 如果需要继承别的类或者实现接口，就用 object 或 companion object。
 */
class StringUtils {
    companion object {
        init {
            // 静态域初始化
        }

        fun isEmpty(string: String): Boolean {
            return string.length == 0
        }
    }
}

/**
 * 单例写法
 *
 * 使用伴生对象和 object 关键字结合的方式
 *
 * 注：
 * 1. Kotlin 用对象表达式和对象声明来实现创建一个对某个类做了轻微改动的类的对象，且不需要去声明一个新的子类。类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，我们就可以直接通过外部类访问到对象的内部元素。
 * 2. 一般情况下在匿名内部类或者单例模式的时候使用object，而companion object一般用来声明静态域
 * 3. object的意思很直接：创建一个类，并且创建一个这个类的对象。这个就是 object 的意思：对象。
 * 4. 用 object 修饰的对象中的变量和函数都是静态的，但有时候，我们只想让类中的一部分函数和变量是静态的该怎么做呢？用companion object。companion 可以理解为伴随、伴生，表示修饰的对象和外部类绑定。这样的好处是调用的时候可以省掉对象名
 */
class Single private constructor() {

    fun sayHello() {
        println("hello")
    }

    companion object {
        fun getInstance(): Single {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = Single()
    }

}

/**
 * Kotlin 中声明常量（编译时常量）
 * Kotlin 的常量必须声明在对象（包括伴生对象）或者「top-level 顶层」中，因为常量是静态的
 * Kotlin 新增了修饰常量的 const 关键字
 * Kotlin 中只有基本类型和 String 类型可以声明成常量
 */
class Sample {
    companion object {
        const val CONST_NUMBER = 1
    }
}

/**
 * 数据类
 *
 * 数据类是 Kotlin 中很特殊的一种类，它可以将我们类中的成员变量自动的生成 getter/setter 方法，以及我们经常需要重写的 toString()、hashCode()、equals()、copy() 方法，而不需要像 Java Bean 一样需要我们手动去重写这些方法。
 * 数据类的声明只需要在类的前面添加 data 关键字。需要注意一点的是，数据类是 final 类型的，不能添加 open 关键字去修饰它！
 */
data class User(val name: String, var age: Int)

/**
 * 枚举类
 *
 * Kotlin 中也有枚举类，它的枚举类与 Java 中的使用是一致的
 * 但是在 Kotlin 中我们很少使用枚举类，而是使用它更加强大的“枚举类”，称之为密闭类。
 */
enum class Command {
    A, B, C, D
}

fun execute(command: Command) {
    when (command) {
        Command.A -> {
            println("A")
        }
        Command.B -> {
            println("B")
        }
        Command.C -> {
            println("C")
        }
        Command.D -> {
            println("D")
        }
    }
}

/**
 * 密闭类
 *
 * 使用 sealed 关键字修饰一个类即可，另外密闭类是可以有子类的，但是密闭类的子类必须和密闭类写在同一个文件中，所以通常会把密闭类的子类写在类本身里面。
 * 它的用法也与枚举类的用法一致，示例如下
 */
sealed class SuperCommand {
    object A : SuperCommand()
    object B : SuperCommand()
    object C : SuperCommand()
    object D : SuperCommand()

    /**
     * 密闭类最大一个特性在于它是可以有扩展它的子类的，并且它的子类也可以成为密闭类的一个选项
     */
    class E(var name: String) : SuperCommand()
}

fun execute(command: SuperCommand) {
    when (command) {
        SuperCommand.A -> {
            println("A")
        }
        SuperCommand.B -> {
            println("B")
        }
        SuperCommand.C -> {
            println("C")
        }
        SuperCommand.D -> {
            println("D")
        }
        is SuperCommand.E -> {
            println("E")
        }
    }
}

fun main() {
    Person1(10)
    Person2("小楠总")

    StringUtils.isEmpty("")

    Single.getInstance().sayHello()

    /**
     * 类型判断与转型
     */
    val activity: Activity = AppCompatActivity()
    if (activity is AppCompatActivity) {
        activity.setSupportActionBar(null)
    }
    (activity as AppCompatActivity).setSupportActionBar(null)
    (activity as? AppCompatActivity)?.setSupportActionBar(null)
}