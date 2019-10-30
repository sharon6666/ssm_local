package com.javese;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-14 16:07
 * @UpdateUser:
 * @UpdateDate: 2019-10-14 16:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class CallBackTest {
    /**
     * 一个用来被测试的方法，进行了一个比较耗时的循环
     */
    public   static   void  testMethod(){
        for ( int  i= 0 ; i< 100000000 ; i++){

        }
    }
    /**
     * 一个简单的测试方法执行时间的方法
     */
    public void testTime(){
        long  begin = System.currentTimeMillis(); //测试起始时间
        testMethod(); //测试方法
        long  end = System.currentTimeMillis(); //测试结束时间
        System.out.println("[use time]:"  + (end - begin)); //打印使用时间
    }

    public static void main(String[] args) {
        CallBackTest test=new CallBackTest();
        test.testTime();
    }
}
