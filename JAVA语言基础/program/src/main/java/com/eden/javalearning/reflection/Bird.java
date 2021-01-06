package com.eden.javalearning.reflection;


import com.eden.javalearning.reflection.annotations.MyMethodAnnotation;


public class Bird implements Flyable{

    private String category;

    private int age;

    public String name;


    protected String nickname;

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

    @MyMethodAnnotation(value = "aaa", request = {"asd","bbbb"})
    public void fly() {
        sing();
        System.out.println("Bird fly");
    }

    public void fly(int speed) {
        sing();
        System.out.println("Bird fly at"+speed);
    }

    private void sing(){
        System.out.println("Bird singing");
    }

    protected void growOld(){
        this.age++;
    }
}
