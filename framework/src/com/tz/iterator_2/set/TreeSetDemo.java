package com.tz.iterator_2.set;

import java.util.TreeSet;

public class TreeSetDemo {
    //TreeSet 会对元素进行默认排序,所以必须保证添加的元素同一种类型
    //底层红黑树
    //数字:按照数字大小排序
    //Character:按照Unicode排序 --> Unicode和Ascii码前128个是一样的
//    String:按字符串每个Character排序
    //出现同一个对象不添加

    //comparable和comparator区别:
//      如果对象要排序就要实现排序规则
//        comparable是一个类定义的时候实现好的接口
//        comparator是专门定义一个类的比较规则,属于挽救比较操作

    public static void main(String[] args){
        TreeSet<Person> tree = new TreeSet<Person>();

        tree.add(new Person("b",20));
        tree.add(new Person("a",11));
        tree.add(new Person("c",38));
        tree.add(new Person("d",12));



        System.out.println(tree);



    }


}


class Person implements Comparable<Person>{

    private String name;
    private int age;


    Person(String name,int age){

        this.name = name;
        this.age = age;


    }

    public int compareTo(Person o){


        if(this.age>o.age){

            return -1;

        }else if(this.age<o.age){

            return 1;
        }



        return 0;


    }

    public String toString(){

        return this.name+"=="+this.age;



    }



}
