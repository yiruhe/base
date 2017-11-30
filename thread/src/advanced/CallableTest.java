package advanced;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    /*
        实现Callable 接口,方法可以返回值,并且抛出异常
     */


    public static void main(String[] args) {

        Callable<Integer> callable = () -> 10;

        //执行Callable方法.需要FutureTask实现类的支持;

        FutureTask<Integer> result = new FutureTask<Integer>(callable);

        new Thread(result).start();

        //接收结果:
        Integer integer = null;
        try {

            integer = result.get(); //会进入阻塞状态,类似闭锁

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(integer);
    }

}
