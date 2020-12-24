package com.eden.jvmlearning.classloader.initialtrigger;

public class SuperClass {

    public static int value = 123;

    static {
        System.out.println("SuperClass static code init!");
    }

    public SuperClass() {
        System.out.println("SuperClass constructor init! ");
    }

    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        SuperClass.value = value;
    }
}
