package com.file.stream;


import java.io.*;
import java.util.Arrays;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler;

public class EvalTestDemo {



    public static void main(String[] args){

        String str = "System.out.println(\"Hello World!\");";

        eval(str);




    }


     static void eval(String str){


        StringBuilder sb = new StringBuilder(30);

        sb.append("public class TestDemo{");
        sb.append("public static void main(String[] args){").append(str).append("}").append("}");

         OutputStream out = null;
        try{
            //创建一个文件输出流
             out = new FileOutputStream(new File("E:/Java/io/CopyTest/TestDemo.java"));

             //把数组中的文件写入文件中
             out.write(sb.toString().getBytes());


        }catch(IOException e){

            e.printStackTrace();

        }finally{

            try{

            if(out != null)out.close();
            }catch(IOException e){

                e.printStackTrace();

            }

        }


         //获取当前的运行时环境
         Runtime runtime = Runtime.getRuntime();

        try{

         Process process =  runtime.exec("javac E:/Java/io/CopyTest/TestDemo.java");

         InputStream in =  process.getErrorStream();

         byte[] arr = new byte[1024];

         int len;

         while((len = in.read(arr)) != -1 ){

            System.out.println(new String(arr,0,len));

         }

         //先关闭流的引用
         in.close();

         Process javaProcess =  runtime.exec("java -cp E:/Java/io/CopyTest/TestDemo");

//            InputStream p =  javaProcess.getInputStream();
            InputStream p =  javaProcess.getErrorStream();



            System.out.println(Arrays.toString(arr));
            while((len = p.read(arr)) != -1 ){

                System.out.println(new String(arr,0,len,"GBK"));

            }


            p.close();



        }catch(Exception e){


            e.printStackTrace();

        }



        //JavaCompiler最核心的方法是run, 通过这个方法编译java源文件, 前3个参数传null时,
         //分别使用标准输入/输出/错误流来 处理输入和编译输出. 使用编译参数-d指定字节码输出目录.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // result = 0 表示成功  否则失败
        int result = compiler.run(null,null,null,"E:/Java/io/CopyTest/TestDemo.java");

        if(result != 0){

            System.out.println("失败");
        }else{

            System.out.println("成功");
        }




     }



}
