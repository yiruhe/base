package com.tz.javaFunction;


public class AbsoluteValue {

	public int abs(int x){
		return (x >= 0)? x :-x;
	}
	public int abs(int x,int b){
		return (x >= 0)? x :-x;
	}
	public int abs(float b,int x){
		return (x >= 0)? x :-x;
	}
	
	public static void main(String[] args){
		
		AbsoluteValue obj = new AbsoluteValue();
	
		int a = obj.abs(-1);
		
		System.out.print(a);
	}
}
