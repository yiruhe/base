package com.tz.socket;

import java.net.InetAddress;
import java.util.Arrays;

public class basisDemo {



    public static void main(String[] args){
        // 端口号+IP地址就是一个套接字
        //源IP加目的IP以及源端口和目的端口的组合合称套接字
        //DNS 就是吧域名解析成IP地址,解析域名的第一步实在本机hosts文件，没有就去
        //IP: 是由网段和主机名组成的 子掩码就是分割网段和主机名的

    	//http:超文本传输协议
    	
//    		1.状态码:
//    			1xx:指示信息,表示请求已经接受
//    			2XX:成功:服务器请求已经被成功接受
//    			3xx:重定向
//    			4xx:客户端错误-请求有语法错误或是请求无法实现
//    			5xx:服务器端错误
    	
//    	200 ok
//    	204:无内容,有缓存
//    	400 bad request 请求语法
//    	401 未经授权
//    	403 请求接收到,拒接提供法务
//    	404 请求资源不存在
//    	500服务器发生了不可预知的错误
//    	503服务器当前不能处理客户端的请求
    	
    	
//    	http:80
//    	https:443
    	
        //三要素: ip 端口  协议

//        java中使用InetAddress类表示ip地址
        //ip决定要去哪里  mac地址决定下一站

        //能产生流量的程序 --> 应用层
        //表示层: 传输之前是否加密或压缩

        //URL: 统一资源定位符是对可以从互联网上得到的资源的位置和访问方法的一种简洁的表示(URL(包含如何去访问比如:http))
        //URI = Universal Resource Identifier 统一资源标志符
//        URL = Universal Resource Locator 统一资源定位符
//        URN = Universal Resource Name 统一资源名称
        //URL代表资源的路径地址，而URI代表资源的名称

//        uri:像是一个域名  url:就是如何去访问 通过 http   ftp


        //公钥加密 --> 私钥解密  私钥加密--->公钥解密

        //还有种方式  两边传输数据  使用对称加密加密数据  然后使用公钥加密对称加密的密钥 然后发送出去

        //https 安全套接字(ssl)

       try{

        InetAddress net = InetAddress.getByName("Microsoft-fengche");

        System.out.println(net);
        System.out.println(net.getHostAddress());
        System.out.println(net.getHostName());
        System.out.println(InetAddress.getLocalHost());
        System.out.println(net.isReachable(1000));



        }catch(Exception e){

            e.printStackTrace();
        }


    }


}
