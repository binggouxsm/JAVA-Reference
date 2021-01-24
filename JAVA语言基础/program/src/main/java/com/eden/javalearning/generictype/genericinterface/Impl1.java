package com.eden.javalearning.generictype.genericinterface;

// 不指定泛化类型
public class Impl1<T> implements GenericInterfaceTest<T> {
    @Override
    public void request(T data) {
        System.out.println(data.getClass().toString());
    }
}
