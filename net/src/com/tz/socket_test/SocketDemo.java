package com.tz.socket_test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/3.
 */
public class SocketDemo {


    public static void main(String[] args) throws IOException {

        //当关闭输出流输入流的时候,socket也会关闭;
        Socket socket = new Socket("localhost",8888);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();


        out.write("Fuck".getBytes());

        socket.setSoTimeout(30);

        byte[] arr = new byte[1024];
        int len;
        while((len = in.read(arr))!= -1){

            System.out.println(new String(arr,0,len));

        }



        System.out.println(socket.isClosed());
        in.close();
        System.out.println(socket.isClosed());

    }
}
