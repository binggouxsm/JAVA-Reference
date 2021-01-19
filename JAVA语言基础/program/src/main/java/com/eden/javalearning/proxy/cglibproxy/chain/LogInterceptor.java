package com.eden.javalearning.proxy.cglibproxy.chain;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogInterceptor implements  Interceptor{
    @Override
    public Object doInterceptor(InterceptorChain chain, Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // Doing something before request
        System.out.println("Doing something before request");
        Object result = chain.doNext(obj, method, args, proxy);
        // Doing something after request
        System.out.println("Doing something after request");
        return result;
    }
}
