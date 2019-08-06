package lock.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jason on 16/6/15.
 */
public class Content implements Runnable {

    private ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {

        Content content = new Content();

        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        //
        //for (int i = 0; i < 2; i++) {
        //    executorService.execute(content);
        //}

        Thread thread1 = new Thread(content);
        thread1.setName("线程1");
        thread1.start();


        TimeUnit.SECONDS.sleep(3);


        Thread thread2 = new Thread(content);
        thread2.setName("线程2");
        thread2.start();

        //thread1.join();

        TimeUnit.SECONDS.sleep(3);

        //thread2.interrupt();



    }


    public void run() {

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始run");
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }





    }
}
