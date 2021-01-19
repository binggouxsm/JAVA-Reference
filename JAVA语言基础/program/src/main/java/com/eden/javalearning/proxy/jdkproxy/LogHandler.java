package com.eden.javalearning.proxy.jdkproxy;

import com.eden.javalearning.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    // target 可以直接是 Object类型，对所有对象进行代理
    private Subject target;

    public LogHandler(Subject target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Doing something before request
        System.out.println("Doing something before request");
        Object result = method.invoke(target,args);
        // Doing something after request
        System.out.println("Doing something after request");
        return result;
    }
}
