package com.tz.inside;

/**
 * Created by Administrator on 2017/1/29 0029.
 */
public class CoverDemo {


    public static void main(String args[]){

        M m = new M();
        m.say();
    }


}

class N{

    String name = "A";

    public void say(){

        System.out.println(name);
    }

}

class M extends N{

    String name = "B";
     public void say(){

        System.out.println(name);
    }




}