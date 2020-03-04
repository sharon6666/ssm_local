package com.javese.集合;

import com.practiceThread.thread1.P;
import com.proxy.cglib.App;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class LinkedBlockingQueueTest {
    static class Apple {
        String color;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Apple(String color) {
            this.color = color;
        }

        public Apple() {
        }
    }

    static class Producer implements Runnable {
        LinkedBlockingQueue<Apple> queueProducer;

        Apple apple;

        public Producer(LinkedBlockingQueue<Apple> queueProducer, Apple apple) {
            this.queueProducer = queueProducer;
            this.apple = apple;
        }

        @Override
        public void run() {
            System.out.println("生产" + apple.getColor() + "的苹果");
            try {
                queueProducer.put(apple);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        LinkedBlockingQueue<Apple> queueConsumer;

        public Consumer(LinkedBlockingQueue<Apple> queueConsumer) {
            this.queueConsumer = queueConsumer;
        }

        @Override
        public void run() {
            Apple app = null;
            try {
                app = queueConsumer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费" + app.getColor() + "的苹果");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        LinkedBlockingQueue<Apple> linkedBlockingQueue = new LinkedBlockingQueue<Apple>();
        Apple red = new Apple("红色");
        Apple green = new Apple("绿色");
        Producer p1 = new Producer(linkedBlockingQueue, red);
        Producer p2 = new Producer(linkedBlockingQueue, green);
        Consumer consumer = new Consumer(linkedBlockingQueue);
        p1.run();
        p2.run();
        consumer.run();
        Thread.sleep(1000);
    }
}
