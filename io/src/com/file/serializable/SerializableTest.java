package com.file.serializable;



import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class SerializableTest {


    public static void main(String[] args) throws Exception {

        ObjectInputStream in;

        in = new ObjectInputStream( new FileInputStream("E:/Java/io/object/Test.txt"));
        Test test = (Test)in.readObject();


        System.out.println(test.name);

    }

}
