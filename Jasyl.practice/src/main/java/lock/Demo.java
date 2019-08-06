package lock;

/**
 * Description:
 * Author: lingyou
 * date: 2018-12-18 23:04
 */
public class Demo {

    private int i=0;

    public synchronized void set(int i) {
        this.i=i;


    }

    public long get() {

        long k = i;
        for (long j = 0; j < 1000000000; j++) {
             k = k + 1 ;

        }
        return k;

    }






    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {


            Demo demo = new Demo();
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    demo.set(1);

                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行1");
                    demo.set(2);
                    System.out.println("执行2");




                }
            });
            Thread thread4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行4");
                    System.out.println("执行3");

                    for (int i = 0; i < 2; i++) {

                        System.out.println(demo.get());





                    }


                }
            });

            thread1.start();
            thread1.join();

            thread2.start();
            thread4.start();


            thread2.join();
            thread4.join();


            System.out.println("-----------------");


        }







    }
}
