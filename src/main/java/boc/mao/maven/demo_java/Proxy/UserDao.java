/**
 * 
 */
package boc.mao.maven.demo_java.Proxy;

/**
 * @author: 猪本聪
 * @description:  目标对象
 * @date: 2019年7月17日
 */


/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao 
{
    public void save() 
    {
        System.out.println("----已经保存数据!----");
    }
}
