package com.tz.node;


public class NodeTest {


    public static void main(String[] args){

        LinkDemo link = new LinkDemo();

        link.add("Hello");
        link.add("world");
        link.add("I");

        link.print();
//
//        System.out.println(link.contains("I"));
//        System.out.println(link.isEmpty());
//        System.out.println(link.size());
//        System.out.println(link.get(2));
        link.remove("world");

        link.print();




    }


}
