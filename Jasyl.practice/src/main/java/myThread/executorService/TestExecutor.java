package myThread.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jason on 16/6/1.
 */
public class TestExecutor {


    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {

            service.execute(new TestRunning());

            System.out.println("************* a" + i + " *************");

        }

        service.shutdown();

        
    }
}


class TestRunning implements Runnable{


    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程被调用了.");
    }
}

