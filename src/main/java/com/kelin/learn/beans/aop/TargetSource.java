// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.aop;

/**
 * @author kelin on 2018/10/8.
 */
public class TargetSource {


    private Object target;
    private Class<?>[] targetClass;


    public TargetSource(Object target, Class<?>... targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class<?>[] getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?>[] targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
