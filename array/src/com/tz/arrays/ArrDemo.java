package com.tz.arrays;


public class ArrDemo {



    public static void main(String[] args){

        //关于多维数组的理解
        //多维数组  int[][] arr = new int[length][]
        //定义多少维，就使用几个中括号就可以了
        //数组中的数组如果没有指定大小，那么就使用null进行的初始化
        //类型是又是一个数组

        //底层类似这样吧
        int[][] arr1 = new int[4][];
        arr1[0] = null;


        //静态初始化
            //简写版：
                int[] arrs = {1,2,3};   //使用这种方式定义时，就必须进行初始化，否者无法判断是否是数组

                //错误的写法
                //int[] arr = null;
                //arr = {1,2,3};

    }
}
