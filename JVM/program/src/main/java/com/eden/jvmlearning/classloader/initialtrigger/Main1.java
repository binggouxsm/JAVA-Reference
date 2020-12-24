package com.eden.jvmlearning.classloader.initialtrigger;

/**
 * 遇到new、getstatic、putstatic或invokestatic这4条字节码指令时，如果类没有进行过初始化，则需要先触发其初始化。
 */
public class Main1 {
    public static void main(String[] args) {

        /**
         * 1. new 字节码指令
         * [Loaded com.eden.jvmlearning.classloader.initialtrigger.SuperClass from XXXX]
         * [Loaded com.eden.jvmlearning.classloader.initialtrigger.SubClass from XXX]
         * SuperClass static code init!
         * SubClass static code init!
         * SuperClass constructor init!
         * SubClass constructor init!
         */
        // SubClass sub = new SubClass();


        /**
         * 2.getstatic字节码指令
         * 被final修饰除外、已在编译期把结果放入常量池的静态字段除外
         * [Loaded com.eden.jvmlearning.classloader.initialtrigger.SuperClass from XXXX]
         * [Loaded com.eden.jvmlearning.classloader.initialtrigger.SubClass from XXX]
         * SuperClass static code init!
         * SubClass static code init!
         */
        // int subvalue = SubClass.subvalue;

        /**
         * 3.setstatic字节码指令
         * [Loaded com.eden.jvmlearning.classloader.initialtrigger.SuperClass from XXXX]
         * [Loaded com.eden.jvmlearning.classloader.initialtrigger.SubClass from XXX]
         * SuperClass static code init!
         * SubClass static code init!
         */
        // SubClass.subvalue = 3;

        /**
         * 4.invokestatic字节码指令
         * [Loaded com.eden.jvmlearning.classloader.initialtrigger.SuperClass from XXXX]
         * [Loaded com.eden.jvmlearning.classloader.initialtrigger.SubClass from XXX]
         * SuperClass static code init!
         * SubClass static code init!
         */
        SubClass.getSubvalue();
    }

}
