package com.tz.iterator;

/**
 * Created by Administrator on 2017/1/21 0021.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class ListTest01 {


    public static void main(String[] args){

        //创建一个List集合
        List i = new ArrayList();
        ArrayList a = new ArrayList();

        //添加
        i.add(1);

        i.add(2);

        i.add(3);

        i.add(4);

        i.add(5);

        i.add(1,555);

        Iterator iterator = i.iterator();

        while(iterator.hasNext()){

                System.out.println(iterator.next());
        }


    }
}
