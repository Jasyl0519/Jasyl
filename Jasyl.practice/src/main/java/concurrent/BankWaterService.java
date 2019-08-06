package concurrent;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Description:
 * Author: lingyou
 * date: 2019-05-09 23:12
 */
public class BankWaterService implements Runnable {
    private CyclicBarrier c = new CyclicBarrier(4, this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();


    private void count() {
        for (int i = 0; i < 4; i++) {

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    map.put(Thread.currentThread().getName(), 1);

                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result = result + entry.getValue();
        }

        System.out.println("result:" + result);

    }

    public static void main(String[] args) {

        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
