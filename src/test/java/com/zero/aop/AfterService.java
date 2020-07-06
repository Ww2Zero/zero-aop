package com.zero.aop;

import com.zero.aop.advisor.AfterAdvice;

import java.lang.reflect.Method;

public class AfterService implements AfterAdvice {
    @Override
    public Object after(Object target, Method method, Object[] args, Object returnVal) {
        System.out.println("after advice is running" + target);
        return returnVal;
    }
}
