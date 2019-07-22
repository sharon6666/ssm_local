package com.utils.thread1;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread1
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 18:42
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 18:42
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Run {
    public static void main(String[] args){
        MyStack myStack = new MyStack();
        P P = new P(myStack);
        C c = new C(myStack);


        P P2 = new P(myStack);
        C c2 = new C(myStack);

        P P3 = new P(myStack);
        C c3 = new C(myStack);

        Thread_P pp = new Thread_P(P);
        Thread_C cc = new Thread_C(c);

        Thread_P pp2 = new Thread_P(P2);
        Thread_C cc2 = new Thread_C(c2);

        Thread_P pp3 = new Thread_P(P3);
        Thread_C cc3 = new Thread_C(c3);

        pp.start();
        cc.start();

        pp2.start();
        cc2.start();

        pp3.start();
        cc3.start();
    }
}
