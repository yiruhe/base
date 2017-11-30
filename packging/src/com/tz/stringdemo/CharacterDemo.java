package com.tz.stringdemo;

public class CharacterDemo {

	public static void main(String[] args){
		
		//一边是基础类型  == 号比较的就是值
		// Integer  有缓存  大于或小于  -128 ~ 127  那么就使用new
		//引用数据 类型的  不能比
		//-128 ~ 127  取得是同一个 所以 true
		//不能被继承，都使用了final
		//switch 也可以使用 包装类  因为底层 自动拆箱
//          可以放入String ，（character 除外）
        //当一个方法被修饰为final方法时，意味着编译器可能将该方法用内联(inline)方式载入，所谓内联方式，是指编译器不用像平常调用函数那样的方式来调用方法，而是直接将方法内的代码通过一定的修改后copy到原代码中(将方法主体直接插入到调用处，而不是进行方法调用)。
//		包装器的缓存：
//		boolean：(全部缓存)
//		byte：(全部缓存)
//		character(0 - 127缓存)
//		short(-128 — 127缓存)
//		long(-128 — 127缓存)
//		integer(-128 — 127缓存)
//		float(没有缓存)
//		double(没有缓存)

		//八大包装类都是用final修饰的,只能使用不能继承

        //Number 下有 的方法有6种包装类装基本类的的方法 intValue  byteValue shortValue floatValue doubleValue

        //基本类型个String之间的转换:   前提 注入的字符串可以转化成数值
		Integer a = 1000;
		Integer b = a;
		Integer c = 1000;
		Integer d = 1000;

		//两种方式装箱
		Integer aa = new Integer(10);
		Integer bb = Integer.valueOf(10);  //带有缓存

		//拆箱
		int num = aa.intValue();

		Object obj = 17;
//		1) 自动装箱  Integer i = 17
//		2) 向上转型  Object obj = i;
		int i = (Integer)obj;

//		System.out.println(b);
//		System.out.println(b == a);
//		System.out.println(c == d);
		
		b = 800;
		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(a.equals(b));
		
		
		Boolean oo = Boolean.valueOf("true");

	}
}
