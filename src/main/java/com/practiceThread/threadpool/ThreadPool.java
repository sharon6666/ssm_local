package com.practiceThread.threadpool;

import com.practiceThread.thread3.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread.threadpool
 * @Description: note
 * @Author: https://blog.csdn.net/u011974987/article/details/51027795
 * @CreateDate: 2019-9-3 10:25
 * @UpdateUser:
 * @UpdateDate: 2019-9-3 10:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ThreadPool {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        }
    }

    public static void main(String[] args){

        //线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
        ExecutorService cachedPool = Executors.newCachedThreadPool();

        /*for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cachedPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }*/

        //因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        fixedThreadPool.execute(t1);
        fixedThreadPool.execute(t2);
        fixedThreadPool.execute(t3);
        fixedThreadPool.execute(t4);
        fixedThreadPool.shutdown();
        /*for(int i=0;i<10;i++){
            final int index =i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }*/

        //创建一个定长线程池，支持定时及周期性任务执行。
        //表示延迟3秒执行。

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        scheduledThreadPool.schedule(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("delay 3 seconds");
//            }
//        }, 3, TimeUnit.SECONDS);
//
//        //表示延迟1秒后每3秒执行一次。
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("delay 1 seconds, and excute every 3 seconds");
//            }
//        }, 1, 3, TimeUnit.SECONDS);

        //newSingleThreadExecutor：
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

        /*
        这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
        如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            singleThreadExecutor.execute(new Runnable() {
//                @OverrideAtomicStampedReference
//                public void run() {
//                    try {
//                        System.out.println(index);
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
    }
}
