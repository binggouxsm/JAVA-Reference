package com.eden.javalearning.generictype.typeerase;

public class Test1 {
    public static void main(String[] args) {

        // 在不指定泛型的情况下，泛型变量的类型为该方法中的几种类型的同一父类的最小级，直到Object
        int i = Test1.add(1,2);

        // 编译报错 Number is not convertible to int
        // int j = Test1.add(1,1.2);
        // 编译报错 Number is not convertible to Float
        // Float j = Test1.add(1,1.2);
        Number j = Test1.add(1,1.2);

        Object o = Test1.add(1, "asd");

        // 在指定泛型的情况下，该方法的几种类型必须是该泛型的实例的类型或者其子类
        int a = Test1.<Integer>add(1, 2);
        // 编译报错，指定了Integer，不能为Float
        // int a = Test1.<Integer>add(1, 1.2);
        Number c = Test1.<Number>add(1, 2.2);

    }

    public static <T> T add(T x,T y){
        return y;
    }
}
