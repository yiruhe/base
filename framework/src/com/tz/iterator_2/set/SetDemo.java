package com.tz.iterator_2.set;


import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class SetDemo {

    public static void main(String[] args){
        //Set:
        // 都不是线程安全的 不允许元素重复
        //无序是指添加先后顺序
        //按照打印按照hash数字中的位置

//        Hash表: 当往HashSet集合中添加新的对象的时候,先往判断该对象和集合对象中的hasCode值:
//            1):不等: 直接把该新的对象存储到hasCode指定的位置
//            2):再继续判断对象和集合对象中的equals做比较
//                    >1:hashCode相同,equals,为true,则视为同一个对象,不保存在hasHash表中。
//                    >2:hashCode相同,equals为false,存储在同hashCode对象的链表上(也就是之前的对象同槽位).(这种是最麻烦的);
        //最好的方式,hasCode相同,equals相同

        //定义一个泛型集合,用泛型去接收,如果接收不加泛型，就是擦除泛型
        //set不保证元素添加的有序性

        //元素值 --> hash(value) --某种映射关系 --> 元素存储索引

        //，默认情况下，数组大小为16，那么当HashMap中元素个数超过16*0.75=12（这个值就是代码中的threshold值，也叫做临界值）的时候，就把数组的大小扩展为 2*16=32，即扩大一倍，
//        然后重新计算每个元素在数组中的位置，而这是一个非常消耗性能的操作，
        Set<String> set = new HashSet<String>();

        //Set<String>  : 定义泛型接收, 使用 String的泛型
        //“参数化类型"

        set.add("!");
        set.add("A");
        set.add("B");
        set.add("C");
//
//        for(String key:set){ //因为使用了泛型,编译后会强转
//
//            System.out.println(key);
//        }

        // //假如iterator 不加泛型就是擦去泛型
        Iterator<String> iterator = set.iterator();  //iterator返回一个泛型对象

        while(iterator.hasNext()){

            System.out.println(iterator.next());

        }



    }
}
