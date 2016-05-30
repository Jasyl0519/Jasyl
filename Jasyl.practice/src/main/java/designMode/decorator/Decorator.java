package designMode.decorator;

/**
 * Created by jason on 16/5/30.
 */
public abstract class Decorator implements ICoffee{

    private ICoffee coffee;

    public void setCoffee(ICoffee coffee) {
        this.coffee = coffee;
    }


    public void showCoffee() {
        coffee.showCoffee();
    }

    public float showPrice() {

        return coffee.showPrice();
    }
}
