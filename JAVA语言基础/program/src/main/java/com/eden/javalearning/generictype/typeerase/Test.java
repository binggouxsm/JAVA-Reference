package com.eden.javalearning.generictype.typeerase;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<Integer> list1 = new ArrayList<>();

        List<String> list2 = new ArrayList<>();

        // 编译后类型擦除，Class对象相等,均为 List
        System.out.println(list1.getClass() == list2.getClass());

        // 直接添加String类型的元素，编译失败
        // list1.add("asd");
        // 通过反射调用 add 方法可以添加 String 类型的元素
        list1.getClass().getMethod("add",Object.class).invoke(list1,"asd");

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

    }
}
