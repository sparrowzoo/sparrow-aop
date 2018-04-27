package com.sparrow.aop;

public interface AopProxy {
    Object getProxy();

    Object getProxy(ClassLoader classLoader);
}
