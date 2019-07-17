package boc.mao.maven.demo_java.Log4j;

import  org.apache.commons.logging.Log; 
import  org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator; 

import org.apache.log4j.*;

/**
 * @author 猪本聪
 * @time 2018年4月11日 - 下午3:19:35
 * 
 * 说明：Log4j和commons log的整合
 */

public class Log4j_CommnsLogging 
{
	//使用common-logging的方式记录日志  (对比下面的方法)
	private static Log Log  =  LogFactory.getLog(Log4j_CommnsLogging.class);
	
	//使用log4j的方式记录日志
	//private static Logger Log  =  Logger.getLogger(Log4j_CommnsLogging. class);
	
	
	public void commnsLogging()
	{
		Log.debug( " 111 " );  
		Log.info( " 222 " );  
		Log.warn( " 333 " );  
		Log.error( " 444 " );  
		Log.fatal( " 555 " ); 
	}
	
	public static void main(String[] args)
	{
		Log4j_CommnsLogging lc = new Log4j_CommnsLogging();
		
		PropertyConfigurator.configure("src/log4j.properties");
		
		lc.commnsLogging();
	}
	
}





