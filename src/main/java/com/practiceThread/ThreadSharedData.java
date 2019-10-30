package com.practiceThread;

import java.util.Random;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-12 14:14
 * @UpdateUser:
 * @UpdateDate: 2019-10-12 14:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 *
 * 会出现两种情况
 * 1.由于线程执行速度，新的随机值将就的随机值覆盖 data 值一样
 * 2.data 值不一样，但 A、B线程都一样
 **/
public class ThreadSharedData {

    private static int data = 0 ;

    public static void main(String[] args) {
        for(int i = 0 ;i<2 ;i++){
            new Thread(new Runnable(){

                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+ " put random data:"+data);
                    new A().get() ;
                    new B().get() ;
                }

            }).start() ;
        }

    }

    static class A {
        public int get(){
            System.out.println("A from " + Thread.currentThread().getName()
                    + " get data :" + data);
            return data ;
        }
    }

    static class B{
        public int get(){
            System.out.println("B from " + Thread.currentThread().getName()
                    + " get data :" + data);
            return data ;
        }
    }


}
