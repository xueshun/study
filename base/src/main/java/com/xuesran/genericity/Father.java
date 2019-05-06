package com.xuesran.genericity;

/**
 * <pre>类名: Inherit</pre>
 * <pre>描述: 泛型继承</pre>
 * <pre>日期: 2019/5/6 14:36</pre>
 * <pre>作者: xueshun</pre>
 */
public abstract class Father<T1, T2> {
    T1 age;

    public abstract void test(T2 name);
}

/**
 * 保留父类泛型（全部保留）
 */
class Son1 extends Father<T1, T2> {
    @Override
    public void test(T2 name) {

    }
}

/**
 * 部分保留
 */
class Son2 extends Father<T1, Integer> {

    @Override
    public void test(Integer name) {

    }
}

/**
 * 不保留
 */
class Son3 extends Father<String, Integer> {

    @Override
    public void test(Integer name) {

    }
}

class Son4 extends Father {

    @Override
    public void test(Object name) {

    }
}



