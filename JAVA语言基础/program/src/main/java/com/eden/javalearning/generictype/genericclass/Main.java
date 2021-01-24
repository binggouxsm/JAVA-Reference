package com.eden.javalearning.generictype.genericclass;


public class Main {
    public static void main(String[] args) {
        GenericClassTest<String> test = new GenericClassTest<>("123");
        System.out.println(test.getData().getClass().toString());

    }
}
