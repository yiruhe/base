package com.tz.utils;

import java.util.TreeSet;
import java.util.Iterator;
public class TreeSetDemo {
	
	public static void main(String[] args) {
		/*
		 *1） HashSet
		 * 	元素无序并且不能重复
		 * 	线程不安全
		 * 	HashSet 是哈希表实现的，里面可以放入null，但是只能放入一个
		 * 	HashCode() 方法是来确定存放的位置，如果没有元素，直接存放这个位置，如果
		 * 有元素存在就调用equals()方法比较，相同就存放，不相同，就散列到其他地方
		 * 2） LinkedHashSet
		 * 	同样根据元素的hashCode值来确定元素的位置。链表维持关系
		 * 3） TreeSet
		 * 	sortedSet接口的唯一实现类。保持处于排序状态,不可以放入null;
		 * 	应该使用Comparator接口，实现int compare(T o1,T o2);
		 * 	Collections.synchronizedList(new HashSet(Integer));
		 * 
		 * */
	
//		TreeSet 不能有重复的 不能有null  默认升序
		TreeSet<Integer> ts = new TreeSet<Integer>(new ComparatorDemo(false));
		ts.add(1);
		ts.add(2);
		ts.add(355);
		ts.add(588);
		ts.add(166);
		ts.add(111);
		ts.add(122);
		ts.add(-451);
		
//		System.out.println(ts.first()+" ");
//		System.out.println(ts.last()+" ");
//		System.out.println(ts.lower(10)+" ");
//		System.out.println(ts.higher(10)+" ");
//		System.out.println(ts.subSet(588,1));
		System.out.println(ts.headSet(2));
		System.out.println(ts.tailSet(111));
		Iterator<Integer> iterator  = ts.iterator();
		
		while(iterator.hasNext()){
			
			System.out.print(iterator.next()+" ");
		}
		
	}

}
