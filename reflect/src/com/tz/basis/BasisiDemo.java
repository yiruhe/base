package com.tz.basis;

/**
 * Created by Administrator on 2017/3/4.
 */
public class BasisiDemo {

    //当调用java命令运行某个java程序,该命令会启动一个JVM进程，
    //同一个JVM中的所有变量处于同一进程中,共享该JVM的内存区域

    //exit()就是退出，传入的参数是程序退出时的状态码，0表示正常退出，其他表示非正常退出，一般都用-1或者1

    //当程序主动使用到某个类时,如果该类还未被加载进内存中,
    //则系统会通过加载,链接,初始化三个步骤

    //类                 实例
    //Date data = new java.util.Date();

    //java.lang.class  字节码对象 --> 用来描述类--> 类加载进内存就是字节码对象(class对象)
    //class对象是用来描述字节码对象的


    //元数据: 描述数据的描述数据
    //字节码描述类,字节码就是类的描述数据 --> 所以字节码对象就是元数据

    //反射就是得到元数据的过程(运行期间,动态的获取类的成员信息)

    //并且把这些类的成员描述成一个新的类,进行访问
    //class:所有的类
    //constructor:表示所有的构造器
    //Method: 表示所有的方法
    //field: 表示所有的字段


    //class类:用来描述类或接口的类型(类,枚举,接口,注解)
    //class类的实例: class实例表示正在运行的类(也就是当前JVM中的类)或接口
    //当程序第一次使用某个类的时候,就会把该类的字节码对象加载进JVM.并创建class对象


    //同一个类在JVM中只有一份字节码

    //T.class  //T表示的是类型,这个类型不一定是类,例如:int  T.class 就是一个字节码对象
    //类.getClass()
    //class.forName(name);name: 类的全称

    //class  所有的数据类型都有class属性

//    九大内置的class类型:JVM预先提供好的class实例分别是:byte,short,int,long.float.double,boolean,char,void

    //Integer.class == int.class   //false   //他们不是同一个数据类型

    //八大基本类型的包装类都有一个静态常量:TYPE,可以获取对应的基本类型的class实例

//  数组的class实例  因为数组没有类名  所以只有2种 数组也是类

//维度和元素类型相同共享一份字节码   例如:  int[]  int是元素类型  [] 维度


//Object: 描述对象
//class:描述类型

    //为什么class类要定义class呢？  大概是因为用于区别class对象的吧,让代码可读性更高,更好用


}


