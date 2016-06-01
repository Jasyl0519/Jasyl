package myThread;

/**
 * Created by jason on 16/5/31.
 */
public class MyThreadForThread extends Thread {

    private int i = 5;
    @Override
    public void run() {

        for (int j = 0; j < 10; j++) {
            if (i > 0) {

                System.out.println("i=" + i --);
            }
        }

    }

    public static void main(String[] args) {

        MyThreadForThread myThreadForThread = new MyThreadForThread();
        MyThreadForThread myThreadForThread1 = new MyThreadForThread();

        myThreadForThread.start();
        myThreadForThread1.start();
    }
}
