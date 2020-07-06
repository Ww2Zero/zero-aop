package com.zero.aop.interceptor;

import com.zero.aop.advisor.BeforeAdvice;
import com.zero.aop.invocation.MethodInvocation;

public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor {


    private BeforeAdvice advice;


    public BeforeMethodAdviceInterceptor(BeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        advice.before(mi, mi.getMethod(), mi.getArguments());
        return mi.process();
    }
}
