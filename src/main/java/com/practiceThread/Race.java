package com.practiceThread;

import com.practiceThread.thread1.C;

import java.util.concurrent.CountDownLatch;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-11 13:45
 * @UpdateUser:
 * @UpdateDate: 2019-10-11 13:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 *  CountDownLatch强调的是一个线程（或多个）需要等待另外的n个线程干完某件事情之后才能继续执行。 上述例子，main线程是裁判，5个AWorker是跑步的。
 *  运动员先准备，裁判喊跑，运动员才开始跑（这是第一次同步，对应begin）。
 *  5个人谁跑到终点了，countdown一下，直到5个人全部到达，裁判喊停（这是第二次同步，对应end），然后算时间。
 **/
public class Race {
    public static void main(String[] args){
        final int num = 5;
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(num);

        for(int i=0;i<num;i++) {
            new Thread(new ARunner(i, begin, end)).start();
        }

        // judge prepare...
        try {
           Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("judge says run!");
        begin.countDown();

        long startTime = System.currentTimeMillis();
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            long endTime = System.currentTimeMillis();
            System.out.println("judge says all arrived!");
            System.out.println("spend " + (endTime - startTime));
        }
    }
}

class ARunner implements Runnable{
    final CountDownLatch begin;
    final CountDownLatch end ;
    final int id;

    public ARunner(final int id, final CountDownLatch begin, final CountDownLatch end){
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run(){
        System.out.println(this.id + " is ready");
        try {
            begin.await();
            Thread.sleep((long)Math.random() * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(this.id + " is arrived");
            end.countDown();
        }
    }
}