package designMode.factory;

/**
 * Created by jason on 16/5/17.
 */
public class ToyotaFactory implements ICarFactory{
    public void productCar() {
        System.out.println("生成丰田");
    }
}
