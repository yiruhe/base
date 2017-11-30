package advanced;


import org.junit.Test;
import sun.awt.windows.ThemeReader;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class SetTest {


    /*

        java 5.0  concurrent包中提供了多种并发容器类来改进容器性能

           ConcurrentHashMap 内部采用锁分段机制代替Hashtable的独占锁,提高性能


           concurrentLevel 级别  默认 16 个
                Segment(分段:默认16): 每个段都是独立的锁



     */

    @Test
    public void testArrayList(){


        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.add("2");
        copyOnWriteArrayList.add("3");
        copyOnWriteArrayList.add("4");


        Iterator<String> iterator =  copyOnWriteArrayList.iterator();

        while (iterator.hasNext()){

             iterator.next();

             //每次写入时,都会复制
            copyOnWriteArrayList.add("6");

        }




    }


    /*

        CountDownLatch: 闭锁 在完成某些运算时,只有其他线城的运算全部完成,当前运算才执行




     */


    @Test
    public void testCountDownLatch() throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(5);

        for (int i = 0; i < latch .getCount(); i++) {


            new Thread(new LatchDemo(latch)).start();

        }

        //在CountDownLatch的计数变为0之前一直等待
        latch.await();

        System.out.println("done");

    }





}


class LatchDemo implements Runnable{


    private final CountDownLatch latch;

    @Override
    public void run() {

        for (int i = 0; i <  20; i++) {

            System.out.println(i);

        }

        //减去一个计数
        latch.countDown();

    }

    public LatchDemo(CountDownLatch latch){

       this.latch  = latch;


    }

}