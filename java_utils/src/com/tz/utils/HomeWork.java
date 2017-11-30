package com.tz.utils;

import java.util.Calendar;
import java.util.Scanner;
public class HomeWork {
	private Calendar  calendars = Calendar.getInstance();
	private int year,month,date;
	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		
		HomeWork demo = new HomeWork();
		demo.year = demo.getInput("年");
		demo.month = demo.getInput("月");
		demo.date = demo.getInput("日");
		demo.peintView();
		
	}
	
	public int getInput(String str){
		
		System.out.println("请输入..."+str+"");
		
		return scanner.nextInt();
	}
	//打印日历视图
	public void peintView(){
		calendars.set(this.year,this.month - 1,this.date);
		int[][] calDay = new int[6][7];
		//拿到做大天数
		int MaxDays = calendars.getActualMaximum(Calendar.DAY_OF_MONTH);
		//从sunday 开始计算的
//		calendars.set(Calendar.DAY_OF_MONTH,15);
		
		for(int i=1;i<=MaxDays;i++){
			
			calendars.set(Calendar.DAY_OF_MONTH,i);
			//拿到这天是这周的几天
			int dayOfWeek = calendars.get(Calendar.DAY_OF_WEEK)-1;
			//拿到这周是这个月的第几周
			int weekOfMonth =  calendars.get(Calendar.WEEK_OF_MONTH)-1;
			
			//周作为行，星期作为列 放入日
			calDay[weekOfMonth][dayOfWeek] = i;
		}
//		System.out.println(dayOfWeek);
		
		for(int[] weeks : calDay){
			
			for(int day: weeks){
				
				if(day != 0){
					if(day == this.date){
						System.out.print("["+day+"]");
					}else{
						
						System.out.print(day);
					}
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
