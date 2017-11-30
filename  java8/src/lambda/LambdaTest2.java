package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Q
 * @version V1.0
 * @Description: ${todo}
 * @date 2017-11-28 14:59
 */
public class LambdaTest2 {


    //函数式接口,接口中只有一个抽象方法  @FunctionalInterface 检查接口是否是函数式接口

    @Test
    public void test1(){


        //格式一: 无参,无返回值  实质就是匿名类
        //参数列表只有一个参数括号可以不写
        Runnable runnable = () -> System.out.println("hello");


    }


    //四大接口测试
    @Test
    public void test2() {

        consumer("测试",m -> System.out.println(m+"Hello"));

    }


    public void consumer(String content,Consumer<String> consumer){

        consumer.accept(content);

    }

    //方法引用:Lambda另一种表达:
    /*
        1.对象::实例方法
        2.类::静态方法
        3.类::实例方法


     */

    @Test
    public void test3(){

        Consumer<String> consumer1 = x -> System.out.println(x);

        Consumer<String> consumer = System.out::print;

         User user = new User(10);

         //原:
        Supplier<Integer> stringSupplier = () -> user.getAge();

        //方法引用:    getAge实现了 Supplier的方法
        Supplier<Integer> supplier = user::getAge;


        //类::静态方法
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);

        Comparator<Integer> comparator1 = Integer::compare;
    }


    //类::实例方法名:
    @Test
    public void test4(){

        //1.若lambda参数列表中的第一个参数是实例方法的调用者,而第二个参数是实例方法的参数,则可以使用 ClassName::method

        //原:
        BiPredicate<String,String> biPredicate = (x,y) -> x.equals(y);

        //方法引用:
        BiPredicate<String,String> biPredicate1 = String::equals;
    }


    @Test
    public void test5(){

        //构造器:
        //构造器的调用哪一个,取决于接口的抽象方法
        Supplier<User> supplier = User::new;


    }

}
