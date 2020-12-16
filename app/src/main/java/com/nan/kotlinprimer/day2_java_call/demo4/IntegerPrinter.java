package com.nan.kotlinprimer.day2_java_call.demo4;

public class IntegerPrinter implements IIntegerPrinter {

    @Override
    public void printNum(int num) {
        System.out.println("printNum unbox num=" + num);
    }

    @Override
    public void printNum(Integer num) {
        System.out.println("printNum box num=" + num);
    }

}
