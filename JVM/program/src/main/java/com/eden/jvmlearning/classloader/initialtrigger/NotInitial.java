package com.eden.jvmlearning.classloader.initialtrigger;

public class NotInitial {
    public static void main(String[] args) {
        // 子类引用父类的静态字段，只会触发子类的加载、父类的初始化，不会导致子类初始化
        // int i = SubClass.value;

        // 通过数组定义来引用类，不会触发此类的初始化,只会触发类的加载
        // SubClass[] a = new SubClass[10];

        // 常量在编译阶段会进行常量优化，将常量存入**调用类**的常量池中，
        // 本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
        System.out.println(ConstClass.HELLOWORLD);
    }
}
