package boc.mao.maven.demo_java.Quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author 猪本聪
 * @time 2018年4月3日 - 下午4:22:28
 * 
 * 说明：创建要被定执行的任务类
 */


public class MyJob implements Job
{

	// JobExecutionContext保存了job的上下文信息，比如绑定的是哪个trigger
	public void execute(JobExecutionContext arg0) throws JobExecutionException 
	{
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(" execute job at " + sdf.format(new Date()));
	}
	
}
