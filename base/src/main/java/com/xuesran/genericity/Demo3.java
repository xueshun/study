package com.xuesran.genericity;

import com.sun.corba.se.impl.ior.FreezableList;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>类名: Demo3</pre>
 * <pre>描述: 上下限</pre>
 * <pre>日期: 2019/5/6 15:13</pre>
 * <pre>作者: xueshun</pre>
 */
public class Demo3<T extends Fruit> {

    private static void test1() {
        Demo3<Fruit> t1 = new Demo3<>();
        Demo3<Apple> t2 = new Demo3<>();
        Demo3<Pear> t3 = new Demo3<>();
    }

    /**
     * 上限
     *
     * @param list
     */
    private static void test2(List<? extends Fruit> list) {

    }

    /**
     * 下限
     *
     * @param list
     */
    private static void test3(List<? super Apple> list) {

    }

    public static void main(String[] args) {
        test2(new ArrayList<Fruit>());
        test2(new ArrayList<Apple>());
        test2(new ArrayList<Pear>());

        test3(new ArrayList<Apple>());
        test3(new ArrayList<Fruit>());
    }
}

class Fruit {

}

class Apple extends Fruit {

}

class Pear extends Fruit {

}

class ReadApple extends Fruit {

}