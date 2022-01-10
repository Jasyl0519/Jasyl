package base;

import org.junit.rules.Stopwatch;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class CASTest1 {


    public void testCAS() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        List<Future> futures = new ArrayList<Future>();
        final AtomicLong sum = new AtomicLong();
        ExecutorService executors = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            futures.add(executors.submit(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10000000; j++) {
                        sum.incrementAndGet();
                    }
                }
            }));
        }
        for (int i = 0; i < futures.size(); i++) {
            try {
                futures.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executors.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("testCAS耗时=" + (endTime - startTime) + " || 结果=" + sum.longValue());


    }


    private long count = 0;

    public void testSynchronized() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        List<Future> futures = new ArrayList<Future>();
        final Object obj = new Object();
        ExecutorService executors = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            futures.add(executors.submit(new Runnable() {
                public void run() {
                    synchronized (obj) {
                        for (int j = 0; j < 10000000; j++) {
                            count++;
                        }
                    }
                }
            }));
        }

        for (int i = 0; i < futures.size(); i++) {
            try {
                futures.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executors.shutdown();
        long endTime = System.currentTimeMillis();

        System.out.println("testSynchronized耗时=" + (endTime - startTime) + " || 结果=" + count);

    }


    public static void main(String[] args) throws Exception {

        CASTest1 casTest1 = new CASTest1();
        for (int i = 0; i < 100; i++) {

//            casTest1.testSynchronized();
            casTest1.testCAS();
        }
//
//        ExecutorService executors = Executors.newFixedThreadPool(5);
//
//
//        for (int i = 0; i < 5; i++) {
//            executors.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        CASTest1 casTest1 = new CASTest1();
//                        casTest1.testSynchronized();
//                        casTest1.testCAS();
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//        }
//        TimeUnit.SECONDS.sleep(10);
//        executors.shutdown();

    }
}
