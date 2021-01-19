package com.eden.javalearning.proxy.cglibproxy;

import com.eden.javalearning.proxy.RealSubject;
import com.eden.javalearning.proxy.Subject;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        // 该设置用于输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);

        // 通过invokeSuper的方式，直接调用代理类的父类方法
        System.out.println("=================================");
        enhancer.setCallback(new LogInterceptor());
        Subject proxy = (Subject)enhancer.create();
        proxy.request();

        // 通过invoke的方式，直接调用目标类的方法
        System.out.println("=================================");
        Subject subject = new RealSubject();
        enhancer.setCallback(new TimeInterceptor(subject));
        Subject proxy1 = (Subject)enhancer.create();
        proxy1.request();


    }



}
