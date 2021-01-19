package com.eden.javalearning.proxy.jdkproxy;

import com.eden.javalearning.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    private Subject target;

    public TimeHandler(Subject target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(target,args);
        long end = System.currentTimeMillis();
        System.out.println("Request finish in " + (end -start));
        return result;
    }
}
