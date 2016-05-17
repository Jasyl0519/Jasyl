package designMode.factory;

/**
 * Created by jason on 16/5/17.
 */
public class TestFactory {

    public static void main(String[] args) {

        ICarFactory bf = new BenzFactory();
        bf.productCar();

        ICarFactory tf = new ToyotaFactory();
        tf.productCar();


    }
}
