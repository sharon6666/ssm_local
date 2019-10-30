package com.springTest.ioc;

import com.ssm.model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.springTest
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-12 11:25
 * @UpdateUser:
 * @UpdateDate: 2019-8-12 11:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 * https://zhuanlan.zhihu.com/p/36770560
 **/
public class SpringTest {

    public static void main(String[] args){
        //创建一个容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //调用方法实现bean的注册
        BeanFactory container = bindViaCode(beanFactory);

        User newsProvider =  (User)container.getBean("djNewsProvider");

    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(User.class);

        // 将bean定义注册到容器中
        registry.registerBeanDefinition("User", newsProvider);
//        registry.registerBeanDefinition("djListener", newsListener);
//        registry.registerBeanDefinition("djPersister", newsPersister);


        // 指定依赖关系
        // 1. 可以通过构造方法注入方式
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0, newsListener);
//        argValues.addIndexedArgumentValue(1, newsPersister);
        newsProvider.setConstructorArgumentValues(argValues);
        // 2. 或者通过setter方法注入方式
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
//        propertyValues.addPropertyValue(new PropertyValue("newPersistener",newsPersister));
        newsProvider.setPropertyValues(propertyValues);

        StringBuffer bf = new StringBuffer();
        StringBuilder bd = new StringBuilder();
        return (BeanFactory) registry;
    }
}
