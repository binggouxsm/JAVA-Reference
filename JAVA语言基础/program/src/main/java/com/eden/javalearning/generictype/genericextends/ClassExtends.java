package com.eden.javalearning.generictype.genericextends;

import java.util.Comparator;

public class ClassExtends<T extends Comparator> {

    private T comparator;

    public int compareTo(Object o1,Object o2){
        return comparator.compare(o1,o2);
    }
}
