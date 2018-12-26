package lock.customlock;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-10-26 上午11:02
 */
public class Task implements Runnable {

    private MyLock lock;
    private String name;

    public Task(String name, MyLock lock) {
        this.lock = lock;
        this.name = name;
    }

    public void run() {
        lock.lock();
        System.out.printf("task: %s: Task the lock\n", name);

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("task: %s: Free the lock\n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }



    public static void main(String[] args) {

        MyLock lock = new MyLock();

        for (int i = 0; i < 10; i++) {

            Task task = new Task("task-" + i, lock);
            Thread thread = new Thread(task);
            thread.start();

        }

        boolean value;

        do {

            try {
                value = lock.tryLock(1, TimeUnit.SECONDS);
                if (!value) {
                    System.out.printf("Main: Trying to get the Lock\n");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                value = false;
            }

        } while (!value);


        System.out.println("Main: got the lock");
        lock.unlock();

        System.out.println("Main: end of the program");

    }


}
