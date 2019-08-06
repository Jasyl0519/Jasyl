package lock.sync;

/**
 * Description:
 * Author: lingyou
 * date: 2018-11-18 下午3:54
 */
public class IncreaseSync1 implements Runnable {

    static int i = 0;

    public void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IncreaseSync1 increaseSync = new IncreaseSync1();
        Thread t1 = new Thread(increaseSync);
        Thread t2 = new Thread(increaseSync);
        t1.start();
        t1.join();

        t2.start();
        t2.join();
        System.out.println(i);
    }
}




