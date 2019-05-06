package com.xuesran.genericity;

/**
 * <pre>类名: Comparator</pre>
 * <pre>描述: 自定义泛型接口</pre>
 * <pre>日期: 2019/5/6 14:27</pre>
 * <pre>作者: xueshun</pre>
 */
public interface Comparator<T1, T2> {

    void compara(T2 t2);

    T2 compare();

    public abstract T1 compare2(T2 t2);

}
