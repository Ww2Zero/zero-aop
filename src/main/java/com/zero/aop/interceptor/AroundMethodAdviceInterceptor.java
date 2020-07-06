package com.zero.aop.interceptor;

import com.zero.aop.advisor.AroundAdvice;
import com.zero.aop.invocation.MethodInvocation;

public class AroundMethodAdviceInterceptor implements AopMethodInterceptor {
    private AroundAdvice advice;

    public AroundMethodAdviceInterceptor(AroundAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return advice.around(mi, mi.getMethod(), mi.getArguments());
    }
}
