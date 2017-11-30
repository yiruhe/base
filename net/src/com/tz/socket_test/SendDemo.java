package com.tz.socket_test;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * Created by Administrator on 2017/3/4.
 */
public class SendDemo {



    public static void main(String[] args) throws java.io.IOException {

        DatagramSocket send = new DatagramSocket(10087);

        String data = "你好...........";

        send.send(new DatagramPacket(data.getBytes(),data.length(),InetAddress.getLocalHost(),10086));

        send.close();




    }

}
