package com.practiceThread.TwoThread;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread.TwoThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-9-9 9:54
 * @UpdateUser:
 * @UpdateDate: 2019-9-9 9:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MyData {
    private int j=0;

    public synchronized void add(){
        j++;
        System.out.println("线程：" + Thread.currentThread().getName() + " j:" + j);
    }

    public synchronized void desc(){
        j--;
        System.out.println("线程：" + Thread.currentThread().getName() + " j:" + j);
    }

    public int getJ(){
        return j;
    }

}
