package com.eden.javalearning.generictype.wildcard;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest {

    public static void test1(List<Fruit> fruits){
        for(Fruit f : fruits){
            f.self();
        }
    }

    public static void test(List<? extends Fruit> fruits){
        for(Fruit f : fruits){
            f.self();
        }
    }

    public static void test2(List<? super Apple> fruits){
        for(Object f : fruits){
            System.out.println(f.getClass().toString());
        }
    }


    public static void main(String[] args) {
        List<Apple> fruits = new ArrayList<>();
        fruits.add(new Apple());
        // 编译错误，incompatiable type List<Apple> 无法转换为 List<Fruit>
        // test1(fruits);

        test(fruits);

        List fruits2 = new ArrayList();
        fruits2.add(new Fruit());
        fruits2.add(new Apple());
        fruits2.add(new Object());

        test2(fruits2);

    }

}

class Fruit {
    public void self(){
        System.out.println("This is Fruit");
    }
}

class Apple extends Fruit {
    public void self(){
        System.out.println("This is Apple");
    }
}

class Banana extends Fruit  {
    public void self(){
        System.out.println("This is Banana");
    }
}





