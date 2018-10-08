// Copyright 2018 Alo7 Inc. All rights reserved.

package com.kelin.learn.beans.aop;

/**
 * @author kelin on 2018/10/8.
 */
public interface PointcutAdvisor extends Advisor {


    Pointcut getPointCut();
}
