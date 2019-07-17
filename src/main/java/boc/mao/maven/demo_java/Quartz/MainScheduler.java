package boc.mao.maven.demo_java.Quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author 猪本聪
 * @time 2018年4月3日 - 下午4:22:28
 * 
 * 说明：创建任务调度，并执行
 */

public class MainScheduler 
{
	//创建调度器
    public static Scheduler getScheduler() throws SchedulerException
    {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }
    
    
    
    public static void schedulerJob() throws SchedulerException
    {
    	/*
    	 * 创建任务 JobDetail 
    	 * 
    	 * 定义的是任务数据，而真正的执行逻辑是在Job中
    	 * 为什么设计成JobDetail + Job，不直接使用Job？这是因为任务是有可能并发执行，如果Scheduler直接使用Job，就会存在对同一个Job实例并发访问的问题。
    	 * 而JobDetail & Job 方式，sheduler每次执行，都会根据JobDetail创建一个新的Job实例，这样就可以规避并发访问的问题。
    	 * */
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class) //定义Job类为MyJob类，这是真正的执行逻辑所在
        		                        .withIdentity("job1", "group1") //定义name/group
        		                        .build();
        
        //创建触发器 每3秒钟执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3") //定义name/group
                                        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()) //每隔三秒执行一次
                                        .build();
        
        // Scheduler 可以将 Trigger 绑定到某一个 JobDetails 中，这样当 Trigger 被触发时，对应的 Job 就被执行。一个 Job 可以对应多个 Trigger，但一个 Trigger 只能对应一个 Job。
        Scheduler scheduler = getScheduler();
        //将任务及其触发器放入调度器
        scheduler.scheduleJob(jobDetail, trigger);
        //调度器开始调度任务
        scheduler.start();
        
    }
    
    
    public static void main(String[] args) throws SchedulerException 
    {
        MainScheduler mainScheduler = new MainScheduler();
        mainScheduler.schedulerJob();
    }
    
    
}












