package com.tz.iterator_2.arrays;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysDemo {

        public static void main(String[] args){


            //Collection接口中有一个方法可以将集合转换为Object的数组 toArray

            //数组也可以转化为集合(list)
            // 数组转化为list对象

            List<String> list = Arrays.asList("a","b","C");
            //通过asList返回的对象,不是java.util.ArrayList而是Arrays类的内部类对象
            //通过这个方法得到的List对象,长度是固定的,不能增加或者减少

            List<Integer> list1 = Arrays.asList(2,1,3,4); //这里会自动装箱
            int[] arr = new int[]{21,12,3,4};
//    List<Integer> list3 = Arrays.asList(arr); //这里是吧arr看成一个数组对象,而不是里面的元素
//        --->
//        List<int[]> list3 = Arrays.asList(arr);
            Integer[] arr1 = new Integer[]{21,12,3,4};
            List<Integer> list3 = Arrays.asList(arr1);

            System.out.println(list3);

            List collections =Collections.emptyList();


        }



}
