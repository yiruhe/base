package com.tz.JavaInterger;

public class JavaInteger {
	
       

	public  static void main(String[] args) {
	new JavaInteger();
	
		//表达式都是有结果的,于是就可以定义一个变量去接受, 比如: 1 + 1  就是一个表达式 结果就要接受
	
	    //无符号(unsigned)数中，所有的位都用于直接表示该值的大小。有符号数中最高位用于表示正负，
		//float 整数就不用  强转
		//由于 浮点默认是double 所以不行
		//1.引用数据类型和基础类型他们值必须相同都是true
		//2： 如果两个引用数据类型比较，那么就不用== 而用 equals
		//equals   原始状态 equals 和== 是相同的东西  基本数据 比较的是 值，引用数据比较的 地址是否相等
		//==
		//类型转换  10L L就代表常量标记  （类型）10

        // i== i+= 等于  T i = (T)i++ 或者 i+= num
        // 自增、自减运算符只能作用于变量

        //表达式自动提升,


        //最大值数据加1，数据溢出会变成最小值
        //最小值数据减一，溢出会变成最大值
//		byte a = 100;
//		int b =a;
//		int c = a;
//		float d = c;
//		double f = a;
//		float g = 1 << 3;
//		double l = 2.2423666E+1;
		/*System.out.println(a+"="+b+"="+c+"="+d+"="+f);
		System.out.println(g);
		System.out.println();

		//科学计数法 底数是10
		3.14E2 == 314.0

        // >> 符号位右移,用符号位补
        //>>> 无符号右移,用0填充
        //符号扩充:用符号位补

		*/
		Integer  aa =  10;
		Integer bb =  aa;
		bb = 20;
//		System.out.println(aa);

        int x = 130;
        byte y = (byte)x;
        //System.out.println(y);



    	byte a = 1;
    	byte b = 2;
//    	byte c = a + b;  //int
    	
//    	System.out.println(c);
        



        //s1+= 1;相当于s1 = (short)(s1 + 1);其中有隐含的强制类型转换。
//        byte q = 10;
//        short w = 10;
//        short e = (short)(q+w);

        //. 它们的运算结果的类型与被运算的变量的类型相同。
        
        //Integer 先是转成基本数据,然后++,然后回到Integer
//          byte a = 10;
//          byte b = a+=10;
//

       // System.out.println(b);

    	
    	//除long的基本数值类型(byte,short,char),字符串和枚举类型 也都是转化为int进行判断的
		
		
	}
}
