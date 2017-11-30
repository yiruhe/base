package com.tz.iterator_2.iterator;


import java.util.ArrayList;
import java.util.List;

public class GenericTypeDemo<T> {

    //泛型(参数化类型)里面只能存放引用类型
    //class My<T>
    //限定类型  --  前后要一致


    //泛型方法:
    //1.泛型类中的泛型，只能适用于非静态方法或变量,如果要给静态方法使用泛型,应使用泛型方法(泛型类中的泛型依赖于创建实例时,而静态是不依赖实例的,是使用类名调用的)


    //2.泛型类中的泛型应该适用于整个类中的多个方法,有时候只对某个类设置泛型即可

    //所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）。
    // 每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
    //类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。


    //泛型的擦除：
    //1. 编译之后自动擦除
    //2.手动擦除     把带泛型的类,赋值给不带泛型的变量,变成了原始类型

    //，由于JVM泛型的擦除机制，在运行时JVM是不知道泛型信息的,

    //数组在创建的时候必须知道内部元素的类型，而且一直都会记得这个类型信息，每次往数组里添加元素，都会做类型检查。
    //但因为Java泛型是用擦除（Erasure）实现的，运行时类型参数会被擦掉
    //运行时，类型参数<String>都被擦掉，只有在最后读取内部元素的时候，才插入一个类型转换


    //<T>(泛型声明部分) :声明泛型,表明这个方法持有几个泛型参数
    //T/List<T>: 返回的类型
    //
    //------------------------------------------
    //

    //ArrayList<String> arrayList1=new ArrayList(); //第一种 情况

//    ArrayList arrayList2=new ArrayList<String>();//第二种 情况

    //这样是没有错误的，不过会有个编译时警告。
//        不过在第一种情况，可以实现与 完全使用泛型参数一样的效果，第二种则完全没效果。
    //本来类型检查就是编译时完成的。new ArrayList()只是在内存中开辟一个存储空间，可以存储任何的类型对象。而真正涉及类型检查的是它的引用，因为我们是使用它引用arrayList1 来调用它的方法，所以arrayList1引用能完成泛型类型的检查

    //而引用arrayList2没有使用泛型，所以不行。

    //所以:类型检查就是针对引用的，谁是一个引用，用这个引用调用泛型方法，就会对这个引用调用的方法进行类型检测，而无关它真正引用的对象。


    //? 通配符  类型不确定   用于声明变量|形参  不能用于创建对象,泛型类,泛型接口




    public static <T> T[] say(T... v) { //由参数决定

        return v;
    }

    public static void main(String[] args) {


        List<? extends Object> ls = new ArrayList<String>();

        //这里不能添加元素,因为赋值给变量的子类不确定,添加的子类种类太多


        GenericTypeDemo.say(1, 12, 3); //can be omitted//可以省略


        //泛型擦除 for example:

        List list = new ArrayList<Integer>();

        list.add(1);
        list.add("A");

        List list2 = list;  //泛型擦除

        List<String> list3 = list2; //先泛型擦除，然后赋值给String类型的泛型

//            当取出above的1时;
        String num = list3.get(0);  //取出的实际是Integer类型, //编译后-->  （String）list3.get(0);

        //print:

        System.out.println(num);  //illegalsStateException
        // 相当于-->String num = （String）Integer.valueOf(1);


    }

//    ?: 通配,只能接收  //限定类型使用第一个类型变量替换强转

    //泛型类中的普通方法
    private T run() {

        return null;
    }
    //不能再传递T
//    class A extends B<Integer>{

//    }

//    或者

        //子类也继续使用泛型,并且使用和父类一样的泛型标记

//        B<T>:表示B这个类的泛型有这个T决定
//        A<T>:表示A这个类的泛型由这个T决定  ps:以前就是搞混了。。。
//        B<T> = new A<T>
//    class A<T> extends B<T>{
//
//    }

    //继承要指明泛型类型,不指明就是Object
    class B<T> {

    }

    //暂时性的总结: 我觉得泛型中的类型是由定义变量的泛型决定的,我以前那种传递的思维是不太正确的




}
