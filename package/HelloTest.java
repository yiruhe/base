package com.tz.packagedemo;

import com.tz.util.Hello;

public class HelloTest{

		public static String name = "小明";
			
        public static void main(String[] args){
          
			//	这里使用系统默认编码。。。。
			//	如果有中文字符 就要更改编码 javac -encoding utf-8 文件名.java
            //javac -d . 文件名.java 
            //-d 
				//生成目录
			//encoding参数
			//	官方的参数说明为：指定源文件使用的字符编码。
			//	在javac中，如果在编译时不指定编码，那么就使用系统的默认编码。win7中文系统默认编码为GBK
            //java 包名  --> 运行这个文件
            //. 
			// 当前目录
            //为什么只有一个public class 因为每个编译单元都只能有一个公共接口，用public类来表现。
			//该接口可以按照要求包含众多的支持包访问权限的类。如果有一个以上的public   类，编译器就会报错。  并且public类的名称必须与文件名相同（严格区分大小写）。  当然一个编译单元内也可以没有public类。 
            //没有加public 的类 就只会被 本包访问了

            Hello hello = new Hello();

			System.out.println(hello.name);
            hello.say();

        }

}