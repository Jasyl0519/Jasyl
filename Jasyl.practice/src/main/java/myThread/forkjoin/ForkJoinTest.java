package myThread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Description:
 * Author: lingyou
 * date: 2019-05-07 23:22
 */
public class ForkJoinTest extends RecursiveTask<Integer> {

    private int start;
    private int end;


    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;

        if (end - start <= 2) {
            for (int i = start; i <= end; i++) {
                sum = sum + i;

            }
        } else {

            int mid = (start + end) / 2;
            ForkJoinTest test1 = new ForkJoinTest(start, mid);
            ForkJoinTest test2 = new ForkJoinTest(mid + 1, end);

            test1.fork();
            test2.fork();
            int result1 = test1.join();
            int result2 = test2.join();

            sum = result1 + result2;




        }




        return sum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTest forkJoinTest = new ForkJoinTest(1, 100);

        ForkJoinTask<Integer> result = forkJoinPool.submit(forkJoinTest);
        System.out.println(result.get());


        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

    }
}
