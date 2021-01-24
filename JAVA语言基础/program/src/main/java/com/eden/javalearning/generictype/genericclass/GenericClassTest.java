package com.eden.javalearning.generictype.genericclass;

public class GenericClassTest<T> {

    private T data;

    public GenericClassTest(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
