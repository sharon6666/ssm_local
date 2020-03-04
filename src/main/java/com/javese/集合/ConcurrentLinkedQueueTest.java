package com.javese.集合;

import com.practiceThread.thread.Run;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class ConcurrentLinkedQueueTest {
    public static int threadCount = 1000;
    public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    static class Offer implements Runnable{
        @Override
        public void run(){
            if(queue.isEmpty()){
                String ele = new Random().nextInt(Integer.MAX_VALUE) + "";
                queue.offer(ele);
                System.out.println("入队的元素是" + ele);
            }
        }
    }

    static class Poll implements Runnable{
        @Override
        public void run(){
            if(!queue.isEmpty()){
                String ele = queue.poll();
                System.out.println("取出的元素是" + ele);
            }
        }
    }

    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for(int x=0;x<threadCount;x++){
            pool.submit(new Offer());
            pool.submit(new Poll());
        }
        pool.shutdown();
    }

}
