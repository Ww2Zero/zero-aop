package com.zero.aop;

import com.zero.aop.advisor.BeforeAdvice;

import java.lang.reflect.Method;

public class BeforeService implements BeforeAdvice {

    @Override
    public void before(Object target, Method method, Object[] args) {
        System.out.println("before  advice is running " + target);
    }
}
