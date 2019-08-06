package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-08-28 上午11:56
 */
class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 2;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        invokeAll(subtask1, subtask2);
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }


    public static void main(String[] args) throws Exception {
        // 创建随机数组成的数组:
        long[] array = new long[100];

        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");



        long startTime1 = System.currentTimeMillis();

        int total = 0;
        for (int i = 0; i < 100; i++) {
            total = total + i;
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("sum: " + total + " in " + (endTime1 - startTime1) + " ms.");




        long startTime2 = System.currentTimeMillis();

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += array[i];
        }

        long endTime2 = System.currentTimeMillis();
        System.out.println("sum: " + sum + " in " + (endTime2 - startTime2) + " ms.");



    }
}