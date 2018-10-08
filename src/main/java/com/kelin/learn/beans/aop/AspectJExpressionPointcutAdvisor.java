// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.aop;

import org.aopalliance.aop.Advice;

/**
 * @author kelin on 2018/10/8.
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {


    private AspectExpressionPointcut pointcut = new AspectExpressionPointcut();

    private Advice advice;


    public AspectExpressionPointcut getPointcut() {
        return pointcut;
    }

    public void setPointcut(AspectExpressionPointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        pointcut.setExpression(expression);
    }

    @Override
    public Pointcut getPointCut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
