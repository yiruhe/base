package com.tz.abstractdemo;

/**
 * Created by Administrator on 2017/1/29 0029.
 */
public class AbsstractDemo{
        //抽象方法 要加上 abstract ，方法没有方法体
        //抽象方法就只比普通类多了个抽象
        // 无法实例化，抽象方法必须定义在抽象类中
        //抽象的构造函数是留给子类调用的
        //外部类是不允许用static修饰的，因为static代表的是类，而内部类可以使用static
        //抽象方法不能加static因为方法覆盖是实例之间的,static是独立出来的,所以static必须被实现
        //内部类就可以实现
        //任何一个类，构造执行完之前，所有的属性内容都是其默认值
        //java中静态属性和和静态方法可以被继承
        //抽象类无法实例化
	
		//结果的类型时表达式中最高的,  byte,short,char 运算自动提升为int ,运算
	
	
	
	//继承的特点:
		//public,protected任何地方都可以继承
		//缺省:同包可继承
		//private:不可继承

	// instanceof: 对象  instanceof 类;
	
	// 

    public static void main(String[] args){
/*

        A.B p = new X();
        p.say();
*/

    	boolean a = new Object() instanceof String; 
    	
        C c = C.getInstance();

        c.print();
    }


}


class A{

    //定义一个静态内部类
    abstract static class B{


        public abstract void say();

    }

}

class X extends A.B{

    public void say(){

        System.out.println("*******************");
    }

}

abstract class C{

    public abstract void print();

    //内部类抽象类子类
    //由于这个类是私有的
    private static class D extends C{

        public void print(){

            System.out.print("###############");

        }

    }
//    所以在这里定义一个getInstance方法 来获取C类中的私有内部类
    //让外部感觉不到这个子类的存在

    public static  C getInstance(){

        return new D();
    }

}
