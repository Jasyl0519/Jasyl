package designMode.decorator;

/**
 * Created by jason on 16/5/30.
 */
public class Coffee implements ICoffee {

    private String name;
    private float price;

    Coffee(String name, float price){

        this.name = name;
        this.price = price;
    }

    public void showCoffee() {

        System.out.println(name + " coffee");

    }

    public float showPrice() {

        return price;
    }
}
