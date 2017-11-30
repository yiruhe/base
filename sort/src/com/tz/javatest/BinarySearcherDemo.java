package com.tz.javatest;

/**
 * Created by Administrator on 2017/2/4 0004.
 */
public class BinarySearcherDemo {



    public static void main(String[] args){

            int[] arr = {1,2,3,4,5,6,7,8,9};
            int key = 10;
            int over = -1;

            //最小索引
            int left = 0;
            //最大索引
            int right = arr.length - 1;

            //假如left > right 就结束循环
            while(left <= right){

                int mid = (left+right) >> 1;

                if(arr[mid] > key){

                    right = mid -1;
                }else if(arr[mid] < key){

                    left = mid +1;
                }else{

                    over = mid;
                    break;
                }

                System.out.println("-----------------");
            }


            System.out.println(over);



    }
}
