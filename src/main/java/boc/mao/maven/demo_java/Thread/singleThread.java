/**
 * 
 */
package boc.mao.maven.demo_java.Thread;

/**
 * @author: 猪本聪
 * @description:  
 * @date: 2018年11月17日
 */
public class singleThread extends Thread
{
	singleThread(String name)
	{
		super(name);
		
		start();
	}

	public void run() 
	{
		System.out.println(getName() + "开始执行 ...");
		try
		{
			this.sleep(1000);
			System.out.println(getName() + "执行结束");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("主进程开始执行 >>>");
		int count = 1;
		
		while(count <= 10)
		{
			singleThread sonThread = new singleThread("子进程" + count);
			
			count ++;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
