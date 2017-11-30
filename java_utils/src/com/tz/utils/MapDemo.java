package com.tz.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import java.util.Set;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Comparator;
public class MapDemo {
	
	public static void main(String[] args){
		//linkedHashSet 是有序的 ， HashSet是无序的
		LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object>();
		//key是由Set维护关系  value有LinkedList去维护关系的
		map.put("a","小1"); //--> 每个键值实际是一个entry对象
		map.put("b","小2");
		map.put("cc","小3");
		map.put("d","小4");
		map.put("df","小5");
		
		System.out.println(map);
//			返回一个key数组
		//System.out.println(map.keySet());
//		for(String key : map.keySet()){
//			
//			System.out.println(map.get(key));
//		}
		//拿到a的 value
		//System.out.println(map.get("a"));
		//删除并返回 value
		//System.out.println(map.remove("a"));
		//是否存在
//		System.out.println(map.containsKey("b"));
//		map.clear();
//		Collection<String> values = map.values();
//		System.out.println(values);
		
		System.out.println(map.entrySet());
		
//		  for(Entry<String,Object> e : map.entrySet()) {
//		           System.out.println("key:"+e.getKey());
//			       System.out.println("value:"+e.getValue());   
//			 }  
//		  
//		  //Iterator
//		  Set<String> keySet = map.keySet();
//		  Iterator<String> iterator =  keySet.iterator();
//		  
//		  while(iterator.hasNext()){
//			  String key = iterator.next();
//			  System.out.println(map.get(key));
//		  }
		//解决key排序问题
//		TreeMap<Integer,Object> maps = new TreeMap<Integer, Object>(new Comparator<Integer>(){
//			@Override
//			public int compare(Integer o1,Integer o2){
//				
//				return  o2.compareTo(o1);
//			}
//		});
//		maps.put(1, "小1");
//		maps.put(2, "小2");
//		maps.put(3, "小3");
//		maps.put(4, "小4");
//		maps.put(5, "小5");
//		maps.put(6, "小6");
//		maps.put(7, "小7");
//		maps.put(8, "小8");
//		for(Entry<Integer,Object> e:maps.entrySet()){
//			System.out.println(e.getKey()+"====="+e.getValue());
//			
//		}
		//如果在treemap里面想按照value排序，就必须借助工具类Collections.sort(List,comparator);
		TreeMap<String,String> maps = new TreeMap<String,String>();
		maps.put("1","aaa");
		maps.put("2","bbb");
		maps.put("3","ccc");
		maps.put("4","ddd");
		maps.put("5","eee");
		maps.put("6","fff");
		ArrayList<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(maps.entrySet()); 
		
		
		Collections.sort(list,new Comparator<Map.Entry<String,String>>(){
			@Override
			public int compare(Map.Entry<String,String> o1,Map.Entry<String,String> o2){
				
				return o1.getValue().compareTo(o2.getValue());
				
			}
		});
		
		for(Map.Entry<String,String> m: list){
			
			
			System.out.println(m.getKey()+"===="+m.getValue());
			
		}
		
		
	}
}
