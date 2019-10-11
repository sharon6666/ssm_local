package com.practiceThread.thread4;

import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread4
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-18 10:39
 * @UpdateUser:
 * @UpdateDate: 2019-7-18 10:39
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class FutureTaskTest {
    Callable<String> shanxian = new Callable<String>() {
        @Override
        public String call() throws Exception {
            for(int i=0;i<10;i++){
                System.out.println("闪现中。。。");
                Thread.sleep(1000);
            }
            return "闪现完成";
        }
    };

    Callable<String> dongjie = new Callable<String>() {
        @Override
        public String call() throws Exception {
            for(int i=0;i<10;i++){
                System.out.println("冻结中。。。。");
                Thread.sleep(1000);
            }
            return "冻结完成";
        }
    };

    public static void main(String[] args){
        FutureTaskTest futureTaskTest = new FutureTaskTest();
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask shanxian = new FutureTask<String>(futureTaskTest.shanxian);
        FutureTask dongjie = new FutureTask<String>(futureTaskTest.dongjie);

        executorService.submit(shanxian);
        executorService.submit(dongjie);

        try {
            System.out.println(shanxian.get());
            System.out.println(dongjie.get());
            System.out.println("kill an enemy");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
