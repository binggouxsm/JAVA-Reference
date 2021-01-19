package com.eden.javalearning.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        // Doing something before request
        System.out.println("Doing something before request");
        Object result = proxy.invokeSuper(o,objects);
        // Doing something after request
        System.out.println("Doing something after request");
        return result;
    }
}
