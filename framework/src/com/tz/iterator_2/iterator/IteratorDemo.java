package com.tz.iterator_2.iterator;


import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class IteratorDemo {



    public static void main(String[] args){

        List list = new LinkedList();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");



        //1:
//        for(int i=0;i<list.size();i++){
//
//
//            System.out.println(list.get(i));
//
//        }


        //2:
//        for(Object o:list){
//
//            System.out.println(o);
//
//        }

        //3:

        Iterator iterator = list.iterator();

        while(iterator.hasNext()){


            list.remove(0);
            System.out.println(iterator.next()); //每次next都会检查

        }

        //ListIterator //双向迭代,从上往下,从下往上迭代
        //Enumeration: //古老的迭代器对象,现在已经被iterator所取代,适用于Vector类


        //iterable  表示可迭代
        //iterator  //迭代器

        //迭代报错:
        //每次迭代都会判断两个线程中元素的数量,如果不等则报并发修改异常
        //当迭代的时候,在当前线程中，会单独创建一个新的线程B
        //A线程负责迭代，B线程负责删除
        //B线程每次迭代都会去检查元素个数是否相同,不是就报错



        //list里面的remove 会删除集合中的元素,但是不会更新迭代其中的个数
        //下次调用next()方法的时候,就会发生错误
        //解决办法;
//        使用iterator的迭代器



        Iterator it = list.iterator();

        while(it.hasNext()){

            it.remove();
        }



    }

}
