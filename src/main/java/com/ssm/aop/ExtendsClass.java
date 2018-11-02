package com.ssm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by hspcadmin on 2018/10/26.
 */
@Aspect
public class ExtendsClass {

    @Pointcut("execution(* com.ssm.service.*.*(..))")
    private void pointCutMethod() {
    }

    @Before("pointCutMethod()")
    public void beforeMethod() {
        System.out.println("this is beforeMethod");
    }

    //声明后置通知
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
    public void doAfterReturning(String result) {
        System.out.println("后置通知");
        System.out.println("---" + result + "---");
    }

    //声明例外通知
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        System.out.println("例外通知");
        System.out.println(e.getMessage());
    }

    //声明最终通知
    @After("pointCutMethod()")
    public void doAfter() {
        System.out.println("最终通知");
    }

    //声明环绕通知
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---环绕通知");
        Object o = pjp.proceed();
        System.out.println("退出方法---环绕通知");
        return o;
    }
}
