package com.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jason on 16/6/2.
 */
public class countDownLatchTest {


    public static void main(String[] args) {



        try {
            ThreadService threadService = new ThreadServiceImpl();

            CountDownLatch count  = new CountDownLatch(5);

            for (int i = 0; i < 5; i++) {
                threadService.execute(new ThreadTest(count));
            }

            System.out.println("countDownLatch await begin.");

            count.await();

            System.out.println("countDownLatch await finished.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
