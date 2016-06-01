package myThread;

/**
 * Created by jason on 16/5/31.
 */
public class MyThread implements Runnable {

    public void run() {
        System.out.println("run");
    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread, "t1" );
        Thread t2 = new Thread(myThread, "t2" );
        t1.start();
        t2.start();


    }
}
