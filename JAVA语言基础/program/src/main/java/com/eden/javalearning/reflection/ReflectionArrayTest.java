package com.eden.javalearning.reflection;

import java.lang.reflect.Array;

public class ReflectionArrayTest {

    public static void main(String[] args) {
        testMultiArray();
    }

    private static void testArray(){
        // 新建数组
        Object intArray = Array.newInstance(int.class,10);

        // 设置数组元素
        // 设置超过长度，抛出ArrayIndexOutOfBoundsException
        // Array.setInt(intArray,11,13);
        Array.setInt(intArray,0,13);

        // 得到数组元素
        System.out.println(Array.getInt(intArray,0));
    }

    private static void testMultiArray(){
        // 新建多维数组
        Object multiArray = Array.newInstance(int.class,2,3);
        Object row0 = Array.get(multiArray,0);
        Object row1 = Array.get(multiArray,1);

        Array.setInt(row0,2,1);
        Array.setInt(row1,1,-1);


    }
}
