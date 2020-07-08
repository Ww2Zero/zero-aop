package com.zero.proxy;

import org.junit.Test;

public class TestProxy {

    @Test
    public void testJdkProxy() {
        JdkProxy jdkProxy = new JdkProxy(new Bus());
        Car instance = (Car) jdkProxy.getInstance();
        System.out.println("instance = " + instance);
        instance.running();
        instance.stop("red");
    }

    @Test
    public void testCglibProxy() {
        CglibProxy cglibProxy = new CglibProxy(new Bus());
        Bus instance = (Bus) cglibProxy.getInstance();
        System.out.println("instance = " + instance);
        instance.running();
        instance.stop("red");
    }


    interface Car {
        void running();

        void stop(String cause);
    }

    static class Bus implements Car {

        @Override
        public void running() {
            System.out.println("bus is running");
        }

        @Override
        public void stop(String cause) {
            System.out.println("bus is stop because " + cause);
        }
    }
}
