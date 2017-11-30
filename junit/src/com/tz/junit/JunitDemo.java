package com.tz.junit;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2017/3/8.
 */
//必须继承 TestCase
public class JunitDemo extends TestCase {

//    @Before  --> @Test --> @After

    //如果有多个@Test 还会先执行@Before  后执行@After
    //每一个测试方法都会运行一次setUp tearDown
    //目标类和测试类要放在同一包下，
	
//	junit3.x  是java5以前的测试方式
	//添加junit3测试jar,添加到项目中  BuildPath -->add Libraries --> junit3.x

    //方法名称必须以test开头，没有参数，无返回值，是公开的，可以抛出异常
	//方法 必须是  public void testXXX() throws Exception {}  XXX表示对象或者模块


    //测试之前运行
    @Override
    protected void setUp() throws Exception {

        System.out.println("setUP");

    }

    protected void tearDown(){

        System.out.println("tearDown");

    }



    // 不以test开头不会执行
   public void testDelete()throws Exception{

        System.out.println("testDelete");

    }

    public void testSave(){

       System.out.println("testSave");

    }



}
