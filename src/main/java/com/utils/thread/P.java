package com.utils.thread;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread
 * @Description: note
 * @Author: 1
 * @CreateDate: 2019-7-16 16:36
 * @UpdateUser: 1
 * @UpdateDate: 2019-7-16 16:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class P {
    private String lock;
    public  P(String lock){
        super();
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                while (ValueObject.value.equals("")){
                    System.out.println("P "+ Thread.currentThread().getName()+ "要开始wait了");
                    lock.wait();
                }
                System.out.println("P "+ Thread.currentThread().getName()+ "要开始runnable了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
