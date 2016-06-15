package designMode.singleton;

import designMode.singleton.hunger.Singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jason on 16/6/2.
 */
public class TestSingleton {



    public static void main(String[] args) {

        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());

        final CountDownLatch countDownLatch = new CountDownLatch(100);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100 ; i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    try {

                        Singleton s = Singleton.getSingleton();
                        instanceSet.add(s.toString());

                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        try {
            Thread.sleep(1000);

            countDownLatch.await();

            Thread.sleep(1000);

            System.out.println("一共有" + instanceSet.size() + "个实例");        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (String s : instanceSet) {

            System.out.println(s);
        }

        executorService.shutdown();
    }
}
