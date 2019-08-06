package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Author: lingyou
 * date: 2018-12-10 22:18
 */
public enum ThreadPool {

    INSTANCE;

    private int core;
    private int max;
    private ArrayBlockingQueue queue;

    private ExecutorService executorService;


    ThreadPool() {


        executorService = new ThreadPoolExecutor(core, max, 1000l, TimeUnit.SECONDS, queue,
                new ThreadFactory() {
                    private AtomicInteger id = new AtomicInteger(0);


                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("real-time-index-thread-" + id.addAndGet(1));
                        return thread;                    }
                });


    }

    public ExecutorService getThreadPool() {
        return executorService;
    }







}
