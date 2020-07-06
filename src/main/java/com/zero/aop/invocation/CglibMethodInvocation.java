package com.zero.aop.invocation;

import com.zero.aop.interceptor.AopMethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zero
 */
public class CglibMethodInvocation extends ReflectioveMethodInvocation {


    private MethodProxy methodProxy;

    public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments, List<AopMethodInterceptor> interceptorList, MethodProxy methodProxy) {
        super(proxy, target, method, arguments, interceptorList);
        this.methodProxy = methodProxy;
    }

    protected Object invokeOriginal() throws Throwable {
        return methodProxy.invoke(target, arguments);
    }


}
