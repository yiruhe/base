package com.file.write_stream;

import java.io.*;

public class InputReaderDemo {

    //转换流:
//        InputStreamReader:把字节流转换成字符流
//        OutputStreamReader:吧字节输出转换成成字符输出流


    public static void main(String[] args) {

        File fileIn = new File("io/CopyTest");

        File fileOut = new File("io/PasteTest");

        //把.java后缀以外的文件过滤掉
        File[] fileList = fileIn.listFiles(new FilenameFilter() {

            public boolean accept(File dir, String name) {


                return new File(dir, name).isFile() && name.endsWith(".java");


            }


        });

        BufferedReader readerIn = null;
        BufferedWriter writerOut = null;


        for (File file : fileList) {
            try {

                //字符输入流:把字节流转换为字符输出流,同时也是用字符缓冲流
                readerIn = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                //字符输出流:

                writerOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileOut, file
                        .getName()))));

                char[] arr = new char[1024];

                int len;
                while ((len = readerIn.read(arr)) != -1) {

                    writerOut.write(arr, 0, len);

                }
            } catch (java.io.IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (readerIn != null) readerIn.close();
                    if (writerOut != null) writerOut.close();

                } catch (java.io.IOException e) {

                    e.printStackTrace();

                }


            }


        }


    }


}
