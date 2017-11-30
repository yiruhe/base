package com.tz;

import java.lang.annotation.Annotation;


@AnnotationMock(level="20",hobby={"java","javascript"})
class Test{

}

public class AnnotationDemo {
    //所有的注解都是java.lang.Annotation 的子接口,annotation是一种特殊的接口
    //@override 限定子类是否覆盖
    //元数据: metadata: 描述数据的数据--<元注解的作用就是负责注解其他注解
    //Deprecated 过时方法

    //SafeVarargs   //抑制堆污染

    //FunctionalInterface   //函数式接口  1.8


    //元注解: 在注解定义的时候,必须使用元注解来标注


    //默认可以存在于字节码中,一旦加载进JVM就消失
    //@Retention: 决定注解可以保留的哪一个时期:
//            一共有三个时期:都封装在RetentionPolicy枚举类中
//                SOURCE:该注解在编译时就会丢弃,不会存在字节码中,只能存在源文件中
//                  CLASS:该注解可以存在源文件和字节码中,一旦加载进JVM,就会丢失
//                    RUNTIME:该注解可以存在源文件,字节码,JVM中

    //@Target: //决定注解可以贴在那些成员上
                //限制都封装在ElementType枚举类中
//      ElementType.ANNOTATION_TYPE 只能修饰Annotation
//      ElementType.CONSTRUCTOR  构造方法
//      ElementType.FIELD   //字段
//      ElementType.LOCAL_VARIABLE   //局部变量
//      ElementType.METHOD   //方法
//      ElementType.PACKAGE   //包
//      ElementType.PARAMETER   //参数
//      ElementType.TYPE   //类,接口,枚举
//


    //@Documented  使用@Document标注会保存带API文档中(做文档的时候)
    //@Inherited  //子类会继承父类的注解(子类会继承被标注的类的注解)


    //deprecation
//      使用了不赞成使用的类或方法时的警告
//
//    unchecked
//      执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。
//
//    fallthrough
//      当 Switch 程序块直接通往下一种情况而没有 Break 时的警告。
//
//    path
//      在类路径、源文件路径等中有不存在的路径时的警告。
//    serial
//      当在可序列化的类上缺少 serialVersionUID 定义时的警告。
//
//     finally
//       任何 finally 子句不能正常完成时的警告。
//
//    all
//       关于以上所有情况的警告

    @SuppressWarnings("all")
   public static void main(String[] args){

        Class<Test> test = Test.class;

        Annotation[] annotation = test.getAnnotations();

        for(Annotation i:annotation){

            System.out.println(i);

        }

        AnnotationMock a = (AnnotationMock)test.getAnnotation(AnnotationMock.class);

        System.out.println(a);
        System.out.println(a.level());

        //这里访问的值的类必须是public的,
        //tried to access class com.tz.Gender from class com.sun.proxy.$Proxy1 包之间的访问权限不够
        System.out.println(a.gender());

   }

}

class Book {

    //过期声明
    @Deprecated
    /**
     *
     * @Deprecated  jdk1.5之前使用的
     */
    public void fun(){}
}




