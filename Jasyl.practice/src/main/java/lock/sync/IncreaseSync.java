package lock.sync;

/**
 * Description:
 * Author: lingyou
 * date: 2018-11-18 下午3:54
 */
public class IncreaseSync implements Runnable {

    static int i = 0;

    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IncreaseSync increaseSync = new IncreaseSync();
        Thread t1 = new Thread(increaseSync);
        Thread t2 = new Thread(increaseSync);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}



