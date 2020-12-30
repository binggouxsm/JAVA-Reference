package com.eden.javalearning.reflection;

public class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane fly");
    }

    @Override
    public void fly(int speed) {
        System.out.println("Airplane fly at"+speed);
    }
}
