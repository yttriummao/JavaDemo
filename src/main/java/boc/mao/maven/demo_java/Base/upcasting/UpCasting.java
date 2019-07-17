/**
 * 
 */
package boc.mao.maven.demo_java.Base.upcasting;

/**
 * @author: 猪本聪
 * @description:  向上转型示例
 * @date: 2019年1月30日
 */

// 父类
class Father
{
	public void say()
	{
		System.out.println("父亲说...");
	}
}

// 子类
class Son extends Father
{
	@Override
	public void say() 
	{
		System.out.println("儿子说...");
	}
	
}

public class UpCasting 
{
	
	
	// 测试"向上转型"
	public void say(Father father)
	{
		father.say();
	}
	
	
	public static void main(String[] args)
	{
		// 向上转型
		Father ft = new Son();
		ft.say();
		
		// 向上转型精简代码
		UpCasting upcasting = new UpCasting();
		Father father = new Father();
		upcasting.say(father);
		Son son = new Son();
		upcasting.say(son);
		
	}
}












