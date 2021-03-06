// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans;

import com.kelin.learn.beans.factory.BeanFactory;

/**
 * @author kelin on 2018/10/8.
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
