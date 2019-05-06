package com.xuesran.annotation;

@FilterPath("/web/updata")
@FilterPath("/web/add")
@FilterPath("/web/delete")
public class Demo01 extends CC {
    public static void main(String[] args) {
        Class<Demo01> clazz = Demo01.class;
        FilterPath[] annotationsByType = clazz.getAnnotationsByType(FilterPath.class);

        // 注意：getDeclaredAnnotationsByType方法获取到的注解不包括父类，其实当 getAnnotationsByType()方法调用时，
        // 其内部先执行了getDeclaredAnnotationsByType方法，只有当前类不存在指定注解时，
        // getAnnotationsByType()才会继续从其父类寻找，但请注意如果@FilterPath和@FilterPaths没有使用了@Inherited的话，仍然无法获取。
        FilterPath[] declaredAnnotationsByType = clazz.getDeclaredAnnotationsByType(FilterPath.class);
        if (annotationsByType != null) {
            for (FilterPath filter : annotationsByType) {
                System.out.println("1:" + filter.value());
            }
        }

        System.out.println("-----------------");

        if (declaredAnnotationsByType != null) {
            for (FilterPath filter : declaredAnnotationsByType) {
                System.out.println("2:" + filter.value());
            }
        }


        System.out.println("使用getAnnotation的结果:" + clazz.getAnnotation(FilterPath.class));
    }
}

@FilterPath("/web/list")
class CC {

}


