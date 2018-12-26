package lock.customlock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-10-26 上午10:46
 */
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {

    private AtomicInteger state;


    public MyAbstractQueuedSynchronizer() {
        this.state = new AtomicInteger(0);
    }


    @Override
    protected boolean tryAcquire(int arg) {
        return state.compareAndSet(0,arg);
    }


    @Override
    protected boolean tryRelease(int arg) {
        return state.compareAndSet(1,arg);
    }











}
