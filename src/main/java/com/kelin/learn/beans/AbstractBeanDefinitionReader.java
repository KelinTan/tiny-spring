// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans;

import com.kelin.learn.beans.resource.ResourceLoader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kelin on 2018/10/8.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {


    private Map<String, BeanDefinition> registry = new ConcurrentHashMap<>();

    private ResourceLoader resourceLoader;


    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public void setRegistry(Map<String, BeanDefinition> registry) {
        this.registry = registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
