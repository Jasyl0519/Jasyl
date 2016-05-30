package designMode.decorator;

/**
 * Created by jason on 16/5/30.
 */
public class Sugar extends Decorator {


    @Override
    public void showCoffee() {
        System.out.println("加糖");
        super.showCoffee();
    }

    @Override
    public float showPrice() {
        return super.showPrice() + 5;
    }
}
