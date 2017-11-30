package com.tz.randomtest;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.UUID;

public class RandomTest {


    public static void main(String[] args){

        Random r1 = new Random(1);

        System.out.println(r1);
        System.out.println(r1.nextInt());
        System.out.println(r1.nextBoolean());
        System.out.println(r1.nextDouble());
        System.out.println(r1.nextFloat());

        //jdk1.7 ThreadLocalRandom  Random的子类

        ThreadLocalRandom tr = ThreadLocalRandom.current();


        System.out.println(tr.nextFloat());
        System.out.println(tr.nextInt(0,179));



        int[][] arr = new int[4][];
        Random a = new Random(10);
        //种子相同，得到的随机数也相同
        //随机数是通过算法得出的
        Random b = new Random(10);

        System.out.println(a.nextInt());
        System.out.println(b.nextInt());

        Math.random();
//        System.out.println(System.nanoTime());
//        System.out.println(System.currentTimeMillis());
        //System.currentTimeMillis()返回的毫秒，这个毫秒其实就是自1970年1月1日0时起的毫秒数。
        //　System.nanoTime()返回的是纳秒，nanoTime而返回的可能是任意时间，甚至可能是负数。



        //　System.currentTimeMillis调用的是native方法，使用的是系统的时间，每个JVM对应的应该是相同的，但因为具体的取值依赖于操作系统的实现，不同JVM间可能会有略微的差异。

        //System.nanoTime每个JVM维护一份，和系统时间无关，可用于计算时间间隔，比System.currentTimeMillis的精度要高。
        //System.nanoTime 也可以用来计算一段程序的执行时间


        //ThreadLocalRandom是java7新增的类，是Random的子类


        //UUID 随机字符串
        //UUID是一个128长的数字，一般使用16进制表示，算法核心思想是结合机器的网卡，当前系统时间，随机数来生成的UUID
        //我们一般来表示：随机的唯一字符串




        //关于instaceof的一些理解:
            //左边的实例和右边的类要有一定的继承关系，编译时要通过cast，否则error;
            //这里Object是UUID的父类，所以是可以的

            //instanceof运行时原理就是测试强制类型如果转换失败，就return false;

        Object uuid =  UUID.randomUUID().toString();

        String aa = "10";
        int bb = 20;

//        boolean flag = aa.equalsIgnoreCase();





        System.out.println(uuid instanceof UUID);

    }
}
