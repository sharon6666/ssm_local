package com.practiceThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class SellTickets {
    AtomicInteger tickets = new AtomicInteger(100);

    class Seller implements Runnable {
        @Override
        public void run() {
            while (tickets.get() > 0) {
                int tmp = tickets.get();
                if (tickets.compareAndSet(tmp, tmp - 1)) {
                    System.out.println(Thread.currentThread().getName() + ":" + tmp);
                }
            }
        }
    }

    public static void main(String[] args){
        SellTickets ss = new SellTickets();
        new Thread(ss.new Seller(), "sellerA").start();
        new Thread(ss.new Seller(), "sellerB").start();
    }
}
