package com.xuesran.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 添加可继承元注解
@Repeatable(FilterPaths.class)
public @interface FilterPath {
    String value();
}

@Target(ElementType.TYPE)
@Inherited // 添加可继承元注解
@Retention(RetentionPolicy.RUNTIME)
@interface FilterPaths {
    FilterPath[] value();
}
