package myThread.account;

/**
 * Created by jason on 16/6/14.
 */
public class Account {

    private String name;

    private float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public void deposit(float amount){

        this.amount += amount;

        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": 存钱 " + amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void withdraw(float amount){

        this.amount -= amount;

        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": 取钱 " + amount);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public float getAmount() {
        return amount;
    }
}
