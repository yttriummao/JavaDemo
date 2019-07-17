/**
 * 
 */
package boc.mao.maven.demo_java.Thread.Exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 猪本聪
 * @description:  模拟主进程无法捕捉线程中的异常....
 * @date: 2018年12月24日
 */
public class notCatch implements Runnable
{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() 
	{
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}

	//现象：控制台打印出异常信息，并运行一段时间后才停止
    public static void main(String[] args)
    {
        //就算把线程的执行语句放到try-catch块中也无济于事
        try
        {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new notCatch());
        }
        catch(RuntimeException e)
        {
            System.out.println("无法捕捉线程中的异常 Exception has been handled!");
        }
    }
}
















