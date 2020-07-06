package com.zero.aop.adapter;

import com.zero.aop.advisor.Advice;
import com.zero.aop.advisor.BeforeAdvice;
import com.zero.aop.interceptor.AopMethodInterceptor;
import com.zero.aop.interceptor.BeforeMethodAdviceInterceptor;

public class BeforeAdviceAdapter implements AdviceAdapter {
    private static final BeforeAdviceAdapter INSTANTS = new BeforeAdviceAdapter();

    private BeforeAdviceAdapter() {
    }

    public static BeforeAdviceAdapter getInstants() {
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advice advice) {
        return new BeforeMethodAdviceInterceptor((BeforeAdvice) advice);
    }
}
