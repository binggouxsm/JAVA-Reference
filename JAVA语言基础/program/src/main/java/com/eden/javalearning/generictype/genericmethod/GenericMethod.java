package com.eden.javalearning.generictype.genericmethod;

public class GenericMethod {

    public static <T> void add(T a, T b){
        System.out.println("a class:"+a.getClass().toString());
        System.out.println("b class:"+b.getClass().toString());
    }

    public static void main(String[] args) {
        GenericMethod.<Integer>add(1,3);
    }
}
