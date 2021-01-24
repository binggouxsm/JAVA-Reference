package com.eden.javalearning.generictype.genericinterface;

// 指定泛化类型
public class Impl2 implements GenericInterfaceTest<String> {
    @Override
    public void request(String data) {
        System.out.println(data);
    }
}
