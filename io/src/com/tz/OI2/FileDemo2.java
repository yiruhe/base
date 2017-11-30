package com.tz.OI2;



import java.io.File;
import java.io.IOException;
public class FileDemo2 {


    public static void main(String[] args){
/*
          try{

              File file = new File("F:/a/b/c/1.txt");

              File pf = file.getParentFile();

              if(!pf.exists()){

                  pf.mkdirs();
              }
              if(!file.exists()){

                  file.createNewFile();
              }

              System.out.println("成功了");
          }catch(IOException e){

              e.printStackTrace();

          }*/
    	
    	File file = new File(".");
    	
    	System.out.println(file.getAbsolutePath());
    }
}
