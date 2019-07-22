package com.utils.thread1;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.utils.thread1
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-17 16:57
 * @UpdateUser:
 * @UpdateDate: 2019-7-17 16:57
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MyStack {
    private List list = new ArrayList<>();
    synchronized public void push(){
        try {
            while(list.size() == 1) {//if 判断可以用notify 来实现 但是notifyAll的话就要用while 为了不让被通知到的现在去修改资源；
                this.wait();
            }
            list.add("random:" + Math.random());
            this.notifyAll();
            System.out.println("push:" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pull(){
        String str = "";
        try {
            while(list.size() == 0){
                System.out.println("pull操作中的" + Thread.currentThread().getName() + "线程呈wait状态");
                this.wait();
            }
            str = list.get(0) + "";
            list.remove(0);
            this.notifyAll();
            System.out.println("pop:" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }
}
