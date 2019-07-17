/**
 * 
 */
package boc.mao.maven.demo_java.Proxy.DynamicProxy;

import boc.mao.maven.demo_java.Proxy.IUserDao;
import boc.mao.maven.demo_java.Proxy.UserDao;

/**
 * @author: 猪本聪
 * @description:  动态代理测试类
 * @date: 2019年7月17日
 */


/**
 * 动态代理测试类
 */
public class App 
{
    public static void main(String[] args) 
    {
        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class boc.mao.maven.demo_java.Proxy.UserDao】
        System.out.println("原始的类型 : " + target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println("内存中动态生成的代理对象 : " + proxy.getClass());
        System.out.println("");

        // 执行方法   【代理对象】
        proxy.save();
    }
}













