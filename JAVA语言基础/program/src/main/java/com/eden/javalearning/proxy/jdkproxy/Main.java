package com.eden.javalearning.proxy.jdkproxy;

import com.eden.javalearning.proxy.RealSubject;
import com.eden.javalearning.proxy.Subject;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //该设置用于输出jdk动态代理产生的类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // jdk8之后的版本采用如下设置
        // System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = new RealSubject();
        //ClassLoader一般为被代理类的类加载器或者其父类加载器
        ClassLoader classLoader = Subject.class.getClassLoader();

        Subject proxy1 = (Subject)Proxy.newProxyInstance(classLoader,new Class[]{Subject.class},new LogHandler(subject));
        Subject proxy2 = (Subject)Proxy.newProxyInstance(classLoader,new Class[]{Subject.class},new TimeHandler(proxy1));

        proxy2.request();

    }
}
