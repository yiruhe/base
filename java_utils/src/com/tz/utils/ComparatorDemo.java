package com.tz.utils;

import java.util.Comparator; 

public class ComparatorDemo implements Comparator<Integer>{
	
	boolean flag;
	public  ComparatorDemo(){
		
	}
	public ComparatorDemo(boolean  flag){
		
		this.flag = flag;
		
	}
	public int compare(Integer o1,Integer o2){
		
		if(o1 > o2){
			
			return flag?1:-1;
		}else if(o1 < o2){
			
			return  flag?-1:1;
		}else{
			
			return 0;
		}
	}
	
}
