package com.eden.jvmlearning.classloader.initialtrigger;

public class ConstClass {
    public static final String HELLOWORLD = "hello world";

    static {
        System.out.println("ConstClass init!");
    }
}
