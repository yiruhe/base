package com.file.path;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PathDemo {

    static List<String> list = new ArrayList<String>();

    public static void main(String[] args){


        File file = new File("E:/javase/视频/String","StringTest01.java");


        System.out.println(file.getPath());

        run(file);

        Collections.reverse(list);

        System.out.println(list);



    }


    static void run(File f){

        File file = f.getParentFile();

        if(file != null){


            if(!"".equals(file.getName())){

                list.add(file.getName());
            }


           run(file);
        }



    }


}
