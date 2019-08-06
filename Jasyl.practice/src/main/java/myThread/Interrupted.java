package myThread;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author: lingyou
 * date: 2018-12-02 22:27
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        //busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepthread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busythread interrupted is " + busyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(2);

    }

    static class SleepRunner implements Runnable {

        @Override
        public void run() {

            while (true) {

                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

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
