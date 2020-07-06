package com.zero.aop.core;

import com.zero.aop.adapter.AfterAdviceAdapter;
import com.zero.aop.adapter.AroundAdviceAdapter;
import com.zero.aop.adapter.BeforeAdviceAdapter;
import com.zero.aop.advisor.*;
import com.zero.aop.interceptor.AopMethodInterceptor;
import com.zero.ioc.core.DefaultBeanFactory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AopBeanFactory extends DefaultBeanFactory {

    private static ConcurrentHashMap<String, AopBeanDefinition> aopBeanDefinitionMap = new ConcurrentHashMap<>();

    private static ConcurrentHashMap<String, Object> aopBeanMap = new ConcurrentHashMap<>();

    protected void registerBean(String name, AopBeanDefinition aopBeanDefinition) {
        aopBeanDefinitionMap.put(name, aopBeanDefinition);
    }

    @Override
    public Object getBean(String beanName) throws Exception {

        Object bean = aopBeanMap.get(beanName);
        if (bean != null) {
            return bean;
        }
        if (aopBeanDefinitionMap.containsKey(beanName)) {
            AopBeanDefinition aopBeanDefinition = aopBeanDefinitionMap.get(beanName);
            if (aopBeanDefinition != null) {
                AdvisedSupport as = getAdvisedSupport(aopBeanDefinition);
                bean = new CglibAopProxy(as).getProxy();
                aopBeanMap.put(beanName, bean);
                return bean;
            }
        }

        return super.getBean(beanName);
    }

    private AdvisedSupport getAdvisedSupport(AopBeanDefinition aopBeanDefinition) throws Exception {
        AdvisedSupport advisedSupport = new AdvisedSupport();

        List<String> interceptorNames = aopBeanDefinition.getInterceptorNames();

        if (interceptorNames != null && !interceptorNames.isEmpty()) {
            for (String interceptorName : interceptorNames) {
                Advice advice = (Advice) getBean(interceptorName);
                Advisor advisor = new Advisor();
                advisor.setAdvice(advice);
                if (advice instanceof BeforeAdvice) {
                    AopMethodInterceptor interceptor = BeforeAdviceAdapter.getInstants().getInterceptor(advice);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }
                if (advice instanceof AfterAdvice) {
                    AopMethodInterceptor interceptor = AfterAdviceAdapter.getInstants().getInterceptor(advice);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }
                if (advice instanceof AroundAdvice) {
                    AopMethodInterceptor interceptor = AroundAdviceAdapter.getInstants().getInterceptor(advice);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }
            }
        }

        TargetSource targetSource = new TargetSource();
        Object targetBean = getBean(aopBeanDefinition.getTarget());
        targetSource.setTargetClass(targetBean.getClass());
        targetSource.setTargetObject(targetBean);
        advisedSupport.setTargetSource(targetSource);

        return advisedSupport;
    }
}
