// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn;

/**
 * @author kelin on 2018/10/8.
 */
public class HelloWorldService {

    private String text;

    private HelloPersonService helloPersonService;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HelloPersonService getHelloPersonService() {
        return helloPersonService;
    }

    public void setHelloPersonService(HelloPersonService helloPersonService) {
        this.helloPersonService = helloPersonService;
    }
}
