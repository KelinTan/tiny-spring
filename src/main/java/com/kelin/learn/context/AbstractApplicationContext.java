// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.context;

import com.kelin.learn.beans.BeanPostProcessor;
import com.kelin.learn.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @author kelin on 2018/10/8.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {


    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }


    public void refresh() throws Exception {

        loadBeanDefinitions(beanFactory);
        registerBeanFactoryProcessors(beanFactory);
//        onRefresh();
    }

    private void onRefresh() {
        beanFactory.preInstantiateSingletons();
    }

    private void registerBeanFactoryProcessors(AbstractBeanFactory beanFactory) {
        List list = beanFactory.getBeansByType(BeanPostProcessor.class);
        for (Object obj : list) {
            beanFactory.addBeanFactoryProcessor((BeanPostProcessor) obj);
        }
    }


    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

}
