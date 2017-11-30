package com.tz.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.Writer;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class URLDemo {



    public static void main(String[] args){

        BufferedReader reader = null;
        BufferedWriter out = null;
        Scanner scanner = null;
        try{


            URL url  = new URL("http://news.baidu.com");

            System.out.println(url.getProtocol());

//               URLConnection connection = url.openConnection();


           // reader = new BufferedReader(new InputStreamReader(url.openStream()));


            out = new BufferedWriter(new FileWriter("E:/Java/net/src/com/tz/socket/test.html"));

             scanner = new Scanner(url.openStream());

            String  len;

            while(scanner.hasNextLine()){

                    out.write(scanner.nextLine());
                    out.newLine();
            }

        }catch(java.io.IOException e){

            e.printStackTrace();

        }finally{

            try{

            if(reader != null)reader.close();

            if(out != null)out.close();

            if(scanner != null)scanner.close();

            }catch(Exception e){

                e.printStackTrace();
            }

        }


    }


}
