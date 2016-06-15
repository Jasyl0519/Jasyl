package myThread.account;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jason on 16/6/14.
 */
public class AccountOperator implements Runnable {

    private Account account;

    AccountOperator(Account account){
        this.account = account;

    }

    @Override
    public synchronized void run() {

        account.deposit(500);
        account.withdraw(300);

        System.out.println(Thread.currentThread().getName() + ":" + account.getAmount());


//        synchronized (account) {
//            account.deposit(500);
//            account.withdraw(500);
//
//            System.out.println(Thread.currentThread().getName() + ":" + account.getAmount());
//        }
    }


    public static void main(String[] args) {

        Account account = new Account("jason", 1000f);
        AccountOperator accountOperator = new AccountOperator(account);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            executorService.execute(accountOperator);

        }
        executorService.shutdown();

        /*final int THREAD_NUM = 2;
        Thread threads[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i ++) {
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
        }*/
    }
}
