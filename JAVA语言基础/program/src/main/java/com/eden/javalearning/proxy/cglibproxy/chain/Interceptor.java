package com.eden.javalearning.proxy.cglibproxy.chain;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public interface Interceptor {

    public Object doInterceptor(InterceptorChain chain, Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable;
}
