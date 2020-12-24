package com.eden.jvmlearning.classloader.initialtrigger;

public class Main4 {

    static {
        System.out.println("Main4 static code init!");
    }

    public Main4() {
        System.out.println("Main4 constructor init!");
    }

    public static void main(String[] args) {
        /**
         * 当虚拟机启动时，用户需要指定一个要执行的主类（ 包含main()方法的那个类），虚拟机会先初始化这个主类。
         * Main4 static code init!
         */
    }
}
