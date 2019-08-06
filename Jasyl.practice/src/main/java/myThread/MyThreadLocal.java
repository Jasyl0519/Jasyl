package myThread;

import java.util.concurrent.TimeUnit;

/**
 * Created by jason on 16/5/31.
 */
public class MyThreadLocal {

    private Long getA () {
        return 100l;
    }

    public static final ThreadLocal<Long> time_threadlocal = new ThreadLocal<Long>() {

        protected Long initialValue() {
            return System.currentTimeMillis();
        }

    };

    static final MyThreadLocal myThreadLocal = new MyThreadLocal() {
        public Long getA () {
            return 200l;

        }
    };

    public static final void begin() {
        time_threadlocal.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - time_threadlocal.get();
    }


    public static void main(String[] args) throws InterruptedException {

        System.out.println( myThreadLocal.getA());
        MyThreadLocal.begin();

        TimeUnit.SECONDS.sleep(1);

        

        System.out.println("cost " + MyThreadLocal.end() + " m");




    }

    static class TimeWaiting implements Runnable {

        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Waiting implements Runnable {

        public void run() {
            while (true) {
                synchronized (Waiting.class) {

                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }


    static class Blocked implements Runnable {

        public void run() {
            while (true) {
                synchronized (Blocked.class) {

                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }
}
