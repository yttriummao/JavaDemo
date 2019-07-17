/**
 * 
 */
package boc.mao.maven.demo_java.Thread.Exception;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: 猪本聪
 * @description:  在主进程中捕捉“线程的异常”
 * @date: 2018年12月24日
 */
public class Catch implements Callable<String>
{
	Catch(){};

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public String call() throws Exception {
		throw new RuntimeException();
	}
	
	
	public static void main(String[] args)
    {
		ExecutorService exec = Executors.newCachedThreadPool();
        Catch c1 = new Catch();
        Future<String> future = exec.submit(c1);
        
        try
        {
        	//毛：注意! 必须调用future.get()方法才能捕获线程中的异常
        	//System.out.println(future.get());
        	future.get();
        }
        catch(Exception e)
        {
            System.out.println("捕捉线程中的异常 ==> " + e.toString());
        }
    }
	
	
	
	
	
	
	
}
