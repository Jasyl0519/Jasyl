package lock;


/**
 * Description:
 * Author: lingyou
 * date: 2018-10-20 下午11:13
 */
public class JoinAndWait {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("main thread start ");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread1 start");
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 start");

            }
        });

        t1.start();


        t2.start();




        System.out.println("main thread end ");

    }

}
