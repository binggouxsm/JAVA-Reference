package com.eden.jvmlearning.classloader.initialtrigger;

/**
 * 初始化类时，如果发现父类还没有初始化，则需要先触发父类的初始化
 */
public class Main3 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();

        //初始化顺序
        //SuperClass static code init!  首先初始化父类静态代码块
        //SubClass static code init!    其次初始化自己的静态代码块
        //SuperClass constructor init!  其次初始化父类的构造器
        //SubClass constructor init!    其次初始化自己的构造器
    }
}
