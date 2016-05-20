package designMode.builder;

/**
 * Created by jason on 16/5/20.
 */
public interface Builder {

    void buildFrame();

    void buildEngine();

    void buildWheel();

    Car buildCar();
}
