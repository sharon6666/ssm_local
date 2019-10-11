package com.practiceThread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread.threadpool
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-9 10:11
 * @UpdateUser:
 * @UpdateDate: 2019-10-9 10:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 3000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        Runnable myRunnable = () -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("---先开启三个线程---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池线程数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("---再开启三个线程---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池线程程数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        Thread.sleep(8000);
        System.out.println("----8秒之后----");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池线程线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        executor.shutdown();

    }
}
