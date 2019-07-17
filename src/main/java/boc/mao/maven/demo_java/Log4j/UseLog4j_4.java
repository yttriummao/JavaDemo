package boc.mao.maven.demo_java.Log4j;

import org.apache.log4j.*;

import java.io.*;

/**
 * @author 猪本聪
 * @time 2018年4月11日 - 上午10:43:11
 * 
 * 说明：如何控制不同目的地的日志输出？
 * 1）这里只列出了五种比较常用的日志输出目的地，还有好多别的，使用到的时候可以在回头看看官方文档，比如：输出到数据库，输出到邮件等等
 * 2）实际工作中使用哪一种，是需要根据具体的业务需求来定的，不过，输出到控制台和输出到通过文件大小的阈值来决定再进行回滚的方式相对使用的比较多
 * 3）注意日志文件的保留大小和份数，如果过大可能会影响对应的主机的使用
 * 4）上线的应用不应将日志信息再往控制台来输出了，往控制台输出的情况，应该只针对代码调试的情形
 * 5）控制日志的输出，我认为针对日志输出的目的地的控制是最为要紧的，所以，这里需要好好的玩玩，彻底能明白输出到每一个合适的目的地到底该如何控制
 */


public class UseLog4j_4 {
    //日志记录器
    private static Logger LOGGER = LogManager.getLogger(UseLog4j_4.class);
    //程序入口——主函数
    public static void main(String[]args) {
        //设置日志信息的格式化方式
        String pattern = "[%d] - %l - %p - %m%n";
        Layout layout = new PatternLayout(pattern);
        /**
         * 设置日志信息的输出目的地，日志输出的目的地主要有以下几种：
         * 常用的公共属性如下所示：
         * 1）immediateFlush 控制消息是否立即被输出，默认值是true,意谓着所有的消息都会被立即输出。
         * 2）encoding 它可以使用任何字符编码，默认情况下是特定于平台的编码方案
         * 3）threshold 指定日志消息的输出最低层次。
         */
        Appender appender= null;

        /**
         * 1）org.apache.log4j.ConsoleAppender（将日志信息输出到控制台）
         *    可以设置日志信息输出的目标，通过 target 属性 或 对应构造方法 来设置，目前有两种属性值可选 System.out 和 System.err 默认是System.out
         */
//        appender = new ConsoleAppender(layout);
//        appender = new ConsoleAppender(layout,"System.err");

        /**
         * 2）org.apache.log4j.FileAppender（将日志信息输出到一个文件）
         *    将日志信息输出到文件中时可以设置一些控制属性，比如：
         *    1）filename    日志文件的名称，日志文件的全路径
         *    2）fileAppend    控制日志信息是否被附加到同一个文件的末尾，默认为true，意味着日志信息会被附加到同一文件的末尾
         *    3）bufferedIO    控制日志信息是否写入缓存，默认为false，意味着日志信息不会写入缓存之中
         *    4）bufferSize    如果 bufferedI/O 启用，表示缓冲区的大小，默认设置为8KB
         */
//        try {
//            appender = new FileAppender(layout,"D:/log4j/testFileAppender.log");
//            appender = new FileAppender(layout,"D:/log4j/testFileAppender.log",false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * 3）org.apache.log4j.DailyRollingFileAppender（将日志信息输出到一个文件，但是这个文件是可控的，可以配置多久产生一个新的日志信息文件），
         *    DailyRollingFileAppender 继承自 FileAppender，所以他有 FileAppender 的所有非私属性，同时他也多了一个控制何时产生一个新的日志文件的属性 datePattern
         *
         *    datePattern 有以下几种属性值：
         *    1：'.'yyyy-MM    Rollover at the beginning of each month
         *    At midnight of May 31st, 2002 /foo/bar.log will be copied to /foo/bar.log.2002-05.
         *    Logging for the month of June will be output to /foo/bar.log until it is also rolled over the next month.

         *   2：'.'yyyy-ww    Rollover at the first day of each week.
         *    The first day of the week depends on the locale.
         *    Assuming the first day of the week is Sunday, on Saturday midnight, June 9th 2002, the file /foo/bar.log will be copied to /foo/bar.log.2002-23.
         *    Logging for the 24th week of 2002 will be output to /foo/bar.log until it is rolled over the next week.

         *   3：'.'yyyy-MM-dd    Rollover at midnight each day.
         *    At midnight, on March 8th, 2002, /foo/bar.log will be copied to /foo/bar.log.2002-03-08.
         *    Logging for the 9th day of March will be output to /foo/bar.log until it is rolled over the next day.

         *   4：'.'yyyy-MM-dd-a    Rollover at midnight and midday of each day.
         *    At noon, on March 9th, 2002, /foo/bar.log will be copied to /foo/bar.log.2002-03-09-AM.
         *    Logging for the afternoon of the 9th will be output to /foo/bar.log until it is rolled over at midnight.

         *   5：'.'yyyy-MM-dd-HH    Rollover at the top of every hour.
         *    At approximately 11:00.000 o'clock on March 9th, 2002, /foo/bar.log will be copied to /foo/bar.log.2002-03-09-10.
         *    Logging for the 11th hour of the 9th of March will be output to /foo/bar.log until it is rolled over at the beginning of the next hour.

         *    6：'.'yyyy-MM-dd-HH-mm    Rollover at the beginning of every minute.
         *    At approximately 11:23,000, on March 9th, 2001, /foo/bar.log will be copied to /foo/bar.log.2001-03-09-10-22.
         *    Logging for the minute of 11:23 (9th of March) will be output to /foo/bar.log until it is rolled over the next minute.
         *
         *    For example, if the File option is set to /foo/bar.log and the DatePattern set to '.'yyyy-MM-dd, on 2001-02-16 at midnight,
         *    the logging file /foo/bar.log will be copied to /foo/bar.log.2001-02-16 and logging for 2001-02-17 will continue in /foo/bar.log
         *    until it rolls over the next day.
         *
         *    上面是API中的原文，大概的意思是这样的 DailyRollingFileAppender 这个日志文件存储器的生成原则是根据配置的 datePattern 来决定的，比如：
         *    我们有一个日志文件 /foo/bar.log 我们设置的 datePattern 是 '.'yyyy-MM-dd，在2001-02-16当天的凌晨，就会生成一个新的日志文件了
         *    这个日志文件的名字是 /foo/bar.log.2001-02-16，这个文件的内容使从 /foo/bar.log 这个文件中拷贝过来的
         *    2001-02-17当天产生的日志信息，会继续存放在日志文件 /foo/bar.log 中，以此类推，会不断的产生新的日志文件，过一天就会产生一个
         *
         *    datePattern 有如上六种常见的重新记录日志的规则，翻译成中文大概意思如下所示：
         *    1：'.'yyyy-MM    Rollover at the beginning of each month 每个月的月初，将当前日志文件复制一份，并且在原文件重新记录日志信息，会根据原文件的名称创建一个新的文件

         *   2：'.'yyyy-ww    Rollover at the first day of each week. 每个周的第一天，将当前日志文件复制一份，并且在原文件重新记录日志信息，会根据原文件的名称创建一个新的文件

         *   3：'.'yyyy-MM-dd    Rollover at midnight each day. 每天的凌晨，将当前日志文件复制一份，并且在原文件重新记录日志信息，会根据原文件的名称创建一个新的文件

         *   4：'.'yyyy-MM-dd-a    Rollover at midnight and midday of each day. 每天的凌晨和中午，将当前日志文件复制一份，并且在原文件重新记录日志信息，会根据原文件的名称创建一个新的文件

         *   5：'.'yyyy-MM-dd-HH    Rollover at the top of every hour.每小时结束，将当前日志文件复制一份，并且在原文件重新记录日志信息，会根据原文件的名称创建一个新的文件

         *   6：'.'yyyy-MM-dd-HH-mm    Rollover at the beginning of every minute.每分钟的开始，将当前日志文件复制一份，并且在原文件重新记录日志信息，会根据原文件的名称创建一个新的文件
         */
//        try {
//            appender = new DailyRollingFileAppender(layout,"D:/log4j/testDailyRollingFileAppender.log","'.'yyyy-MM-dd-HH-mm");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * 4）org.apache.log4j.RollingFileAppender（将日志信息输出到一个文件，但是这个文件是可控的，可以指定当文件大小到达指定尺寸的时候产生一个新的文件）
         *    RollingFileAppender 继承自 FileAppender，所以他有 FileAppender 的所有非私属性，同时他也多两个控制产生新日志文件的属性，如下所示：
         *
         * 1）maxFileSize    当日志文件的大小达到此值时，会产生新的日志文件，默认值是10MB
         * 2）maxBackupIndex    此属性表示要创建的备份文件的最大数量，默认值是1，如果此值为零，则不会产生备份的文件
         *
         * 如果进行如下的设置，setMaximumFileSize(2L) setMaxBackupIndex(5) 那么产生日志文件的方式是这样的
         * 第一次运行程序会产生两个日志文件
         * testRollingFileAppender.log testRollingFileAppender.log.1
         * 第二次运行程序会产生三个日志文件
         * testRollingFileAppender.log testRollingFileAppender.log.1 testRollingFileAppender.log.2
         * 。。。
         * 第五次运行程序会产生六个日志文件
         * testRollingFileAppender.log testRollingFileAppender.log.1 testRollingFileAppender.log.2 。。。 testRollingFileAppender.log.5
         * 第n（n>5）次运行程序仍会产生六个日志文件
         * testRollingFileAppender.log testRollingFileAppender.log.1 testRollingFileAppender.log.2 。。。 testRollingFileAppender.log.5
         *
         * 从上面的分析我们，可以看到，当生成的日志备份等于自己定义的个数时就不在生成新的备份文件了，至少从日志文件的名字上看是这样的
         * 但是好玩的地方在于，下面再次运行程序的时候每个日志文件都会发生变化，日志文件从1到5总是保持最新的五份
         * 当我们再次运行程序的时候，会生成一份新的日志文件，它会被命名1，原来的1会被重命名2，原来的2会被重命名3，以此类推，直到所有的日志文件都重新命名为止
         * 最久的那份日志文件会被删除掉
         */
//        try {
//            RollingFileAppender rollingFileAppender = new RollingFileAppender(layout,"D:/log4j/testRollingFileAppender.log");
//            rollingFileAppender.setMaximumFileSize(2L);
//            rollingFileAppender.setMaxBackupIndex(5);
//            appender = rollingFileAppender;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * 5）org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
         *    这个功能很强大，我们自定义日志信息的流向，这里为了方便演示，我就将他他输出到一个文件之中了
         */
        OutputStream os = null;
        try {
            os= new FileOutputStream("D:/log4j.log");
            appender= new WriterAppender(layout,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //设置日志信息的输出配置
        BasicConfigurator.configure(appender);
        //输出日志信息
        LOGGER.info(" my level is INFO");
    }
}