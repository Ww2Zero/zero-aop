package com.zero.aop.advisor;

import java.lang.reflect.Method;

public interface BeforeAdvice extends Advice {

    void before(Object target, Method method, Object[] args);
}
