package lock.reentrantlock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Author: lingyou
 * date: 2018-11-22 下午10:56
 */
public class LockAndLockInterruptibly {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        //
        //
        //System.out.println(1);
        //LockSupport.park(lock);
        //System.out.println(11);
        //
        //lock.unlock();



        Thread t1 = new Thread(new RunTt3());
        Thread t2 = new Thread(new RunTt3());

        t1.start();
        t2.start();

        t2.interrupt();
        t2.isInterrupted();
        LockSupport.unpark(t1);


    }






    static class RunTt3 implements Runnable {


        Lock lock = new ReentrantLock();



        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " running");

            //lock.lock();
            //try {
            //    lock.lockInterruptibly();
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            LockSupport.park(this);

            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch(InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            } finally {
                lock.unlock();
            }

        }
    }
}


