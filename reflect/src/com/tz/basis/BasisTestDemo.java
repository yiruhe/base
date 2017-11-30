package com.tz.basis;

import java.util.Properties;

/**
 * Created by Administrator on 2017/3/6.
 */
public class BasisTestDemo {
    //Java在一个类的class文件的时候,那么也会生成所对应的一个class实例

    //bin目录就是classpath 类路经

    //类加载器
    //1.启动加载器  BootStrap classLoader 用于加载java运行中的核心类库--> 对于用户隐藏 获取为null
    //2.扩展类加载器 Extension       //加载一些api里没有的类
    //3.系统类加载器  application  //负责加载classpath下面的jar或者类

    //启动（Bootstrap）类加载器：引导类装入器是用本地代码实现的类装入器，它负责将 <Java_Runtime_Home>/lib 下面的类库加载到内存中。由于引导类加载器涉及到虚拟机本地实现细节，开发者无法直接获取到启动类加载器的引用，所以不允许直接通过引用进行操作。

    //标准扩展（Extension）类加载器：扩展类加载器是由 Sun 的 ExtClassLoader（sun.misc.Launcher$ExtClassLoader） 实现的。它负责将 < Java_Runtime_Home >/lib/ext 或者由系统变量 java.ext.dir 指定位置中的类库加载到内存中。开发者可以直接使用标准扩展类加载器。

    //系统（System）类加载器：系统类加载器是由 Sun 的 AppClassLoader（sun.misc.Launcher$AppClassLoader）实现的。它负责将系统类路径（CLASSPATH）中指定的类库加载到内存中。开发者可以直接使用系统类加载器。

    //JVM在加载类时默认采用的是双亲委派机制。通俗的讲，就是某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，依次递归，如果父类加载器可以完成类加载任务，就成功返回；只有父类加载器无法完成此加载任务时，才自己去加载。关于虚拟机默认的双亲委派机制，我们可以从系统类加载器和标准扩展类加载器为例作简单分析。

    //当一个类加载和初始化的时候，类仅在有需要加载的时候被加载。假设你有一个应用需要的类叫作Abc.class，首先加载这个类的请求由 Application类加载器委托给它的父类加载器Extension类加载器，然后再委托给Bootstrap类加载器。Bootstrap类加载器 会先看看rt.jar中有没有这个类，因为并没有这个类，所以这个请求由回到Extension类加载器，它会查看jre/lib/ext目录下有没有这 个类，如果这个类被Extension类加载器找到了，那么它将被加载，而Application类加载器不会加载这个类；而如果这个类没有被 Extension类加载器找到，那么再由Application类加载器从classpath中寻找。记住classpath定义的是类文件的加载目 录，而PATH是定义的是可执行程序如javac，java等的执行路径。

    public static void main(String[] args) throws Exception {

        Class class1 = String.class;

        Class class2 = Class.forName("java.lang.String");

        System.out.println(class2);


        Properties properties = new Properties();

        //默认去classpath目录寻找文件  //利用类加载器的ResourceAsStream();
        properties.load(BasisTestDemo.class.getClassLoader().getResourceAsStream("test.properties"));

        System.out.println(properties);

        //还有就是根据字节码路径去找

        //有两个ResourceAsStream  一个是class类的(字节码文件的路径)  一个是类加载器的(根路径)



    }

}
