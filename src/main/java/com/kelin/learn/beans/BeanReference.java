// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans;

/**
 * @author kelin on 2018/10/8.
 */
public class BeanReference {

    private String name;
    private Object bean;


    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
