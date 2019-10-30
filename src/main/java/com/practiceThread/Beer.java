package com.practiceThread;

import com.practiceThread.thread.Run;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-11 14:39
 * @UpdateUser:
 * @UpdateDate: 2019-10-11 14:39
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 *
 * 使用cyclicbarrier
 *
 * 定义：是一个同步辅助类，它允许一组线程互相等待，直到到达某个公共的屏障点，所有线程一起继续执行或者返回。
 * 一个特性就是CyclicBarrier支持一个可选的Runnable命令，在一组线程中的最后一个线程到达之后，该命令只在每个屏障点运行一次。
 * 若在继续所有参与线程之前更新此共享状态，此屏障操作很有用。
 *
 * 用法：用计数 N 初始化CyclicBarrier, 每调用一次await，线程阻塞，并且计数+1（计数起始是0），当计数增长到指定计数N时，所有阻塞线程会被唤醒。继续调用await也将迅速返回。
 *
 * 规定五个人只要都跑到终点了，大家可以喝啤酒。但是，只要有一个人没到终点，就不能喝。 这里也没有要求大家要同时起跑
 **/
public class Beer {
    public static void main(String[] args){
        final int count = 5;
        final CyclicBarrier barrier = new CyclicBarrier(count, new Runnable(){
            @Override
            public void run() {
                System.out.println("drink beer!");
            }
        });

        // they do not have to start at the same time...
        for (int i = 0; i < count; i++) {
            new Thread(new Worker(i, barrier)).start();
        }
    }
}

class Worker implements Runnable {
    final int id;
    final CyclicBarrier barrier;

    public Worker(final int id, final CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.id + "starts to run !");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println(this.id + "arrived !");
            this.barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
