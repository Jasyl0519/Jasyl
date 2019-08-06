package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Description:
 * Author: lingyou
 * date: 2019-05-09 23:22
 */
public class SemaphoreTest {

    public static final int THREAD_COUNT = 30;

    private static ExecutorService service = Executors.newFixedThreadPool(30);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {

        for (int i = 0; i < THREAD_COUNT; i++) {

            service.execute(new Task(i));

        }

        service.shutdown();
    }

    static class Task implements Runnable {

        private Integer a;

        public Task(Integer a) {
            this.a = a;
        }

        @Override
        public void run() {

            try {
                semaphore.acquire();
                System.out.println("save data" + a);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
