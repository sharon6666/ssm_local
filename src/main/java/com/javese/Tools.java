package com.javese;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-14 16:10
 * @UpdateUser:
 * @UpdateDate: 2019-10-14 16:10
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Tools {

    /**
     * 测试函数使用时间，通过定义CallBack接口的execute方法
     *
     * @param callBack
     */
    public void testTime(CallBack callBack) {
        long begin = System.currentTimeMillis(); //测试起始时间
        callBack.execute(); ///进行回调操作
        long end = System.currentTimeMillis(); //测试结束时间
        System.out.println("[use time]:" + (end - begin)); //打印使用时间
    }

    public static void main(String[] args) {
        Tools tool = new Tools();
        tool.testTime(new CallBack() {
            //定义execute方法
            public void execute() {
                //这里可以加放一个或多个要测试运行时间的方法
                CallBackTest.testMethod();
            }
        });
    }
}