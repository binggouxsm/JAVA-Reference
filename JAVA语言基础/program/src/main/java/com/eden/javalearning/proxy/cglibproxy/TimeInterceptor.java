package com.eden.javalearning.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeInterceptor implements MethodInterceptor {

    private Object target;

    public TimeInterceptor(Object target) {
        this.target = target;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proxy.invoke(target,objects);
        long end = System.currentTimeMillis();
        System.out.println("Request finish in " + (end -start));
        return result;
    }
}
