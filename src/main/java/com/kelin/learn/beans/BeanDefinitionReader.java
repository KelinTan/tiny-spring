// Copyright 2018 Alo7 Inc. All rights reserved.

package com.kelin.learn.beans;

import java.io.IOException;

/**
 * @author kelin on 2018/10/8.
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws IOException, Exception;
}
