package com.tz.car;

public class Test {


		public static  Car getCar(String name){
			if(name.equalsIgnoreCase("BMW")){
				
				return new BMW();
			}else if(name.equalsIgnoreCase("Ben")){
				return new Ben();
			}
			return null;
		}

}
