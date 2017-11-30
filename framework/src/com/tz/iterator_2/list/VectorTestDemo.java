package com.tz.iterator_2.list;


import java.util.Vector;
public class VectorTestDemo {



    public static void main(String[] args) {

        Vector vector = new Vector();
        // 集合中只能装对象
        //java5之前,装基本数据类型,需要手动装箱,Integer.valueOf(1);
        //

//        vector.add  和addElement是两个一样的方法,addElement是历史遗留问题
        //集合中存放的都是引用

//        Stack类继承与Vector  底层实现就是数组
        //Stack  和 ArrayDeque 都是栈结构,优先使用ArrayDeque;


        //Queue  单项队列  //只能头删除，尾添加  接口
        //Deque  双向队列 //头尾都能添加删除  接口


        vector.add(1);
        vector.add(2);
        vector.add(3);

        Vector v = new Vector();

        v.add("A");
        v.add("B");
        v.add("C");
        v.add(1);

//        v.add(vector);
//        v.addAll(vector);
//        System.out.println(v);
//        System.out.println(v.get(0));

//        v.containsAll(vector); //并集
        v.retainAll(vector); //交集
        System.out.println(v);

        v.toArray();  //返回一个新数组





    }


}
