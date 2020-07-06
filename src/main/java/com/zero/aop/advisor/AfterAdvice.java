package com.zero.aop.advisor;

import java.lang.reflect.Method;

public interface AfterAdvice extends Advice {

    Object after(Object target, Method method, Object[] args, Object returnVal);
}
