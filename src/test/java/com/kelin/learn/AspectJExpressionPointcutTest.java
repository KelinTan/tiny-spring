package com.kelin.learn;

import com.kelin.learn.beans.aop.AspectExpressionPointcut;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kelin
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(*  com.kelin.learn.*.*(..))";
        AspectExpressionPointcut aspectJExpressionPointcut = new AspectExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.kelin.learn.*.*(..))";
        AspectExpressionPointcut aspectJExpressionPointcut = new AspectExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloAopServiceImpl.class.getDeclaredMethod("sayHello"), HelloAopServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
