/**
 * 
 */
package boc.mao.maven.demo_java.Log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * @author: 猪本聪
 * @description:  
 * @date: 2019年5月22日
 */

public class Log4jUtil 
{
	private static String LOGPATH = "src/log4j.properties";
	
	public static Logger getLogger()
	{
		//读取使用Java的特性文件编写的配置文件
        PropertyConfigurator.configure(LOGPATH);
        
        Logger LOGGER = LogManager.getLogger("");
        
        return LOGGER;
	}
	

	public static Logger getLogger(String name)
	{
		//读取使用Java的特性文件编写的配置文件
        PropertyConfigurator.configure(LOGPATH);
        
        Logger LOGGER = LogManager.getLogger(name);
        
        return LOGGER;
	}
	
	@CallerSensitive
	public static Logger getClassLogger(String className) throws ClassNotFoundException
	{
		Class<?> clazz = Class.forName(className);
		
		//读取使用Java的特性文件编写的配置文件
        PropertyConfigurator.configure(LOGPATH);
        
        
        Logger LOGGER = LogManager.getLogger(clazz);
        
        return LOGGER;
	}
	
	
}








