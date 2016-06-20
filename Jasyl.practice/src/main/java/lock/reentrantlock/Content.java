package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jason on 16/6/15.
 */
public class Content {

    private ReentrantLock lock = new ReentrantLock();

    public void method(){

        lock.lock();

        System.out.println("do atomic operation");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
