package com.xuesran.annotation;


public class Demo02 extends DD {
    public static void main(String[] args) {
        Class<?> clazz = Demo02.class;
        //通过getAnnotationsByType方法获取所有重复注解
        FilterPath[] annotationsByType = clazz.getAnnotationsByType(FilterPath.class);
        FilterPath[] annotationsByType2 = clazz.getDeclaredAnnotationsByType(FilterPath.class);
        if (annotationsByType != null) {
            for (FilterPath filter : annotationsByType) {
                System.out.println("1:" + filter.value());
            }
        }

        System.out.println("-----------------");

        if (annotationsByType2 != null) {
            for (FilterPath filter : annotationsByType2) {
                System.out.println("2:" + filter.value());
            }
        }


        System.out.println("使用getAnnotation的结果:" + clazz.getAnnotation(FilterPath.class));
    }
}

@FilterPath("/web/list")
@FilterPath("/web/getList")
class DD {

}