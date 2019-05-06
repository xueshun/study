package com.xuesran.genericity;

public class Box<T> {
    private T data;

    public Box() {
    }

    public Box(T data) {
        this.data = data;
    }

    /**
     * 获取data
     *
     * @return data
     */
    public T getData() {
        return data;
    }
}
