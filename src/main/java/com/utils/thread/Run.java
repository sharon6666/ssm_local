package com.utils.thread;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-16 19:47
 * @UpdateUser:
 * @UpdateDate: 2019-7-16 19:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Run {
    public static void main(String[] args){
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadC[] threadCS = new ThreadC[2];
        ThreadP[] threadPS = new ThreadP[2];
        for(int i=0;i<2;i++){
            threadPS[i] = new ThreadP(p);
            threadPS[i].setName("生产者" + (i+1));
            threadCS[i] = new ThreadC(c);
            threadCS[i].setName("消费者" + (i+1));
            threadPS[i].start();
            threadCS[i].start();

        }
    }
}
