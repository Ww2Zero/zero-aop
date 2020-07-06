package com.zero.aop.interceptor;

import com.zero.aop.advisor.AfterAdvice;
import com.zero.aop.invocation.MethodInvocation;

public class AfterMethodAdviceInterceptor implements AopMethodInterceptor {

    private AfterAdvice advice;

    public AfterMethodAdviceInterceptor(AfterAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnVal = mi.process();
        advice.after(mi, mi.getMethod(), mi.getArguments(), returnVal);
        return returnVal;
    }
}
