package designMode.Observers;

import java.util.Observable;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-02-24 下午4:57
 */
public class Stock extends Observable {

    private double price;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;

        setChanged();

        notifyObservers();
    }
}
