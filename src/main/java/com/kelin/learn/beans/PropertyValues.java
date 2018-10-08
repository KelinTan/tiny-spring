// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kelin on 2018/10/8.
 */
public class PropertyValues {


    private List<PropertyValue> list = new ArrayList<>();


    public PropertyValues() {
    }

    public PropertyValues(List<PropertyValue> list) {
        this.list = list;
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        list.add(propertyValue);
    }

    public List<PropertyValue> getList() {
        return list;
    }

    public void setList(List<PropertyValue> list) {
        this.list = list;
    }
}
