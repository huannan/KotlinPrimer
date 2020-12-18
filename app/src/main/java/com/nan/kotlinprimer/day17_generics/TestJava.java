package com.nan.kotlinprimer.day17_generics;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestJava {
    public void test1() {
        // 多态
        TextView textView = new Button(null);

        List<Button> buttons1 = new ArrayList<>();
        // 报错，因为Java 的泛型本身具有「不可变性 Invariance」
        // List<TextView> textViews = buttons;

        // 数组可以
        TextView[] textViewArrays = new Button[]{};

        // 这个 ? extends 叫做「上界通配符」，可以使 Java 泛型具有「协变性 Covariance」，协变就是允许这种赋值是合法的。
        List<? extends TextView> textViews1 = buttons1;
    }

    /**
     * 协变
     */
    public void test2() {
        List<? extends TextView> textViews = new ArrayList<>();
        // 由于它满足 ? extends TextView 的限制条件，所以 get 出来的对象，肯定是 TextView 的子类型，根据多态的特性，能够赋值给 TextView，啰嗦一句，赋值给 View 也是没问题的。
        TextView textView = textViews.get(0);
        // List<? extends TextView> 由于类型未知，它可能是 List<Button>，也可能是 List<TextView>。
        // 对于前者，显然我们要添加 TextView 是不可以的。
        // 实际情况是编译器无法确定到底属于哪一种，无法继续执行下去，就报错了。
        // 由于 add 的这个限制，使用了 ? extends 泛型通配符的 List，只能够向外提供数据被消费，从这个角度来讲，向外提供数据的一方称为「生产者 Producer」
        // textViews.add(textView);
    }

    /**
     * 逆协变
     */
    public void test3() {
        List<? super Button> buttons = new ArrayList<>();
        Object object = buttons.get(0);
        Button button = new Button(null);
        // 使用下界通配符 ? super 的泛型 List，只能读取到 Object 对象，一般没有什么实际的使用场景，通常也只拿它来添加数据，也就是消费已有的 List<? super Button>，往里面添加 Button，因此这种泛型类型声明称之为「消费者 Consumer」。
        buttons.add(button);
    }
}
