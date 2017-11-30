package com.tz.socket_test;

/**
 * Created by Administrator on 2017/3/3.
 */
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

public class ServerSocketDemo {


    public static void main(String[] args) throws java.io.IOException {

        //流的关闭会导致socket的关闭
        //关闭此套接字也将会关闭该套接字的 InputStream 和 OutputStream

        //单次交互 阻塞  3种解决方案
        //shutdownInput
        //setTimeout
        //设置读取长度,当读取长度到达时就退出

        //多次 交互就又是另一种实现方式了
        ServerSocket server = new ServerSocket(8888);

        System.out.println("服务启动");
        Socket socket = server.accept();
        System.out.println("链接成功");



       // socket.close();
        socket.setSoTimeout(20);

        //这里关闭输出流,并不关服务区的事
        OutputStream out = socket.getOutputStream();

        out.write("你好啊".getBytes());

        InputStream in = socket.getInputStream();

        int literal;

        while((literal = in.read()) != -1){

            System.out.println((char)literal);
            System.out.println("***************");

        }


        System.out.println(socket.isClosed());
//        out.close();
        System.out.println(server.isClosed());
//        server.close();
        System.out.println(server.isClosed());

    }
}
