package com.practiceThread;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-12 11:37
 * @UpdateUser:
 * @UpdateDate: 2019-10-12 11:37
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class SellTicket {
    public static void main(String[] args){
        Ticket tt = new Ticket();
        for(int i = 0; i < 4; i ++) {   //四个线程来卖票
            new Thread(tt).start();
        }

    }
}

class Ticket implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
//        while (ticket > 0){
            synchronized (this) {
                if (ticket > 0) {
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "线程， 现在剩余票数为： " + ticket);
                }
            }
//        }
    }
}
