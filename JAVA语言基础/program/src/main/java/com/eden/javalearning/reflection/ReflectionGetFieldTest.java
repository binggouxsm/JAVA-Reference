package com.eden.javalearning.reflection;


import java.lang.reflect.Field;

public class ReflectionGetFieldTest {

    public static void main(String[] args) {
        Class clazz = Bird.class;
        // 获取所有的public变量
        Field[] fields = clazz.getFields();

        // 获取所有声明的变量（包括private）
        Field[] declaredFields = clazz.getDeclaredFields();


    }
}
