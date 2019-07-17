package boc.mao.maven.demo_java.Log4j;

import org.apache.log4j.*;

/**
 * @author 猪本聪
 * @time 2018年4月11日 - 上午10:37:39
 * 
 * 说明：如何控制不同风格的日志信息的输出？
 * 下面的代码将几种常用的日志输出风格都列出来了，感兴趣的话，可以将注释解注，试验一下效果
 */


//by godtrue
public class UseLog4j_3 
{
  //日志记录器
  private static Logger LOGGER = LogManager.getLogger(UseLog4j_3.class);
  //程序入口——主函数
  public static void main(String[]args){
      /**
       * 设置日志信息输出的风格样式，日志输出的风格主要有以下几种，可以各自设置一下，看看对应的效果
       */

      /**
       * 1）org.apache.log4j.HTMLLayout ，以HTML表格形式布局，输出的信息为：
       * 1：从layout（布局）的构建到日志事件创建所经过的毫秒数
       * 2：生成该日志事件的线程的名称
       * 3：日志事件的优先级，即DEBUG，INFO，WARN，ERROR
       * 4：日志事件的category（类别），通常就是所在类的全名
       * 5：代码中指定的消息
       */
       Layout layout = new HTMLLayout();

      /**
       * 2）org.apache.log4j.SimpleLayout，输出的信息为：
       * 1：日志事件的优先级，即DEBUG，INFO，WARN，ERROR
       * 2：代码中指定的消息
       */
       //Layout layout = new SimpleLayout();

      /**
       * 3）org.apache.log4j.TTCCLayout，输出的信息为：
       * 1：从layout（布局）的构建到日志事件创建所经过的毫秒数
       * 2：生成该日志事件的线程的名称
       * 3：日志事件的优先级，即DEBUG，INFO，WARN，ERROR
       * 4：日志事件的category（类别），通常就是所在类的全名
       * 5：代码中指定的消息
       */
       //Layout layout = new TTCCLayout();

      /**
       * 4）org.apache.log4j.PatternLayout（可以灵活地指定布局模式），这是实际工作中我们最常用的一种，输出的信息是自定义的，比如：下面的设置
       */
      //设置日志信息的格式化方式
      String pattern = "%l - %p - %m%n";
      //Layout layout = new PatternLayout(pattern);

      //设置日志信息的输出目的地
      Appender appender= new ConsoleAppender(layout);
      //设置日志信息的输出配置
      BasicConfigurator.configure(appender);
      //输出日志信息
      LOGGER.info(" my level is INFO");
  }
}
