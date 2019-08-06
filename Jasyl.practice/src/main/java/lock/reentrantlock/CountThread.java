package lock.reentrantlock;

/**
 * Description:
 * Author: lingyou
 * date: 2018-10-21 上午12:23
 */
public class CountThread extends Thread {

    int total = 0;

    @Override
    public void run() {

        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total = total + i;
            }

            this.notify();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        CountThread countThread = new CountThread();
        countThread.start();

        synchronized (countThread) {
            System.out.println("等到countThread线程计算结束...");

            countThread.wait();

            System.out.println(countThread.total);
        }




    }
}
