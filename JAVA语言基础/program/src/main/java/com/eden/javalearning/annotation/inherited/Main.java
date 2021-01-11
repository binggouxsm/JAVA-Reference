package com.eden.javalearning.annotation.inherited;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        // 子类继承父类，子类会得到修饰父类的@Inherited注解
        Annotation[] anno = ChildClazz.class.getAnnotations();
        System.out.println("Child class has annotation");
        for (int i = 0; i < anno.length; i++) {
            System.out.println(anno[i].toString());
        }

        // @Inherited修饰方法的注解时，无效，和不写不存在任何区别
        Method method = ChildClazz.class.getMethod("test",null);
        System.out.println("Child test method has annotation");
        anno = method.getAnnotations();
        for (int i = 0; i < anno.length; i++) {
            System.out.println(anno[i].toString());
        }
        // 子类重写父类方法时，父类方法上的注解，在子类方法上均不存在
        Method method1 = ChildClazz.class.getMethod("test1",null);
        System.out.println("Child test1 method has annotation");
        anno = method1.getAnnotations();
        for (int i = 0; i < anno.length; i++) {
            System.out.println(anno[i].toString());
        }

        // @Inherited修饰接口时，也不会继承
        anno = ParentInterface.class.getAnnotations();
        System.out.println("Parent Interface has annotation");
        for (int i = 0; i < anno.length; i++) {
            System.out.println(anno[i].toString());
        }

        anno = ChildInterface.class.getAnnotations();
        System.out.println("Child Interface has annotation");
        for (int i = 0; i < anno.length; i++) {
            System.out.println(anno[i].toString());
        }

        anno = ImplClazz.class.getAnnotations();
        System.out.println("Clazz Implment Parent Interface has annotation");
        for (int i = 0; i < anno.length; i++) {
            System.out.println(anno[i].toString());
        }

    }
}
