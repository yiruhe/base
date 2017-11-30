package com.tz.EnumTest;

public class EnumDemo {


    //固定的常量对象集合 ==> 枚举
    //我们自定义的enum类 ，底层都是继承的Enum(抽象类)
    //声明的常量类必须放在第一行
    //枚举类也是一个类，所以可以定义其他的一些东西
    //构造不能使用public声明 //构造方法不能为public，因为enum并不可以被实例化
    //，enum中的构造方法只能是private标识，这样做是为了防止用户实例化enum。,默认就是private

    //默认把参数传给了Enum类

//    String name = 枚举类.name();  //名字
//      int ordinal = 枚举类.ordinal() //序数

//    编译器提供的方法 --> 自动生成的

//    Weekday[] values = Weekday.values()  // 返回当前枚举类型的所有常量，使用数组装
//      Weekday values = Weekday.valueOf(String) //通过String在enum中查找，并返回名字相同的对象
                                                    //内部调用Enum的valueOf

    //switch  //支持enum ，底层还是用的int做的判断， 调用的是--->枚举类.ordinal();

}

enum Weekday{

    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY

    //等价  public static final MONDAY = new Weekday("MONDAY",1); //1表示序号
    //枚举的构造器默认是private,也必须是private


}