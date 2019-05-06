package com.xuesran.guava;

public interface Func<F, T> {

    T apply(F currentElement, T origin);

}