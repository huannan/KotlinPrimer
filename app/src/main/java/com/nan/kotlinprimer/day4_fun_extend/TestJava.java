package com.nan.kotlinprimer.day4_fun_extend;

public class TestJava {
    public static void main(String[] args) {
        User user = new User("小楠总");
        // 其次我们需要注意是，这个扩展函数并不是这个类本身的函数，而是我们扩展出来的，它在编译的时候会被编译到那个类所对应的 class 中去。
        // 所以在 Java 中我们实际上是调用 FileKt 这个类中的扩展方法，另外还需要一点注意的是，扩展函数的第一个参数是需要扩展的类的对象
        DemoKt.sayHello(user);
    }
}
