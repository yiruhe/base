package lambda;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    /**
     *  接口中default方法相同,子类必须实现其中一个(在实现的方法中调用接口的方法(接口.super.方法)),
     *  父类和接口出现相同方法,父类覆盖了接口的方法
     *  接口可以使用静态方法
     *
     *   lambda会进行类型推断
     *
     *   lambda 四大内置函数式接口
     *
     *      Consumer<T>  消费接口
     *          void accept(T t)
     *
     *      Supplier<T> 供给接口
     *          T get();
     *
     *      Function<T,R> 函数型接口
     *          R apply(T t)
     *
     *      Predicate<T> 断言型接口
     *         boolean test(T t)
     *
     *         方法引用:
     *              1.lambda 体调用的方法的参数列表与返回值,要与函数式接口的抽象方法一致
     *
     *         类::实例方法
     *              2.参数列表第一个参数是实例方法的调用者,第二个是实例方法的参数时使用 类::实例
     *                  类::实例方法  x -> x.toString()  等于  X::toString  第一个参数自动作为实例方法的调用者
     *
                      --类成员方法引用

                         类的成员方法不能是静态的，而这个情况其实和静态方法类似，区别是，Lambda表达式的参数个数需要等于所调用方法的入参个数加一。

                             为什么要加一？

                     因为类的成员方法不能通过类名直接调用，只能通过对象来调用，也就是Lambda表达式的第一个参数，是方法的调用者，
                     从第二个开始的参数个数要和需要调用方法的入参个数一致即可。
     *
     *
     *         构造引用:
     *          ClassName::new
     */

    @Test
    public void testLambda(){

        User[] users = new User[]{new User(1),new User(2)};

//        lambda : 会形成闭包(会保存自由变量,)
        /**
         *  操作自由变量的代码块就是闭包
         * lambda 中的this 就是 他所在方法的this
         *
         */

        Arrays.sort(users,(o1,o2) -> Integer.compare(o1.getAge(),o2.getAge()));



    }

    @Test
    public void testLambda2(){

        Integer[] integer = new Integer[]{1,2,3};

//        lambda : 会形成闭包(会保存自由变量,)
        /**
         *  操作自由变量的代码块就是闭包
         * lambda 中的this 就是 他所在方法的this
         *
         */

        Arrays.sort(integer,Integer::compare);

    }


    @Test
    public void testSort(){

        List<Integer> list = Arrays.asList(new Integer[]{50,20,30});


        list.sort(Integer::compareTo);

        System.out.println(list);

    }

}


class User {

    private int age;

    public int getAge(){


        return this.age;

    }

    public User(int age){



    }


    public User(){


    }


}
