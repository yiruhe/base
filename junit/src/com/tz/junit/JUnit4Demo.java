package com.tz.junit;

/**
 * Created by Administrator on 2017/3/9.
 */

import org.junit.*;

public class JUnit4Demo {


    @BeforeClass  //和类一起初始化

    //被注释为 BeforeClass和AfterClass 的方法必须为static方法。
    public static void saveTest(){

        System.out.println("....save....");

    }
    @Before
    public  void initTest(){

        System.out.println("....save....");

    }

    //断言报异常
    //报错断言成功
    @Test(expected=ArithmeticException.class)
    public void runTest(){

        System.out.println("run");
    }

    @Test(timeout=2000)
    public void deleteTest(){


        System.out.println("delete");

    }
    @After
    public  void doneTest(){

        System.out.println("....done....");

    }

    @AfterClass  //最后
    public static void lastTest(){


        System.out.println("done");

    }




}
