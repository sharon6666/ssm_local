package com.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class JDKProxyTest {
    public static void main(String[] args){
        Star ldh = new Liu();
        StarProxy proxy = new StarProxy();
        proxy.setTarget(ldh);
        Object obj = proxy.CreatProxyedObj();
        Star star = (Star)obj;
        System.out.println(star.dance());
    }
}
