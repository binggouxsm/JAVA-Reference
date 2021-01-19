package com.eden.javalearning.proxy.cglibproxy.chain;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

public class InterceptorChain implements MethodInterceptor {

    private List<Interceptor> interceptors;

    private int index;

    public InterceptorChain(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
        this.index = 0;
    }

    public Object doNext(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if(index < interceptors.size()){
            Interceptor in = interceptors.get(index);
            index++;
            in.doInterceptor(this,obj,method,args,proxy);
        }else{
            return proxy.invokeSuper(obj,args);
        }
        return null;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return doNext(obj, method, args, proxy);
    }
}
