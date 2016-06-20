package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jason on 16/6/14.
 */
public class LockClass implements Runnable {

    private int count;

    LockClass(){
        count = 0;
    }


    @Override
    public void run() {

        Lock lock = new ReentrantLock();
        lock.lock();

        
        try {
            for (int i = 0; i < 5; i++) {

                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        LockClass lockClass = new LockClass();
        for (int i = 0; i < 2; i++) {

            executorService.execute(lockClass);
        }

        executorService.shutdown();

    }
}
