package com.eden.jvmlearning.classloader.loader;

import java.util.Arrays;

class Test{
}

public class Main {

    public static void main(String[] args) {
        /**
         * 类加载器的等级 AppClassLoader -》 ExtClassLoader -》 BootstrapClassLoader
         */
        // 运行结果  sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Test.class.getClassLoader().toString());
        // 运行结果  sun.misc.Launcher$ExtClassLoader@4554617c
        System.out.println(Test.class.getClassLoader().getParent().toString());
        // 运行结果  null
        System.out.println(Test.class.getClassLoader().getParent().getParent());
        // 运行结果  null
        System.out.println(int.class.getClassLoader());

        /**
         * 数组的类加载器 与数组内元素类型的加载器一致
         */
        Test[] arr = new Test[10];
        // 运行结果  null
        System.out.println(arr.getClass().getClassLoader().toString());
        int[] arr2 = new int[10];
        // 运行结果  sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(arr2.getClass().getClassLoader());

    }
}
