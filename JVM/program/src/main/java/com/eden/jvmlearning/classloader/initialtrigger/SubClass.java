package com.eden.jvmlearning.classloader.initialtrigger;

public class SubClass extends SuperClass {

    public static int subvalue = 456;

    static {
        System.out.println("SubClass static code init!");
    }

    public SubClass() {
        System.out.println("SubClass constructor init! ");
    }

    public static int getSubvalue() {
        return subvalue;
    }

    public static void setSubvalue(int subvalue) {
        SubClass.subvalue = subvalue;
    }
}
