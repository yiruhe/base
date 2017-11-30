package com.tz.utils;

import java.util.HashSet;
import java.util.Iterator;
public class SetDemo {
	
	public static void main(String[] args) {
//		HashSet<Integer> set = new HashSet<Integer>();
//		//不能有重复的
//		set.add(1);
//		set.add(23);
//		set.add(3);
//		set.add(15);
//		set.add(15);
//		set.add(16);
//		System.out.println(set);
		
		HashSet<StudentsDemo> su = new HashSet<StudentsDemo>();
		HashSet<StudentsDemo> su2 = new HashSet<StudentsDemo>();
		su.add(new StudentsDemo("1号",23));
		su.add(new StudentsDemo("2号",23));
		su.add(new StudentsDemo("3号",23));
		su.add(new StudentsDemo("4号",23));
		su.add( new StudentsDemo("5号",23));
		su2.add(new StudentsDemo("6号",23));
		su2.add(new StudentsDemo("7号",23));
		su.addAll(su2);
		
		Iterator<StudentsDemo> iterator = su.iterator();
		System.out.println(su.containsAll(su2));
		while(iterator.hasNext()){
			
			StudentsDemo s = iterator.next();
			System.out.println("姓名"+s.getName()+"年龄"+s.getAge());
		}
	}

}
