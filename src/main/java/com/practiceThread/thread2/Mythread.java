package com.practiceThread.thread2;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread2
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 19:37
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 19:37
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Mythread extends Thread {
    @Override
    public void run(){
        int secondValue = (int)(Math.random() * 10000);
        System.out.println(secondValue);
        try {
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
