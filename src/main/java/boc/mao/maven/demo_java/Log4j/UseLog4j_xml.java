package boc.mao.maven.demo_java.Log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author 猪本聪
 * @time 2018年4月11日 - 上午11:36:01
 * 
 * 说明：log4j.xml简单配置样例说明
 */


public class UseLog4j_xml {
    //日志记录器
    private static Logger LOGGER = LogManager.getLogger(UseLog4j_xml.class);
    //程序入口——主函数
    public static void main(String[]args) {
        //读取使用Java的特性文件编写的配置文件
        DOMConfigurator.configure( "src/log4j.xml" );
        //输出日志信息，测试日志级别的作用（配置在配置文件中），仅仅输出大于等于目前有效级别的日志信息
        LOGGER.debug("[1]-my level is DEBUG 天");
        LOGGER.info("[2]-my level is INFO");
        LOGGER.warn("[3]-my level is WARN");
        LOGGER.error("[4]-my level is ERROR");
    }
}
