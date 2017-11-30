package com.tz.OI2;

/**
 * Created by Administrator on 2017/1/23 0023.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class FileInputDemo {



    public static void main(String[] agrs){
        FileInputStream fs = null;
        try{

         fs = new FileInputStream("F:/2.txt");
         int temp = 0;
         while((temp = fs.read()) != -1){

             System.out.print((char)temp+"\t");
         }

        }catch(FileNotFoundException e){

            e.printStackTrace();

        }catch(IOException e){

            e.printStackTrace();
        }finally{

            try{

                if(fs != null)fs.close();
            }catch(IOException e){

                e.printStackTrace();
            }
        }



    }
}
