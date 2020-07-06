package com.zero.aop.core;

public interface AopProxy {

    Object getProxy();

    Object getProxy(ClassLoader classLoader);
}
