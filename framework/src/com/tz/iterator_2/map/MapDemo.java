package com.tz.iterator_2.map;


import java.util.Map;
import java.util.HashMap;

import java.io.PrintStream;
import java.util.Set;


public class MapDemo {

    //map并没有继承于collection接口

    //Entry(key-value)

    //重复的元素会覆盖 ,key相当于set  value 相当于list

    //Set底层就是相同的算法的Map
    //Set的值作为Map的Value,在使用了一个Object常量作为Value


//    map:

//    HashMap:哈希表 不允许重复   判断标准:--> hashCode相等,equals相等
//    TreeMap: 红黑树--》 不允许重复---判断标准: compareTo,compare返回是否为0
//    LinkedHashMap:链表和哈希表组成,靠链表维护添加的先后顺序
//        HashTable:hashMap的前身
//    Properties:HashTable的子类,要求key和Value都是子类-->hash算法



    //相互转换:
//        直接就可以通过构造器转换  会去掉重复元素
//            map可以间接转换
   public static void main(String[] args){

       Map<String,Object> map = new HashMap<String,Object>();

       map.put("1","1---");
       map.put("2","2---");
       map.put("3","3---");
       map.put("4","4---");

       System.out.println(map.toString());

        Set<String> set = map.keySet();

        for(String s:set){

            System.out.println(s+"==="+map.get(s));
        }


        //entry:
       Set<Map.Entry<String,Object>> s = map.entrySet();

        for(Map.Entry<String,Object> k:s){

            System.out.println(k);

        }

   }


}
