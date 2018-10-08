// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn;

/**
 * @author kelin on 2018/10/8.
 */
public class HelloAopServiceImpl implements HelloAopService {
    @Override
    public String sayHello() {
        return "hello this is aop ";
    }
}
