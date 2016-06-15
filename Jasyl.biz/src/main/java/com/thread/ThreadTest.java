package com.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jason on 16/6/1.
 */
public class ThreadTest implements Runnable{

    private CountDownLatch countDownLatch;

    ThreadTest(CountDownLatch countDownLatch){

        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " countDownLatch test start");

            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
