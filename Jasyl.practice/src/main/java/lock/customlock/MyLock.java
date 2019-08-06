package lock.customlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-10-26 上午10:59
 */
public class MyLock implements Lock {

    private MyAbstractQueuedSynchronizer sync;

    public MyLock() {
        this.sync = new MyAbstractQueuedSynchronizer();
    }


    public void lock() {
        sync.tryAcquire(1);

    }


    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);

    }


    public boolean tryLock() {
        try {
            sync.tryAcquireNanos(1,1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, TimeUnit.NANOSECONDS.convert(time, unit));
    }


    public void unlock() {
        sync.release(0);

    }


    public Condition newCondition() {
        return sync.new ConditionObject();
    }

    public static void main(String[] args) {


        System.out.println("uid".hashCode());
        System.out.println("wjf_uid".hashCode());
    }

}
