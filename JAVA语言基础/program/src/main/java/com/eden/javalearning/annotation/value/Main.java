package com.eden.javalearning.annotation.value;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Method method = Test.class.getMethod("testMethod",null);
        ValueAnno anno = method.getAnnotation(ValueAnno.class);
        System.out.println(anno.request());
        System.out.println(anno.value());
        System.out.println(anno.value());
    }
}
