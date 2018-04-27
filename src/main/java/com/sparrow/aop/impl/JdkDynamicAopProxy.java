package com.sparrow.aop.impl;

import com.sparrow.aop.AopProxy;
import com.sparrow.utility.ClassUtility;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by harry on 2018/4/27.
 */
public class JdkDynamicAopProxy implements AopProxy,InvocationHandler{
    private Object target;
    private MethodInvocation methodInvocation;
    public JdkDynamicAopProxy(Object target,MethodInvocation methodInvocation){
        this.target=target;
        this.methodInvocation=methodInvocation;
    }

    @Override
    public Object getProxy() {
        return getProxy(ClassUtility.getDefaultClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader,
                target.getClass().
                        getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return methodInvocation.proceed();
    }
}
