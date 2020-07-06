package com.zero.aop.adapter;

import com.zero.aop.advisor.Advice;
import com.zero.aop.advisor.AroundAdvice;
import com.zero.aop.interceptor.AopMethodInterceptor;
import com.zero.aop.interceptor.AroundMethodAdviceInterceptor;

public class AroundAdviceAdapter implements AdviceAdapter {

    private static final AroundAdviceAdapter INSTANTS = new AroundAdviceAdapter();

    private AroundAdviceAdapter() {
    }

    public static AroundAdviceAdapter getInstants() {
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advice advice) {
        return new AroundMethodAdviceInterceptor((AroundAdvice) advice);
    }
}
