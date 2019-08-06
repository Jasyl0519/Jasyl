package lock.sync;

/**
 * Description:
 * Author: lingyou
 * date: 2018-11-18 下午3:54
 */
public class SynchronizedClass implements Runnable {

    static int i = 0;

    //实例方法
    public synchronized void increase1() {
        i++;
    }
    //同步块
    public void increase2() {
        synchronized (this){
            i++;
        }
    }

    //静态方法
    public static synchronized void increase3() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase2();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //new新实例
        Thread t1 = new Thread(new SynchronizedClass());
        //new心事了
        Thread t2 = new Thread(new SynchronizedClass());
        //启动线程
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}