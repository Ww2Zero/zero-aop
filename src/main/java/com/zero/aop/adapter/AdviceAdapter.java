package com.zero.aop.adapter;

import com.zero.aop.advisor.Advice;
import com.zero.aop.interceptor.AopMethodInterceptor;

public interface AdviceAdapter {

    AopMethodInterceptor getInterceptor(Advice advice);
}
