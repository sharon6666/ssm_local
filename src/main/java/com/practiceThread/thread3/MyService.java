package com.practiceThread.thread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread3
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 20:01
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 20:01
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void testReen(){
        lock.lock();
        System.out.println("await时间是：" + System.currentTimeMillis());
        try {
            condition.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal(){
        lock.lock();
        try {

            System.out.println("signal时间是：" + System.currentTimeMillis());
            condition.signal();

        }finally {
            lock.unlock();
        }
    }
}
