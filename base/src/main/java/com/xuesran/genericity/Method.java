package com.xuesran.genericity;

import java.io.Closeable;
import java.util.List;

/**
 * <pre>类名: Method</pre>
 * <pre>描述: 非泛型类中定义泛型方法</pre>
 * <pre>日期: 2019/5/6 14:28</pre>
 * <pre>作者: xueshun</pre>
 */
public class Method {

    /**
     * 泛型方法，在返回类型前面使用泛型字母
     *
     * @param t
     * @param <T>
     */
    public static <T> void test1(T t) {
        System.out.println(t);
    }

    /**
     * T 只能是List或者是List的子类
     *
     * @param t
     * @param <T>
     */
    public static <T extends List> void test2(T t) {
        t.add("aa");
    }

    /**
     * T... 可变参数 -> T[]
     *
     * @param a
     * @param <T>
     */
    public static <T extends Closeable> void tests(T... a) {

    }

}
