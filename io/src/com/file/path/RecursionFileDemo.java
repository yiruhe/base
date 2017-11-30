package com.file.path;


import java.io.File;

public class RecursionFileDemo {



    public static void main(String[] args){





        File file = new File("F:/网易");

        run(file);

    }


    static void run(File f){



        File[] fileArr = f.listFiles(); //拿到该路径下的所有文件

        for(File k:fileArr){

            System.out.println(k);

            if(k.isDirectory()){


                run(k);

            }


        }



    }



}
