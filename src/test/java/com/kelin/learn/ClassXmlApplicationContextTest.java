// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn;

import com.kelin.learn.beans.aop.AdvisedSupport;
import com.kelin.learn.beans.aop.JdkDynamicProxy;
import com.kelin.learn.beans.aop.TargetSource;
import com.kelin.learn.context.ApplicationContext;
import com.kelin.learn.context.ClassPathXmlApplicationContext;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kelin on 2018/10/8.
 */
public class ClassXmlApplicationContextTest {

    @Test
    public void applicationContextTest() {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");


        HelloPersonService helloPersonService = helloWorldService.getHelloPersonService();

        Assert.assertNotNull(helloWorldService);
        Assert.assertNotNull(helloPersonService);
        Assert.assertTrue(helloWorldService.getText().equals("Hello World!"));
        Assert.assertTrue(helloPersonService.getText().equals("Hello Person"));

        System.out.println(helloWorldService.getText());
        System.out.println(helloPersonService.getText());
    }

    @Test
    public void jdkDynamicTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        HelloAopService helloAopService = (HelloAopService) applicationContext.getBean("helloAopService");


        System.out.println("origin : " + helloAopService.sayHello());

        // --------- with AOP
        // 1. 设置被代理对象(JoinPoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloAopService, HelloAopService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        JdkDynamicProxy jdkDynamicAopProxy = new JdkDynamicProxy(advisedSupport);
        HelloAopService helloAopServiceProxy = (HelloAopService) jdkDynamicAopProxy.getProxy();

        // 4. 基于AOP的调用
        System.out.println("aop : " + helloAopServiceProxy.sayHello());
    }

    @Test
    public void jdkDynamicTest2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");

        HelloAopService helloAopService = (HelloAopService) applicationContext.getBean("helloAopService");

        helloAopService.sayHello();

    }
}
