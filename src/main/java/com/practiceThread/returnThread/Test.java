package com.practiceThread.returnThread;

import org.apache.ibatis.executor.ExecutorException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池使用练习
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread.returnThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-14 14:28
 * @UpdateUser:
 * @UpdateDate: 2019-8-14 14:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Test {

    public static void main(String[] args) throws Exception{

        Callable<String> callable = new MyCallabale("ff");
        FutureTask<String> ft = new FutureTask<String>(callable);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println("ft.get()::::" + ft.get());

        System.out.println("可同时进行线程数：" + Runtime.getRuntime().availableProcessors());
        /**
         * 有返回值的任务必须实现 Callable 接口，类似的，无返回值的任务必须 Runnable 接口。执行
         * Callable 任务后，可以获取一个 Future 的对象，在该对象上调用 get 就可以获取到 Callable 任务
         * 返回的 Object 了，再结合线程池接口 ExecutorService 就可以实现传说中有返回结果的多线程
         * 了。
         */
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ExecutorService pool1 = Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(12);
        List<Future> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Callable c = new MyCallabale( i + "");
            Future f = pool.submit(c);//执行任务并获取Future对象
            list.add(f);
        }
        pool.shutdown();
        for(Future ff : list){
            System.out.println(ff.get().toString());
        }

        /**
         * 基于线程池的方式线程和数据库连接这些资源都是非常宝贵的资源。那么每次需要的时候创建，不需要的时候销毁，
         * 是非常浪费资源的。那么我们就可以使用缓存的策略，也就是使用线程池。
         */
        ExecutorService poola = Executors.newFixedThreadPool(10);
        while (true){
            poola.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "is running");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    static class MyCallabale implements Callable{

        private String i = null;

        public MyCallabale(String i) {
            this.i = i;
        }

        @Override
        public Object call() throws Exception {
            return i + "";
        }
    }
}
