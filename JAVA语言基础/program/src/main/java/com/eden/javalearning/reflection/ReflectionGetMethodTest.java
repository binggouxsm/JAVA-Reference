package com.eden.javalearning.reflection;

import java.lang.reflect.Method;

public class ReflectionGetMethodTest {

    public static void main(String[] args) {
        Class clazz = Bird.class;
        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();
    }
}
