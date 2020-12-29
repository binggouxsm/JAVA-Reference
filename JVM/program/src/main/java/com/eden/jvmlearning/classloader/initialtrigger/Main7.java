package com.eden.jvmlearning.classloader.initialtrigger;


interface I {
    int i = 1, ii = Main7.out("ii", 2);
}
interface J extends I {
    int j = Main7.out("j", 3), jj = Main7.out("jj", 4);
}
interface K extends J {
    int k = Main7.out("k", 5);
}
class Main7 {
    public static void main(String[] args) {
        /**
         * I.i是常量，子接口J.i不会触发接口I的初始化
         */
        System.out.println(J.i);
        /**
         * J.j是变量，子接口K.j会触发接口J的初始化，但不触发接口I的初始化
         */
        System.out.println(K.j);
    }
    static int out(String s, int i) {
        System.out.println(s + "=" + i);
        return i;
    }
}
