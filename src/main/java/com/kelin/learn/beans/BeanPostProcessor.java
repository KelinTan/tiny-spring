// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans;

/**
 * @author kelin on 2018/10/8.
 */
public interface BeanPostProcessor {


    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
