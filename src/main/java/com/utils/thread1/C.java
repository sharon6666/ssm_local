package com.utils.thread1;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread1
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 18:36
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 18:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class C {
    private MyStack stack;
    public C(MyStack stack){
        super();
        this.stack = stack;
    }
    public void pullService(){
        System.out.println("pull" + stack.pull());
    }
}
