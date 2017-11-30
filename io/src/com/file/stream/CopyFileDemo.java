package com.file.stream;


import java.io.*;
import java.util.Arrays;

public class CopyFileDemo {


    public static void main(String[] args){


        //修改文件名放在最后

        File file = new File("io/CopyTest");


        File[] fileList = file.listFiles(new FilenameFilter(){ //must either be declared or implements


            @Override
            public boolean accept(File dir,String name){ //arguments--> one: 文件所在目录 two:文件名


                return new File(dir,name).isFile() && name.endsWith(".java");


            }

        });

        System.out.println(Arrays.toString(fileList));

        for(File f:fileList){

            InputStream in = null;
            OutputStream out = null;
            File paste = new File("io/PasteTest",f.getName());

            try{

                in = new FileInputStream(f);

                out = new FileOutputStream(paste);
                byte[] arr = new byte[1024];

                int len;

                while((len = in.read(arr)) != -1){

                    out.write(arr,0,len);

                }

            }catch(java.io.IOException e){


                e.printStackTrace();

            }finally{

                try{

                    if(in != null)in.close();
                    if(out != null)out.close();

//                    Thread.sleep(3600);
                    //修改文件名称  要先close关闭以后,才能修改，不关闭文件就会一直被输出流所引用
                    //被close以后文件才会被创建
                paste.renameTo(new File("io/PasteTest","Pasted_"+paste.getName()));





                }catch(Exception e){

                    e.printStackTrace();

                }



            }



        }







    }


}
