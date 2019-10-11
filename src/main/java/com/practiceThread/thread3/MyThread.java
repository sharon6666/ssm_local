package com.practiceThread.thread3;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread3
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 20:04
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 20:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MyThread extends Thread{
    private MyService myService;

    public MyThread(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run(){
        myService.testReen();
    }

    public static void main(String[] args){
        MyService myService = new MyService();
        MyThread myThread = new MyThread(myService);
        myThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        myService.signal();
    }
}
