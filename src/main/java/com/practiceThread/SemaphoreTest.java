package com.practiceThread;

import net.sourceforge.htmlunit.corejs.javascript.EcmaError;

import java.util.concurrent.Semaphore;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-14 15:55
 * @UpdateUser:
 * @UpdateDate: 2019-8-14 15:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class SemaphoreTest {
    //创建一个计数阙值是5的信号量对象
    //只能同时有5个线程访问
    public static void main(String[] args) {
        Semaphore sema = new Semaphore(5);
        try {
            sema.acquire();
            try {
                //业务逻辑
            }catch (Exception e){

            }finally {
                sema.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
