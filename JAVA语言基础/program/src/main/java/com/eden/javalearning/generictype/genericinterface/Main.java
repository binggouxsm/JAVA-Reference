package com.eden.javalearning.generictype.genericinterface;

public class Main {
    public static void main(String[] args) {
        GenericInterfaceTest<Integer> test = new Impl1<>();
        test.request(123);

        // 编译错误  Incompatible type
        // GenericInterfaceTest<Integer> test1 = new Impl2();

        GenericInterfaceTest<String> test1 = new Impl2();
        test1.request("asdasd");
    }
}
