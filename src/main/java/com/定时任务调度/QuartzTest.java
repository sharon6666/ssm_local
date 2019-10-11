package com.定时任务调度;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;

import java.util.Date;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.定时任务调度
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-9 13:41
 * @UpdateUser:
 * @UpdateDate: 2019-10-9 13:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class QuartzTest {
    /**
     * 虽然ScheduledExecutorService对Timer进行了线程池的改进，但是依然无法满足复杂的定时任务调度场景。
     * 因此OpenSymphony提供了强大的开源任务调度框架：Quartz。Quartz是纯Java实现，
     * 而且作为Spring的默认调度框架，由于Quartz的强大的调度功能、灵活的使用方式、还具有分布式集群能力，
     * 可以说Quartz出马，可以搞定一切定时任务调度！
     *
     * Quartz的体系结构
     */

    public static void main(String[] args) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "myGroup")
                .usingJobData("name", "wangxue")
                .build();
        //每两秒执行一次，直到永远
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName", "triggerGroup")
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .startNow()
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("执行 ： " + new Date() + ","  + jobExecutionContext.getJobDetail()
                .getJobDataMap().get("name"));
    }
}
//https://cloud.tencent.com/developer/article/1347336
