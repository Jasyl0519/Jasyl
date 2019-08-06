package myThread.completable;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-24 22:44
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        //runAsyncTest2();
        //supplyAsyncTest2();
        //thenApplyTest2();
        //thenApplyTest3();
        thenAcceptTest();



    }

    private static void thenAcceptTest() {

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            User user = new User();
            user.setName("jason");
            user.setPassword("123");

            return user;

        }).thenAccept(u -> {
            System.out.println("hello " + u.getName());

        });
        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
    private static void thenApplyTest3() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "jason";

        }).thenApply(name -> {
            return "hello " + name;

        }).thenApply(sb -> {

            return "你好 " + sb;
        });


        try {
            String result = completableFuture.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static void thenApplyTest2() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "jason";

        });
        System.out.println("异步");


        CompletableFuture<String> greetingFuture = completableFuture.thenApply(name -> {
            return "hello " + name;
        });


        try {
            String result = greetingFuture.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static void supplyAsyncTest2() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";

        });
        System.out.println("异步");

        try {
            String result = completableFuture.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static void runAsyncTest2() {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {

                // Simulate a long-running Job
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println("I'll run in a separate thread than the main thread.");


            }
        });

        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static void test1() {
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();

        new Thread(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            completableFuture.complete("ok");


        }).start();
        try {
            String result = completableFuture.get(5000, TimeUnit.MILLISECONDS);

            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    @Data
    static class User {
        private String name;
        private String password;

    }
}


