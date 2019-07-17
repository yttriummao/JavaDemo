package boc.mao.maven.demo_java.Log4j;

import org.apache.log4j.*;

/**
 * @author 猪本聪
 * @time 2018年4月11日 - 上午9:52:02
 * 
 * 说明：
 */


//by godtrue
public class UseLog4j_2 
{
	//日志记录器
    private static Logger LOGGER = LogManager.getLogger(UseLog4j_2.class);
    //程序入口——主函数
    public static void main(String[]args){
        //设置日志信息的格式化方式
        String pattern = "%l ---> %p ---> %m%n";
        //设置日志信息输出的风格样式
        Layout layout = new PatternLayout(pattern);
        //设置日志信息的输出目的地
        Appender appender= new ConsoleAppender(layout);
        //设置日志信息的输出配置
        BasicConfigurator.configure(appender);
        /**
         * 日志输出的级别，主要有以下几种：
         * 1）ALL    打印各级日志信息包括自定义级别。
         * 2）TRACE    最详细的信息。一般这些信息只记录到日志文件中。自版本1.2.12[3]。
         * 3）DEBUG    流经系统的详细信息。一般这些信息只记录到日志文件中。
         * 4）INFO    令人感兴趣的运行时事件（启动/关闭）。一般这些信息将立即呈现在状态控制台上，因而要保守使用，并保持到最低限度。
         * 5）WARN    使用已过时的API，API的滥用，潜在错误，其他不良的或意外的运行时的状况（但不一定是错误的）。一般这些信息将立即呈现在状态控制台上。
         * 6）ERROR    其他运行时错误或意外情况。一般这些信息将立即呈现在状态控制台上。
         * 7）FATAL    导致应用程序提前终止的严重错误。一般这些信息将立即呈现在状态控制台上。
         * 8）OFF    最高级别，用于关闭日志记录。
         *
         * 日志的级别之间的大小关系如右所示：ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF
         *
         * Log4j建议只使用四个级别，优先级从高到低分别是 ERROR > WARN > INFO > DEBUG。
         * 通过在这里定义的级别，您可以控制到应用程序中相应级别的日志信息的开关。
         * 比如：在这里如果定义了INFO级别，则应用程序中所有DEBUG级别的日志信息将不被打印出来，但是 ERROR > WARN > INFO 这三者的日志信息能够正常打印
         */

        /**
         * 设置日志的级别，为了加深日志级别的作用的印象，你可以试试设置一下各个级别，看看对日志信息输出的控制：
         *     public static final Level OFF = new Level(2147483647, "OFF", 0);
         *     public static final Level FATAL = new Level('썐', "FATAL", 0);
         *     public static final Level ERROR = new Level('鱀', "ERROR", 3);
         *     public static final Level WARN = new Level(30000, "WARN", 4);
         *     public static final Level INFO = new Level(20000, "INFO", 6);
         *     public static final Level DEBUG = new Level(10000, "DEBUG", 7);
         *     public static final Level TRACE = new Level(5000, "TRACE", 7);
         *     public static final Level ALL = new Level(-2147483648, "ALL", 7);
         */
        LOGGER.setLevel(Level.INFO);
        //打印当前的日志信息有效级别
        LOGGER.fatal("the effective level is : "+LOGGER.getEffectiveLevel());
        //测试日志级别的作用，仅仅输出大于等于目前有效级别的日志信息
        LOGGER.trace("my level is TRACE");
        LOGGER.debug("my level is DEBUG");
        LOGGER.info(" my level is INFO");
        LOGGER.warn(" my level is WARN");
        LOGGER.error("my level is ERROR");
        LOGGER.fatal("my level is FATAL");
    }
}