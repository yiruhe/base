package com.tz.javatest;

import java.util.Scanner;

public class HelloWord {

	public static void main(String[] args) {
		/**
		 * 录入人员信息
		 */
		System.out.print("输入录入人员信息的个数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//建立一个二维数组存储信息
		String[][] person = new String[num][4];
		for(int i=0;i<person.length;i++){
			System.out.println("请输入第"+(i+1)+"个人的信息");
			System.out.println("请输入人员的名字:");
			person[i][0] = sc.next();
			System.out.println("请输入人员的年龄:");
			person[i][1] = sc.next();
			System.out.println("请输入人员的身高:");
			person[i][2] = sc.next();
			System.out.println("请输入人员的性别:");
			person[i][3] = sc.next();
		}
		//遍历一下二维数组
		for (int  i= 0;  i< person.length; i++) {
			
				System.out.println("人员信息");
			for(int j=0;j<person.length;j++){
				
				System.out.println(person[i][j]+"\t");
			}
            System.out.println();
		}
	}
}
