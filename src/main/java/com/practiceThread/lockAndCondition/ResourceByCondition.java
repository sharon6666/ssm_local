package com.practiceThread.lockAndCondition;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class ResourceByCondition {
    private String name;
    private int count = 0;
    private boolean flag = false;
    Lock lock = new ReentrantLock();

    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    public void producer(String name) {
        lock.lock();
        try {
            while (flag) {
                producer_con.await();
            }
            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "...生产者5.0..." + this.name);
            flag = true;
            consumer_con.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (!flag) {
                consumer_con.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "...消费者5.0..." + this.name);
            flag = false;
            producer_con.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static class Producer implements Runnable {
        private ResourceByCondition condition;

        Producer(ResourceByCondition condition) {
            this.condition = condition;
        }

        @Override
        public void run() {
            while (true) {
                condition.producer("杭州糕点");
            }
        }
    }

    static class Consumer implements Runnable {

        private ResourceByCondition resourceByCondition;

        Consumer(ResourceByCondition resourceByCondition) {
            this.resourceByCondition = resourceByCondition;
        }

        @Override
        public void run() {
            while (true) {
                resourceByCondition.consume();
            }
        }
    }

    public static void main(String[] args) {
        ResourceByCondition r = new ResourceByCondition();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
