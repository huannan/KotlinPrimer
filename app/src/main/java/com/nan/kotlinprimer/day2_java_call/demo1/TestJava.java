package com.nan.kotlinprimer.day2_java_call.demo1;

public class TestJava {

    public static void main(String[] args) {
        // Kotlin 文件中的函数编译后直接转换为对应文件名 + Kt 类中以 public static 开头的方法
        // 修改生成的类名可以通过
        // DemoKt.testJavaCall();
        HelloWorld.testJavaCall();

        // 如果在 Java 代码调用，需要使用以下方法
        Utils.INSTANCE.sayHello();

        // Java调用Kotlin真正的静态方法
        Utils.sayHelloStatic();
    }

}
