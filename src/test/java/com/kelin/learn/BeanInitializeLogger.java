// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn;

import com.kelin.learn.beans.BeanPostProcessor;

/**
 * @author kelin on 2018/10/8.
 */
public class BeanInitializeLogger implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {

        System.out.println("this is bean logger before");

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {

        System.out.println("this is bean logger after");
        return bean;
    }
}
