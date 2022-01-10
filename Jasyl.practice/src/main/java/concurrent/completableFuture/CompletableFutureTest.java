package concurrent.completableFuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author zhengcheng
 * @date 2021/10/27 5:29 下午
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        CompletableFuture<String> str = CompletableFuture.supplyAsync(() -> {
        return "Hello World1!";
        });
        System.out.println(str.get());

        CompletableFuture.runAsync(() -> System.out.println("Hello World!"));

        //异步回调
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t completableFuture2");
            int i = 10/0;
            return 1024;
        });

        completableFuture2.whenComplete((t,u)->{
            System.out.println("-------t="+t);
            System.out.println("-------u="+u);
        }).exceptionally(f->{
            System.out.println("-----exception:"+f.getMessage());
            return 444;
        });


        CompletableFuture.supplyAsync(() -> "000")
                .thenApply(s -> s.length()) // Function
                .whenComplete((integer, throwable) -> System.out.println(integer));



    }
}
