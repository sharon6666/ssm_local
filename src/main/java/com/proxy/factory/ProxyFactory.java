package com.proxy.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.proxy.factory
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-22 10:41
 * @UpdateUser:
 * @UpdateDate: 2019-7-22 10:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ProxyFactory {
    private Object object;
    public ProxyFactory(Object object){
        this.object = object;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("开始动态改造");
                    Object returnV = method.invoke(object, args);
                    return returnV;
                }
            });
    }
}
