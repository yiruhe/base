
public class Basic {

    //自动装箱:语法糖
        //底层还是手动装箱和拆箱 Integer.valueOf的方式,而不是new Integer

        //switch: switch会对包装类拆箱

            // Object i = 1;
            //1):自动装箱: Integer i = 1
            //2):再assigned Object


    //Boolean:都缓存
    //Integer/Byte/Short:-128~127
    //Character:[0,127]

    //equals:比较 --> 基本类型的比较


    public static void main(String[] args){


        //创建的对象
        Integer a = new Integer(1);

        //缓存中的值
        Integer b = Integer.valueOf(1);


        System.out.println(a == b);

        //缓存:
        Boolean b1 = true;
        Boolean b2 = true;

        System.out.println(b1 == b2);



        Integer i1 = 1;
        Integer i2 = 1;

        System.out.println("Integer"+(i1 == i2));

    }


}
