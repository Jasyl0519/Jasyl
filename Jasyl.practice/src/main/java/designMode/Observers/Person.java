package designMode.Observers;

import java.util.Observable;
import java.util.Observer;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-02-24 下午5:00
 */
public class Person implements Observer {


    private String name;

    public Person (Observable o, String name) {
        this.name = name;
        o.addObserver(this);

    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    public void update(Observable o, Object arg) {

        System.out.println("我是" + name + "股票价格发生改变：" + ((Stock)o).getPrice());
        
    }
}
