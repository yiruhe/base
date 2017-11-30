package com.tz.javatest;

public class BubbleSort {

	public static void main(String[] args){
		
		int[] arr = {5,55,1,6,330,22};
		/*//第一次循环，把最大的排在后面，第二次拍好倒数第二个
		 * i是轮数
		 * j用来交换，负责把数移到后面
		 * 
*/		for(int i=1;i<arr.length;i++){
			
			for(int j=0;j<arr.length-i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
}
