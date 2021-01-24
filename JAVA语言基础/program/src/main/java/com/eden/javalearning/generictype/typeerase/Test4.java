package com.eden.javalearning.generictype.typeerase;

import java.util.Date;

class Pair<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class DateInter extends Pair<Date> {
    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    @Override
    public Date getValue() {
        return super.getValue();
    }

}

public class Test4 {
    public static void main(String[] args) {
        DateInter inter = new DateInter();
        
    }
}
