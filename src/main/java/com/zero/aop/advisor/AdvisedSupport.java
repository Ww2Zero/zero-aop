package com.zero.aop.advisor;

import com.zero.aop.interceptor.AopMethodInterceptor;

import java.util.LinkedList;
import java.util.List;

public class AdvisedSupport extends Advisor {

    private TargetSource targetSource;

    private List<AopMethodInterceptor> list = new LinkedList<>();


    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public List<AopMethodInterceptor> getList() {
        return list;
    }

    public void setList(List<AopMethodInterceptor> list) {
        this.list = list;
    }

    public void addAopMethodInterceptor(AopMethodInterceptor interceptor) {
        list.add(interceptor);
    }
}
