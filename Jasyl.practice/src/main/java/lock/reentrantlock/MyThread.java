package lock.reentrantlock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jason on 16/6/15.
 */
public class MyThread implements Runnable{

    private Content content;

    MyThread(Content content){
        this.content = content;

    }

    @Override
    public void run() {

        content.method();

    }

    public static void main(String[] args) {

        try {
            Content context = new Content();
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            CountDownLatch count = new CountDownLatch(5);

            for (int i = 0; i < 5; i++) {

                executorService.execute(new MyThread(context));
            }

            executorService.shutdown();

            System.out.println(" begin ");

            count.await();
            System.out.println(" end ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
