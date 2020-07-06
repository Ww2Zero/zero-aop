package com.zero.aop;

import com.zero.aop.advisor.AroundAdvice;
import com.zero.aop.invocation.MethodInvocation;

import java.lang.reflect.Method;

public class AroundService implements AroundAdvice {

    @Override
    public Object around(MethodInvocation target, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "计时开始");
        long start = System.currentTimeMillis();
        Object process = target.process();
        long end = System.currentTimeMillis();
        System.out.println(method.getName() + "计时结束：" + (end - start) + "");
        return process;
    }
}
