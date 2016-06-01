package com.thread;

/**
 * Created by jason on 16/6/1.
 */
public class ThreadTest implements Runnable{



    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " executor start");
    }
}
