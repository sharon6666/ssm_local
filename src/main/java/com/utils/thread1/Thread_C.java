package com.utils.thread1;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread1
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 17:05
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 17:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Thread_C extends Thread {
    private C c;
    public Thread_C(C c){
        super();
        this.c = c;
    }

    @Override
    public void run(){
        while (true)
            c.pullService();
    }
}
