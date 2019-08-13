package com.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.proxy.cglib
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-22 11:15
 * @UpdateUser:
 * @UpdateDate: 2019-7-22 11:15
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ProxyFactory implements MethodInterceptor {
    private Object target;//目标对象

    public ProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getTargetInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());//设置父类
        enhancer.setCallback(this);
        return enhancer.create();//创建子类，代理对象
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用cglib包实现代理");
        Object returnV = method.invoke(target,objects);//执行目标对象的方法
        return returnV;
    }
}
