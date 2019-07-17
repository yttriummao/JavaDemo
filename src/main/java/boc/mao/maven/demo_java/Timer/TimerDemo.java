package boc.mao.maven.demo_java.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 
 * timer.schedule 每次执行时间为上一次任务结束起向后推一个时间间隔; 取决于每次任务执行的时间长短，是基于不固定时间间隔进行任务调度
 * 
 * timer.scheduleAtFixedRate 每次执行时间为上一次任务开始起向后推一个时间间隔; 是基于固定时间间隔进行任务调度
 * 
 * 当执行任务的时间大于周期间隔时，会发生什么呢？
 * 
 * 结论
 * schedule：下一次的执行时间点=上一次程序执行完成的时间点+间隔时间
 * 
 * scheduleAtFixedRate：下一次的执行时间点=上一次程序开始执行的时间点+间隔时间
 * */

public class TimerDemo extends TimerTask 
{
	private String JobName = "";
	
	public TimerDemo(String JobName)
	{
		super();
		this.JobName = JobName;
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = new Date();
		System.out.println(myFmt.format(dt) + " execute " + this.JobName);
	}
	
	public static void main(String[] args)
	{
		Timer timer = new Timer();
		
		long delay1 = 1 * 1000;
		long period1 = 1000;
		
		//每隔一秒钟执行一次job
		timer.schedule(new TimerDemo("firstJob"), delay1, period1);
		
		long delay2 = 2 * 1000;
		long period2 = 2000;
		timer.schedule(new TimerDemo("secondJob"), delay2, period2);
	}
	
	
	/*
	   原理

		Timer 的设计核心是一个 TaskQueue 和一个 TimerThread。Timer 将接收到的任务丢到自己的 TaskQueue中。TimerThread 在创建 Timer 时会启动成为一个守护线程。这个线程会轮询所有任务，找到一个最近要执行的任务，然后休眠，当到达最近要执行任务的开始时间点，TimerThread 被唤醒并执行该任务。之后 TimerThread 更新最近一个要执行的任务，继续休眠。
		
		优缺点
		
		Timer 的优点在于简单易用;
		
		但由于所有任务都是由同一个线程来调度，因此所有任务都是串行执行的，同一时间只能有一个任务在执行
		
		前一个任务的延迟或异常都将会影响到之后的任务。
	
	 */
	
	
	
	
	
	
	
	
	
	
	
}


















