package com.tz.socket;


import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingDemo {

    public static void main(String[] args){

        try{

        String encode = URLEncoder.encode("测试 12 345","UTF-8");

        System.out.println(encode);

        String decoder = URLDecoder.decode(encode,"UTF-8");
        System.out.println(decoder);


        }catch(java.io.UnsupportedEncodingException e){

            e.printStackTrace();

        }



    }


}
