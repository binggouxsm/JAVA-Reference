package com.eden.javalearning.proxy.cglibproxy.chain;

import com.eden.javalearning.proxy.RealSubject;
import com.eden.javalearning.proxy.Subject;
import net.sf.cglib.proxy.Enhancer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Interceptor> list = new ArrayList<>();
        list.add(new TimeInterceptor());
        list.add(new LogInterceptor());

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new InterceptorChain(list));

        Subject proxy = (Subject)enhancer.create();
        proxy.request();
    }
}
