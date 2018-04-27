package com.sparrow.aop.support;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author harry
 * @date 2018/4/27
 */
public class MethodElapsed implements MethodInterceptor, Serializable {
    private static Logger logger = LoggerFactory.getLogger(MethodElapsed.class);
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info("before");
        Object result = invocation.proceed();
        logger.info("after");
        return result;
    }
}
