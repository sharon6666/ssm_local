package com.定时任务调度;

import com.practiceThread.thread.ThreadP;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.定时任务调度
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-9 13:21
 * @UpdateUser:
 * @UpdateDate: 2019-10-9 13:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class TimerTest implements Runnable{
    public static void main(String[] args) {
        /**
         * Timer的一些缺陷？
         *
         * 前面已经提及到Timer背后是一个单线程，因此Timer存在管理并发任务的缺陷：所有任务都是由同一个线程来调度，所有任务都是串行执行，意味着同一时间只能有一个任务得到执行，而前一个任务的延迟或者异常会影响到之后的任务。
         * 其次，Timer的一些调度方式还算比较简单，无法适应实际项目中任务定时调度的复杂度。
         */
//        Timer timer = new Timer();
//        Calendar calendar = Calendar.getInstance();
//        timer.scheduleAtFixedRate(new MyTask(), calendar.getTime(), 5000);

        /**
         * JDK对定时任务调度的线程池支持：ScheduledExecutorService
         * 由于Timer存在的问题，JDK5之后便提供了基于线程池的定时任务调度：ScheduledExecutorService。
         * 设计理念：每一个被调度的任务都会被线程池中的一个线程去执行，因此任务可以并发执行，而且相互之间不受影响。
         */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleAtFixedRate(new TimerTest(), 1000, 2000, TimeUnit.MILLISECONDS);

    }

    @Override
    public void run(){
        System.out.println(" 执行： " + new SimpleDateFormat("hh:mm:ss").format(new Date()));
    }
}

class MyTask extends TimerTask{
@Override
    public void run(){
    System.out.println("execute time start is :" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            .format(this.scheduledExecutionTime()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
