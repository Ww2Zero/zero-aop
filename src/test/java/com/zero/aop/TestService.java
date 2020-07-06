package com.zero.aop;

public class TestService {


    private String serviceName;

    public TestService() {

    }

    public TestService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String hello(String name) throws InterruptedException {
        String res = "hello " + name;
        Thread.sleep(1000);
        System.out.println(res);
        return res;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
