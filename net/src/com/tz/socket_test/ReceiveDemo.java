package com.tz.socket_test;

import java.net.DatagramSocket;
import java.net.DatagramPacket;

/**
 * Created by Administrator on 2017/3/4.
 */
public class ReceiveDemo {


    public static void main(String[] args) throws java.io.IOException{
        //DatagramSocket本身只是码头，不维护状态，不能产生IO流，它的唯一作用就是接收和发送数据报，Java使用DatagramPacket来代表数据报，DatagramSocket接收和发送的数据都是通过DatagramPacket对象完成的

        //创建socket对象
        DatagramSocket receive = new DatagramSocket(10086);

        DatagramPacket packet =  new DatagramPacket(new byte[1024],1024);
        //接收数据
        receive.receive(packet);

        String str = new String(packet.getData(),0,packet.getData().length);

        System.out.println(str);
        receive.close();


    }




}
