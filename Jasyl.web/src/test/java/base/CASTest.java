package base;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 5)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class CASTest {

    /**
     * 循环次数
     */
    @Param(value = {"1000000", "10000000"})
    private int loop;

    /**
     * 线程数
     */
    @Param(value = {"10", "100"})
    private int threadSize;

    private static AtomicLong sumCas = new AtomicLong(0);
    private static long sumSync = 0;
    private static final Object lock = new Object();


    @Benchmark
    public void testCAS() throws InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            executors.submit(new Runnable() {
                public void run() {
                    for (int j = 0; j < loop; j++) {
                        sumCas.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executors.shutdown();

    }


    @Benchmark
    public void testSynchronized() throws InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            executors.submit(new Runnable() {
                public void run() {
                    for (int j = 0; j < loop; j++) {
                        synchronized (lock) {
                            sumSync++;
                        }
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executors.shutdown();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CASTest.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }
}
