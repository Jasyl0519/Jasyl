package lock.reentrantlock;

/**
 * Description:
 * Author: lingyou
 * date: 2018-11-24 上午10:04
 */
public class InterruptClass implements Runnable {
    @Override
    public void run() {

        while(true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Someone interrupted me.");
                System.out.println(Thread.interrupted());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.interrupted());
                break;
            }
            else{
                System.out.println("Thread is Going...");

            }
        }

    }

    public static void main(String[] args) {
        InterruptClass ic = new InterruptClass();
        Thread t1 = new Thread(ic);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            System.out.println("InterruptedException...");

        }
        t1.interrupt();
    }

}
