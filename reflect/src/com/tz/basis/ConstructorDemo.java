package com.tz.basis;

/**
 *
 * Created by Administrator on 2017/3/5.
 */
import java.lang.reflect.Constructor;
public class ConstructorDemo {

    //每一个构造器都是constructor的实例
    //创建对象,必须和new一起使用,不然就是去调用这个方法

    //外界可访问,无参数 可以直接Class new对象

    public static void main(String[] args) throws Exception{

        Class<User> c = User.class;

        //获取构造器
        Constructor<User> constructor =  c.getConstructor();
        //使用构造器对象的newInstance构造对象

        User user = constructor.newInstance();

        Constructor<User> constructor2 = c.getDeclaredConstructor(String.class);

        constructor2.newInstance("小A");

    }
}


class User{

    public User(){

        System.out.println("**************");
    }

    User(String name){


        System.out.println(name);

    }

    private User(String name,int age){

        System.out.println(name+"==="+age);

    }


}
