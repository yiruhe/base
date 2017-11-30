package com.tz.OI2;

/**
 *
 * Created by Administrator on 2017/1/26 0026.
 */
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;

public class HomeWorkURLDemo
{

    public static void main(String[] args){

        BufferedReader bf =null;
        BufferedWriter bw = null;
      try{
          //拿到网址
          URL url = new URL("http://www.qq.com/");
          //打开网址
          URLConnection connection= url.openConnection();
          //获取字符输入流
          InputStream in = connection.getInputStream();
          //使用缓冲输入流
           bf = new BufferedReader(new InputStreamReader(in,"gbk"));

          String content = null;
          StringBuilder str = new StringBuilder();
          while((content =bf.readLine()) != null){


              str.append(content);

          }

          File file = new File("f:/1.html");

          //创建一写入缓存区
          bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"gbk"));

          bw.write(str.toString());

          bw.flush();
      }catch(MalformedURLException me){

          me.printStackTrace();

      }catch(IOException ie){

          ie.printStackTrace();
      }finally{

          try{

              if(bf != null)bf.close();
              if(bw != null)bw.close();

          }catch(IOException e){

              e.printStackTrace();
          }

      }


    }

}
