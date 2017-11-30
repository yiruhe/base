package nio;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NIOTest {

    /**
     *  NIO面向通道 非阻塞
     *
     *
     *  1.缓冲区:
     *      根据不同的类型(boolean除外),提供了相应的缓冲区
     *
     *      t通过allocate()获取缓冲区
     *
     *   缓冲区的方法:
     *      put()
     *      get()
     *
     *     属性:
     *      capacity: 容量 表示缓冲区最大存储数据的容量,一旦声明不能改变
     *      limit: 界限 表示缓冲区可操作数据的大小(limit后的数据不能读写)
     *      position: 位置 缓冲区正在操作数据的位置
     *      mark : 标记 记录position的位置,可以通过reset()恢复到mark的位置
     *
     *      直接缓冲区与非直接
     *
     *      非直接: 通过allocate() 方法分配缓冲区  缓冲区在JVM
     *      直接    allocateDirect()  缓冲区在物理内存中
     *
     *
     *      通道: 用于源节点与目标节点的连接.Channel本身不存储数据,必须配合缓冲区
     *
     *          通道的主要实现类
     *                  Channel接口
     *                      -FileChannel
     *                      -Socket...
     *                      -serverSocket..
     *                      -Datagram..
     *
     *          获取通道:
     *              getChannel()
     *              1.7中 个通道提供了静态方法open()
     *               1.7中Files.newByteChannel()
     *
     *
     *      通道之间的数据传输:
     *          transferFrom
     *          transferTo
     *
     *
     *    分散与聚集
     *      分散读取: 将读取的数据分散到多个Buffer
     *      聚集写入: 将多个Buffer聚集到Channel
     *
     *
     */
    @Test
    public void testBuffer(){

        String string = "test";

        //分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(100);

//        System.out.println("limit: "+buffer.limit());
//        System.out.println("position: "+buffer.position());
//        System.out.println("capacity: "+buffer.capacity());

        //利用put存入数据
        buffer.put(string.getBytes());

//        System.out.println("=================================");
//        System.out.println("limit: "+buffer.limit());
//        System.out.println("position: "+buffer.position());
//        System.out.println("capacity: "+buffer.capacity());

        //切换为读取模式 position 回到初始位置 limit 为 数据的大小

        buffer.flip();

        System.out.println("=================================");
        System.out.println("limit: "+buffer.limit());
        System.out.println("position: "+buffer.position());
        System.out.println("capacity: "+buffer.capacity());

    }

    @Test
    public void testChannel() throws Exception{

        System.out.println( new File("1.txt").getAbsolutePath());

        //获取流
        FileInputStream fileInputStream  = new FileInputStream("1.txt");


        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");

        //获取通道
        FileChannel inFileChannel = fileInputStream.getChannel();
        FileChannel outFileChannel = fileOutputStream.getChannel();

        //指定缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(inFileChannel.read(buffer) != -1){

            buffer.flip();

            outFileChannel.write(buffer);

            buffer.clear();
        }

        inFileChannel.close();
        outFileChannel.close();
        fileInputStream.close();
        fileOutputStream.close();

    }


    /**
     *  网络通信:
     *      Channel: 连接
     *      Buffer: 数据存取
     *      selector: 监控连接
     *
     *
     */
    @Test
    public void testClient() throws Exception {

        //获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        //切换非阻塞
        socketChannel.configureBlocking(false);

        //分配缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //发送
        buffer.put("你好".getBytes());

        buffer.flip();

        socketChannel.write(buffer);

        buffer.clear();

        socketChannel.close();


    }


    @Test
    public void testServer() throws IOException {

        //获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);


        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //获取选择器
        Selector selector = Selector.open();


        //将通道注册到选择器上,并监听事件(SelectionKey.OP_ACCEPT)
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);



        //轮询获取选择器已经就绪的事件
        //select 此时处于阻塞状态,有事件发生时返回


        while(true){

            //通道就绪时,选择器才去连接服务器
            selector.select();

         /*   通道触发了一个事件意思是该事件已经就绪。所以，某个channel成功连接到另一个服务器称为“连接就绪”。
            一个server socket channel准备好接收新进入的连接称为“接收就绪”。
            一个有数据可读的通道可以说是“读就绪”。等待写数据的通道可以说是“写就绪”。
         */
            //返回就绪的通道
            Iterator<SelectionKey> it=  selector.selectedKeys().iterator();

            while(it.hasNext()){

                //获取事件
                //可以遍历这个已选择的键集合来访问就绪的通道
                SelectionKey key = it.next();

                //手动移除
                //注意每次迭代末尾的keyIterator.remove()调用。
                // Selector不会自己从已选择键集中移除SelectionKey实例。必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
                it.remove();

                if(key.isAcceptable()){

                    //接受连接
                    SocketChannel socketChannel  =  serverSocketChannel.accept();


                    socketChannel.configureBlocking(false);


                    //设置为读就绪  一个有数据可读的通道可以说是“读就绪“
                    socketChannel.register(selector,SelectionKey.OP_READ);


                }

                if(key.isReadable()){


                     SocketChannel channel =  (SocketChannel)key.channel();

                     ByteBuffer buffer = ByteBuffer.allocate(1024);

                     int len = 0;

                     while((len = channel.read(buffer)) != -1){

                         buffer.flip();

                         System.out.println(new String(buffer.array(),0,len));

                         buffer.clear();
                     }

//                     channel.close();

                }



            }


        }

    }


}
