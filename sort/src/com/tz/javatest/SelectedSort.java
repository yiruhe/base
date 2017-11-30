package com.tz.javatest;


public class SelectedSort {



    public static void main(String[] args){

        int[] arr = {55,66,1,2,0,6,44,33};

        //打擂台排序    //8个数只需要比较7次
        for(int i = 0;i<arr.length - 1;i++){

            int min = i;

            for(int j=i+1;j<arr.length;j++){ //依次比较

                if(arr[min] > arr[j]){

                        min  = j;

                }

            }

            //i不等于min是就证明a[min]不是最小的，
            //i等于min时证明a[i]就是本轮比较过程中最小的值
            if(min != i){

                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }

        for(int i :arr){

        System.out.print(i+"===");
        }


    }

}
