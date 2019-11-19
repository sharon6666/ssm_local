package com.ssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.ssm.aop
 * @Description: note
 * @Author:
 * @date: 2019-11-4 16:09
 * @UpdateUser:
 * @UpdateDate: 2019-11-4 16:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Aspect
@Component
public class LoggingAspect {

    //声明该方法是一个前置通知：在目标方法开始之前执行，其中*为具体的某个方法名，也可以指全部的方法名
    @Before("execution(public int com.dhx.spring.aop.impl.ArtithmeticCalculatorImpl.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        //方法名
        String methodName=joinPoint.getSignature().getName();
        //参数
        List<Object> args= Arrays.asList(joinPoint.getArgs());
        System.out.println("the method "+methodName+" begins with "+args);
    }

    //后置通知：在目标方法执行后(无论是否发生异常)，执行的通知
    //在后置通知中还不能访问目标方法执行的结果
    @After("execution(public int com.dhx.spring.aop.impl.ArtithmeticCalculatorImpl.*(int, int))")
    public void afterMethod(JoinPoint joinPoint) {
        //方法名
        String methodName=joinPoint.getSignature().getName();
        System.out.println("the method "+methodName+" ends");
    }

}