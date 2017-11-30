package com.tz.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListDemo {

	public static void main(String[] atgs){
//		ArrayList 动态数组 // 默认10个空间大小
		List<Integer> lists = new ArrayList<Integer>();
		lists.add(1);
		lists.add(1);
		lists.add(1);
		//是否为空
		System.out.println(lists.isEmpty());
		//清空
//		lists.clear();
		//根据索引添加
		lists.add(2,626);
		System.out.print(lists);
//		for(Integer list : lists){
//			
//			System.out.print(list);
//		}
		//元素大小
//		for(int i=0;i<lists.size();i++){
//			System.out.println(lists.get(i));
//		}
//		Iterator<Integer> iterator =  lists.iterator();
//		
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
	}
}
