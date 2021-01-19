package com.eden.javalearning.proxy.cglibproxy.chain;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeInterceptor implements  Interceptor{
    @Override
    public Object doInterceptor(InterceptorChain chain, Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = chain.doNext(obj, method, args, proxy);
        long end = System.currentTimeMillis();
        System.out.println("Request finish in " + (end -start));
        return result;

    }
}
