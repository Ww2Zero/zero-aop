package com.zero.aop.core;

import com.zero.aop.advisor.TargetSource;
import com.zero.aop.interceptor.AopMethodInterceptor;
import com.zero.aop.invocation.CglibMethodInvocation;
import com.zero.aop.invocation.MethodInvocation;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zero
 */
public class DynamicAdvisedInterceptor implements MethodInterceptor {

    protected final List<AopMethodInterceptor> interceptorList;
    protected final TargetSource targetSource;

    public DynamicAdvisedInterceptor(List<AopMethodInterceptor> interceptorList, TargetSource targetSource) {
        this.interceptorList = interceptorList;
        this.targetSource = targetSource;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        MethodInvocation invocation = new CglibMethodInvocation(obj, targetSource.getTargetObject(), method, args, interceptorList, proxy);
        return invocation.process();
    }
}
