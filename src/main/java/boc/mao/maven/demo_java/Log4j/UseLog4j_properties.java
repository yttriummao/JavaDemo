package boc.mao.maven.demo_java.Log4j;

import org.apache.log4j.*;

/**
 * @author 猪本聪
 * @time 2018年4月11日 - 上午11:00:46
 * 
 * 说明：log4j.properties简单配置样例说明
 * 1）使用配置文件来控制日志的输出，相当的灵活方便，对于业务程序本身的耦合性也变得最低了，这也是在实际的工作中常常使用的一种方式
 * 2）我这里为了方便演示和研究配置文件怎么配置的，就没有加入其它框架了，也没有采用建一个JavaWeb项目通过配置文件的方式来控制了，实际工作中应该如此的
 * 3）这里的关注点是配置文件怎么配置，我在注释中做了足够多的说明，如果看过前面的博文，对于这些东西相对一定很容易理解，毕竟日志框架就是干这些事情的
 * 4）这里列举的配置方式并不完整，毕竟还有许多的日志输出目的地不在其内，不过他们是常用的
 * 5）每一个还是要好好的试验一下，理解起来才更深刻的，否则下次项目出问题了，项目负责人让你解决，你都不知道到哪里找日志文件来分析的
 */

public class UseLog4j_properties 
{
    //日志记录器
    private static Logger LOGGER = LogManager.getLogger(UseLog4j_properties.class);
    //程序入口——主函数
    public static void main(String[]args) 
    {
        //读取使用Java的特性文件编写的配置文件
        PropertyConfigurator.configure( "src/log4j.properties" );
        //输出日志信息，测试日志级别的作用（配置在配置文件中），仅仅输出大于等于目前有效级别的日志信息
        LOGGER.debug("[1]-my level is DEBUG Godtrue 说：今天天气很好呀！");
        LOGGER.info("[2]-my level is INFO");
        LOGGER.warn("[3]-my level is WARN");
        LOGGER.error("[4]-my level is ERROR");
    }
}



