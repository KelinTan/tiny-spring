// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.context;

import com.kelin.learn.beans.BeanDefinition;
import com.kelin.learn.beans.factory.AbstractBeanFactory;
import com.kelin.learn.beans.factory.AutowireCapableBeanFactory;
import com.kelin.learn.beans.resource.UrlResourceLoader;
import com.kelin.learn.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author kelin on 2018/10/8.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {


    private String configLocation;


    public ClassPathXmlApplicationContext(String configLocation) {
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory abstractBeanFactory, String configLocation) {
        super(abstractBeanFactory);
        this.configLocation = configLocation;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new UrlResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
