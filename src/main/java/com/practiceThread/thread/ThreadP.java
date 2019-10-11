package com.practiceThread.thread;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-16 19:42
 * @UpdateUser:
 * @UpdateDate: 2019-7-16 19:42
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ThreadP extends Thread{
    private P p;
    public ThreadP(P p){
        super();
        this.p = p;
    }

    @Override
    public void run(){
        while (true)
        p.setValue();
    }
}
