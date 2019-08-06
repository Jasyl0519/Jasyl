package myThread;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author: lingyou
 * date: 2018-12-02 22:27
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {


        Runner one = new Runner();

        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();


        Runner two = new Runner();

        Thread countThread1 = new Thread(two, "CountThread1");
        countThread1.start();
        TimeUnit.SECONDS.sleep(1);
        countThread1.join();

        two.cancel();




    }

    static class Runner implements Runnable {

        private long i;

        private volatile boolean on = true;

        @Override
        public void run() {

            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }

            System.out.println(Thread.currentThread().getName() + " count i = " + i);

        }

        public void cancel() {
            on = false;
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {

            while (true) {
            }

        }
    }
}
