package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jason on 16/6/14.
 */
public class LockClass implements Runnable {

    private int count;
    private ReentrantLock lock;

    public LockClass(ReentrantLock lock) {
        this.lock = lock;
    }

    public void add() {
        for (int i = 0; i < 100000; i++) {
            count ++;
        }
    }


    public void run() {
        lock.lock();


        try {
            add();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    public static void main(String[] args) throws Exception {

        ReentrantLock lock = new ReentrantLock();

        LockClass lockClass = new LockClass(lock);

        Thread thread1 = new Thread(lockClass);
        Thread thread2 = new Thread(lockClass);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(lockClass.count);

    }
}
