package com.zero.aop.interceptor;

import com.zero.aop.invocation.MethodInvocation;

public interface AopMethodInterceptor {

    Object invoke(MethodInvocation mi) throws Throwable;
}
