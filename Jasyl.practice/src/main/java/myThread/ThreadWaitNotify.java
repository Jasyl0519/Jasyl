package myThread;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-10-26 上午10:24
 */
public class ThreadWaitNotify {

    public static void main(String[] args) throws InterruptedException {

        ThreadB threadB = new ThreadB();
        threadB.start();

        System.out.println("threadB is start...");
        //threadB.join();
        synchronized (threadB) {

            System.out.println("waiting for b to complete...");
            try {
                threadB.wait();  //main thread waiting
                System.out.println("b is completed... now back to main thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total is : " + threadB.total);

    }



    static class ThreadB extends Thread {
        int total = 0;


        public void run() {
            //try {
            //    Thread.sleep(1000);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            synchronized (this) {

                for (int i = 0; i < 10000; i++) {

                    total = total + i;
                }
                System.out.println("total is " + total);
                this.notify();
            }
        }

    }
}
