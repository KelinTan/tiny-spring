// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.aop;

/**
 * @author kelin on 2018/10/8.
 */
public interface ClassFilter {

    boolean matches(Class target);
}
