package com.zero.aop;

import com.zero.aop.core.AdpApplicationContext;

public class test {

    public static void main(String[] args) throws Exception {
        AdpApplicationContext aopApplicationContext = new AdpApplicationContext("application01.json");
        aopApplicationContext.init();

        Object testServiceProxy = aopApplicationContext.getBean("testServiceProxy");
        TestService testService = (TestService) testServiceProxy;

        testService.hello("zero");

    }
}
