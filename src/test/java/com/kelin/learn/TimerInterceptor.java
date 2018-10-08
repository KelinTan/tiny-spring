package com.kelin.learn;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author  kelin
 */
public class TimerInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long time = System.nanoTime();
		System.out.println("Invocation of Method " + invocation.getMethod().getName() + " start!");
		Object proceed = invocation.proceed();
		System.out.println("result : " + proceed);
		System.out.println("Invocation of Method " + invocation.getMethod().getName() + " end! takes " + (System.nanoTime() - time)
				+ " nanoseconds.");
		return proceed;
	}
}
