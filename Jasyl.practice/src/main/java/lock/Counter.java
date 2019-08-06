package lock;


/**
 * Description:
 * Author: lingyou
 * date: 2018-10-20 下午11:13
 */
public class Counter {
    //
    //public static <T> T asList(T a) {
    //    ArrayList<T> arrLt = new ArrayList<>();
    //    return a;
    //}
    //
    //private AtomicInteger atomicI = new AtomicInteger(0);
    //
    //private int i = 0;
    //
    //public static void main(String[] args) {
    //
    //    final Counter cas = new Counter();
    //    List<Thread> ts = new ArrayList<Thread>(600);
    //
    //    long start = System.currentTimeMillis();
    //    for (int j = 0; j < 100; j++) {
    //        Thread t = new Thread(new Runnable() {
    //            @Override
    //            public void run() {
    //                for (int i = 0; i < 10000; i++) {
    //                    cas.count();
    //                    cas.safeCount();
    //                }
    //
    //            }
    //        });
    //       ts.add(t);
    //    }
    //    for (Thread t : ts) {
    //        t.start();
    //    }
    //
    //    for (Thread t : ts) {
    //        try {
    //            t.join();
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //    }
    //
    //    System.out.println(cas.i);
    //    System.out.println(cas.atomicI.get());
    //    System.out.println(System.currentTimeMillis() - start);
    //
    //}
    //
    //private void safeCount() {
    //    atomicI.addAndGet(1);
    //}
    //
    //private void count() {
    //    i++;
    //}
}
