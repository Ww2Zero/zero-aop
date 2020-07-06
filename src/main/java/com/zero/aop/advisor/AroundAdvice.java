package com.zero.aop.advisor;

import com.zero.aop.invocation.MethodInvocation;

import java.lang.reflect.Method;

public interface AroundAdvice extends Advice {

    Object around(MethodInvocation target, Method method, Object[] args) throws Throwable;
}
