package com.zero.aop.adapter;

import com.zero.aop.advisor.Advice;
import com.zero.aop.advisor.AfterAdvice;
import com.zero.aop.interceptor.AfterMethodAdviceInterceptor;
import com.zero.aop.interceptor.AopMethodInterceptor;

public class AfterAdviceAdapter implements AdviceAdapter {
    private static final AfterAdviceAdapter INSTANTS = new AfterAdviceAdapter();

    private AfterAdviceAdapter() {
    }

    public static AfterAdviceAdapter getInstants() {
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advice advice) {
        return new AfterMethodAdviceInterceptor((AfterAdvice) advice);
    }
}
