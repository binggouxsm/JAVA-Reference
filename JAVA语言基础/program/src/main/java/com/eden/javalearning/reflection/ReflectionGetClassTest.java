package com.eden.javalearning.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

public class ReflectionGetClassTest {

    public static void main(String[] args) throws Exception {
        /**
         * 1. 获取Class对象的方法
         */
        // 对象实例，调用object.getClass()
        Class cl10 = new Bird().getClass();
        System.out.println(cl10.toString());

        Bird[] arr10 = new Bird[10];
        System.out.println(arr10.getClass());// 数组返回的是 [L数组存储的类型;

        double[] darr = new double[10];
        System.out.println(darr.getClass());

        // 通过类的类型获取Class对象
        System.out.println(int.class.toString());
        System.out.println(Bird.class.toString());

        // 通过类的全限定名获取Class对象，基础类型无法使用此方法
        System.out.println(Class.forName("com.eden.javalearning.reflection.Airplane"));
        // 通过调用反射的相关方法获取Class对象
        System.out.println(F35.class.getSuperclass().toString());

    }
}
