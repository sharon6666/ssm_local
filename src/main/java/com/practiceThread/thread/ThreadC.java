package com.practiceThread.thread;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-16 19:46
 * @UpdateUser:
 * @UpdateDate: 2019-7-16 19:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ThreadC extends Thread{
    private C c;
    public ThreadC(C c){
        super();
        this.c = c;
    }

    @Override
    public void run(){
        while (true)
            c.setValue();
    }
}
