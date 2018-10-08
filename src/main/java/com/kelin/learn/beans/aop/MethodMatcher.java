// Copyright 2018 Alo7 Inc. All rights reserved.

package com.kelin.learn.beans.aop;

import java.lang.reflect.Method;

/**
 * @author kelin on 2018/10/8.
 */
public interface MethodMatcher {

    boolean matches(Method method, Class target);
}
