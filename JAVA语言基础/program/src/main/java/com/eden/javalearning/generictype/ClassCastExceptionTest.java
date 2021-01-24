package com.eden.javalearning.generictype;

import java.util.ArrayList;
import java.util.List;

public class ClassCastExceptionTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add(123);

        for (int i = 0; i < list.size(); i++) {
            System.out.println((String) list.get(i));
        }
    }
}
