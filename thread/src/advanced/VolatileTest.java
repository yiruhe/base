package advanced;



public class VolatileTest
{

    //volatile 多线程操作共享数据时,保证可见性(synchronized也有这个效果),

    public static void main(String[] args) {

        ThreadDemo threadDemo =  new ThreadDemo();

        new Thread(threadDemo).start();

        while(true){

            System.out.println(threadDemo.flag);

            //主线程读取的值,是自己自己线程中的值
            //两个线程都有独立的缓存,对值得操作都是不可见的
            if(threadDemo.flag){
                System.out.println(threadDemo.flag);

                System.out.println("--------------");

                break;
            }

        }

    }


    /*
        原子变量: jdk1.5后java.util.concurrent.atomic包
            1.保证了内存可见性
             2.CAS算法保证数据的原子性
                cas包括3个操作数
                   真实的内存值:V  先读取一次
                    预期的内存值:A  更新前读取, 比较 内存值和预估值 如果相等,进行赋值
                    更新值:B
                        当且V == A 时, V = B .否则不进行任何操作


                就是更新值前,再次读取内存值,和第一次读取的内存值相比较,相等则更新,失败不更新,重新操作


           1.非静态方法的锁默认this,静态则是Class实例
           2.某一个时刻,只能有一个线程持有锁


     */



    /*

        线程池: 提供了一个线程队列.队列中保存着所有等待状态的线程,避免了创建与销毁的开销


            Executor:负责线程池的使用调度的根接口

           ScheduledThreadPoolExecutor

        工具类: Executors 创建线程池的工具类


       ForkJoinPool 采用"工作窃取"模式
                当执行新的任务时它可以将其拆分分成更小的任务执行，
                并将小任务加到线程队列中，
                然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。

                相比线程池,减少了线程的等待时间,提高了效率


     */



}


class ThreadDemo implements Runnable {


    boolean flag = false;

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;

    }

}
