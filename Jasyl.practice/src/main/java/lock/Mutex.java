package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Description:
 * Author: lingyou
 * date: 2018-10-21 下午11:35
 */
public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {

        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0 ,1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;

            }
            return false;

        }

        protected boolean tryRelease(int releases) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();

            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;

        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);

    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }


    private String getA() {
        for (;;) {

        }
    }


    public static void main(String[] args) {
        int a = (1 << 16) - 1;
        System.out.println( 1 & a);
        System.out.println( 2 >>> 16);
    }
}
