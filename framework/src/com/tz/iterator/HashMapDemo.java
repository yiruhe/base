package com.tz.iterator;

/**
 * Created by Administrator on 2017/1/22 0022.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;

public class HashMapDemo {

  public static void main(String[] args){
      //创建一个Map集合
      Map persons = new HashMap();

      persons.put("1号","java");
      persons.put("2号","javascitpt");
      persons.put("3号","node");
      persons.put("4","vue");
      persons.put("5","jsp");
/*
      //判断大小
      System.out.println(persons.size());
      //判断是否含有这样的key
      System.out.println(persons.containsKey("1号"));
      //判断是否含有这样的value
      System.out.println(persons.containsValue("vue"));
      //get
      System.out.println(persons.get("1号"));
*/

      //获取所有的values
      Collection values = persons.values();

      Iterator iterator = values.iterator();

      while(iterator.hasNext()){

          System.out.println(iterator.next());
      }
  }


}
