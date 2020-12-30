package com.eden.javalearning.reflection;

public class Bird implements Flyable{

    private String category;

    private int age;

    public Bird() {
    }

    public Bird(String category, int age) {
        this.category = category;
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly");
    }

    @Override
    public void fly(int speed) {
        System.out.println("Bird fly at"+speed);
    }
}
