package lock.deadlock;

/**
 * Description:
 * Author: lingyou
 * date: 2018-10-18 下午11:11
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    public void deadLock() {

        new Thread(() -> {

            synchronized (A) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (B) {
                    System.out.println("1");
                }
            }

        }).start();

        new Thread(() -> {

            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }
        }).start();
    }
}
