package com.utils.thread2;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread2
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 19:39
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 19:39
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Test {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args){
        if(t1.get() == null){
            System.out.println("现在没有值");
            t1.set("设值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
//        Mythread mythread = new Mythread();
//        mythread.start();
//        try {
//            mythread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("等threadTest线程结束了我再执行吧 可以么？");


    }
}
