package com.zero.aop.invocation;

import java.lang.reflect.Method;

public interface MethodInvocation {

    Method getMethod();

    Object[] getArguments();

    Object process() throws Throwable;
}
