// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.factory;

import com.kelin.learn.beans.BeanDefinition;
import com.kelin.learn.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kelin on 2018/10/8.
 */
public abstract class AbstractBeanFactory implements BeanFactory {


    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private List<String> beanDefinitionNames = new ArrayList<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new RuntimeException("this bean definition " + name + " not exist");
        }

        Object bean = beanDefinition.getBean();
        if (bean == null) {
            try {
                bean = doCreateBean(beanDefinition);
                bean = initializeBean(bean, name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    private Object initializeBean(Object bean, String name) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }

        //TODO other initialize method

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }
        return bean;
    }


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }


    public void preInstantiateSingletons() {
        for (String beanName : beanDefinitionNames) {
            getBean(beanName);
        }
    }


    public void addBeanFactoryProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }


    public List getBeansByType(Class type) {

        List<Object> list = new ArrayList<>();

        for (String beanName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanName).getBeanClass())) {
                list.add(getBean(beanName));
            }
        }
        return list;
    }

    public abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
