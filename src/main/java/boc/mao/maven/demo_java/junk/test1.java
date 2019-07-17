/**
 * 
 */
package boc.mao.maven.demo_java.junk;

/**
 * @author: 猪本聪
 * @description:  
 * @date: 2019年1月25日
 */


public class test1 
{
	
	objA obja;
	
	public void func()
	{
		obja = new objA();
		obja.setName("毛钇");
		System.out.println("obja name is ==> " + obja.getName());
		changeName(obja);
		System.out.println("now obja name is ==> " + obja.getName());
		
		int num = 1;
		System.out.println("num is ==> " + num);
		changeNum(num);
		System.out.println("now num is ==> " + num);
		
		String str1 = "java";
		String str2 = "java";
		
		changeStr1(str1, str2);
		System.out.println("str1 ==> " + str1);
		System.out.println("str2 ==> " + str2);
	}
	
	public void changeName(objA obja)
	{
		obja.setName("谢丹");
	}
	
	public void changeNum(int num)
	{
		num = 2;
	}
	
	public void changeStr1(String str1, String str2)
	{
		str1 = "java mao";
		str2 = str2 + " mao";
	}
	
	class objA
	{
		String name;

		public objA() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	
	
	public static void main(String[] args)
	{
		test1 t = new test1();
		t.func();
		
		String sql = " where 1=0 ";
		String order = " order by a ";
		String countSql = String.format("SELECT COUNT(*) FROM %s t %s", sql, order);
		System.out.println("countSql ==> " + countSql);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
