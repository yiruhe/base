package com.file.path;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterDemo {



    public static void main(String[] args){

       /*
       public File[] listFiles(FilenameFilter filter) {
            String ss[] = list();  //获取到当前路径的所有文件
            if (ss == null) return null;
            ArrayList<File> files = new ArrayList<>();
            for (String s : ss) //遍历ss
                if ((filter == null) || filter.accept(this, s)) //符合accept 条件的进入add
                    files.add(new File(s, this));
            return files.toArray(new File[files.size()]);//吧ArrayList变为数组


        }*/



        File file = new File("E:/javase/视频/day22/day22/day22/video");

        File[] arr = file.listFiles(new FilenameFilter(){


            public boolean accept(File dir,String name){


                    return new File(dir,name).isFile() && name.endsWith(".avi");


            }


        });

        for(File name:arr){

            System.out.println(name);


        }



    }


}
