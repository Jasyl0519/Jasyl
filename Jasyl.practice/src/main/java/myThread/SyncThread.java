package myThread;

/**
 * Created by jason on 16/6/14.
 */
public class SyncThread implements Runnable {
    private static int count;

    public SyncThread(){
        count = 0;
    }
    
    @Override
    public void run() {
        synchronized (this) {

            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        


    }


    public static void main(String[] args) {
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();

        Thread thread1 = new Thread(syncThread1, "syncThread1");
        Thread thread2 = new Thread(syncThread1, "syncThread1");

        thread1.start();
        thread2.start();
    }
}
