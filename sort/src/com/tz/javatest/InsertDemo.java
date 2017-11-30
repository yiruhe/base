package com.tz.javatest;


import java.util.Arrays;

public class InsertDemo {



    public static void main(String[] args){

        int[] arr = new int[]{22,11,555,333,2,4,1,9};

        //假设第一个是排好了的，就从第二个开始

        for(int i=1;i<arr.length;i++){
            //取出第i个,与前面的数进行比较
            int temp = arr[i];
            //表示前面的数的个数
            int in=i;

            //如果temp一直比前一个小，那么一直循环
            while(in>0 && temp<arr[in-1]){

                //移动temp下标前的位置,为temp腾出空间
                arr[in] = arr[in-1];

                in--;

            }

            //找到位置进行赋值
            arr[in] = temp;

        }


        System.out.println(Arrays.toString(arr));

    }

}
