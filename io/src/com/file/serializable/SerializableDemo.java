package com.file.serializable;


import java.io.*;

public class SerializableDemo {


    //java.io.Serializable(接口)标志接口(里面什么都没有)
    //需要做序列化的对象的类,必须实现序列化接口
    //Java序列化是指把Java对象转换为字节序列的过程；而Java反序列化是指把字节序列恢复为Java对象的过程。

    //序列化一般用于以下场景：
//            1.永久性保存对象，保存对象的字节序列到本地文件中；
//            2.通过序列化对象在网络中传递对象；
//            3.通过序列化在进程间传递对象。

    //做反序列化必须存在序列对象的字节码

    //transient是类型修饰符，只能用来修饰字段。在对象序列化的过程中，标记为transient的变量不会被序列化
    //transient(专门修饰实例,)专门用来修饰成员变量的,不能修饰其他成员
    //这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化

    //串行化只能保存对象的非静态成员交量，不能保存任何的成员方法和静态的成员变量，而且串行化保存的只是变量的值，对于变量的任何修饰符都不能保存。

    //只要这个类实现了Serializable接口，这个类的所有属性和方法都会自动序列化。
    //transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。
    //一个静态变量不管是否被transient修饰，均不能被序列化
    //反序列化后类中static型变量username的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的

    //序列化时，只对对象的状态进行保存，而不管对象的方法；


    public static void main(String[] args){

        //ObjectOutputStream: 做序列化操作的
        //ObjectInputStream:通过反序列化的

        File file = new File("io/object/Test.txt");
        ObjectOutputStream obj =null;
        ObjectInputStream  objIn = null;
        //序列化我们的对象数据
        try{

        obj = new ObjectOutputStream(new FileOutputStream(file));
        //直接写入Object对象
        obj.writeObject(new Test("Serializable Test"));

        objIn = new ObjectInputStream(new FileInputStream(file));



        Test use = (Test)objIn.readObject();

        System.out.println(use.name+"===");

        }catch(java.io.IOException | ClassNotFoundException e){

            e.printStackTrace();

        }finally{

            try{

                if(obj != null)obj.close();
                if(objIn != null)objIn.close();

            }catch(Exception e){


                e.printStackTrace();

            }


        }


    }
}

//要序列化的对象,必须实现Serializable 接口
class Test implements java.io.Serializable{

    //.如果不显式设置SerialVersionUid，有什么后果？
    //jdk文档中有解释，建议我们显式声明，因为如果不声明，JVM会为我们自动产生一个值，但这个值和编译器的实现相关
    //随着项目的开发,class也会升级更新,如果不手动

//    如果没有设置这个值，你在序列化一个对象之后，改动了该类的字段或者方法名之类的，那如果你再反序列化想取出之前的那个对象时就可能会抛出异常，因为你改动了类中间的信息，serialVersionUID是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段,当修改后的类去反序列化的时候发现该类的serialVersionUID值和之前保存在问价中的serialVersionUID值不一致，所以就会抛出异常。
//
    //在恢复数据的时候会进行ID比较
//
//    而显示的设置serialVersionUID值就可以保证版本的兼容性，如果你在类中写上了这个值，就算类变动了，它反序列化的时候也能和文件中的原值匹配上。而新增的值则会设置成null，删除的值则不会显示。

    //一般情况我们手动定义就可以了  1L --> 2L...等等
    private static final long serialVersionUID = 1L;
       String name;


    Test(String name){

        this.name = name;

    }

    public String getName(){



        return this.name;

    }

}
