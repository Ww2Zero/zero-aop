package com.zero.aop.core;

import com.zero.aop.utils.JsonUtils;
import com.zero.ioc.base.BeanDefinition;
import com.zero.ioc.utils.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zero
 */
public class AdpApplicationContext extends AopBeanFactory {

    private String jsonFileName;

    public AdpApplicationContext(String jsonFileName) {
        this.jsonFileName = jsonFileName;
    }

    public void init() throws ClassNotFoundException, IOException {

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(jsonFileName);

        List<AopBeanDefinition> beanDefinitions = JsonUtils.jsonToAopBeanDefinition(is);

        if (beanDefinitions != null && !beanDefinitions.isEmpty()) {

            for (AopBeanDefinition beanDefinition : beanDefinitions) {
                Class<?> clz = ClassUtils.loadClass(beanDefinition.getClassName());
                if (clz == ProxyFactoryBean.class) {
                    registerBean(beanDefinition.getBeanName(), beanDefinition);
                } else {
                    registerBean(beanDefinition.getBeanName(), (BeanDefinition) beanDefinition);
                }
            }
        }
    }
}
