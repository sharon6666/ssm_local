package com.utils.thread1;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread1
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 18:40
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 18:40
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Thread_P extends Thread{
    private P p;
    public Thread_P(P p){
        super();
        this.p = p;
    }

    @Override
    public void run(){
        while (true)
        p.pushService();
    }
}
