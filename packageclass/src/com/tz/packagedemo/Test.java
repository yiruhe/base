package com.tz.packagedemo;

/**
 * Created by Administrator on 2017/1/27 0027.
 */
public class Test {
	
//	在windows中,环境变量%%是引用其他环境变量

    //package  包.子包
    //classpath jVM到那个文件去找class文件
    //javahome 服务器之内的东西。。



    //当我们在编写一个Java源代码文件的时候，我们通常把该文件通常被称为一个编译单元（有时称为翻译单位）。每个编译单元必须有一个后缀。Java
    //1、每个编译单元(文件)只能有一个public 类。这么做的意思是，每个编
//    译单元只能有一个公开的接口，而这个接口就由其public 类来表示。
//    你可以根据需要，往这个文件里面添加任意多个提供辅助功能的package 权限的类。但是如果这个编译单元里面有两个或两个以上的public 类的话，编译器就会报错。
//            2. public 类的名字必须和这个编译单元的文件名完全相同，包括大小
//    写。所以对Widget 类，文件名必须是Widget.java，不能是widget.java 或WIDGET.java。如果你不遵守，编译器又要报错
//    了。
//            3. 编译单元里面可以没有public 类，虽然这种情况不常见，但却是可以
//    的。这时，你就能随意为文件起名字了。

    //类里面只能写声明


    //	这里使用系统默认编码。。。。
    //	如果有中文字符 就要更改编码 javac -encoding utf-8 文件名.java
    //javac -d . 文件名.java
    //-d
    //生成目录
    //encoding参数
    //	官方的参数说明为：指定源文件使用的字符编码。
    //	在javac中，如果在编译时不指定编码，那么就使用系统的默认编码。win7中文系统默认编码为GBK
    //java 包名  --> 运行这个文件
    //.
    // 当前目录
    //为什么只有一个public class 因为每个编译单元都只能有一个公共接口，用public类来表现。
    //该接口可以按照要求包含众多的支持包访问权限的类。如果有一个以上的public   类，编译器就会报错。  并且public类的名称必须与文件名相同（严格区分大小写）。  当然一个编译单元内也可以没有public类。
    //没有加public 的类 就只会被 本包访问了

    //如果导入不同包，但是类名相同。 就要写上完整的类名

    // 生成jar
    //jar -cvf 名字.jar 要打包的目录名
    //生成的jar文件，必须要使用classPath  才能使用


    //设置classpath后，只要解释java文件，就会到这个文件目录中，那么就可以把classpath设置成“.”，当前路径进行类加载

    //SET　CLASSPATH=".;jar路径"

    //public: 项目的任何地方都可以 访问
    // （缺损）: 必须本包中才能访问

//    java -cp .;c:\dir1\lib.jar Test

//    javac -encoding utf-8 -d . -cp my.jar HelloTest.java
//    java  -cp my.jar; HelloTest
//
//-cp 和 -classpath 一样，是指定类运行所依赖其他类的路径，通常是类库，jar包之类，需要全路径到jar包，window上分号“;”
//
//    分隔，linux上是分号“:”分隔。不支持通配符，需要列出所有jar包，用一点“.”代表当前路径。

    //后来通过查阅资料，解决的办法就是加一个参数指定编码：
//    java -Dfile.encoding=utf-8 -jar project.jar




//    在myeclipse中，有两种方法可以将jar包导入到项目中，一种是项目右击，选择build path-->add external archives，找到jar包所在位置，导入；另外一种方法是在WEB-INF/lib文件加上右击，import-->File System，找到jar包，导入。这两种方式的区别是，build path并没有将jar包复制到workspace中项目目录下，而是建立了一个到该jar包的引用，一旦本地jar包发生移动或删除，将影响项目的运行。而import的方式则是将jar包复制到lib下，即使本地jar包不再存在，或者将项目拷贝到其他机器上，仍然能够正常编译运行。
}
