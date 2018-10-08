// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.factory;

import com.kelin.learn.beans.BeanDefinition;
import com.kelin.learn.beans.BeanFactoryAware;
import com.kelin.learn.beans.BeanReference;
import com.kelin.learn.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author kelin on 2018/10/8.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) throws Exception {

        Object bean = beanDefinition.getBeanClass().newInstance();
        beanDefinition.setBean(bean);
        applyProperValues(bean, beanDefinition);
        return bean;
    }


    private void applyProperValues(Object bean, BeanDefinition beanDefinition) throws Exception {

        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }

        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getList()) {

            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                Method method = bean.getClass().getDeclaredMethod("set" + propertyValue.getName().substring(0, 1).toUpperCase() + propertyValue.getName().substring(1), value.getClass());
                method.setAccessible(true);
                method.invoke(bean, value);
            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                field.set(bean, value);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
