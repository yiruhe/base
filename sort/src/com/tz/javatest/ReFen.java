package com.tz.javatest;

public class ReFen {

	public static void main(String[] args){
		int arr[] = new int[]{4,9,6,7,1,4,66,8,55,33};
		for(int i=0;i<arr.length;i++){
			//获取待排序的元素
			int temp = arr[i],  //i=2 temp = 6
				//left right mid 都是下标
				left = 0,
				right = i-1,  // i=1
				mid = 0;
			System.out.println(temp+"=="+right+"=="+left);
			//查找区间，直到left大于right；停止查找
			while(left<=right){
				//获取两个之间的下标
				mid = (left+right)/2;  //1
				//temp 小于 取出的他两之间的数字
				if(temp<arr[mid]){
//					那么我的right的下标就要往left这边走,位置应该下于mid
//					那么就是 mid -1
					right = mid -1;  //
				}else{
//					如果取出的这个值大于
					left = mid +1;
				}
				
			}
			
			//先往后移动// i这个值小于她的值都想右移动一个位置，直到j小于left的位置
			for (int j =i-1; j >= left; j--) {
				
				arr[j+1] = arr[j];
			}
			//插入
			System.out.println(arr[left] +"==交换=="+ temp);
			//最后交换位置
			arr[left] = temp;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
