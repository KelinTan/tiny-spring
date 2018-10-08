// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kelin on 2018/10/8.
 */
public class JdkDynamicProxy implements AopProxy, InvocationHandler {


    private AdvisedSupport advised;

    public JdkDynamicProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(JdkDynamicProxy.class.getClassLoader(), advised.getTargetSource()
                .getTargetClass(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method,
                args));
    }
}
